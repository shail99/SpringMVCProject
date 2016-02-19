package com.shail99.controller;

import java.io.File;
import com.shail99.businessLogic.*;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

@Controller
public class HelloWorldController{

	@RequestMapping("/welcome")
	protected ModelAndView helloWorld(){

		ModelAndView model = new ModelAndView("HelloPage");
		
		File root_dir = new File("/Users/shaileshpujari/paymentTimingLogs/20160212");
		Directory my_dir = new Directory();
		Directory dir = my_dir.convertDirToJsonFile(root_dir);
		dir.printDirectoryStructure(0);
		
		GsonBuilder builder = new GsonBuilder();
		builder.setPrettyPrinting();
		Gson gson = builder.create();
		
		
		//System.out.println(gson.toJson(dir));
		
		
		model.addObject("msg", gson.toJson(dir));
		
		return model;
	}
	
//	@RequestMapping("/jqtree/tree.jquery.js")
//	protected void printHello(){
//		System.out.println("In here");
//	}
}