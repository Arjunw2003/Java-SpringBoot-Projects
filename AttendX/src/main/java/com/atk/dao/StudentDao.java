package com.atk.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.atk.entity.Student;
import com.atk.repository.StudentRepo;

@Repository
public class StudentDao {

	@Autowired
	StudentRepo repo;

	public StudentDao(StudentRepo repo) {
		this.repo = repo;
	}

	public Student save(Student student) {
		return repo.save(student);
	}

	public List<Student> findAll() {
		return repo.findAll();
	}

	public Optional<Student> findById(Long id) {
		return repo.findById(id);
	}

	public boolean existsByEmail(String email) {
		return repo.existsByEmail(email);
	}

	public void deleteById(Long id) {
		repo.deleteById(id);
	}
}