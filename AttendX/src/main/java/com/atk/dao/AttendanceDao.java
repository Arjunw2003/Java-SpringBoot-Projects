package com.atk.dao;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.atk.entity.AttendanceRecord;
import com.atk.repository.AttendanceRecordRepo;

@Repository
public class AttendanceDao {

	@Autowired
	AttendanceRecordRepo repo;

	public AttendanceDao(AttendanceRecordRepo repo) {
		this.repo = repo;
	}

	public AttendanceRecord save(AttendanceRecord record) {
		return repo.save(record);
	}

	public Optional<AttendanceRecord> findById(Long id) {
		return repo.findById(id);
	}

	public List<AttendanceRecord> findAll() {
		return repo.findAll();
	}

	public boolean exists(Long studentId, Long sessionId) {
		return repo.existsByStudentStudentIdAndSessionSessionId(studentId, sessionId);
	}

	public List<AttendanceRecord> findByDate(LocalDate date) {
		return repo.findByAttendanceDate(date);
	}

	public List<AttendanceRecord> findByStudent(Long studentId) {
		return repo.findByStudentStudentId(studentId);
	}

	public List<AttendanceRecord> findBySession(Long sessionId) {
		return repo.findBySessionSessionId(sessionId);
	}

	public List<AttendanceRecord> findByStudentAndDateRange(Long studentId, LocalDate startDate, LocalDate endDate) {

		return repo.findByStudentStudentIdAndSessionSessionDateBetween(studentId, startDate, endDate);
	}
	
	
}