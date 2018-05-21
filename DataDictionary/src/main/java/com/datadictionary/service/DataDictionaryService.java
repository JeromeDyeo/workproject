package com.datadictionary.service;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.datadictionary.entity.DataRow;
import com.datadictionary.repository.DataDictionaryRepository;

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
	
	public boolean delete(DataRow dataRow) {
		try {
			dataDictionaryRepository.delete(dataRow);
			return true;
		} catch (EmptyResultDataAccessException ex) {
			System.out.println(ex.getMessage());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return false;
	}
	
	public List<DataRow> getAll() {
		return dataDictionaryRepository.findAll();
	}
}
