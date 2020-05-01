package com.qa.qacdb.controller;

import java.util.List;

import org.apache.log4j.Logger;

import com.qa.qacdb.persistence.domain.Order;
import com.qa.qacdb.services.CrudServices;
import com.qa.qacdb.utils.Utils;

public class OrderController implements CrudController<Order> {

	public static final Logger LOGGER = Logger.getLogger(OrderController.class);

	private CrudServices<Order> orderService;

	public OrderController(CrudServices<Order> orderService) {
		this.orderService = orderService;
	}

	String getInput() {
		return Utils.getInput();
	}

	@Override
	public List<Order> readAll() {
		List<Order> orders = orderService.readAll();
		for (Order order : orders) {
			LOGGER.info(order.toString());
		}
		return orders;
	}

	@Override
	public Order create() {
		Long ordid = 0L;
		LOGGER.info("Please enter a CustomerID number");
		Long custid = Long.valueOf(getInput());
		LOGGER.info("Please enter a date(yyyy-mm-dd)");
		String date = getInput();

		Order order = orderService
				.create(new Order(ordid, custid, date));
		LOGGER.info("Order created");
		return order;
	}

	@Override
	public Order update() {
		LOGGER.info("Please enter the OrderID of the order you would like to update");
		Long OrderID = Long.valueOf(getInput());
		LOGGER.info("Please enter a CustomerID number");
		Long custid = Long.valueOf(getInput());
		LOGGER.info("Please enter a date(yyyy-mm-dd)");
		String date = getInput();

		Order order = orderService
				.update(new Order(OrderID, custid, date));
		LOGGER.info("Order Updated");
		return order;
	}

	@Override
	public void delete() {
		LOGGER.info("Please enter the OrderID of the order you would like to delete");
		Long OrderID = Long.valueOf(getInput());
		orderService.delete(OrderID);
	}

	
}
