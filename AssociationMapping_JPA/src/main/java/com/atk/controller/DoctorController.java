package com.atk.controller;

import java.util.List;
import java.util.Optional;

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

import com.atk.entities.Doctor;
import com.atk.service.DoctorService;

@RestController
@RequestMapping("/doctor")
public class DoctorController {

	@Autowired
	DoctorService service;

	@PostMapping("/addDoctor")
	public String addDoctor(@RequestBody Doctor d) {
		return service.addDoctor(d);
	}

	@GetMapping("/getById/{id}")
	public Doctor getSingleDoctor(@PathVariable int id) {
		return service.getById(id);
	}

	@GetMapping("/getAll")
	public List<Doctor> getAllDoctor() {
		return service.getAllDoctor();
	}
	
	@PutMapping("/updateDoctor/{id}")
	public String updateDoctor(@RequestBody Doctor d,@PathVariable int id) {
		return service.updateDoctor(d, id);
	}
	
	@DeleteMapping("/deleteDoctor")
	public String deleteDoctor(@RequestParam int id) {
		return service.deleteDoctor(id);
	} 

}
