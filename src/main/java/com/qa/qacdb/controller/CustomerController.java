package com.qa.qacdb.controller;

import java.util.List;

import org.apache.log4j.Logger;

import com.qa.qacdb.persistence.domain.Customer;
import com.qa.qacdb.services.CrudServices;
import com.qa.qacdb.utils.Utils;

public class CustomerController implements CrudController<Customer> {

	public static final Logger LOGGER = Logger.getLogger(CustomerController.class);

	private CrudServices<Customer> customerService;

	public CustomerController(CrudServices<Customer> customerService) {
		this.customerService = customerService;
	}

	String getInput() {
		return Utils.getInput();
	}

	@Override
	public List<Customer> readAll() {
		List<Customer> customers = customerService.readAll();
		for (Customer customer : customers) {
			LOGGER.info(customer.toString());
		}
		return customers;
	}

	@Override
	public Customer create() {
		Long custid = 0L;
		LOGGER.info("Please enter a Firstname");
		String FirstName = getInput();
		LOGGER.info("Please enter a Surname");
		String Surname = getInput();
		LOGGER.info("Please enter a PhoneNumber");
		String PhoneNumber = getInput();
		LOGGER.info("Please enter a Email");
		String Email = getInput();
		LOGGER.info("Please enter a Address");
		String Address = getInput();
		LOGGER.info("Please enter a Postcode");
		String Postcode = getInput();

		Customer customer = customerService
				.create(new Customer(custid, FirstName, Surname, PhoneNumber, Email, Address, Postcode));
		LOGGER.info("Customer created");
		return customer;
	}

	@Override
	public Customer update() {
		LOGGER.info("Please enter the CustomerID of the customer you would like to update");
		Long CustomerID = Long.valueOf(getInput());
		LOGGER.info("Please enter a Firstname");
		String FirstName = getInput();
		LOGGER.info("Please enter a Surname");
		String Surname = getInput();
		LOGGER.info("Please enter a PhoneNumber");
		String PhoneNumber = getInput();
		LOGGER.info("Please enter a Email");
		String Email = getInput();
		LOGGER.info("Please enter a Address");
		String Address = getInput();
		LOGGER.info("Please enter a Postcode");
		String Postcode = getInput();
		Customer customer = customerService
				.update(new Customer(CustomerID, FirstName, Surname, PhoneNumber, Email, Address, Postcode));
		LOGGER.info("Customer Updated");
		return customer;
	}

	@Override
	public void delete() {
		LOGGER.info("Please enter the CustomerID of the customer you would like to delete");
		Long CustomerID = Long.valueOf(getInput());
		customerService.delete(CustomerID);
	}

}
