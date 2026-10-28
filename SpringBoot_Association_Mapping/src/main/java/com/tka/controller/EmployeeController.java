package com.tka.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tka.entities.Employee;
import com.tka.service.EmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

	@Autowired
	EmployeeService service;

	@PostMapping("/addEmployee")
	public String addEmployee(@RequestBody Employee emp) {
		String msg = service.addEmployee(emp);
		return msg;
	}

	@GetMapping("/getSingleEmployee/{id}")
	public Employee getSingleEmployee(@PathVariable int id) {
		Employee emp = service.getSingleEmployee(id);
		return emp;
	}

	@GetMapping("/getAllEmployee")
	public List<Employee> getAllEmployee() {
		List<Employee> list = service.getAllEmployee();
		return list;
	}
	
	@PutMapping("/updateEmployee/{id}")
	public String updateEmployee(@PathVariable int id, @RequestBody Employee emp) {
		String msg = service.updateEmployee(id, emp);
		return msg; 
	}
	
	@DeleteMapping("/deleteEmployee")
	public String deleteEmployee(@RequestParam int id) {
		String msg = service.deleteEmployee(id);
		return msg;
	}
}
