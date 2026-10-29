package com.atk.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.atk.entity.Student;

public interface StudentRepo extends JpaRepository<Student, Long> {
	boolean existsByEmail(String email);
}
