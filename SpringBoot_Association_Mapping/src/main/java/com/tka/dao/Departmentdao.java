package com.tka.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tka.entities.Department;

@Repository
public class Departmentdao {

	@Autowired
	SessionFactory factory;

	public String insert(Department dept) {

		Session ss = factory.openSession();
		Transaction tr = ss.beginTransaction();

		ss.persist(dept);

		tr.commit();
		ss.close();

		return "Department Insert...!";
	}

	public Department getSingleDeparment(int id) {

		Session ss = factory.openSession();
		Transaction tr = ss.beginTransaction();

		Department dept = ss.find(Department.class, id);

		dept.getEmp().size();

		tr.commit();
		ss.close();

		return dept;
	}

	public List<Department> getAllDeparment() {

		Session ss = factory.openSession();
		Transaction tr = ss.beginTransaction();

		String hqlQuery = "from Department";

		Query<Department> query = ss.createQuery(hqlQuery, Department.class);
		List<Department> list = query.getResultList();

		return list;
	}

	public String updateDepartment(Department dept, int id) {

		Session ss = factory.openSession();
		Transaction tr = ss.beginTransaction();

		Department dep = ss.find(Department.class, id);

		dep.setDeptName(dept.getDeptName());

		ss.merge(dep);
		tr.commit();
		ss.close();

		return "Department Updated Successfully";
	}

	public String deleteDeparment(int id) {
		Session ss = factory.openSession();
		Transaction tr = ss.beginTransaction();

		Department dep = ss.find(Department.class, id);

		ss.remove(dep);
		tr.commit();
		ss.close();

		return "Department Deleted Successfully";
	}

}
