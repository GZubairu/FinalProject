package com.qa.qacdb.persistence.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.qa.qacdb.persistence.domain.Product;
import com.qa.qacdb.utils.Utils;

public class ProductDaoMySql implements Dao<Product> {

	public static final Logger LOGGER = Logger.getLogger(ProductDaoMySql.class);

	private String jdbcConnectionUrl;
	private String username;
	private String password;

	public ProductDaoMySql(String username, String password) {
		this.jdbcConnectionUrl = "jdbc:mysql://" + Utils.MYSQL_URL + "/qacdb?useSSL=false";
		this.username = username;
		this.password = password;
	}

	public ProductDaoMySql(String jdbcConnectionUrl, String username, String password) {
		this.jdbcConnectionUrl = jdbcConnectionUrl;
		this.username = username;
		this.password = password;
	}

	Product productFromResultSet(ResultSet rs) throws SQLException {
		Long prodid = rs.getLong("ProductID");
		String prodname = rs.getString("ProductName");
		String proddesc = rs.getString("ProductDescription");
		Long price = rs.getLong("Price");

		return new Product(prodid, prodname, proddesc, price);
	}

	@Override
	public List<Product> readAll() {
		try (Connection connection = DriverManager.getConnection(jdbcConnectionUrl, username, password);
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery("SELECT * FROM Product");) {
			ArrayList<Product> products = new ArrayList<>();
			while (resultSet.next()) {
				products.add(productFromResultSet(resultSet));
			}
			return products;
		} catch (SQLException e) {
			LOGGER.debug(e.getStackTrace());
			LOGGER.error(e.getMessage());
		}
		return new ArrayList<>();
	}

	public Product readLatest() {
		try (Connection connection = DriverManager.getConnection(jdbcConnectionUrl, username, password);
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement
						.executeQuery("SELECT * FROM Product ORDER BY ProductID DESC LIMIT 1");) {
			resultSet.next();
			return productFromResultSet(resultSet);
		} catch (Exception e) {
			LOGGER.debug(e.getStackTrace());
			LOGGER.error(e.getMessage());
		}
		return null;
	}

	@Override
	public Product create(Product product) {
		try (Connection connection = DriverManager.getConnection(jdbcConnectionUrl, username, password);
				Statement statement = connection.createStatement();) {
			statement.executeUpdate(
					"INSERT INTO Product(ProductName, ProductDescription, Price)  VALUES('" + product.getProductName()
							+ "', '" + product.getProductDescription() + "', '" + product.getPrice() + "')");
			return readLatest();
		} catch (Exception e) {
			LOGGER.debug(e.getStackTrace());
			LOGGER.error(e.getMessage());
		}
		return null;
	}

	public Product readProduct(Long pid) {
		try (Connection connection = DriverManager.getConnection(jdbcConnectionUrl, username, password);
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery("SELECT * FROM `Product` where ProductID = " + pid);) {
			resultSet.next();
			return productFromResultSet(resultSet);
		} catch (Exception e) {
			LOGGER.debug(e.getStackTrace());
			LOGGER.error(e.getMessage());
		}
		return null;
	}

	@Override
	public Product update(Product product) {
		try (Connection connection = DriverManager.getConnection(jdbcConnectionUrl, username, password);
				Statement statement = connection.createStatement();) {
			statement.executeUpdate("UPDATE Product SET ProductName ='" + product.getProductName()
					+ "', ProductDescription ='" + product.getProductDescription() + "', Price ='" + product.getPrice()
					+ "' WHERE ProductID =" + product.getProductID());
			return readProduct(product.getProductID());
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
			statement.executeUpdate("DELETE FROM Product WHERE ProductID = " + id);
		} catch (Exception e) {
			LOGGER.debug(e.getStackTrace());
			LOGGER.error(e.getMessage());
		}
	}

}
