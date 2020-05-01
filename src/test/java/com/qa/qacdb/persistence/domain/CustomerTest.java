package com.qa.qacdb.persistence.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class CustomerTest {
	
	private Customer customer;
	private Customer other;
	
	@Before
	public void setUp() {
		customer = new Customer(1L, "Chris", "Perrins", "08001234567", "cp@mail.com", "1 Main Road", "DA1 1AB");
		other = new Customer(1L, "Chris", "Perrins", "08001234567", "cp@mail.com", "1 Main Road", "DA1 1AB");
	}
	
	@Test
	public void settersTest() {
		assertNotNull(customer.getCustomerID());
		assertNotNull(customer.getFirstname());
		assertNotNull(customer.getSurname());
		assertNotNull(customer.getPhoneNumber());
		assertNotNull(customer.getEmail());
		assertNotNull(customer.getAddress());
		assertNotNull(customer.getPostcode());
		
		customer.setCustomerID(null);
		assertNull(customer.getCustomerID());
		customer.setFirstname(null);
		assertNull(customer.getFirstname());
		customer.setSurname(null);
		assertNull(customer.getSurname());
		customer.setPhoneNumber(null);
		assertNull(customer.getPhoneNumber());
		customer.setEmail(null);
		assertNull(customer.getEmail());
		customer.setAddress(null);
		assertNull(customer.getAddress());
		customer.setPostcode(null);
		assertNull(customer.getPostcode());
		
	}
	
	@Test
	public void equalsWithNull() {
		assertFalse(customer.equals(null));
	}
	
	@Test
	public void equalsWithDifferentObject() {
		assertFalse(customer.equals(new Object()));
	}
	
	@Test
	public void createCustomerWithId() {
		assertEquals(1L, customer.getCustomerID(), 0);
		assertEquals("Chris", customer.getFirstname());
		assertEquals("Perrins", customer.getSurname());
	}
	
	@Test
	public void checkEquality() {
		assertTrue(customer.equals(customer));
	}
	
	@Test
	public void checkEqualityBetweenDifferentObjects() {
		assertTrue(customer.equals(other));
	}
	
	@Test
	public void customerNameNullButOtherNameNotNull() {
		customer.setFirstname(null);
		assertFalse(customer.equals(other));
	}
	
	@Test
	public void customerNamesNotEqual() {
		other.setFirstname("rhys");
		assertFalse(customer.equals(other));
	}
	
	@Test
	public void checkEqualityBetweenDifferentObjectsNullName() {
		customer.setFirstname(null);
		other.setFirstname(null);
		assertTrue(customer.equals(other));
	}
	
	@Test
	public void nullId() {
		customer.setCustomerID(null);
		assertFalse(customer.equals(other));
	}
	
	@Test
	public void nullIdOnBoth() {
		customer.setCustomerID(null);
		other.setCustomerID(null);
		assertTrue(customer.equals(other));
	}
	
	@Test
	public void otherIdDifferent() {
		other.setCustomerID(2L);
		assertFalse(customer.equals(other));
	}
	
	@Test
	public void nullSurname() {
		customer.setSurname(null);
		assertFalse(customer.equals(other));
	}
	
	@Test
	public void nullSurnameOnBoth() {
		customer.setSurname(null);
		other.setSurname(null);
		assertTrue(customer.equals(other));
	}
	
	@Test
	public void otherSurnameDifferent() {
		other.setSurname("thompson");
		assertFalse(customer.equals(other));
	}
	
	@Test
	public void constructorWithoutId() {
		Customer customer = new Customer("Chris", "Perrins", "08001234567", "cp@mail.com", "1 Main Road", "DA1 1AB");
		assertNull(customer.getCustomerID());
		assertNotNull(customer.getFirstname());
		assertNotNull(customer.getSurname());
		assertNotNull(customer.getPhoneNumber());
		assertNotNull(customer.getEmail());
		assertNotNull(customer.getAddress());
		assertNotNull(customer.getPostcode());
	}
	
	@Test
	public void hashCodeTest() {
		assertEquals(customer.hashCode(), other.hashCode());
	}
	
	@Test
	public void hashCodeTestWithNull() {
		Customer customer = new Customer(null, null, null, null, null, null);
		Customer other = new Customer(null, null, null, null, null, null);
		assertEquals(customer.hashCode(), other.hashCode());
	}
	
	@Test
	public void toStringTest() {
		String toString = "Customer [CustomerID=1, Firstname=Chris, Surname=Perrins, PhoneNumber=08001234567, Email=cp@mail.com, Address=1 Main Road, Postcode=DA1 1AB]";
		assertEquals(toString, customer.toString());
	}
}
