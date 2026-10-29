package com.atk.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.atk.entity.AttendanceRecord;

public interface AttendanceRecordRepo extends JpaRepository<AttendanceRecord, Long> {

	boolean existsByStudentStudentIdAndSessionSessionId(Long studentId, Long sessionId);

	List<AttendanceRecord> findByAttendanceDate(LocalDate attendanceDate);

	List<AttendanceRecord> findByStudentStudentId(Long studentId);

	List<AttendanceRecord> findBySessionSessionId(Long sessionId);

	List<AttendanceRecord> findByStudentStudentIdAndSessionSessionDateBetween(Long studentId, LocalDate startDate,
			LocalDate endDate);

}
