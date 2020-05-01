package com.qa.qacdb.controller;

import java.util.List;

import org.apache.log4j.Logger;

import com.qa.qacdb.persistence.domain.Product;
import com.qa.qacdb.services.CrudServices;
import com.qa.qacdb.utils.Utils;

public class ProductController implements CrudController<Product> {
	
	public static final Logger LOGGER = Logger.getLogger(ProductController.class);

	private CrudServices<Product> productService;

	public ProductController(CrudServices<Product> productService) {
		this.productService = productService;
	}

	String getInput() {
		return Utils.getInput();
	}

	@Override
	public List<Product> readAll() {
		List<Product> products = productService.readAll();
		for (Product product : products) {
			LOGGER.info(product.toString());
		}
		return products;
	}

	@Override
	public Product create() {
		Long prodid = 0L;
		LOGGER.info("Please enter a Product Name");
		String ProductName = getInput();
		LOGGER.info("Please enter a Product Description");
		String ProductDesc = getInput();
		LOGGER.info("Please enter a Price for the Product");
		Long Price = Long.valueOf(getInput());

		Product product = productService
				.create(new Product(prodid, ProductName, ProductDesc, Price));
		LOGGER.info("Product created");
		return product;
	}

	@Override
	public Product update() {
		LOGGER.info("Please enter the ProductID of the product you would like to update");
		Long ProductID = Long.valueOf(getInput());
		LOGGER.info("Please enter a Product Name");
		String ProductName = getInput();
		LOGGER.info("Please enter a Product Description");
		String ProductDesc = getInput();
		LOGGER.info("Please enter a Price for the Product");
		Long Price = Long.valueOf(getInput());

		Product product = productService
				.update(new Product(ProductID, ProductName, ProductDesc, Price));
		LOGGER.info("Product Updated");
		return product;
	}

	@Override
	public void delete() {
		LOGGER.info("Please enter the ProductID of the product you would like to delete");
		Long ProductID = Long.valueOf(getInput());
		productService.delete(ProductID);
	}

}
