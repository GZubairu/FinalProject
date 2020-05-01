package com.qa.qacdb.persistence.domain;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class DomainTest {
	
	@Test
	public void customerTest() {
		Domain domain = Domain.CUSTOMER;
		assertTrue(domain.getDescription().toLowerCase().contains("customer"));
	}
	
	@Test
	public void productTest() {
		Domain domain = Domain.PRODUCT;
		assertTrue(domain.getDescription().toLowerCase().contains("product"));
	}
	
	@Test
	public void orderTest() {
		Domain domain = Domain.ORDER;
		assertTrue(domain.getDescription().toLowerCase().contains("orders"));
	}
	
	@Test
	public void orderLineTest() {
		Domain domain = Domain.ORDERLINE;
		assertTrue(domain.getDescription().toLowerCase().contains("total"));
	}
	
	@Test
	public void stopTest() {
		Domain domain = Domain.STOP;
		assertTrue(domain.getDescription().toLowerCase().contains("close"));
	}

}
