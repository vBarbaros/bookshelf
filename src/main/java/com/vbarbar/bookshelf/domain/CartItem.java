package com.vbarbar.bookshelf.domain;

import java.io.Serializable;
import java.math.BigDecimal;

public class CartItem implements Serializable{

	private static final long serialVersionUID = -4314427089896169685L;
	
	private Book book;
	private int quantity;
	private BigDecimal totalPrice;
	
	public CartItem() {
		// TODO Auto-generated constructor stub
		this.quantity = 1;
	}
	
	public CartItem(Book book) {
		super();
		this.book = book;
		this.quantity = 1;
		this.totalPrice = book.getPricePerUnit();
	}
	
	public Book getBook() {
		return book;
	}
	
	public void setBook(Book book) {
		this.book = book;
		this.updateTotalPrice();
	}
	
	public int getQuantity() {
		return quantity;
	}
	
	public void setQuantity(int quantity) {
		this.quantity = quantity;
		this.updateTotalPrice();
	}
	
	public BigDecimal getTotalPrice() {
		return totalPrice;
	}

	public void updateTotalPrice() {
		totalPrice = this.book.getPricePerUnit().multiply(new BigDecimal(this.quantity));
	}
	
	@Override
	public int hashCode() {
		final int prime = 311;
		int result = 1;
		result = prime * result + ((book == null) ? 0 : book.hashCode());
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
		CartItem other = (CartItem) obj;
		if (book == null) {
			if (other.book != null)
				return false;
		} else if (!book.equals(other.book))
			return false;
		return true;
	}
}
