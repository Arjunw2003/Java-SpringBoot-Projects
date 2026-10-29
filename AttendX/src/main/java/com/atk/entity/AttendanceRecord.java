package com.atk.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "attendance_records", uniqueConstraints = @UniqueConstraint(name = "uk_student_session", columnNames = {
		"student_id", "session_id" }))
@Data
public class AttendanceRecord {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long attendanceId;

	@ManyToOne(optional = false)
	@JoinColumn(name = "student_id")
	private Student student;

	@ManyToOne(optional = false)
	@JoinColumn(name = "session_id")
	private AttendanceSession session;

	@Column(nullable = false)
	private LocalDate attendanceDate;

	private LocalTime checkInTime;
	private LocalTime checkOutTime;

	@Column(nullable = false)
	private String attendanceStatus;

	private String remarks;

	public Long getAttendanceId() {
		return attendanceId;
	}

	public void setAttendanceId(Long attendanceId) {
		this.attendanceId = attendanceId;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public AttendanceSession getSession() {
		return session;
	}

	public void setSession(AttendanceSession session) {
		this.session = session;
	}

	public LocalDate getAttendanceDate() {
		return attendanceDate;
	}

	public void setAttendanceDate(LocalDate attendanceDate) {
		this.attendanceDate = attendanceDate;
	}

	public LocalTime getCheckInTime() {
		return checkInTime;
	}

	public void setCheckInTime(LocalTime checkInTime) {
		this.checkInTime = checkInTime;
	}

	public LocalTime getCheckOutTime() {
		return checkOutTime;
	}

	public void setCheckOutTime(LocalTime checkOutTime) {
		this.checkOutTime = checkOutTime;
	}

	public String getAttendanceStatus() {
		return attendanceStatus;
	}

	public void setAttendanceStatus(String attendanceStatus) {
		this.attendanceStatus = attendanceStatus;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

}
