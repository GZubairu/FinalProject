package com.qa.qacdb.persistence.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.qa.qacdb.persistence.domain.OrderLine;
import com.qa.qacdb.utils.Utils;

public class OrderLineDaoMySql implements Dao<OrderLine> {

	public static final Logger LOGGER = Logger.getLogger(OrderLineDaoMySql.class);

	private String jdbcConnectionUrl;
	private String username;
	private String password;

	public OrderLineDaoMySql(String username, String password) {
		this.jdbcConnectionUrl = "jdbc:mysql://" + Utils.MYSQL_URL + "/qacdb?useSSL=false";
		this.username = username;
		this.password = password;
	}

	public OrderLineDaoMySql(String jdbcConnectionUrl, String username, String password) {
		this.jdbcConnectionUrl = jdbcConnectionUrl;
		this.username = username;
		this.password = password;
	}

	OrderLine orderLineFromResultSet(ResultSet rs) throws SQLException {
		Long ordlid = rs.getLong("OrderLineID");
		Long ordid = rs.getLong("OrderID");
		Long prodid = rs.getLong("ProductID");
		Long quan = rs.getLong("Quantity");

		return new OrderLine(ordlid, ordid, prodid, quan);
	}

	@Override
	public List<OrderLine> readAll() {
		try (Connection connection = DriverManager.getConnection(jdbcConnectionUrl, username, password);
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery("SELECT * FROM OrderLine");) {
			ArrayList<OrderLine> orderLines = new ArrayList<>();
			while (resultSet.next()) {
				orderLines.add(orderLineFromResultSet(resultSet));
			}
			return orderLines;
		} catch (SQLException e) {
			LOGGER.debug(e.getStackTrace());
			LOGGER.error(e.getMessage());
		}
		return new ArrayList<>();
	}

	public OrderLine readLatest() {
		try (Connection connection = DriverManager.getConnection(jdbcConnectionUrl, username, password);
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement
						.executeQuery("SELECT * FROM OrderLine ORDER BY OrderLineID DESC LIMIT 1");) {
			resultSet.next();
			return orderLineFromResultSet(resultSet);
		} catch (Exception e) {
			LOGGER.debug(e.getStackTrace());
			LOGGER.error(e.getMessage());
		}
		return null;
	}	

	@Override
	public OrderLine create(OrderLine orderLine) {
		try (Connection connection = DriverManager.getConnection(jdbcConnectionUrl, username, password);
				Statement statement = connection.createStatement();) {
			statement.executeUpdate(
					"INSERT INTO OrderLine (OrderID, ProductID, Quantity)  VALUES('" + orderLine.getOrderID() + "', '"
							+ orderLine.getProductID() + "', '" + orderLine.getQuantity() + "')");
			return readLatest();
		} catch (Exception e) {
			LOGGER.debug(e.getStackTrace());
			LOGGER.error(e.getMessage());
		}
		return null;
	}

	public OrderLine readOrderLine(Long olid) {
		try (Connection connection = DriverManager.getConnection(jdbcConnectionUrl, username, password);
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery("SELECT * FROM OrderLine where OrderLineID = " + olid);) {
			resultSet.next();
			return orderLineFromResultSet(resultSet);
		} catch (Exception e) {
			LOGGER.debug(e.getStackTrace());
			LOGGER.error(e.getMessage());
		}
		return null;
	}

	@Override
	public OrderLine update(OrderLine orderLine) {
		try (Connection connection = DriverManager.getConnection(jdbcConnectionUrl, username, password);
				Statement statement = connection.createStatement();) {
			statement.executeUpdate("UPDATE OrderLine SET Quantity ='" + orderLine.getQuantity()
					+ "' WHERE OrderLineID =" + orderLine.getOrderLineID());
			return readOrderLine(orderLine.getOrderLineID());
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
			statement.executeUpdate("DELETE FROM OrderLine WHERE OrderLineID = " + id);
		} catch (Exception e) {
			LOGGER.debug(e.getStackTrace());
			LOGGER.error(e.getMessage());
		}
	}

}
