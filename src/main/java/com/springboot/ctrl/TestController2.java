package com.springboot.ctrl;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController2 {
	
	@RequestMapping("/a")
	public String getDefault() {
		return "Hello,Spring Boot";
	}
	
	@RequestMapping(value="/atest",method=RequestMethod.GET)
	public String getTest() {
		return "Hello,Spring Boot ,/test and RequestMethod.GET";
	}
	
	@RequestMapping(value="/ahotreload",method=RequestMethod.GET)
	public String getHostReload() {
		return "Hello,Spring Boot ,/hotreload and RequestMethod.GEa22T";
	}
}
