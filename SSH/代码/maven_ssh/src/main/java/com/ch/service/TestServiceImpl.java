package com.ch.service;



import java.util.Date;


import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.ch.bean.Test;

@Service
@Transactional
public class TestServiceImpl implements TestService {

	@Autowired
	SessionFactory sessionfactoty;
	
	public String test() {
		
		Session session = sessionfactoty.openSession();
		
		Criteria createCriteria = session.createCriteria(Test.class);
		Test test01 = new Test();
		test01.setName("西游记");
		test01.setTime(new Date());
		session.save(test01);
		session.close();
		return "test";
	}
	
	@Transactional(rollbackFor = RuntimeException.class)
	public void gettest() {
		Session session = sessionfactoty.getCurrentSession();
		for(int i = 0; i < 4; i++){
			Test test01 = new Test();
			test01.setName("西游记26");
			test01.setTime(new Date());
			session.save(test01);
			if(i == 2){
				int c = 1/1;
				
			}
			
		}
		
	}
}
