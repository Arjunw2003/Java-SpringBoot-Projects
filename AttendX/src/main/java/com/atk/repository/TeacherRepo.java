package com.atk.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.atk.entity.Teacher;

public interface TeacherRepo extends JpaRepository<Teacher, Long> {
}
