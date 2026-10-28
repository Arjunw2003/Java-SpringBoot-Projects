package com.tka.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tka.entities.Student;

@Repository
public class StudentDao {

	@Autowired
	SessionFactory factory;
	
	public String saveStudent(Student std) {
		
		Session ss = factory.openSession();
		Transaction tr = ss.beginTransaction();
		
		ss.persist(std);
		
		tr.commit();
		ss.close();
		
		return "Student save Successfully";
	}

}
