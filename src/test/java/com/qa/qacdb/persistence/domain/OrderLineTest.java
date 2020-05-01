package com.qa.qacdb.persistence.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class OrderLineTest {
	
	private OrderLine orderLine;
	private OrderLine other;
	
	@Before
	public void setUp() {
		orderLine = new OrderLine(1L, 1L, 1L, 1L);
		other = new OrderLine(1L, 1L, 1L, 1L);
	}
	
	@Test
	public void settersTest() {
		assertNotNull(orderLine.getOrderLineID());
		assertNotNull(orderLine.getOrderID());
		assertNotNull(orderLine.getProductID());
		assertNotNull(orderLine.getQuantity());
		
		orderLine.setOrderLineID(null);
		assertNull(orderLine.getOrderLineID());
		orderLine.setOrderID(null);
		assertNull(orderLine.getOrderID());
		orderLine.setProductID(null);
		assertNull(orderLine.getProductID());
		orderLine.setQuantity(null);
		assertNull(orderLine.getQuantity());
		
	}
	
	@Test
	public void equalsWithNull() {
		assertFalse(orderLine.equals(null));
	}
	
	@Test
	public void equalsWithDifferentObject() {
		assertFalse(orderLine.equals(new Object()));
	}
	
	@Test
	public void createOrderLineWithId() {
		assertEquals(1L, orderLine.getOrderLineID(), 0);
		assertEquals(1L, orderLine.getOrderID(), 0);
		assertEquals(1L, orderLine.getProductID(), 0);
		assertEquals(1L, orderLine.getQuantity(), 0);
	}
	
	@Test
	public void checkEquality() {
		assertTrue(orderLine.equals(orderLine));
	}
	
	@Test
	public void checkEqualityBetweenDifferentObjects() {
		assertTrue(orderLine.equals(other));
	}
	
	@Test
	public void orderIDNullButOtherNotNull() {
		orderLine.setOrderID(null);
		assertFalse(orderLine.equals(other));
	}
	
	@Test
	public void orderIDNotEqual() {
		other.setOrderID(66L);
		assertFalse(orderLine.equals(other));
	}
	
	@Test
	public void checkEqualityBetweenDifferentObjectsNullQuantity() {
		orderLine.setQuantity(null);
		other.setQuantity(null);
		assertTrue(orderLine.equals(other));
	}
	
	@Test
	public void nullId() {
		orderLine.setOrderLineID(null);
		assertFalse(orderLine.equals(other));
	}
	
	@Test
	public void nullIdOnBoth() {
		orderLine.setOrderLineID(null);
		other.setOrderLineID(null);
		assertTrue(orderLine.equals(other));
	}
	
	@Test
	public void otherIdDifferent() {
		other.setOrderLineID(2L);
		assertFalse(orderLine.equals(other));
	}
	
	@Test
	public void nullProductID() {
		orderLine.setProductID(null);
		assertFalse(orderLine.equals(other));
	}
	
	@Test
	public void nullProductIDOnBoth() {
		orderLine.setProductID(null);
		other.setProductID(null);
		assertTrue(orderLine.equals(other));
	}
	
	@Test
	public void otherProductIDDifferent() {
		other.setProductID(9L);
		assertFalse(orderLine.equals(other));
	}
	
	@Test
	public void constructorWithoutOrderLineId() {
		OrderLine orderLine = new OrderLine(1L, 1L, 8L);
		assertNull(orderLine.getOrderLineID());
		assertNotNull(orderLine.getOrderID());
		assertNotNull(orderLine.getProductID());
		assertNotNull(orderLine.getQuantity());
		
	}
	
	@Test
	public void hashCodeTest() {
		assertEquals(orderLine.hashCode(), other.hashCode());
	}
	
	@Test
	public void hashCodeTestWithNull() {
		OrderLine orderLine = new OrderLine(null, null, null, null);
		OrderLine other = new OrderLine(null, null, null, null);
		assertEquals(orderLine.hashCode(), other.hashCode());
	}
	
	@Test
	public void toStringTest() {
		String toString = "OrderLine [OrderLineID=1, OrderID=1, ProductID=1, Quantity=1]";
		assertEquals(toString, orderLine.toString());
	}
}