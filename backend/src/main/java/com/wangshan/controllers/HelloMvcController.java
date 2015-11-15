package com.wangshan.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Controller
@RequestMapping("/test")
public class HelloMvcController {
	private static Logger log = LoggerFactory.getLogger(HelloMvcController.class);
	@RequestMapping("/mvc")
	public String helloMvc() {
		log.info("==========================Œ“»’");
		System.out.println("=========================sdsdsds");
		return "home";
	}
}


