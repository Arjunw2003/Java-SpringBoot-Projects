package com.atk.service;

import java.time.LocalDate;
import java.time.YearMonth;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.atk.dao.AttendanceDao;
import com.atk.dto.AbsentStudentResponse;
import com.atk.dto.MonthlyAttendanceReport;
import com.atk.entity.AttendanceRecord;
import com.atk.entity.AttendanceSession;
import com.atk.entity.Student;
import com.atk.repository.AttendanceSessionRepo;
import com.atk.repository.StudentRepo;

@Service
public class AttendanceService {

	private final AttendanceDao dao;
	private final StudentRepo studentRepo;
	private final AttendanceSessionRepo sessionRepo;

	public AttendanceService(AttendanceDao dao, StudentRepo studentRepo, AttendanceSessionRepo sessionRepo) {
		this.dao = dao;
		this.studentRepo = studentRepo;
		this.sessionRepo = sessionRepo;
	}

	@Transactional
	public AttendanceRecord markAttendance(Long studentId, Long sessionId, AttendanceRecord input) {

		Student student = studentRepo.findById(studentId)
				.orElseThrow(() -> new IllegalArgumentException("Student not found"));

		AttendanceSession session = sessionRepo.findById(sessionId)
				.orElseThrow(() -> new IllegalArgumentException("Session not found"));

		if (dao.exists(studentId, sessionId)) {
			throw new IllegalArgumentException("Attendance already marked for this student and session");
		}

		if (!session.getSessionDate().equals(input.getAttendanceDate())) {
			throw new IllegalArgumentException("Attendance date must match session date");
		}

		String status = input.getAttendanceStatus();

		if (status == null || !List.of("PRESENT", "ABSENT").contains(status)) {
			throw new IllegalArgumentException("Status must be PRESENT or ABSENT");
		}

		AttendanceRecord record = new AttendanceRecord();
		record.setStudent(student);
		record.setSession(session);
		record.setAttendanceDate(input.getAttendanceDate());
		record.setAttendanceStatus(status);
		record.setCheckInTime(input.getCheckInTime());
		record.setCheckOutTime(input.getCheckOutTime());
		record.setRemarks(input.getRemarks());

		return dao.save(record);
	}

	public List<AttendanceRecord> getAllAttendance() {
		return dao.findAll();
	}

	public List<AttendanceRecord> getByDate(String date) {
		return dao.findByDate(LocalDate.parse(date));
	}

	public List<AttendanceRecord> getByStudent(Long studentId) {
		if (!studentRepo.existsById(studentId)) {
			throw new IllegalArgumentException("Student not found");
		}
		return dao.findByStudent(studentId);
	}

	public List<AttendanceRecord> getBySession(Long sessionId) {
		if (!sessionRepo.existsById(sessionId)) {
			throw new IllegalArgumentException("Session not found");
		}
		return dao.findBySession(sessionId);
	}

	public MonthlyAttendanceReport getMonthlyReport(Long studentId, int year, int month) {

		if (month < 1 || month > 12) {
			throw new IllegalArgumentException("Month must be between 1 and 12");
		}

		Student student = studentRepo.findById(studentId)
				.orElseThrow(() -> new IllegalArgumentException("Student not found"));

		YearMonth yearMonth = YearMonth.of(year, month);

		LocalDate startDate = yearMonth.atDay(1);
		LocalDate endDate = yearMonth.atEndOfMonth();

		// All scheduled sessions for the requested month
		long totalSessions = sessionRepo.findBySessionDateBetween(startDate, endDate).size();

		List<AttendanceRecord> records = dao.findByStudentAndDateRange(studentId, startDate, endDate);

		int present = 0;
		int markedAbsent = 0;

		for (AttendanceRecord record : records) {
			switch (record.getAttendanceStatus()) {
			case "PRESENT" -> present++;
			case "ABSENT" -> markedAbsent++;
			default -> throw new IllegalArgumentException("Invalid attendance status in database");
			}
		}

		int unmarked = (int) totalSessions - records.size();
		int absent = markedAbsent + unmarked;

		double percentage = totalSessions == 0 ? 0.0 : Math.round((present * 10000.0) / totalSessions) / 100.0;

		return new MonthlyAttendanceReport(student.getStudentId(), student.getStudentName(), year, month,
				(int) totalSessions, present, absent, unmarked, percentage);
	}

	public List<AbsentStudentResponse> getAbsentStudents(Long sessionId) {

		AttendanceSession session = sessionRepo.findById(sessionId)
				.orElseThrow(() -> new IllegalArgumentException("Session not found"));

		Set<Long> absentIds = dao.findBySession(sessionId).stream()
				.filter(record -> "ABSENT".equals(record.getAttendanceStatus()))
				.map(record -> record.getStudent().getStudentId()).collect(Collectors.toSet());

		Set<Long> recordedIds = dao.findBySession(sessionId).stream().map(record -> record.getStudent().getStudentId())
				.collect(Collectors.toSet());

		List<Student> students = studentRepo.findAll();

		return students.stream().filter(Student::isActive).filter(
				student -> absentIds.contains(student.getStudentId()) || !recordedIds.contains(student.getStudentId()))
				.map(student -> new AbsentStudentResponse(session.getSessionId(), student.getStudentId(),
						student.getStudentName(), student.getEmail()))
				.toList();
	}

}
