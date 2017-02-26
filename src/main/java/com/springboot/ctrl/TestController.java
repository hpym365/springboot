package com.springboot.ctrl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.dao.UserDao;
import com.springboot.entity.User;

//@Controller
public class TestController {
	@Autowired
	UserDao dao;
	
	@RequestMapping("/")
    public String index(ModelMap map) {
        // 加入一个属性，用来在模板中读取
        map.addAttribute("host", "http://blog.didispace.com");
        // return模板文件的名称，对应src/main/resources/templates/index.html
        return "index";  
    }
	
	@ResponseBody
	@RequestMapping(value="/test",method=RequestMethod.GET)
	public String getTest() {
		return "Hello,Spring Boot ,/test and RequestMethod.GET";
	}
	
	@RequestMapping(value="/hotreload",method=RequestMethod.GET)
	public String getHostReload() {
		return "Hello,Spring Boot ,/hotreload and RequestMethod.GET2";
	}
	
	@RequestMapping(value="/adduser",method=RequestMethod.POST)
	public String adduser(@RequestBody User user) {
		dao.createUser(user);
		return "Hello,Spring Boot ,/hotreload and RequestMethod.GET2";
	}
}
