package com.qa.qacdb.services;

import java.util.List;

import com.qa.qacdb.persistence.dao.Dao;
import com.qa.qacdb.persistence.domain.Product;

public class ProductServices implements CrudServices<Product> {
	
	private Dao<Product> productDao;

	public ProductServices(Dao<Product> productDao) {
		this.productDao = productDao;
	}

	public List<Product> readAll() {
		return productDao.readAll();
	}

	public Product create(Product product) {
		return productDao.create(product);
	}

	public Product update(Product product) {
		return productDao.update(product);
	}

	public void delete(Long id) {
		productDao.delete(id);
	}

}
