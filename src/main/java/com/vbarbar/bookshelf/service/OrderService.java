package com.vbarbar.bookshelf.service;

import com.vbarbar.bookshelf.domain.Order;

public interface OrderService {

	void processOrder(String bookId, long count);
	
	Long saveOrder(Order order);
}
