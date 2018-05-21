package com.datadictionary.controller;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.datadictionary.entity.DataRow;
import com.datadictionary.service.DataDictionaryService;

@Controller
public class DataDictionaryController {

	@Autowired
	private DataDictionaryService dataDictionaryService;
	
	public ModelAndView createDataRow(@ModelAttribute("dataRow") DataRow dataRow) {
		ModelAndView mv = new ModelAndView("mainpage.jsp");
		dataDictionaryService.create(dataRow);
		
		return mv;
	}
	
	public ModelAndView deleteDataRow(@ModelAttribute("dataRow") DataRow dataRow) {
		ModelAndView mv = new ModelAndView("mainpage.jsp");
		boolean status = dataDictionaryService.delete(dataRow);
		if (status) {
			
		} else {
			
		}
		return mv;
	}
	
	@RequestMapping (value= {"/getAll"}, method = RequestMethod.GET)
	public ModelAndView getAllData() {
		ModelAndView mv = new ModelAndView("table");
		ArrayList<DataRow> allData = (ArrayList<DataRow>) dataDictionaryService.getAll();
		mv.addObject("allData", allData);
		return mv;
	}
}
