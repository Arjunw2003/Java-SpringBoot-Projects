package com.tka.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tka.dao.PersonDao;
import com.tka.entities.Person;

@Service
public class PersonService {
	
	@Autowired
	PersonDao dao;

	public String savePerson(Person per) {
		String msg = dao.savePerson(per);
		return msg;
	}

}
