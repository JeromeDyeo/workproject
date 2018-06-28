package com.datadictionary.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.datadictionary.entity.ApplicationDetail;
import com.datadictionary.entity.DataRow;

@Repository ("ApplicationRepository")
public interface ApplicationRepository extends CrudRepository<ApplicationDetail, Integer> {

	public ApplicationDetail findById (int id);
	public ApplicationDetail findByApplication (String application);
	public void delete (ApplicationDetail applicationDetail);
    public boolean existsById (int id);
    public boolean existsByApplication(String application);
    public List<ApplicationDetail> findAll();
}
