package com.qa.qacdb.controller;

import java.util.List;

import org.apache.log4j.Logger;

import com.qa.qacdb.persistence.domain.OrderLine;
import com.qa.qacdb.services.CrudServices;
import com.qa.qacdb.utils.Utils;

public class OrderLineController implements CrudController<OrderLine> {

	public static final Logger LOGGER = Logger.getLogger(OrderLineController.class);

	private CrudServices<OrderLine> orderLineService;

	public OrderLineController(CrudServices<OrderLine> orderLineService) {
		this.orderLineService = orderLineService;
	}

	String getInput() {
		return Utils.getInput();
	}

	@Override
	public List<OrderLine> readAll() {
		List<OrderLine> orderLines = orderLineService.readAll();
		for (OrderLine orderLine : orderLines) {
			LOGGER.info(orderLine.toString());
		}
		return orderLines;
	}

	@Override
	public OrderLine create() {
		Long olid = 0L;
		LOGGER.info("Please enter an OrderID number");
		Long ordid = Long.valueOf(getInput());
		LOGGER.info("Please enter a ProductID number");
		Long prodid = Long.valueOf(getInput());
		LOGGER.info("Please enter a Quantity");
		Long quan = Long.valueOf(getInput());

		OrderLine orderLine = orderLineService
				.create(new OrderLine(olid, ordid, prodid, quan));
		LOGGER.info("OrderLine created");
		return orderLine;
	}

	@Override
	public OrderLine update() {
		LOGGER.info("Please enter the OrderLineID of the orderLine you would like to update");
		Long OrderLineID = Long.valueOf(getInput());
		LOGGER.info("Please enter an OrderID number");
		Long ordid = Long.valueOf(getInput());
		LOGGER.info("Please enter a ProductID number");
		Long prodid = Long.valueOf(getInput());
		LOGGER.info("Please enter a Quantity");
		Long quan = Long.valueOf(getInput());
		
		OrderLine orderLine = orderLineService
				.update(new OrderLine(OrderLineID, ordid, prodid, quan));
		LOGGER.info("OrderLine Updated");
		return orderLine;
	}

	@Override
	public void delete() {
		LOGGER.info("Please enter the OrderLineID of the orderLine you would like to delete");
		Long OrderLineID = Long.valueOf(getInput());
		orderLineService.delete(OrderLineID);
	}

}

