package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.ModelAndView;

import com.entity.DataRow;
import com.service.DataDictionaryService;

@Controller
public class DataDictionaryController {

	@Autowired
	private DataDictionaryService dataDictionaryService;
	
	public ModelAndView createDataRow(@ModelAttribute("dataRow") DataRow dataRow) {
		ModelAndView mv = new ModelAndView();
		dataDictionaryService.create(dataRow);
		
		return mv;
	}
	
	public ModelAndView deleteDataRow(@ModelAttribute("dataRow") DataRow dataRow) {
		ModelAndView mv = new ModelAndView();
		dataDictionaryService.delete(dataRow);
		
		return mv;
	}
}
