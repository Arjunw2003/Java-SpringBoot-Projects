package com.tka.dao;

import com.tka.service.TeacherService;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.MutationQuery;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.tka.PracticeCrudApplicationHqlQueryApplication;
import com.tka.entities.Customer;

@Repository
public class CustomerDao {

	private final PracticeCrudApplicationHqlQueryApplication practiceCrudApplicationHqlQueryApplication;

	private final TeacherService teacherService;

	@Autowired
	SessionFactory factory;

	CustomerDao(TeacherService teacherService,
			PracticeCrudApplicationHqlQueryApplication practiceCrudApplicationHqlQueryApplication) {
		this.teacherService = teacherService;
		this.practiceCrudApplicationHqlQueryApplication = practiceCrudApplicationHqlQueryApplication;
	}

	public String addCustomer(Customer c) {

		Session ss = factory.openSession();
		Transaction tr = ss.beginTransaction();

		String hqlQuery = "insert into Customer(customerName, email, mobileNumber, city) values(:customerName, :email, :mobileNumber, :city)";

		MutationQuery mq = ss.createMutationQuery(hqlQuery);

		mq.setParameter("customerName", c.getCustomerName());
		mq.setParameter("email", c.getEmail());
		mq.setParameter("mobileNumber", c.getMobileNumber());
		mq.setParameter("city", c.getCity());

		int add = mq.executeUpdate();

		tr.commit();
		ss.close();

		if (add > 0) {
			return "Add Customer Succesfully...!";
		} else {
			return "Add Customer Faild...!";

		}

	}

	public String updateCustomer(Customer c, int id) {

		Session ss = factory.openSession();
		Transaction tr = ss.beginTransaction();

		String hqlQuery = "update Customer set customerName = :customerName, email = :email, mobileNumber = :mobileNumber, city = :city where customerId = :id";

		MutationQuery mq = ss.createMutationQuery(hqlQuery);

		mq.setParameter("id", id);
		mq.setParameter("customerName", c.getCustomerName());
		mq.setParameter("email", c.getEmail());
		mq.setParameter("mobileNumber", c.getMobileNumber());
		mq.setParameter("city", c.getCity());

		int update = mq.executeUpdate();

		tr.commit();
		ss.close();

		if (update > 0) {
			return "Customer Updated Successfully...!";
		} else {
			return "Customer Updated Faild...!";
		}
	}

	public String deleteCustomer(int id) {

		Session ss = factory.openSession();
		Transaction tr = ss.beginTransaction();

		String hqlQuery = "delete from Customer where customerId = :id";

		MutationQuery mq = ss.createMutationQuery(hqlQuery);

		mq.setParameter("id", id);

		int delete = mq.executeUpdate();

		tr.commit();
		ss.close();

		if (delete > 0) {
			return "Customer Deleted Successfully...!";
		} else {
			return "Customer Deleted Faild...!";
		}
	}

	public Customer getSingleCustomer(int id) {

		Session ss = factory.openSession();
		Transaction tr = ss.beginTransaction();

		String hqlQuery = "from Customer where customerId = :id";

		Query<Customer> query = ss.createQuery(hqlQuery, Customer.class);

		query.setParameter("id", id);

		Customer c = query.getSingleResult();

		return c;

	}
	
	public List<Customer> getAllCustomer() {
		Session ss = factory.openSession();
		Transaction tr = ss.beginTransaction();
		
		String hqlQuery = "from Customer";
		
		Query<Customer> query = ss.createQuery(hqlQuery, Customer.class);
		List<Customer> list = query.getResultList();
		
		return list;
	}

}
