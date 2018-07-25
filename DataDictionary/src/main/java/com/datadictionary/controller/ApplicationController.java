package com.datadictionary.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import java.util.*;

import com.datadictionary.entity.ApplicationDetail;
import com.datadictionary.entity.DataRow;
import com.datadictionary.service.ApplicationService;

@Controller
public class ApplicationController {

	@Autowired
	ApplicationService applicationService;
	
	@RequestMapping (value = {"/getApplications"}, method = RequestMethod.GET)
	public ModelAndView getAllApplications() {
		ModelAndView mv = new ModelAndView("applications");
		List<ApplicationDetail> applications = applicationService.getAll();
		mv.addObject("applications", applications);
		return mv;
	}
	
	@RequestMapping (value = {"/getSchema"}, method = RequestMethod.GET)
	public ModelAndView getSchema(@RequestParam(value = "application") String application) {
		ModelAndView mv = new ModelAndView("schema");
		ApplicationDetail applicationDetail = applicationService.getByApplication(application);
		Set<DataRow> allRows = applicationDetail.getDataRow();
		List<String> schemas = new ArrayList<>();
		for (DataRow r : allRows) {
			String schemaName = r.getSchemaName();
			if (!schemas.contains(schemaName)) {
				schemas.add(schemaName);
			}
		}
		mv.addObject("schemas", schemas);
		mv.addObject("application", application);
		return mv;
		
	}
	
	@RequestMapping (value = {"/updateAppView"}, method = RequestMethod.POST)
	public ModelAndView updateView(@RequestParam("id") int id) {
		ModelAndView mv = new ModelAndView("updateapp");
		ApplicationDetail application = applicationService.getById(id);
		mv.addObject("application", application);
		return mv;
	}
	
	@RequestMapping (value = {"/updateAppPost"}, method = RequestMethod.POST)
	public ModelAndView updateDataRow(@ModelAttribute("application") ApplicationDetail application) {
		ModelAndView mv = new ModelAndView("redirect:getAll");
		ApplicationDetail applicationUpdate = applicationService.update(application);
		//ApplicationDetail updatedApplication = applicationService.update(applicationDetail);
		return mv;
	}
}
