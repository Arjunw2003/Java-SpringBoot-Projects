package com.tka.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tka.dao.ProductDao;
import com.tka.entities.Product;

@Service
public class ProductService {

	@Autowired
	ProductDao dao;

	public String insertProduct(Product prod) {
		return dao.insertProduct(prod);
	}

	public String updateProduct(Product prod, int id) {

		return dao.updateProduct(prod, id);
	}

	public String deleteProduct(int id) {

		return dao.deleteProduct(id);
	}

	public Product getSingleProduct(int id) {

		return dao.getSingleProduct(id);
	}

	public List<Product> getAllProduct() {

		return dao.getAllProduct();
	}

}
