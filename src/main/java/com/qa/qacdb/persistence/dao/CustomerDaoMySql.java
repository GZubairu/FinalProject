package com.qa.qacdb.persistence.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.qa.qacdb.persistence.domain.Customer;
import com.qa.qacdb.utils.Utils;

public class CustomerDaoMySql implements Dao<Customer> {

	public static final Logger LOGGER = Logger.getLogger(CustomerDaoMySql.class);

	private String jdbcConnectionUrl;
	private String username;
	private String password;

	public CustomerDaoMySql(String username, String password) {
		this.jdbcConnectionUrl = "jdbc:mysql://" + Utils.MYSQL_URL + "/qacdb?useSSL=false";
		this.username = username;
		this.password = password;
	}

	public CustomerDaoMySql(String jdbcConnectionUrl, String username, String password) {
		this.jdbcConnectionUrl = jdbcConnectionUrl;
		this.username = username;
		this.password = password;
	}

	Customer customerFromResultSet(ResultSet rs) throws SQLException {
		Long custid = rs.getLong("CustomerID");
		String name1 = rs.getString("Firstname");
		String name2 = rs.getString("Surname");
		String pnum = rs.getString("PhoneNumber");
		String email1 = rs.getString("Email");
		String address1 = rs.getString("Address");
		String pcode1 = rs.getString("Postcode");

		return new Customer(custid, name1, name2, pnum, email1, address1, pcode1);
	}

	@Override
	public List<Customer> readAll() {
		try (Connection connection = DriverManager.getConnection(jdbcConnectionUrl, username, password);
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery("SELECT * FROM Customer");) {
			ArrayList<Customer> customers = new ArrayList<>();
			while (resultSet.next()) {
				customers.add(customerFromResultSet(resultSet));
			}
			return customers;
		} catch (SQLException e) {
			LOGGER.debug(e.getStackTrace());
			LOGGER.error(e.getMessage());
		}
		return new ArrayList<>();
	}

	public Customer readLatest() {
		try (Connection connection = DriverManager.getConnection(jdbcConnectionUrl, username, password);
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement
						.executeQuery("SELECT * FROM Customer ORDER BY CustomerID DESC LIMIT 1");) {
			resultSet.next();
			return customerFromResultSet(resultSet);
		} catch (Exception e) {
			LOGGER.debug(e.getStackTrace());
			LOGGER.error(e.getMessage());
		}
		return null;
	}

	@Override
	public Customer create(Customer customer) {
		try (Connection connection = DriverManager.getConnection(jdbcConnectionUrl, username, password);
				Statement statement = connection.createStatement();) {
			statement.executeUpdate(
					"INSERT INTO Customer(Firstname, Surname, PhoneNumber, Email, Address, Postcode)  VALUES('"
							+ customer.getFirstname() + "', '" + customer.getSurname() + "', '"
							+ customer.getPhoneNumber() + "', '" + customer.getEmail() + "', '" + customer.getAddress()
							+ "', '" + customer.getPostcode() + "')");
			return readLatest();
		} catch (Exception e) {
			LOGGER.debug(e.getStackTrace());
			LOGGER.error(e.getMessage());
		}
		return null;
	}

	public Customer readCustomer(Long cid) {
		try (Connection connection = DriverManager.getConnection(jdbcConnectionUrl, username, password);
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery("SELECT * FROM `Customer` where CustomerID = " + cid);) {
			resultSet.next();
			return customerFromResultSet(resultSet);
		} catch (Exception e) {
			LOGGER.debug(e.getStackTrace());
			LOGGER.error(e.getMessage());
		}
		return null;
	}

	@Override
	public Customer update(Customer customer) {
		try (Connection connection = DriverManager.getConnection(jdbcConnectionUrl, username, password);
				Statement statement = connection.createStatement();) {
			statement.executeUpdate("UPDATE Customer SET Firstname ='" + customer.getFirstname() + "', Surname ='"
					+ customer.getSurname() + "', PhoneNumber ='" + customer.getPhoneNumber() + "', Email ='"
					+ customer.getEmail() + "', Address='" + customer.getAddress() + "', Postcode = '"
					+ customer.getPostcode() + "' WHERE CustomerID =" + customer.getCustomerID());
			return readCustomer(customer.getCustomerID());
		} catch (Exception e) {
			LOGGER.debug(e.getStackTrace());
			LOGGER.error(e.getMessage());
		}
		return null;
	}

	@Override
	public void delete(Long id) {
		try (Connection connection = DriverManager.getConnection(jdbcConnectionUrl, username, password);
				Statement statement = connection.createStatement();) {
			statement.executeUpdate("DELETE FROM Customer WHERE CustomerID = " + id);
		} catch (Exception e) {
			LOGGER.debug(e.getStackTrace());
			LOGGER.error(e.getMessage());
		}
	}

}
