package com.atk.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.atk.entities.Doctor;
import com.atk.exception.NotFoundException;
import com.atk.repository.DoctorRepo;

@Service
public class DoctorService {

	@Autowired
	DoctorRepo repo;

	public String addDoctor(Doctor d) {
		repo.save(d);
		return "Add Doctor Successfully...!";
	}

	public Doctor getById(int id) {
		return repo.findById(id).orElseThrow(() -> new NotFoundException("Doctor Not Found with Id: " + id));

	}

	public List<Doctor> getAllDoctor() {
		return repo.findAll();
	}

	public String updateDoctor(Doctor d, int id) {
		Doctor d1 = repo.getById(id);
		d1.setDoctorName(d.getDoctorName());
		d1.setSpecialization(d.getSpecialization());
		d1.setExperience(d.getExperience());
		d1.setFees(d.getFees());
		d1.setHospitalName(d.getHospitalName());

		repo.save(d1);

		return "Doctor Updated Successfully...!";
	}

	public String deleteDoctor(int id) {
		repo.deleteById(id);
		return "Doctor Deleted Success...!";

	}

}
