package com.datadictionary.controller;

import java.io.IOException;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.datadictionary.entity.DataRow;
import com.datadictionary.service.DataDictionaryService;

@Controller
public class DataDictionaryController {

	@Autowired
	private DataDictionaryService dataDictionaryService;
	
	@RequestMapping (value = {"/create"}, method = RequestMethod.GET)
	public ModelAndView createDataRow(@ModelAttribute("dataRow") DataRow dataRow) {
		ModelAndView mv = new ModelAndView("table");
		dataDictionaryService.create(dataRow);
		
		return mv;
	}
	
	@RequestMapping (value = {"/delete"}, method = RequestMethod.GET)
	public ModelAndView deleteDataRow(@ModelAttribute("dataRow") DataRow dataRow) {
		ModelAndView mv = new ModelAndView("table");
		boolean status = dataDictionaryService.delete(dataRow);
		if (status) {
			
		} else {
			
		}
		return mv;
	}
	
	@RequestMapping (value = {"/update"}, method = RequestMethod.GET)
	public ModelAndView updateDataRow(@ModelAttribute("dataRow") DataRow dataRow) {
		ModelAndView mv = new ModelAndView("table");
		
		return mv;
	}
	
	@RequestMapping (value= {"/getAll"}, method = RequestMethod.GET)
	public ModelAndView getAllData() {
		ModelAndView mv = new ModelAndView("table");
		ArrayList<DataRow> allData = (ArrayList<DataRow>) dataDictionaryService.getAll();
		mv.addObject("allData", allData);
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
}
