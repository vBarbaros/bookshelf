package com.vbarbar.bookshelf.domain.repository;

import com.vbarbar.bookshelf.domain.Order;

public interface OrderRepository {

	Long saveOrder(Order order);
}
