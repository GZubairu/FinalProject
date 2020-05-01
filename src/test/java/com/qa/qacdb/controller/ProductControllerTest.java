package com.qa.qacdb.controller;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import com.qa.qacdb.persistence.domain.Product;
import com.qa.qacdb.services.ProductServices;

@RunWith(MockitoJUnitRunner.class)
public class ProductControllerTest {

	@Mock
	private ProductServices productServices;

	@Spy // for the methods in productController
	@InjectMocks // for any classes our productController calls (in this case productService)
	private ProductController productController;

	@Test
	public void create() {
		Long prodid = 0L;
		String prodname = "Remmington 680";
		String proddesc = "Pump action shotgun";
		String price = "500";
		Long price1 = 500L;
		Mockito.doReturn(prodname, proddesc, price).when(productController).getInput();
		Product c = new Product(prodid, prodname, proddesc, price1);
		Product saved = new Product(0L, "Remmington 680", "Pump action shotgun", 500L);
		Mockito.when(productServices.create(c)).thenReturn(saved);
		assertEquals(saved, productController.create());
	}

	@Test
	public void readAllTest() {
		ProductController productController = new ProductController(productServices);
		List<Product> products = new ArrayList<>();
		products.add(new Product("TV", "Television", 400L));
		products.add(new Product("Laptop", "Mobile PC", 250L));
		products.add(new Product("iPhone", "Phone by Apple", 1000L));
		Mockito.when(productServices.readAll()).thenReturn(products);
		assertEquals(products, productController.readAll());
	}

	@Test
	public void updateTest() {
		String id = "1";
		Long id1 = 1L;
		String prodname = "Remmington 680";
		String proddesc = "Pump action shotgun";
		String price = "500";
		Long price1 = 500L;
		Mockito.doReturn(id, prodname, proddesc, price).when(productController).getInput();
		Product product = new Product(id1, prodname, proddesc, price1);
		Mockito.when(productServices.update(product)).thenReturn(product);
		assertEquals(product, productController.update());
	}

	@Test
	public void deleteTest() {
		String id = "1";
		Mockito.doReturn(id).when(productController).getInput();
		productController.delete();
		Mockito.verify(productServices, Mockito.times(1)).delete(1L);
	}

}
