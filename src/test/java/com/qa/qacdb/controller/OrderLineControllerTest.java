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

import com.qa.qacdb.persistence.domain.OrderLine;
import com.qa.qacdb.services.OrderLineServices;

@RunWith(MockitoJUnitRunner.class)
public class OrderLineControllerTest {

	@Mock
	private OrderLineServices orderLineServices;

	@Spy // for the methods in orderLineController
	@InjectMocks // for any classes our orderLineController calls (in this case orderLineService)
	private OrderLineController orderLineController;

	@Test
	public void create() {
		Long olid = 0L;
		Long ordid = 1L;
		Long prodid = 1L;
		Long quan = 5L;
		String ordid1 = "1";
		String prodid1 = "1";
		String quan1 = "5";
		Mockito.doReturn(ordid1, prodid1, quan1).when(orderLineController).getInput();
		OrderLine c = new OrderLine(olid, ordid, prodid, quan);
		OrderLine saved = new OrderLine(1L, 1L, 1L, 5L);
		Mockito.when(orderLineServices.create(c)).thenReturn(saved);
		assertEquals(saved, orderLineController.create());
	}

	@Test
	public void readAllTest() {
		OrderLineController orderLineController = new OrderLineController(orderLineServices);
		List<OrderLine> orderLines = new ArrayList<>();
		orderLines.add(new OrderLine(1L, 1L, 2L, 5L));
		orderLines.add(new OrderLine(2L, 3L, 1L, 5L));
		orderLines.add(new OrderLine(3L, 1L, 1L, 5L));
		Mockito.when(orderLineServices.readAll()).thenReturn(orderLines);
		assertEquals(orderLines, orderLineController.readAll());
	}

	@Test
	public void updateTest() {
		Long olid = 1L;
		Long ordid = 1L;
		Long prodid = 1L;
		Long quan = 5L;
		String olid1 = "1";
		String ordid1 = "1";
		String prodid1 = "1";
		String quan1 = "5";
		Mockito.doReturn(olid1, ordid1, prodid1, quan1).when(orderLineController).getInput();
		OrderLine orderLine = new OrderLine(olid, ordid, prodid, quan);
		Mockito.when(orderLineServices.update(orderLine)).thenReturn(orderLine);
		assertEquals(orderLine, orderLineController.update());
	}

	@Test
	public void deleteTest() {
		String id = "1";
		Mockito.doReturn(id).when(orderLineController).getInput();
		orderLineController.delete();
		Mockito.verify(orderLineServices, Mockito.times(1)).delete(1L);
	}

}
