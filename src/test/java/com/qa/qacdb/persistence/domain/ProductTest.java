package com.qa.qacdb.persistence.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class ProductTest {
	
	private Product product;
	private Product other;
	
	@Before
	public void setUp() {
		product = new Product(1L, "Top", "Made in China", 50L);
		other = new Product(1L, "Top", "Made in China", 50L);
	}
	
	@Test
	public void settersTest() {
		assertNotNull(product.getProductID());
		assertNotNull(product.getProductName());
		assertNotNull(product.getProductDescription());
		assertNotNull(product.getPrice());
		
		product.setProductID(null);
		assertNull(product.getProductID());
		product.setProductName(null);
		assertNull(product.getProductName());
		product.setProductDescription(null);
		assertNull(product.getProductDescription());
		product.setPrice(null);
		assertNull(product.getPrice());
				
	}
	
	@Test
	public void equalsWithNull() {
		assertFalse(product.equals(null));
	}
	
	@Test
	public void equalsWithDifferentObject() {
		assertFalse(product.equals(new Object()));
	}
	
	@Test
	public void createProductWithId() {
		assertEquals(1L, product.getProductID(), 0);
		assertEquals("Top", product.getProductName());
		assertEquals("Made in China", product.getProductDescription());
	}
	
	@Test
	public void checkEquality() {
		assertTrue(product.equals(product));
	}
	
	@Test
	public void checkEqualityBetweenDifferentObjects() {
		assertTrue(product.equals(other));
	}
	
	@Test
	public void productNameNullButOtherNameNotNull() {
		product.setProductName(null);
		assertFalse(product.equals(other));
	}
	
	@Test
	public void productNamesNotEqual() {
		other.setProductName("rhys");
		assertFalse(product.equals(other));
	}
	
	@Test
	public void checkEqualityBetweenDifferentObjectsNullName() {
		product.setProductName(null);
		other.setProductName(null);
		assertTrue(product.equals(other));
	}
	
	@Test
	public void nullId() {
		product.setProductID(null);
		assertFalse(product.equals(other));
	}
	
	@Test
	public void nullIdOnBoth() {
		product.setProductID(null);
		other.setProductID(null);
		assertTrue(product.equals(other));
	}
	
	@Test
	public void otherIdDifferent() {
		other.setProductID(2L);
		assertFalse(product.equals(other));
	}
	
	@Test
	public void nullProductDescription() {
		product.setProductDescription(null);
		assertFalse(product.equals(other));
	}
	
	@Test
	public void nullProductDescriptionOnBoth() {
		product.setProductDescription(null);
		other.setProductDescription(null);
		assertTrue(product.equals(other));
	}
	
	@Test
	public void otherProductDescriptionDifferent() {
		other.setProductDescription("Made in Mexico");
		assertFalse(product.equals(other));
	}
	
	@Test
	public void constructorWithoutId() {
		Product product = new Product("Hat", "On your head", 90L);
		assertNull(product.getProductID());
		assertNotNull(product.getProductName());
		assertNotNull(product.getProductDescription());
		assertNotNull(product.getPrice());
	}
	
	@Test
	public void hashCodeTest() {
		assertEquals(product.hashCode(), other.hashCode());
	}
	
	@Test
	public void hashCodeTestWithNull() {
		Product product = new Product(null, null, null, null);
		Product other = new Product(null, null, null, null);
		assertEquals(product.hashCode(), other.hashCode());
	}
	
	@Test
	public void toStringTest() {
		String toString = "Product [ProductID=1, ProductName=Top, ProductDescription=Made in China, Price=50]";
		assertEquals(toString, product.toString());
	}
}