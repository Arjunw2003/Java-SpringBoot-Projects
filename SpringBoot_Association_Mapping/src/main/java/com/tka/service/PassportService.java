package com.tka.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tka.dao.PassportDao;
import com.tka.entities.Passport;

@Service
public class PassportService {
	
	@Autowired
	PassportDao dao;

	public String savePassport(Passport pass) {
		String msg = dao.savePassport(pass);
		return msg;
	}

}
