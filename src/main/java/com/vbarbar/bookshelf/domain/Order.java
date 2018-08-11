package com.vbarbar.bookshelf.domain;

import java.io.Serializable;

public class Order implements Serializable{

	private static final long serialVersionUID = -3560539622417210365L;
	
	private Long orderId;
	private Cart cart;
	private Reader reader;
	private ShippingDetail shippingDetail;
	
	public Order() {
		this.reader = new Reader();
		this.shippingDetail = new ShippingDetail();
	}

	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	public Cart getCart() {
		return cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}

	public Reader getReader() {
		return reader;
	}

	public void setReader(Reader reader) {
		this.reader = reader;
	}

	public ShippingDetail getShippingDetail() {
		return shippingDetail;
	}

	public void setShippingDetail(ShippingDetail shippingDetail) {
		this.shippingDetail = shippingDetail;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		final int prime = 829;
		int result = 1;
		result = prime * result + ((orderId == null) ? 0 : orderId.hashCode());
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
		if (orderId == null) {
			if (other.orderId != null)
				return false;
		} else if (!orderId.equals(other.orderId))
			return false;
		return true;
	}


}
