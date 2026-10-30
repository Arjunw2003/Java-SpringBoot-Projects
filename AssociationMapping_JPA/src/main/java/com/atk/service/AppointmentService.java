package com.atk.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.atk.entities.Appointment;
import com.atk.entities.Doctor;
import com.atk.exception.NotFoundException;
import com.atk.repository.AppointmentRepo;

@Service
public class AppointmentService {

	@Autowired
	AppointmentRepo repo;

	public String addAppointment(Appointment appo) {
		repo.save(appo);
		return "Appointment Successfully...!";
	}

	public Appointment getByIdAppointment(int id) {
		return repo.findById(id).orElseThrow(() -> new NotFoundException("Appointmet Not Found with Id: " + id));
	}

	public List<Appointment> getAllAppointment() {
		return repo.findAll();
	}

	public String updateAppointment(Appointment appo, int id) {

		Appointment app = repo.getById(id);

		app.setPatientName(appo.getPatientName());
		app.setPatientAge(appo.getPatientAge());
		app.setAppointmentDate(appo.getAppointmentDate());
		app.setAppointmentTime(appo.getAppointmentTime());
		app.setReason(appo.getReason());
		app.setDoctor(appo.getDoctor());

		repo.save(app);

		return "Appointment Updated Successfully!";
	}

	public String deleteAppointment(int id) {
		repo.deleteById(id);
		return "Appointment Deleted...!";
	}

}
