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

import com.qa.qacdb.persistence.domain.Customer;
import com.qa.qacdb.services.CustomerServices;

@RunWith(MockitoJUnitRunner.class)
public class CustomerControllerTest {

	@Mock
	private CustomerServices customerServices;

	@Spy // for the methods in customerController
	@InjectMocks // for any classes our customerController calls (in this case customerService)
	private CustomerController customerController;

	@Test
	public void createUser() {
		Long custid = 0L;
		String firstname = "Chris";
		String lastname = "P";
		String phone = "00000000000";
		String email = "cp@gmail.com";
		String address = "10 High road";
		String postcode = "SW1 1AB";
		Mockito.doReturn(firstname, lastname, phone, email, address, postcode).when(customerController).getInput();
		Customer c = new Customer(custid, firstname, lastname, phone, email, address, postcode);
		Customer saved = new Customer(0L, "Chris", "P", "00000000000", "cp@mail.com", "10 High Road", "SW1 1AB");
		Mockito.when(customerServices.create(c)).thenReturn(saved);
		assertEquals(saved, customerController.create());
	}

	@Test
	public void readAllTest() {
		CustomerController customerController = new CustomerController(customerServices);
		List<Customer> customers = new ArrayList<>();
		customers.add(new Customer("Chris", "P", "00000000000", "cp@mail.com", "10 High Road", "SW1 1AB"));
		customers.add(new Customer("Rhys", "T", "00000000000", "rt@mail.com", "11 High Road", "SW1 1AB"));
		customers.add(new Customer("Nic", "J", "00000000000", "nj@mail.com", "12 High Road", "SW1 1AB"));
		Mockito.when(customerServices.readAll()).thenReturn(customers);
		assertEquals(customers, customerController.readAll());
	}

	@Test
	public void updateTest() {
		String id = "1";
		Long id1 = 1L;
		String firstName = "Cristiano";
		String lastname = "Ronaldo";
		String phone = "77777777777";
		String email = "cr7@gmail.com";
		String address = "2 Main road";
		String postcode = "SW1 1BB";
		Mockito.doReturn(id, firstName, lastname, phone, email, address, postcode).when(customerController).getInput();
		Customer customer = new Customer(id1, firstName, lastname, phone, email, address, postcode);
		Mockito.when(customerServices.update(customer)).thenReturn(customer);
		assertEquals(customer, customerController.update());
	}

	@Test
	public void deleteTest() {
		String id = "1";
		Mockito.doReturn(id).when(customerController).getInput();
		customerController.delete();
		Mockito.verify(customerServices, Mockito.times(1)).delete(1L);
	}

}
