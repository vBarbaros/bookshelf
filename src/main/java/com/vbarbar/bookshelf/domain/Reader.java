package com.vbarbar.bookshelf.domain;

import java.io.Serializable;

public class Reader implements Serializable{

	private static final long serialVersionUID = 2284040482222162898L;
	
	private String readerId;
	private String name;
	private Address billingAddress;
	private String phoneNumber;
	
	public Reader() {
		this.billingAddress = new Address();
	}
	
	public Reader(String readerId, String name) {
		this();
		this.readerId = readerId;
		this.name = name;
	}

	public String getReaderId() {
		return readerId;
	}

	public void setReaderId(String readerId) {
		this.readerId = readerId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Address getBillingAddress() {
		return billingAddress;
	}

	public void setBillingAddress(Address billingAddress) {
		this.billingAddress = billingAddress;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		final int prime = 853;
		int result = 1;
		result = prime * result
				+ ((readerId == null) ? 0 : readerId.hashCode());
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
		Reader other = (Reader) obj;
		if (readerId == null) {
			if (other.readerId != null)
				return false;
		} else if (!readerId.equals(other.readerId))
			return false;
		return true;
	}

	
}
