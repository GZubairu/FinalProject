package com.qa.qacdb.persistence.domain;

public class Customer {

	private Long CustomerID;
	private String Firstname;
	private String Surname;
	private String PhoneNumber;
	private String Email;
	private String Address;
	private String Postcode;

	public Customer(Long CustomerID, String Firstname, String Surname, String PhoneNumber, String Email, String Address,
			String Postcode) {
		this.CustomerID = CustomerID;
		this.Firstname = Firstname;
		this.Surname = Surname;
		this.PhoneNumber = PhoneNumber;
		this.Email = Email;
		this.Address = Address;
		this.Postcode = Postcode;
	}

	public Customer(String Firstname, String Surname, String PhoneNumber, String Email, String Address,
			String Postcode) {
		this.Firstname = Firstname;
		this.Surname = Surname;
		this.PhoneNumber = PhoneNumber;
		this.Email = Email;
		this.Address = Address;
		this.Postcode = Postcode;
	}

	public Long getCustomerID() {
		return CustomerID;
	}

	public void setCustomerID(Long customerID) {
		this.CustomerID = customerID;
	}

	public String getFirstname() {
		return Firstname;
	}

	public void setFirstname(String firstname) {
		this.Firstname = firstname;
	}

	public String getSurname() {
		return Surname;
	}

	public void setSurname(String surname) {
		this.Surname = surname;
	}

	public String getPhoneNumber() {
		return PhoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.PhoneNumber = phoneNumber;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		this.Email = email;
	}

	public String getAddress() {
		return Address;
	}

	public void setAddress(String address) {
		this.Address = address;
	}

	public String getPostcode() {
		return Postcode;
	}

	public void setPostcode(String postcode) {
		this.Postcode = postcode;
	}

	public String toString() {
		return "Customer [CustomerID=" + CustomerID + ", Firstname=" + Firstname + ", Surname=" + Surname
				+ ", PhoneNumber=" + PhoneNumber + ", Email=" + Email + ", Address=" + Address + ", Postcode="
				+ Postcode + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((CustomerID == null) ? 0 : CustomerID.hashCode());
		result = prime * result + ((Firstname == null) ? 0 : Firstname.hashCode());
		result = prime * result + ((Surname == null) ? 0 : Surname.hashCode());
		result = prime * result + ((PhoneNumber == null) ? 0 : PhoneNumber.hashCode());
		result = prime * result + ((Email == null) ? 0 : Email.hashCode());
		result = prime * result + ((Address == null) ? 0 : Address.hashCode());
		result = prime * result + ((Postcode == null) ? 0 : Postcode.hashCode());

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

		Customer other = (Customer) obj;

		if (CustomerID == null) {
			if (other.CustomerID != null)
				return false;
		} else if (!CustomerID.equals(other.CustomerID))
			return false;

		if (Firstname == null) {
			if (other.Firstname != null)
				return false;
		} else if (!Firstname.equals(other.Firstname))
			return false;

		if (Surname == null) {
			if (other.Surname != null)
				return false;
		} else if (!Surname.equals(other.Surname))
			return false;

		if (PhoneNumber == null) {
			if (other.PhoneNumber != null)
				return false;
		} else if (!PhoneNumber.equals(other.PhoneNumber))
			return false;

		if (Email == null) {
			if (other.Email != null)
				return false;
		} else if (!Email.equals(other.Email))
			return false;

		if (Address == null) {
			if (other.Address != null)
				return false;
		} else if (!Address.equals(other.Address))
			return false;

		if (Postcode == null) {
			if (other.Postcode != null)
				return false;
		} else if (!Postcode.equals(other.Postcode))
			return false;
		return true;
	}

}
