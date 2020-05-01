package com.qa.qacdb.persistence.domain;

public class Order {

	private Long OrderID;
	private Long CustomerID;
	private String Date;

	public Order(Long OrderID, Long CustomerID, String Date) {
		this.OrderID = OrderID;
		this.CustomerID = CustomerID;
		this.Date = Date;
	}

	public Order(Long CustomerID, String Date) {
		this.CustomerID = CustomerID;
		this.Date = Date;
	}

	public Long getOrderID() {
		return OrderID;
	}

	public void setOrderID(Long OrderID) {
		this.OrderID = OrderID;
	}

	public Long getCustomerID() {
		return CustomerID;
	}

	public void setCustomerID(Long CustomerID) {
		this.CustomerID = CustomerID;
	}

	public String getDate() {
		return Date;
	}

	public void setDate(String Date) {
		this.Date = Date;
	}

	@Override
	public String toString() {
		return "Order [OrderID=" + OrderID + ", CustomerID=" + CustomerID + ", Date=" + Date + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((OrderID == null) ? 0 : OrderID.hashCode());
		result = prime * result + ((CustomerID == null) ? 0 : CustomerID.hashCode());
		result = prime * result + ((Date == null) ? 0 : Date.hashCode());

		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;

		Order other = (Order) obj;

		if (OrderID == null) {
			if (other.OrderID != null)
				return false;
		} else if (!OrderID.equals(other.OrderID))
			return false;

		if (CustomerID == null) {
			if (other.CustomerID != null)
				return false;
		} else if (!CustomerID.equals(other.CustomerID))
			return false;

		if (Date == null) {
			if (other.Date != null)
				return false;
		} else if (!Date.equals(other.Date))
			return false;
		return true;
	}
}