package com.qa.qacdb.persistence.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class OrderTest {
	
	private Order order;
	private Order other;
	
	@Before
	public void setUp() {
		order = new Order(1L, 1L, "0000-00-00");
		other = new Order(1L, 1L, "0000-00-00");
	}
	
	@Test
	public void settersTest() {
		assertNotNull(order.getOrderID());
		assertNotNull(order.getCustomerID());
		assertNotNull(order.getDate());
		
		order.setOrderID(null);
		assertNull(order.getOrderID());
		order.setCustomerID(null);
		assertNull(order.getCustomerID());
		order.setDate(null);
		assertNull(order.getDate());
		
	}
	
	@Test
	public void equalsWithNull() {
		assertFalse(order.equals(null));
	}
	
	@Test
	public void equalsWithDifferentObject() {
		assertFalse(order.equals(new Object()));
	}
	
	@Test
	public void createOrderWithId() {
		assertEquals(1L, order.getOrderID(), 0);
		assertEquals(1L, order.getCustomerID(), 0);
		assertEquals("0000-00-00", order.getDate());
	}
	
	@Test
	public void checkEquality() {
		assertTrue(order.equals(order));
	}
	
	@Test
	public void checkEqualityBetweenDifferentObjects() {
		assertTrue(order.equals(other));
	}
	
	@Test
	public void customerIDNullButOthercustomerIDNotNull() {
		order.setCustomerID(null);
		assertFalse(order.equals(other));
	}
	
	@Test
	public void orderCustomerIDNotEqual() {
		other.setCustomerID(69L);
		assertFalse(order.equals(other));
	}
	
	@Test
	public void checkEqualityBetweenDifferentObjectsNull() {
		order.setDate(null);
		other.setDate(null);
		assertTrue(order.equals(other));
	}
	
	@Test
	public void nullId() {
		order.setOrderID(null);
		assertFalse(order.equals(other));
	}
	
	@Test
	public void nullIdOnBoth() {
		order.setOrderID(null);
		other.setOrderID(null);
		assertTrue(order.equals(other));
	}
	
	@Test
	public void otherIdDifferent() {
		other.setOrderID(2L);
		assertFalse(order.equals(other));
	}
	
	@Test
	public void nullCustomerID() {
		order.setCustomerID(null);
		assertFalse(order.equals(other));
	}
	
	@Test
	public void nullCustomerIDOnBoth() {
		order.setCustomerID(null);
		other.setCustomerID(null);
		assertTrue(order.equals(other));
	}
	
	@Test
	public void otherCustomerIDDifferent() {
		other.setCustomerID(20L);
		assertFalse(order.equals(other));
	}
	
	@Test
	public void constructorWithoutOrderId() {
		Order order = new Order(6L, "0000-00-00");
		assertNull(order.getOrderID());
		assertNotNull(order.getCustomerID());
		assertNotNull(order.getDate());
	}
	
	@Test
	public void hashCodeTest() {
		assertEquals(order.hashCode(), other.hashCode());
	}
	
	@Test
	public void hashCodeTestWithNull() {
		Order order = new Order(null, null, null);
		Order other = new Order(null, null, null);
		assertEquals(order.hashCode(), other.hashCode());
	}
	
	@Test
	public void toStringTest() {
		String toString = "Order [OrderID=1, CustomerID=1, Date=0000-00-00]";
		assertEquals(toString, order.toString());
	}
}