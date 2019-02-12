package com.quicktutorials.learnmicroservices.ToDoMicroservices.controllers;


import org.springframework.web.bind.annotation.RequestMapping;

@org.springframework.web.bind.annotation.RestController
public class RestController {

	
	
	@RequestMapping("/hello")
	public String sayHello() {
		return "hello controller";        //"hello"-> hello.jsp is searched by ViewResolver if u don't put @ResponseBody
	
	}
}
