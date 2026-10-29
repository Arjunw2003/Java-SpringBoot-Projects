package com.atk.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.atk.entity.AttendanceSession;

public interface AttendanceSessionRepo extends JpaRepository<AttendanceSession, Long> {

//	List<AttendanceSession> findBySessionDate(LocalDate sessionDate);

	List<AttendanceSession> findBySessionDateBetween(LocalDate startDate, LocalDate endDate);
}
