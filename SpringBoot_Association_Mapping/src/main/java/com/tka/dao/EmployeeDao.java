package com.tka.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tka.entities.Employee;

@Repository
public class EmployeeDao {

	@Autowired
	SessionFactory factory;
	
	public String addEmployee(Employee emp) {
		Session ss = factory.openSession();
		Transaction tr = ss.beginTransaction();

		ss.persist(emp);

		tr.commit();
		ss.close();
		
		return "Add Employee Success...!";
	}
	
	public Employee getSingleEmployee(int id) {
		Session ss = factory.openSession();
		Transaction tr = ss.beginTransaction();
		
		Employee emp = ss.find(Employee.class, id);
		
		tr.commit();
		ss.close();
		
		return emp;
	}

	public List<Employee> getAllEmployee() {
		
		Session ss = factory.openSession();
		Transaction tr = ss.beginTransaction();
		
		String HqlQ ="from Employee";
		
		Query<Employee> query = ss.createQuery(HqlQ, Employee.class);
		List<Employee> list = query.getResultList();
		
		tr.commit();
		ss.close();
		
		return list;
		
	}

	public String updateEmployee(int id, Employee emp) {
		Session ss = factory.openSession();
		Transaction tr = ss.beginTransaction();
		
		Employee e = ss.find(Employee.class, id);
		
		e.setEmpName(emp.getEmpName());
		e.setEmail(emp.getEmail());
		e.setMobNumber(emp.getMobNumber());
		e.setGender(emp.getGender());
		e.setAge(emp.getAge());
		e.setDob(emp.getDob());
		e.setDesignation(emp.getDesignation());
		e.setSalary(emp.getSalary());
		e.setQualification(emp.getQualification());
		e.setExperience(emp.getExperience());
		e.setCity(emp.getCity());
		e.setState(emp.getState());
		e.setCountry(emp.getCountry());
		e.setPincode(emp.getPincode());
		e.setAddress(emp.getAddress());
		e.setEmploymentType(emp.getEmploymentType());
		e.setStatus(emp.getStatus());
		e.setStatus(emp.getStatus());
		e.setJoiningDate(emp.getJoiningDate());
		e.setDept(emp.getDept());
		
		ss.merge(e);
		
		tr.commit();
		ss.close();
		
		return "Employee Updated SuccessFully...!";
	}

	public String deleteEmployee(int id) {
		
		Session ss = factory.openSession();
		Transaction tr = ss.beginTransaction();
		
		Employee emp = ss.find(Employee.class, id);
		
		ss.remove(emp);
		
		tr.commit();
		ss.close();
		
		return "Employee deleted Successfully...!";
	}
}
