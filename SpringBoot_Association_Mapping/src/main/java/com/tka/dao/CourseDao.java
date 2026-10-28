package com.tka.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tka.entities.Course;

@Repository
public class CourseDao {

	@Autowired
	SessionFactory factory;

	public String addCourse(Course c) {

		Session ss = factory.openSession();
		Transaction tr = ss.beginTransaction();

		ss.persist(c);

		tr.commit();
		ss.close();

		return "Course Added Successfully";
	}

}
