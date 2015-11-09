package com.imooc.mvcdemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/test")
public class HelloMvcController {
	Logger logger = Logger.getLogger(HelloMvcController.class)
	@RequestMapping("/mvc")
	public String helloMvc(){
		logger.debug("===================================");
		return "home";
	}
}
