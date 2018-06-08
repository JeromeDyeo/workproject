package com.datadictionary.controller;

import java.io.IOException;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.datadictionary.entity.DataRow;
import com.datadictionary.service.DataDictionaryService;

@Controller
public class DataDictionaryController {

	@Autowired
	private DataDictionaryService dataDictionaryService;
	
	@RequestMapping (value = {"/create"}, method = RequestMethod.POST)
	public ModelAndView createDataRow(@ModelAttribute("dataRow") DataRow dataRow) {
		ModelAndView mv = new ModelAndView("redirect:getAll");
		dataDictionaryService.create(dataRow);
		
		return mv;
	}
	
	@RequestMapping (value = {"/delete"}, method = RequestMethod.POST)
	public ModelAndView deleteDataRow(@RequestParam("dataRow") int dataRow) {
		ModelAndView mv = new ModelAndView("redirect:getAll");
		boolean status = dataDictionaryService.delete(dataRow);
		if (status) {
			
		} else {
			
		}
		return mv;
	}
	
	@RequestMapping (value = {"/updateView"}, method = RequestMethod.POST)
	public ModelAndView updateView(@RequestParam("id") int id) {
		ModelAndView mv = new ModelAndView("update");
		DataRow dataRow = dataDictionaryService.getById(id);
		mv.addObject("data", dataRow);
		return mv;
	}
	
	@RequestMapping (value = {"/update"}, method = RequestMethod.POST)
	public ModelAndView updateDataRow(@ModelAttribute("dataRow") DataRow dataRow) {
		ModelAndView mv = new ModelAndView("redirect:getAll");
		DataRow updated = dataDictionaryService.update(dataRow);
		return mv;
	}
	
	@RequestMapping (value = {"/upload"}, method = RequestMethod.POST) 
	public ModelAndView upload(@RequestPart(value = "file") MultipartFile multipartFile) throws IOException {
		ModelAndView mv = new ModelAndView("uploadFile");
		HashMap<Integer,ArrayList<String>> error = dataDictionaryService.uploadFile(multipartFile);
		if (error.isEmpty()) {
			mv.addObject("uploadSuccess", true);
		} else {
			mv.addObject("error", error);
		}
		
		return mv;
	}
	
	@RequestMapping (value = {"/getAll"}, method = RequestMethod.GET)
	public ModelAndView getAllData(@RequestParam(value = "application", required = false) String application, 
			@RequestParam(value = "tableName", required = false) String tableName) {
		ModelAndView mv = new ModelAndView("table");
		ArrayList<DataRow> allData = new ArrayList<>();
		if ((application == null || application.isEmpty()) && (tableName == null || tableName.isEmpty())) {
			allData = (ArrayList<DataRow>) dataDictionaryService.getAll();
		} else if (!(application == null || application.isEmpty()) && (tableName == null || tableName.isEmpty())) {
			allData = (ArrayList<DataRow>) dataDictionaryService.getByApplication(application);
		} else if ((application == null || application.isEmpty()) && !(tableName == null || tableName.isEmpty())) {
			allData = (ArrayList<DataRow>) dataDictionaryService.getByTableName(tableName);
		} else {
			allData = (ArrayList<DataRow>) dataDictionaryService.getByApplicationAndTableName(application, tableName);
		}
		mv.addObject("allData", allData);
		
		ArrayList<DataRow> allDataUnfiltered = (ArrayList<DataRow>) dataDictionaryService.getAll();
		ArrayList<String> applicationData = (ArrayList<String>) dataDictionaryService.getDistinctByApplication(allDataUnfiltered);
		mv.addObject("applicationData", applicationData);
		ArrayList<String> tableData = (ArrayList<String>) dataDictionaryService.getDistinctByTableName(allDataUnfiltered);
		mv.addObject("tableData", tableData);
		
		return mv;
	}
	
	@GetMapping(value = "/search")
	public ModelAndView search(@RequestParam("searchFilter") String searchFilter,
			@RequestParam("searchKeyword") String searchKeyword) {
		ModelAndView mv = new ModelAndView("table");
		ArrayList<DataRow> allData = new ArrayList<>();
		if (searchFilter.equals("Table")) {
			allData = (ArrayList<DataRow>) dataDictionaryService.searchByTableName(searchKeyword);
		} else {
			allData = (ArrayList<DataRow>) dataDictionaryService.searchByDescription(searchKeyword);
		}
		mv.addObject("allData", allData);
		
		ArrayList<DataRow> allDataUnfiltered = (ArrayList<DataRow>) dataDictionaryService.getAll();
		ArrayList<String> applicationData = (ArrayList<String>) dataDictionaryService.getDistinctByApplication(allDataUnfiltered);
		mv.addObject("applicationData", applicationData);
		ArrayList<String> tableData = (ArrayList<String>) dataDictionaryService.getDistinctByTableName(allDataUnfiltered);
		mv.addObject("tableData", tableData);
		
		return mv;
	}
	
}
