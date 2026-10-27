package com.tka.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tka.entities.Product;

@Repository
public class ProductDao {

	@Autowired
	SessionFactory factory;

	public String insertProduct(Product prod) {

		Session s = factory.openSession();
		Transaction tr = s.beginTransaction();

		s.persist(prod);

		tr.commit();
		s.close();
		return "Product Added Successfully...!";
	}

	public String updateProduct(Product prod, int id) {

		Session s = factory.openSession();
		Transaction tr = s.beginTransaction();

		Product pr = s.find(Product.class, id);
		pr.setProductName(prod.getProductName());
		pr.setCategory(prod.getCategory());
		pr.setBrand(prod.getBrand());
		pr.setPrice(prod.getPrice());
		pr.setQuantity(prod.getQuantity());
		pr.setColor(prod.getColor());
		pr.setSize(prod.getSize());
		pr.setSupplierName(prod.getSupplierName());

		s.merge(pr);
		
		tr.commit();
		s.close();

		return "Product Updated Successfully...!";
	}

	public String deleteProduct(int id) {
		
		Session s = factory.openSession();
		Transaction tr = s.beginTransaction();
		
		Product pr = s.find(Product.class, id);
		s.remove(pr);
		
		tr.commit();
		s.close();
		
		return "Product Deleted Successfully...!";
	}

	public Product getSingleProduct(int id) {
		
		Session s = factory.openSession();
		Transaction tr = s.beginTransaction();
		
		Product pr = s.find(Product.class, id);
		
		tr.commit();
		s.close();
		
		return pr;
	}

	public List<Product> getAllProduct() {
		
		Session s = factory.openSession();
		Transaction tr = s.beginTransaction();
		
		String hqlQuery = "from Product";
		
		Query<Product> query = s.createQuery(hqlQuery, Product.class);
		List<Product> list = query.getResultList();
		
		return list;
	}

}
