package com.datadictionary.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.datadictionary.entity.ApplicationDetail;
import com.datadictionary.entity.DataRow;
import com.datadictionary.repository.ApplicationRepository;
import com.datadictionary.repository.DataDictionaryRepository;

@Service("ApplicationService")
public class ApplicationService {

	@Autowired
	private ApplicationRepository applicationRepository;

	public ApplicationDetail create(ApplicationDetail applicationDetail) {
		ApplicationDetail createdApplication;
		try {
			createdApplication = applicationRepository.save(applicationDetail);
			return createdApplication;
		} catch (Exception e) {
			System.out.println("Error Creating Data! " + e.getMessage());
		}
		return null;
	}

	public ApplicationDetail update(ApplicationDetail applicationDetail) {

		try {
			ApplicationDetail updateRow = applicationRepository.findById(applicationDetail.getId());

			if (!applicationDetail.getApplication().isEmpty()) {
				updateRow.setApplication(applicationDetail.getApplication());
			}

			ApplicationDetail r = applicationRepository.save(updateRow);
			return r;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return null;
	}

	public ApplicationDetail getById(int id) {
		return applicationRepository.findById(id);
	}
	
	public ArrayList<String> getDistinctByApplication() {
		ArrayList<String> distinctApplication = new ArrayList<>();
		
		ArrayList<ApplicationDetail> all = (ArrayList<ApplicationDetail>) applicationRepository.findAll();
		
		for (ApplicationDetail a : all) {
			if (!distinctApplication.contains(a.getApplication())) {
				distinctApplication.add(a.getApplication());
			}
		}
		return distinctApplication;
	}
	
	public List<ApplicationDetail> getAll() {
		return applicationRepository.findAll();
	}
	
	public ApplicationDetail getByApplication(String application) {
		return applicationRepository.findByApplication(application);
	}
}
