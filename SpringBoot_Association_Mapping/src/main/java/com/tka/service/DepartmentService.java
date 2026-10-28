package com.tka.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tka.dao.Departmentdao;
import com.tka.entities.Department;

@Service
public class DepartmentService {

	@Autowired
	Departmentdao dao;

	public String insert(Department dept) {
		String msg = dao.insert(dept);
		return msg;
	}

	public Department getSingleDepartment(int id) {
		Department dept = dao.getSingleDeparment(id);
		return dept;
	}

	public List<Department> getAllDepartment() {
		List<Department> list = dao.getAllDeparment();
		return list;
	}

	public String updateDepartment(Department dept, int id) {
		String msg = dao.updateDepartment(dept, id);
		return msg;
	}

	public String deleteDeparment(int id) {
		String msg = dao.deleteDeparment(id);
		return msg;
	}

}
