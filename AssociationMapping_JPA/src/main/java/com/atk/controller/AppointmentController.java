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

import com.atk.entities.Appointment;
import com.atk.service.AppointmentService;

@RestController
@RequestMapping("/appointment")
public class AppointmentController {
	
	@Autowired
	AppointmentService service;

	@PostMapping("/addAppointment")
	public String addAppointment(@RequestBody Appointment appo) {
		return service.addAppointment(appo);
	}
	
	@GetMapping("/getById/{id}")
	public Appointment getBySingleAppointment(@PathVariable int id) {
		return service.getByIdAppointment(id);
	}
	
	@GetMapping("/getAll")
	public List<Appointment> getAllAppointment() {
		return service.getAllAppointment();
	}
	
	@PutMapping("/update/{id}")
	public String updateAppointment(@RequestBody Appointment appo,@PathVariable int id) {
		return service.updateAppointment(appo, id);
	}
	
	@DeleteMapping("/delete")
	public String deleteAppointment(@RequestParam int id) {
		return service.deleteAppointment(id);
	}
	
}
