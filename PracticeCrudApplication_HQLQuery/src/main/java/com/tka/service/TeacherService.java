package com.tka.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tka.dao.TeacherDao;
import com.tka.entities.Teacher;

@Service
public class TeacherService {

	@Autowired
	TeacherDao dao;

	public String addTeacher(Teacher te) {
		return dao.addTeacher(te);
	}

	public String updateTeacher(Teacher te, int id) {
		return dao.updateTeacher(te, id);
	}

	public String deleteTeacher(int id) {
		return dao.deleteTeacher(id);
	}
	
	public Teacher getSingleTeacher(int id) {
		return dao.getSingleTeacher(id);
	}
	
	public List<Teacher> getAllTeacher() {
		return dao.getAllTeacher();
	}

}
