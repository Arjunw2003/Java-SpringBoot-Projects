package com.atk.controller;

import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.atk.entity.AttendanceSession;
import com.atk.entity.Subject;
import com.atk.entity.Teacher;
import com.atk.repository.AttendanceSessionRepo;
import com.atk.repository.SubjectRepo;
import com.atk.repository.TeacherRepo;

@RestController
@RequestMapping("/api")
public class SetupController {

	private final TeacherRepo teachers;
	private final SubjectRepo subjects;
	private final AttendanceSessionRepo sessions;

	public SetupController(TeacherRepo teachers, SubjectRepo subjects, AttendanceSessionRepo sessions) {
		this.teachers = teachers;
		this.subjects = subjects;
		this.sessions = sessions;
	}

	@PostMapping("/teachers")
	@ResponseStatus(HttpStatus.CREATED)
	public Teacher addTeacher(@RequestBody Teacher teacher) {
		return teachers.save(teacher);
	}

	@PostMapping("/subjects")
	@ResponseStatus(HttpStatus.CREATED)
	public Subject addSubject(@RequestBody Subject subject) {
		return subjects.save(subject);
	}

	@PostMapping("/sessions")
	@ResponseStatus(HttpStatus.CREATED)
	public AttendanceSession addSession(@RequestBody Map<String, Object> body) {

		Long teacherId = Long.valueOf(body.get("teacherId").toString());
		Long subjectId = Long.valueOf(body.get("subjectId").toString());

		Teacher teacher = teachers.findById(teacherId)
				.orElseThrow(() -> new IllegalArgumentException("Teacher not found"));

		Subject subject = subjects.findById(subjectId)
				.orElseThrow(() -> new IllegalArgumentException("Subject not found"));

		AttendanceSession session = new AttendanceSession();
		session.setTeacher(teacher);
		session.setSubject(subject);
		session.setSessionDate(java.time.LocalDate.parse(body.get("sessionDate").toString()));

		if (body.get("startTime") != null) {
			session.setStartTime(java.time.LocalTime.parse(body.get("startTime").toString()));
		}

		if (body.get("endTime") != null) {
			session.setEndTime(java.time.LocalTime.parse(body.get("endTime").toString()));
		}

		return sessions.save(session);
	}
}
