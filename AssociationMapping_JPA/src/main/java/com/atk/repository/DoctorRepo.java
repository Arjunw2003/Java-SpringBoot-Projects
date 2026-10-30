package com.atk.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.atk.entities.Doctor;

@Repository
public interface DoctorRepo extends JpaRepository<Doctor, Integer> {

}
