package com.atk.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.atk.dao.StudentDao;
import com.atk.entity.Student;

@Service
public class StudentService {

	private final StudentDao dao;

	public StudentService(StudentDao dao) {
		this.dao = dao;
	}

	@Transactional
	public Student addStudent(Student student) {
		if (dao.existsByEmail(student.getEmail())) {
			throw new IllegalArgumentException("Student email already exists");
		}

		return dao.save(student);
	}

	public List<Student> getAllStudents() {
		return dao.findAll();
	}

	public Student getStudent(Long id) {
		return dao.findById(id).orElseThrow(() -> new IllegalArgumentException("Student not found: " + id));
	}

	@Transactional
	public Student updateStudent(Long id, Student input) {
		Student student = getStudent(id);

		if (!student.getEmail().equals(input.getEmail()) && dao.existsByEmail(input.getEmail())) {
			throw new IllegalArgumentException("Student email already exists");
		}

		student.setStudentName(input.getStudentName());
		student.setEmail(input.getEmail());
		student.setMobileNumber(input.getMobileNumber());
		student.setGender(input.getGender());
		student.setCity(input.getCity());
		student.setCourse(input.getCourse());
		student.setBatch(input.getBatch());
		student.setAdmissionDate(input.getAdmissionDate());
		student.setActive(input.isActive());

		return dao.save(student);
	}

	@Transactional
	public void deleteStudent(Long id) {
		Student student = getStudent(id);
		dao.deleteById(student.getStudentId());
	}
}
