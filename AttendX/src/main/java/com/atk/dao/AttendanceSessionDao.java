package com.atk.dao;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.atk.entity.AttendanceSession;
import com.atk.repository.AttendanceSessionRepo;

@Repository
public class AttendanceSessionDao {

	@Autowired
	AttendanceSessionRepo repo;

	public AttendanceSessionDao(AttendanceSessionRepo repo) {
		this.repo = repo;
	}

	public Optional<AttendanceSession> findById(Long id) {
		return repo.findById(id);
	}

	public List<AttendanceSession> findBetween(LocalDate startDate, LocalDate endDate) {
		return repo.findBySessionDateBetween(startDate, endDate);
	}
}
