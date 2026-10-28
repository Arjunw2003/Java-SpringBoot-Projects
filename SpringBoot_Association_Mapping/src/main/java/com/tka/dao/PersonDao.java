package com.tka.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tka.entities.Person;

@Repository
public class PersonDao {

	@Autowired
	SessionFactory factory;

	public String savePerson(Person per) {

		Session ss = factory.openSession();
		Transaction tr = ss.beginTransaction();

		ss.persist(per);

		tr.commit();
		ss.close();

		return "Save Person Successfully...!";
	}

}
