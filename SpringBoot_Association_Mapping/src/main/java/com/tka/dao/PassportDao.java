package com.tka.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tka.entities.Passport;

@Repository
public class PassportDao {
	
	@Autowired
	SessionFactory factory;

	public String savePassport(Passport pass) {
		
		Session ss = factory.openSession();
		Transaction tr = ss.beginTransaction();
		
		ss.persist(pass);
		
		tr.commit();
		ss.close();
		
		return "Passport Save Successfully...!";
	}

}
