package com.vbarbar.bookshelf.service;

import java.util.List;
import java.util.Map;
import java.util.Set;

import com.vbarbar.bookshelf.domain.Book;

public interface BookService {

	List<Book> getAllBooks();
	
	Book getBookById(String productId);
	
	List<Book> getBooksByGenre(String genre);
	
	Set<Book> getBooksByFilter(Map<String, List<String>> filterParams);
}
