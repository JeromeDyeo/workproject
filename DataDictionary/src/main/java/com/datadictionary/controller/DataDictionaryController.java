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
	
	@GetMapping (value= "/getAll")
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
