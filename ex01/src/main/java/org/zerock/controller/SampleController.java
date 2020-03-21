package org.zerock.controller;

import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.zerock.domain.SampleDTO;

import lombok.extern.java.Log;
import lombok.extern.log4j.Log4j;


@Controller
@RequestMapping("/sample/*")
@Log
public class SampleController {
	
	@RequestMapping(value="/basic", method= {RequestMethod.GET, RequestMethod.POST})
	public void basicGet() {
		log.info("basic get...........................");
	}
	
	@GetMapping("/ex01")
	public String ex01(SampleDTO dto) {
		log.info("" + dto);
		
		return "ex01";
	}
	
	@GetMapping("/ex02")
	public String ex02(@RequestParam("name") String name, @RequestParam("age") int age) {
		log.info("name : " + name);
		log.info("age : " + age);
		
		return "ex02";
	}
	
	
	
	
	
	
	/*
	@GetMapping("/ex02List")
	public String ex02List(@RequestParam("ids")ArrayList<String> ids) {
		log.info("ids : " + ids);
		
		return "ex02List";
	}
	*/
	
	
	
	
	
//	@GetMapping("/ex02Array")
//	public String ex02Array(@RequestParam("ids")String[] ids) {
//		log.info("array ids : " + Arrays.toString(ids));
//		
//		return "ex02Array";
//	}
	
	public String 02Array(@RequestParam="ids" String=ps	 ids
}
