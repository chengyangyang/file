package com.ch.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ch.service.TestService;

@Controller
@RequestMapping("/t")
public class TestController {

	@Autowired
	TestService test;
	
	@RequestMapping(value = "/test", method = RequestMethod.GET)
    public String test(){
		System.out.println("nihao");
//        实际返回的是views/test.jsp ,spring-mvc.xml中配置过前后缀
        return "test";
	}
	
	@RequestMapping(value = "/springtest", method = RequestMethod.GET)
    public String springtest(){
		System.out.println(test.test());
        return test.test();
	}
	
	@RequestMapping(value = "/trantest", method = RequestMethod.GET)
    public String trantest(){
		test.gettest();
        return "test";
	}
}