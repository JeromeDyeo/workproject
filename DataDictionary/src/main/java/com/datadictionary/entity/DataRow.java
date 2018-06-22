package com.datadictionary.entity;

import javax.persistence.*;

import com.opencsv.bean.CsvBindByName;

@Entity
@Table(name = "datarow")

public class DataRow {
	
	private int id;
	
	private ApplicationDetail applicationDetail;
	
	@CsvBindByName (column = "Schema")
	private String schemaName;
	
	@CsvBindByName (column = "Table")
	private String tableName;
	
	@CsvBindByName (column = "Table Type")
	private String tableType;
	
	@CsvBindByName (column = "Column")
	private String columnName;
	
	@CsvBindByName (column = "Data Type")
	private String dataType;
	
	@CsvBindByName (column = "Default Value")
	private String defaultValue;
	
	@CsvBindByName (column = "Column Key")
	private String columnKey;
	
	@CsvBindByName (column = "Null Able")
	private String nullAble;
	
	@CsvBindByName (column = "Auto Increment")
	private String autoIncrement;
	
	@CsvBindByName (column = "Description")
	private String description;
	
	@Id
	@Column(name = "did")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getId() {
		return this.id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "aid")
	public ApplicationDetail getApplicationDetail() {
		return applicationDetail;
	}

	public void setApplicationDetail(ApplicationDetail applicationDetail) {
		this.applicationDetail = applicationDetail;
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


	public String getTableType() {
		return tableType;
	}

	public void setTableType(String tableType) {
		this.tableType = tableType;
	}

	public String getDefaultValue() {
		return defaultValue;
	}

	public void setDefaultValue(String defaultValue) {
		this.defaultValue = defaultValue;
	}

	public String getColumnKey() {
		return columnKey;
	}

	public void setColumnKey(String columnKey) {
		this.columnKey = columnKey;
	}

	public String getNullAble() {
		return nullAble;
	}

	public void setNullAble(String nullAble) {
		this.nullAble = nullAble;
	}

	public String getAutoIncrement() {
		return autoIncrement;
	}

	public void setAutoIncrement(String autoIncrement) {
		this.autoIncrement = autoIncrement;
	}

	
}
