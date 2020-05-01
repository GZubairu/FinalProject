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

import com.qa.qacdb.persistence.domain.Order;
import com.qa.qacdb.services.OrderServices;

@RunWith(MockitoJUnitRunner.class)
public class OrderControllerTest {

	@Mock
	private OrderServices orderServices;

	@Spy // for the methods in orderController
	@InjectMocks // for any classes our orderController calls (in this case orderService)
	private OrderController orderController;

	@Test
	public void create() {
		Long ordid = 0L;
		Long custid = 1L;
		String date = "2020-04-30";
		String custid1 = "1";
		Mockito.doReturn(custid1, date).when(orderController).getInput();
		Order c = new Order(ordid, custid, date);
		Order saved = new Order(1L, 1L, "2020-04-30");
		Mockito.when(orderServices.create(c)).thenReturn(saved);
		assertEquals(saved, orderController.create());
	}

	@Test
	public void readAllTest() {
		OrderController orderController = new OrderController(orderServices);
		List<Order> orders = new ArrayList<>();
		orders.add(new Order(1L, 1L, "2020-04-30"));
		orders.add(new Order(2L, 1L, "2020-04-30"));
		orders.add(new Order(3L, 2L, "2020-04-30"));
		Mockito.when(orderServices.readAll()).thenReturn(orders);
		assertEquals(orders, orderController.readAll());
	}

	@Test
	public void updateTest() {
		Long custid = 1L;
		Long ordid = 1L;
		String date = "2020-04-30";
		String ordid1 = "1";
		String custid1 = "1";
		Mockito.doReturn(ordid1, custid1, date).when(orderController).getInput();
		Order order = new Order(ordid, custid, date);
		Mockito.when(orderServices.update(order)).thenReturn(order);
		assertEquals(order, orderController.update());
	}

	@Test
	public void deleteTest() {
		String id = "1";
		Mockito.doReturn(id).when(orderController).getInput();
		orderController.delete();
		Mockito.verify(orderServices, Mockito.times(1)).delete(1L);
	}

}
