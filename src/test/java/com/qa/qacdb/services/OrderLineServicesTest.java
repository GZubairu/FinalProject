package com.qa.qacdb.services;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.qa.qacdb.persistence.dao.Dao;
import com.qa.qacdb.persistence.domain.OrderLine;

@RunWith(MockitoJUnitRunner.class)
public class OrderLineServicesTest {
	
	@Mock
	private Dao<OrderLine> orderLineDao;
	
	@InjectMocks
	private OrderLineServices orderLineServices;
	
	@Test
	public void orderLineServicesCreate() {
		OrderLine orderLine = new OrderLine(1L, 1L, 1L, 1L);
		orderLineServices.create(orderLine);
		Mockito.verify(orderLineDao, Mockito.times(1)).create(orderLine);
	}
	
	@Test
	public void orderLineServicesRead() {
		orderLineServices.readAll();
		Mockito.verify(orderLineDao, Mockito.times(1)).readAll();
	}
	
	@Test
	public void orderLineServicesUpdate() {
		OrderLine orderLine = new OrderLine(1L, 1L, 1L, 1L);
		orderLineServices.update(orderLine);
		Mockito.verify(orderLineDao, Mockito.times(1)).update(orderLine);
	}
	
	@Test
	public void orderLineServicesDelete() {
		orderLineServices.delete(1L);;
		Mockito.verify(orderLineDao, Mockito.times(1)).delete(1L);
	}
}