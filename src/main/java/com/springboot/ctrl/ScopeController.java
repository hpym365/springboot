package com.springboot.ctrl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpRequest;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.entity.Student;
import com.springboot.entity.User;
import com.springboot.repository.StudentRepsitory;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@RestController
@Scope("request")
//当不添加scope 默认为sigleton 单例模式 全局使用一个对象
//当为prototype 每次被调用都会创建一个实例
//当scope为session时  每个session创建一个当前实例 
//当为request时 每次请求创建一个当前实例
// @RequestMapping(value = "/scope")
public class ScopeController {

	private List<String> list = new ArrayList<String>();

	@RequestMapping("/get")
	public List<String> getList(HttpServletRequest req) {
//		this.getClass();
		if(list.size()==0)
			list.add(req+"");
		return list;
	}

	@RequestMapping("/set")
	public List<String> setList(HttpServletRequest req) {
		list.add("增加" + new Date()+"  request:"+req);
		return list;
	}
}
