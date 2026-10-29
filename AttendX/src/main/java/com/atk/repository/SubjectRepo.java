package com.atk.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.atk.entity.Subject;

public interface SubjectRepo extends JpaRepository<Subject, Long> {
}
