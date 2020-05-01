package com.qa.qacdb;

import org.apache.log4j.Logger;

import com.qa.qacdb.controller.Action;
import com.qa.qacdb.controller.CrudController;
import com.qa.qacdb.controller.CustomerController;
import com.qa.qacdb.controller.OrderController;
import com.qa.qacdb.controller.OrderLineController;
import com.qa.qacdb.controller.ProductController;
import com.qa.qacdb.persistence.dao.CustomerDaoMySql;
import com.qa.qacdb.persistence.dao.OrderDaoMySql;
import com.qa.qacdb.persistence.dao.OrderLineDaoMySql;
import com.qa.qacdb.persistence.dao.ProductDaoMySql;

import com.qa.qacdb.persistence.domain.Domain;
import com.qa.qacdb.services.CustomerServices;
import com.qa.qacdb.services.OrderLineServices;
import com.qa.qacdb.services.OrderServices;
import com.qa.qacdb.services.ProductServices;
import com.qa.qacdb.utils.Utils;

public class Qacdb {

	public static final Logger LOGGER = Logger.getLogger(Qacdb.class);

	public void QacdbSystem() {
		LOGGER.info("What is your Username");
		String username = Utils.getInput();
		LOGGER.info("What is your Password");
		String password = Utils.getInput();

		LOGGER.info("Which entity would you like to use?");
		Domain.printDomains();

		Domain domain = Domain.getDomain();
		LOGGER.info("What would you like to do with " + domain.name().toLowerCase() + ":");

		Action.printActions();
		Action action = Action.getAction();

		switch (domain) {
		case CUSTOMER:
			CustomerController customerController = new CustomerController(
					new CustomerServices(new CustomerDaoMySql(username, password)));
			doAction(customerController, action);
			break;
		case PRODUCT:
			ProductController productController = new ProductController(
					new ProductServices(new ProductDaoMySql(username, password)));
			doAction(productController, action);
			break;
		case ORDER:
			OrderController orderController = new OrderController(
					new OrderServices(new OrderDaoMySql(username, password)));
			doAction(orderController, action);
			break;
		case ORDERLINE:
			OrderLineController orderLineController = new OrderLineController(
					new OrderLineServices(new OrderLineDaoMySql(username, password)));
			doAction(orderLineController, action);
			break;
		case STOP:
			break;
		default:
			break;
		}

	}
	public void doAction(OrderLineController orderLineController, Action action) {
		switch (action) {
		case CREATE:
			orderLineController.create();
			break;
		case READ:
			orderLineController.readAll();
			break;
		case UPDATE:
			orderLineController.update();
			break;
		case DELETE:
			orderLineController.delete();
			break;
		default:
			break;
		}
	}

	public void doAction(CrudController<?> crudController, Action action) {
		switch (action) {
		case CREATE:
			crudController.create();
			break;
		case READ:
			crudController.readAll();
			break;
		case UPDATE:
			crudController.update();
			break;
		case DELETE:
			crudController.delete();
			break;

		default:
			break;
		}
	}


}
