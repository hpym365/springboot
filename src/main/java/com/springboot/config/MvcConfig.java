package com.springboot.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
/**
 * 
 * @author hanpeng
 * mvc配置类 
 * 现配置了localtions对应web请求目录
 */
@Configuration
public class MvcConfig extends WebMvcConfigurerAdapter {

	public void addResourceHandlers(ResourceHandlerRegistry reg){
		reg.addResourceHandler("/jttp/**").addResourceLocations("classpath:/tp/");
		System.out.println("目录映射关系为");
		
		System.out.println(reg);
		super.addResourceHandlers(reg);
	}
}
