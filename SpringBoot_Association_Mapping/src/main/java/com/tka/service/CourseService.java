package com.tka.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tka.dao.CourseDao;
import com.tka.entities.Course;

@Service
public class CourseService {
	
	@Autowired
	CourseDao dao;

	public String addCourse(Course c) {
		
		return dao.addCourse(c);
	}

}
