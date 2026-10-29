package com.atk.controller;


import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.atk.entity.Student;
import com.atk.service.StudentService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/students")
public class StudentController {

	private final StudentService service;

	public StudentController(StudentService service) {
		this.service = service;
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Student addStudent(@Valid @RequestBody Student student) {
		return service.addStudent(student);
	}

	@GetMapping
	public List<Student> getAllStudents() {
		return service.getAllStudents();
	}

	@GetMapping("/{id}")
	public Student getStudent(@PathVariable Long id) {
		return service.getStudent(id);
	}

	@PutMapping("/{id}")
	public Student updateStudent(@PathVariable Long id, @Valid @RequestBody Student student) {
		return service.updateStudent(id, student);
	}

	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteStudent(@PathVariable Long id) {
		service.deleteStudent(id);
	}
}
