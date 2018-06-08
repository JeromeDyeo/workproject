package com.datadictionary.service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.datadictionary.entity.DataRow;
import com.datadictionary.repository.DataDictionaryRepository;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.bean.HeaderColumnNameTranslateMappingStrategy;

@Service("DataDictionaryService")
public class DataDictionaryService {

	@Autowired
	private DataDictionaryRepository dataDictionaryRepository;
	
	public DataRow create(DataRow dataRow) {
		DataRow createdRow;
		try {
			createdRow = dataDictionaryRepository.save(dataRow);
			return createdRow;
		} catch (Exception e) {
			System.out.println("Error Creating Data! " + e.getMessage());
		}
		return null;
	}
	
	public boolean delete(int dataRow) {
		try {
			dataDictionaryRepository.deleteById(dataRow);
			return true;
		} catch (EmptyResultDataAccessException ex) {
			System.out.println(ex.getMessage());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return false;
	}
	
	public DataRow update(DataRow dataRow) {
		
		try {
			DataRow updateRow = dataDictionaryRepository.findById(dataRow.getId());
			if (!dataRow.getApplication().isEmpty()) {
				updateRow.setApplication(dataRow.getApplication());
			}
			if (!dataRow.getSchemaName().isEmpty()) {
				updateRow.setSchemaName(dataRow.getSchemaName());
			}
			if (!dataRow.getTableName().isEmpty()) {
				updateRow.setTableName(dataRow.getTableName());
			}
			if (!dataRow.getColumnName().isEmpty()) {
				updateRow.setColumnName(dataRow.getColumnName());
			}
			if (!dataRow.getDataType().isEmpty()) {
				updateRow.setDataType(dataRow.getDataType());
			}
			if (!dataRow.getDescription().isEmpty()) {
				updateRow.setDescription(dataRow.getDescription());
			}
			DataRow r = dataDictionaryRepository.save(updateRow);
			return r;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return null;
	}
	
	public HashMap<Integer,ArrayList<String>> uploadFile(MultipartFile multipartFile) throws IOException {

		File file = convertMultiPartToFile(multipartFile);

		HashMap<Integer,ArrayList<String>> error = new HashMap<>();
		
//		Map<String, String> columnMapping = new HashMap<String, String>();
//		columnMapping.put("Application", "application");
//		columnMapping.put("Schema", "schemaName");
//		columnMapping.put("Table", "tableName");
//		columnMapping.put("Column", "columnName");
//		columnMapping.put("Data Type", "dataType");
//		columnMapping.put("Description", "description");
//
//		HeaderColumnNameTranslateMappingStrategy<DataRow> strategy = new HeaderColumnNameTranslateMappingStrategy<DataRow>();
//		strategy.setType(DataRow.class);
//		strategy.setColumnMapping(columnMapping);
		
//		try (Reader reader = new FileReader(file);) {
		try (Reader reader = new BufferedReader(new InputStreamReader(new FileInputStream(file), "UTF-8"));) {
			reader.mark(1);
			if (reader.read() != 0xFEFF) {
				reader.reset();
			}
				
//			CsvToBean<DataRow> csvToBean = new CsvToBeanBuilder<DataRow>(reader).withType(DataRow.class)
//					.withIgnoreLeadingWhiteSpace(true).withMappingStrategy(strategy).build();
			CsvToBean<DataRow> csvToBean = new CsvToBeanBuilder<DataRow>(reader).withType(DataRow.class)
					.withIgnoreLeadingWhiteSpace(true).build();
			List<DataRow> dataList = csvToBean.parse();

			Iterator<DataRow> dataListClone = dataList.iterator();
			
			int row = 0;
			
			while (dataListClone.hasNext()) {
				row++;
				DataRow dataRow = dataListClone.next();
				ArrayList<String> rowErrors = new ArrayList<>();
				
				if (dataRow.getApplication() == null || dataRow.getApplication().isEmpty()) {
					rowErrors.add("Missing/invalid application");
				} 
				if (dataRow.getSchemaName() == null || dataRow.getSchemaName().isEmpty()) {
					rowErrors.add("Missing/invalid schema");
				} 
				if (dataRow.getTableName() == null || dataRow.getTableName().isEmpty()) {
					rowErrors.add("Missing/invalid table");
				} 
				if (dataRow.getColumnName() == null || dataRow.getColumnName().isEmpty()) {
					rowErrors.add("Missing/invalid column");
				} 
				if (dataRow.getDataType() == null || dataRow.getDataType().isEmpty()) {
					rowErrors.add("Missing/invalid data type");
				} 
//				if (dataRow.getDescription() == null || dataRow.getDescription().isEmpty()) {
//					rowErrors.add("Missing/invalid description");
//				} 
				if (!rowErrors.isEmpty()) {
					error.put(row, rowErrors);
					dataListClone.remove();
				}
			}

			dataDictionaryRepository.saveAll(dataList);
		}
		return error;
	}
	
	public File convertMultiPartToFile(MultipartFile file) throws IOException {
		File convFile = new File(file.getOriginalFilename());
		FileOutputStream fos = new FileOutputStream(convFile);
		fos.write(file.getBytes());
		fos.close();
		return convFile;
	}
	
	public List<DataRow> getAll() {
		return dataDictionaryRepository.findAll();
	}
	
	public DataRow getById(int id) {
		return dataDictionaryRepository.findById(id);
	}
	
	public List<DataRow> getByApplication(String application) {
		return dataDictionaryRepository.findByApplication(application);
	}
	
	public List<DataRow> getByTableName(String tableName) {
		return dataDictionaryRepository.findByTableName(tableName);
	}
	
	public List<DataRow> getByApplicationAndTableName(String application, String tableName) {
		return dataDictionaryRepository.findByApplicationAndTableName(application, tableName);
	}
	
	public List<DataRow> searchByTableName(String searchKeyword) {
		return dataDictionaryRepository.findByTableNameContaining(searchKeyword);
	}
	
	public List<DataRow> searchByDescription(String searchKeyword) {
		return dataDictionaryRepository.findByDescriptionContaining(searchKeyword);
	}
	
	public List<String> getDistinctByApplication(ArrayList<DataRow> data) {
		ArrayList<String> app = new ArrayList<>();
		for (DataRow d : data) {
			if (!app.contains(d.getApplication())) {
				app.add(d.getApplication());
			}
		}
		return app;
	}
	
	public List<String> getDistinctByTableName(ArrayList<DataRow> data) {
		ArrayList<String> tableName = new ArrayList<>();
		for (DataRow d : data) {
			if (!tableName.contains(d.getTableName())) {
				tableName.add(d.getTableName());
			}
		}
		return tableName;
	}
}
