package com.softi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.softi.bean.Person;
import com.softi.dao.PersonMapper;

@Service
public class PersonService {

	@Autowired
	PersonMapper personMapper;
	
	
	public List<Person> getAllPerson(){		
		return personMapper.selectByExample(null);
	}
	
		
	
}
