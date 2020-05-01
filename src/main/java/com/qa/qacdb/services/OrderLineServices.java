package com.qa.qacdb.services;

import java.util.List;


import com.qa.qacdb.persistence.dao.Dao;
import com.qa.qacdb.persistence.domain.OrderLine;

public class OrderLineServices implements CrudServices<OrderLine> {
	
	private Dao<OrderLine> orderLineDao;
	

	public OrderLineServices(Dao<OrderLine> orderLineDao) {
		this.orderLineDao = orderLineDao;
	}

	public List<OrderLine> readAll() {
		return orderLineDao.readAll();
	}

	public OrderLine create(OrderLine orderLine) {
		return orderLineDao.create(orderLine);
	}

	public OrderLine update(OrderLine orderLine) {
		return orderLineDao.update(orderLine);
	}

	public void delete(Long id) {
		orderLineDao.delete(id);
	}

}
