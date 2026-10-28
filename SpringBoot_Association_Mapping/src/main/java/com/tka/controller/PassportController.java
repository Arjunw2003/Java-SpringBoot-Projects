package com.tka.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tka.entities.Passport;
import com.tka.service.PassportService;

@RestController
@RequestMapping("/passport")
public class PassportController {

	@Autowired
	PassportService service;
	
	@PostMapping("/savePassport")
	public String savePassport(@RequestBody Passport pass) {
		String msg = service.savePassport(pass);
		return msg;
	}
}
