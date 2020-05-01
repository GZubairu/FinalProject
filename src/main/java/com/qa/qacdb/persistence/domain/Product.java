package com.qa.qacdb.persistence.domain;

public class Product {
	
	private Long ProductID;
	private String ProductName;
	private String ProductDescription;
	private Long Price;
	
	public Product(Long ProductID, String ProductName, String ProductDescription, Long Price) {
		this.ProductID = ProductID;
		this.ProductName = ProductName;
		this.ProductDescription = ProductDescription;
		this.Price = Price;
	}
	public Product(String ProductName, String ProductDescription, Long Price) {
		this.ProductName = ProductName;
		this.ProductDescription = ProductDescription;
		this.Price = Price;
	}
	
	public Long getProductID() {
		return ProductID;
	}
	public void setProductID(Long productID) {
		this.ProductID = productID;
	}
	public String getProductName() {
		return ProductName;
	}
	public void setProductName(String productName) {
		ProductName = productName;
	}
	public String getProductDescription() {
		return ProductDescription;
	}
	public void setProductDescription(String productDescription) {
		ProductDescription = productDescription;
	}
	public Long getPrice() {
		return Price;
	}
	public void setPrice(Long price) {
		Price = price;
	}
	
	@Override
	public String toString() {
		return "Product [ProductID=" + ProductID + ", ProductName=" + ProductName + ", ProductDescription="
				+ ProductDescription + ", Price=" + Price + "]";
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((ProductID == null) ? 0 : ProductID.hashCode());
		result = prime * result + ((ProductName == null) ? 0 : ProductName.hashCode());
		result = prime * result + ((ProductDescription == null) ? 0 : ProductDescription.hashCode());
		result = prime * result + ((Price == null) ? 0 : Price.hashCode());

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

		Product other = (Product) obj;

		if (ProductID == null) {
			if (other.ProductID != null)
				return false;
		} else if (!ProductID.equals(other.ProductID))
			return false;

		if (ProductName == null) {
			if (other.ProductName != null)
				return false;
		} else if (!ProductName.equals(other.ProductName))
			return false;
		
		if (ProductDescription == null) {
			if (other.ProductDescription != null)
				return false;
		} else if (!ProductDescription.equals(other.ProductDescription))
			return false;

		if (Price == null) {
			if (other.Price != null)
				return false;
		} else if (!Price.equals(other.Price))
			return false;
		return true;
	}
	
	
	

}
