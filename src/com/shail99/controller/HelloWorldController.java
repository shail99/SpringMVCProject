package com.shail99.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloWorldController{

	@RequestMapping("/welcome/{countryName}/{userName}")
	protected ModelAndView helloWorld(@PathVariable("userName") String name, 
			@PathVariable("countryName") String country){
		ModelAndView model = new ModelAndView("HelloPage");
		
		model.addObject("msg", "Hello "+name+". Welcome to "+country);
		
		return model;
	}
	
	
	@RequestMapping("/hello/{countryName}/{userName}")
	protected ModelAndView sayHello(@PathVariable Map<String,String> pathVars){
		ModelAndView model = new ModelAndView("HelloPage");
		
		String name = pathVars.get("userName");
		String country = pathVars.get("countryName");
		
		model.addObject("msg", "Hello "+name+". Welcome to "+country);
		
		return model;
	}
	
}