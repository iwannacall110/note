package com.imooc.mvcdemo.controller;

import org.slf4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/hello")
public class HelloMvcController {	
	private static org.apache.log4j.Logger log = LoggerFactory.getLoger(HelloMvcController.class)
	@RequestMapping("/mvc")
	public String helloMvc(){
		log.debug("========================hello, world!");
		return "home";
	}
}
