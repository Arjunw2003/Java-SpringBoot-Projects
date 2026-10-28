package com.tka.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tka.dao.EmployeeDao;
import com.tka.entities.Employee;

@Service
public class EmployeeService {

	@Autowired
	EmployeeDao dao;

	public String addEmployee(Employee emp) {
		String msg = dao.addEmployee(emp);
		return msg;
	}

	public Employee getSingleEmployee(int id) {
		Employee emp = dao.getSingleEmployee(id);
		return emp;
	}

	public List<Employee> getAllEmployee() {
		List<Employee> list = dao.getAllEmployee();
		return list;
		
	}

	public String updateEmployee(int id, Employee emp) {
		String msg = dao.updateEmployee(id,emp);
		return msg;
	}

	public String deleteEmployee(int id) {
		String msg = dao.deleteEmployee(id);
		return msg;
	}
}
