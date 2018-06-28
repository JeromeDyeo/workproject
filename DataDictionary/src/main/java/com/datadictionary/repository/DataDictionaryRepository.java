package com.datadictionary.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.datadictionary.entity.ApplicationDetail;
import com.datadictionary.entity.DataRow;

@Repository ("DataDictionaryRepository")
public interface DataDictionaryRepository extends CrudRepository<DataRow, Integer> {

	public DataRow findById (int id);
	public List<DataRow> findByApplicationDetail(ApplicationDetail application);
	public List<DataRow> findByTableName(String tableName);
	public List<DataRow> findByApplicationDetailAndTableName(ApplicationDetail application, String tableName);
	public List<DataRow> findByTableNameContaining(String searchKeyword);
	public List<DataRow> findByDescriptionContaining(String searchKeyword);
    public void delete (DataRow dataRow);
    public boolean existsById (int id);
    public List<DataRow> findAll();
}
