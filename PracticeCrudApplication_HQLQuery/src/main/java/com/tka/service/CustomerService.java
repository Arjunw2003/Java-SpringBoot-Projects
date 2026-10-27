package com.tka.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tka.dao.CustomerDao;
import com.tka.entities.Customer;

@Service
public class CustomerService {
	
	@Autowired
	CustomerDao dao;
	
	public String addCustomer(Customer c) {
		
		return dao.addCustomer(c);
		
	}

	public String updateCustomer(Customer c, int id) {
		return dao.updateCustomer(c, id);
	}

	public String deleteCustomer(int id) {
		return dao.deleteCustomer(id);
	}

	public Customer getSingleCustomer(int id) {
		return dao.getSingleCustomer(id);
		
	} 
	
	public List<Customer> getAllData() {
		return dao.getAllCustomer();
	}

}
