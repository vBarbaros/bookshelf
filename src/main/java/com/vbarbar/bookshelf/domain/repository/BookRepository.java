package com.vbarbar.bookshelf.domain.repository;

import java.util.List;
import java.util.Map;
import java.util.Set;

import com.vbarbar.bookshelf.domain.Book;

public interface BookRepository {
	
	List<Book> getAllBooks();
	
	Book getBookById(String bookId);
	
	List<Book> getBooksByGenre(String genre);
	
	Set<Book> getBooksByFilter(Map<String, List<String>> filterParams);
	
	void addBook(Book book);
}
