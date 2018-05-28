package com.ch.bean;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ch.service.TestServiceImpl;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-hibernate.xml")
public class Junit {
	@Autowired
	TestServiceImpl testservice;
	
	@Test
	public void gettest() {
		testservice.gettest();
}
}