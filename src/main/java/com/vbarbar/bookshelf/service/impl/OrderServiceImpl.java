package com.vbarbar.bookshelf.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vbarbar.bookshelf.domain.Book;
import com.vbarbar.bookshelf.domain.repository.BookRepository;
import com.vbarbar.bookshelf.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService{

	@Autowired
    private BookRepository bookRepository;
	
	public void processOrder(String productId, long quantity) { 
		
		Book bookById = bookRepository.getBookById(productId);
		
		if (bookById.getUnitsInStock() < quantity) {
			throw new IllegalArgumentException("Out of Stock. Available Units in stock"+ bookById.getUnitsInStock());
		}
		
		bookById.setUnitsInStock(bookById.getUnitsInStock() - quantity);
	}
}
