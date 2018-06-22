package com.datadictionary.entity;

import java.util.Set;

import javax.persistence.*;

import com.opencsv.bean.CsvBindByName;

@Entity
@Table(name = "applicationdetail")

public class ApplicationDetail {

	private int id;
	
	@CsvBindByName (column = "Application")
	private String application;
	
	private String imagePath;
	
	private Set<DataRow> dataRow;
	
	@Id
	@Column(name = "aid")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getId() {
		return id;
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

	public String getImagePath() {
		return imagePath;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}
	
	@OneToMany(targetEntity=DataRow.class, mappedBy="applicationDetail", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	public Set<DataRow> getDataRow() {
		return dataRow;
	}

	public void setDataRow(Set<DataRow> dataRow) {
		this.dataRow = dataRow;
	}
}
