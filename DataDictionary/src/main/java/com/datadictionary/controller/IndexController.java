package com.datadictionary.controller;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class IndexController implements ErrorController {

	private final String PATH = "/error";
	
	@RequestMapping(value = {"/"})
    public ModelAndView index() {
        ModelAndView modelAndView = new ModelAndView("index");
        return modelAndView;
    }
	
	@RequestMapping(value = {"table"})
    public ModelAndView table() {
        return new ModelAndView("table");
    }
	
	@RequestMapping(value = PATH)
    public ModelAndView error() {
        return new ModelAndView("error/404");
    }
	
	@Override
    public String getErrorPath() {
        return PATH;
    }
}
