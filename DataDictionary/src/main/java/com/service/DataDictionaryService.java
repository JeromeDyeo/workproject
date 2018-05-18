package com.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;

import com.entity.DataRow;
import com.repository.DataDictionaryRepository;

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
			System.out.println(e.getMessage());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return false;
	}
}
