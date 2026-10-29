package com.atk.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.atk.dto.AbsentStudentResponse;
import com.atk.dto.MonthlyAttendanceReport;
import com.atk.entity.AttendanceRecord;
import com.atk.service.AttendanceService;

@RestController
@RequestMapping("/api/attendance")
public class AttendanceController {

	private final AttendanceService service;

	public AttendanceController(AttendanceService service) {
		this.service = service;
	}

	@PostMapping("/mark/{studentId}/{sessionId}")
	@ResponseStatus(HttpStatus.CREATED)
	public AttendanceRecord markAttendance(@PathVariable Long studentId, @PathVariable Long sessionId,
			@RequestBody AttendanceRecord record) {
		return service.markAttendance(studentId, sessionId, record);
	}

	@GetMapping
	public List<AttendanceRecord> getAllAttendance() {
		return service.getAllAttendance();
	}

	@GetMapping("/date/{date}")
	public List<AttendanceRecord> getByDate(@PathVariable String date) {
		return service.getByDate(date);
	}

	@GetMapping("/student/{studentId}")
	public List<AttendanceRecord> getByStudent(@PathVariable Long studentId) {
		return service.getByStudent(studentId);
	}

	@GetMapping("/session/{sessionId}")
	public List<AttendanceRecord> getBySession(@PathVariable Long sessionId) {
		return service.getBySession(sessionId);
	}

	@GetMapping("/report/monthly/{studentId}")
	public MonthlyAttendanceReport getMonthlyReport(@PathVariable Long studentId, @RequestParam int year,
			@RequestParam int month) {

		return service.getMonthlyReport(studentId, year, month);
	}

	@GetMapping("/absent/session/{sessionId}")
	public List<AbsentStudentResponse> getAbsentStudents(@PathVariable Long sessionId) {

		return service.getAbsentStudents(sessionId);
	}
}