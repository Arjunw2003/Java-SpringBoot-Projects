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

import com.tka.entities.Department;
import com.tka.service.DepartmentService;

@RestController
@RequestMapping("/department")
public class DeparmentController {

	@Autowired
	DepartmentService service;

	@PostMapping("/addDepartment")
	public String insert(@RequestBody Department dept) {
		String msg = service.insert(dept);
		return msg;
	}
	
	@GetMapping("/getSingleDeparment")
	public Department getsingleDeparment(@RequestParam int id) {
		Department dept = service.getSingleDepartment(id);
		return dept;
	}
	
	@GetMapping("/getAllDeparment")
	public List<Department> getAllDeparment() {
		List<Department> list = service.getAllDepartment();
		return list;
	}
	
	@PutMapping("/updateDeparment/{id}")
	public String updateDepartment(@RequestBody Department dept,@PathVariable  int id) {
		String msg = service.updateDepartment(dept, id);
		return msg;
	}
	
	@DeleteMapping("/deleteDeparment")
	public String deleteDeparment(@RequestParam  int id) {
		String msg = service.deleteDeparment(id);
		return msg;
	}

}
