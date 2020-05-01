package com.qa.qacdb.services;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.qa.qacdb.persistence.dao.Dao;
import com.qa.qacdb.persistence.domain.Customer;

@RunWith(MockitoJUnitRunner.class)
public class CustomerServicesTest {
	
	@Mock
	private Dao<Customer> customerDao;
	
	@InjectMocks
	private CustomerServices customerServices;
	
	@Test
	public void customerServicesCreate() {
		Customer customer = new Customer("Chris", "Perrins", "08001234567", "cp@mail.com", "1 Main Road", "DA1 1AB");
		customerServices.create(customer);
		Mockito.verify(customerDao, Mockito.times(1)).create(customer);
	}
	
	@Test
	public void customerServicesRead() {
		customerServices.readAll();
		Mockito.verify(customerDao, Mockito.times(1)).readAll();
	}
	
	@Test
	public void customerServicesUpdate() {
		Customer customer = new Customer("Chris", "Perrins", "08001234567", "cp@mail.com", "1 Main Road", "DA1 1AB");
		customerServices.update(customer);
		Mockito.verify(customerDao, Mockito.times(1)).update(customer);
	}
	
	@Test
	public void customerServicesDelete() {
		customerServices.delete(1L);;
		Mockito.verify(customerDao, Mockito.times(1)).delete(1L);
	}
}