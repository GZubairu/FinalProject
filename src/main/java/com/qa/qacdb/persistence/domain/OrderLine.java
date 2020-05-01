package com.qa.qacdb.persistence.domain;

public class OrderLine {

	private Long OrderLineID;
	private Long OrderID;
	private Long ProductID;
	private Long Quantity;

	public OrderLine(Long OrderLineID, Long OrderID, Long ProductID, Long Quantity) {
		this.OrderLineID = OrderLineID;
		this.OrderID = OrderID;
		this.ProductID = ProductID;
		this.Quantity = Quantity;
	}
	
	public OrderLine(Long OrderID, Long ProductID, Long Quantity) {
		this.OrderID = OrderID;
		this.ProductID = ProductID;
		this.Quantity = Quantity;
	}

	public Long getOrderLineID() {
		return OrderLineID;
	}

	public void setOrderLineID(Long OrderLineID) {
		this.OrderLineID = OrderLineID;
	}

	public Long getOrderID() {
		return OrderID;
	}

	public void setOrderID(Long OrderID) {
		this.OrderID = OrderID;
	}

	public Long getProductID() {
		return ProductID;
	}

	public void setProductID(Long ProductID) {
		this.ProductID = ProductID;
	}

	public Long getQuantity() {
		return Quantity;
	}

	public void setQuantity(Long Quantity) {
		this.Quantity = Quantity;
	}

	@Override
	public String toString() {
		return "OrderLine [OrderLineID=" + OrderLineID + ", OrderID=" + OrderID + ", ProductID=" + ProductID
				+ ", Quantity=" + Quantity + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((OrderLineID == null) ? 0 : OrderLineID.hashCode());
		result = prime * result + ((OrderID == null) ? 0 : OrderID.hashCode());
		result = prime * result + ((ProductID == null) ? 0 : ProductID.hashCode());
		result = prime * result + ((Quantity == null) ? 0 : Quantity.hashCode());

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

		OrderLine other = (OrderLine) obj;

		if (OrderLineID == null) {
			if (other.OrderLineID != null)
				return false;
		} else if (!OrderLineID.equals(other.OrderLineID))
			return false;

		if (OrderID == null) {
			if (other.OrderID != null)
				return false;
		} else if (!OrderID.equals(other.OrderID))
			return false;

		if (ProductID == null) {
			if (other.ProductID != null)
				return false;
		} else if (!ProductID.equals(other.ProductID))
			return false;

		if (Quantity == null) {
			if (other.Quantity != null)
				return false;
		} else if (!Quantity.equals(other.Quantity))
			return false;
		return true;
	}
}
