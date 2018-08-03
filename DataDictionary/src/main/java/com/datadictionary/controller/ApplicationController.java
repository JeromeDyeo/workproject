package com.datadictionary.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

import javax.servlet.http.HttpServletRequest;

import com.datadictionary.entity.ApplicationDetail;
import com.datadictionary.entity.DataRow;
import com.datadictionary.service.ApplicationService;

@Controller
public class ApplicationController {

	@Autowired
	ApplicationService applicationService;

	@RequestMapping(value = { "/getApplications" }, method = RequestMethod.GET)
	public ModelAndView getAllApplications(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView("applications");
		List<ApplicationDetail> applications = applicationService.getAll();
		mv.addObject("applications", applications);
		request.setAttribute("application", applications);
		return mv;
	}

	@RequestMapping(value = { "/getSchema" }, method = RequestMethod.GET)
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

	@RequestMapping(value = { "/updateAppView" }, method = RequestMethod.POST)
	public ModelAndView updateView(@RequestParam("id") int id, HttpServletRequest request) {
		ModelAndView mv = new ModelAndView("updateapp");
		ApplicationDetail application = applicationService.getById(id);
		mv.addObject("application", application);
		request.setAttribute("application", application);
		return mv;
	}

	@RequestMapping(value = { "/updateAppPost" }, method = RequestMethod.POST)
	public ModelAndView updateDataRow(@ModelAttribute("applicationDetail") ApplicationDetail applicationDetail,
			@RequestParam("imageUpload") MultipartFile image, HttpServletRequest request) throws IOException {
		ModelAndView mv = new ModelAndView("redirect:getApplications");
		ApplicationDetail originalApp = applicationService.getById(applicationDetail.getId());
		Calendar calendar = Calendar.getInstance();
		if (!image.isEmpty()) {

			byte[] bytes = image.getBytes();
			String extension = image.getContentType().substring(image.getContentType().indexOf("/") + 1);
			String fileName = Long.toString(calendar.getTimeInMillis()) + "." + extension;
			String applicationPath = request.getServletContext().getRealPath("");
			String uploadFilePath = applicationPath + "img/";

			// delete existing image
			String originalImage = originalApp.getImagePath();
			if (originalImage != null) {
				String originalImagePath = uploadFilePath + originalImage;
				File original = new File(originalImagePath);
				original.delete();
			}

			// create and upload new image
			Path path = Paths.get(uploadFilePath + fileName);
			if (!Files.exists(path.getParent())) {
				Files.createDirectories(path.getParent());
			}
			Files.write(path, bytes);
			applicationDetail.setImagePath(fileName);
			// Path path = Paths.get("src/main/webapp/img/userupload/customer/" + fileName);
			// Path path = Paths.get("../webapps/"+ request.getContextPath() +
			// "/img/userupload/customer/" + fileName);
		} else {
			applicationDetail.setImagePath(originalApp.getImagePath());
		}
		ApplicationDetail applicationUpdate = applicationService.update(applicationDetail);
		// ApplicationDetail updatedApplication =
		// applicationService.update(applicationDetail);
		return mv;
	}
	
	@RequestMapping(value = { "/createApp" }, method = RequestMethod.POST) 
	public ModelAndView createApp(@ModelAttribute("applicationDetail") ApplicationDetail applicationDetail){
		ModelAndView mv = new ModelAndView("redirect:getApplications");
		ApplicationDetail created = applicationService.create(applicationDetail);
		return mv;
	}
}
