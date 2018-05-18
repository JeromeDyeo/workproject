package com.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.entity.DataRow;

@Repository ("DataDictionaryRepository")
public interface DataDictionaryRepository extends CrudRepository<DataRow, Integer> {

	public DataRow findOne(int id);
    public void delete (DataRow dataRow);
    public boolean exists (int id);
    public List<DataRow> findAll();
}
