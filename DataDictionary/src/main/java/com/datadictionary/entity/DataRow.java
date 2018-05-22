package com.datadictionary.entity;

import javax.persistence.*;

import com.opencsv.bean.CsvBindByName;

@Entity
@Table(name = "datarow")

public class DataRow {
	
	private int id;
	
	@CsvBindByName (column = "Application")
	private String application;
	
	@CsvBindByName (column = "Schema")
	private String schemaName;
	
	@CsvBindByName (column = "Table")
	private String tableName;
	
	@CsvBindByName (column = "Column")
	private String columnName;
	
	@CsvBindByName (column = "Data Type")
	private String dataType;
	
	@CsvBindByName (column = "Description")
	private String description;
	
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getId() {
		return this.id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	public String getApplication() {
		return application;
	}

	public void setApplication(String application) {
		this.application = application;
	}

	public String getSchemaName() {
		return schemaName;
	}

	public void setSchemaName(String schemaName) {
		this.schemaName = schemaName;
	}

	public String getTableName() {
		return tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}
	
	public String getColumnName() {
		return columnName;
	}

	public void setColumnName(String columnName) {
		this.columnName = columnName;
	}

	public String getDataType() {
		return dataType;
	}

	public void setDataType(String dataType) {
		this.dataType = dataType;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	
	
}
