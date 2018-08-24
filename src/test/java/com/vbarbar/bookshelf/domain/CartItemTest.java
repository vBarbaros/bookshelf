package com.vbarbar.bookshelf.domain;

import java.math.BigDecimal;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class CartItemTest {
	
	private CartItem cartItem;

	@Before
	public void setup() {
		cartItem = new CartItem();
	}
	
	@Test
	public void cartItem_total_price_should_be_eaual_to_book_price_per_unit_in_case_of_single_quantity() {
		//Arrange
		Book bookOne = new Book("B0001","Millenium-Test 1", new BigDecimal(500));
		cartItem.setBook(bookOne);
		
		//Act
		BigDecimal totalPrice = cartItem.getTotalPrice();
		
		//Assert
		Assert.assertEquals(bookOne.getPricePerUnit(), totalPrice);
	}
}
