package com.springboot.ctrl;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
	
	@RequestMapping("/")
	public String getDefault() {
		return "Hello,Spring Boot12123cdxfxnbv ,mnbvcx hgfdszaVGBC NMFDGEWza";
	}
	
	@RequestMapping(value="/test",method=RequestMethod.GET)
	public String getTest() {
		return "Hello,Spring Boot ,/test and RequestMethod.GET";
	}
	
	@RequestMapping(value="/hotreload",method=RequestMethod.GET)
	public String getHostReload() {
		return "Hello,Spring Boot ,/hotreload and RequestMethod.GET2";
	}
}
