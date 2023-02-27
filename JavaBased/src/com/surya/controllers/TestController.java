package com.surya.controllers;


import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.ServletContext;
import javax.servlet.ServletRequest;

import org.apache.catalina.core.ApplicationContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.web.FilterChainProxy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.WebApplicationContext;

@RestController
//@RequestMapping(value="/test")
public class TestController {
	@Autowired
	@Qualifier("springSecurityFilterChain")
	private Filter springSecurityFilterChain;
	@GetMapping("/hello")
	public String hello(ServletRequest request)
	{
	ServletContext context=request.getServletContext();
	System.out.println(context);
		Enumeration e=context.getAttributeNames();
		System.out.println("-----------------");
//		Collections.list(ac.getAttributeNames()).stream().forEach((x)->System.out.println(x));
		WebApplicationContext xx=(WebApplicationContext) context.getAttribute("org.springframework.web.context.WebApplicationContext.ROOT");
		Arrays.asList(xx.getBeanDefinitionNames()).stream().forEach((x)->System.out.println(x));
		System.out.println("-----------------");
		Collections.list(e).stream().forEach((x)->System.out.println(x));
		System.out.println("kjkj"+xx.getBean("springSecurityFilterChain").getClass().getName());
		 FilterChainProxy filterChainProxy = (FilterChainProxy) springSecurityFilterChain;
		System.out.println("=========");
		 filterChainProxy.getFilterChains().stream().forEach((x)->System.out.println(x));
		 return "hello";
	}
	
	
	
	@GetMapping("/hi")
	public String hi(ServletRequest request)
	{
	ServletContext context=request.getServletContext();
	System.out.println(context);
		Enumeration e=context.getAttributeNames();
		System.out.println("-----------------");
//		Collections.list(ac.getAttributeNames()).stream().forEach((x)->System.out.println(x));
		WebApplicationContext xx=(WebApplicationContext) context.getAttribute("org.springframework.web.context.WebApplicationContext.ROOT");
		Arrays.asList(xx.getBeanDefinitionNames()).stream().forEach((x)->System.out.println(x));
		System.out.println("-----------------");
		Collections.list(e).stream().forEach((x)->System.out.println(x));
		System.out.println("kjkj"+xx.getBean("springSecurityFilterChain").getClass().getName());
		 FilterChainProxy filterChainProxy = (FilterChainProxy) springSecurityFilterChain;
		System.out.println("=========");
		 filterChainProxy.getFilterChains().stream().forEach((x)->System.out.println(x));
		 return "hi";
	}

}
