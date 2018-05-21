package com.datadictionary.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.datadictionary.entity.DataRow;

@Repository ("DataDictionaryRepository")
public interface DataDictionaryRepository extends CrudRepository<DataRow, Integer> {

	public DataRow findById (int id);
    public void delete (DataRow dataRow);
    public boolean existsById (int id);
    public List<DataRow> findAll();
}
