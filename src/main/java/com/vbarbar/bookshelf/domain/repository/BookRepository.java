package com.vbarbar.bookshelf.domain.repository;

import java.util.List;

import com.vbarbar.bookshelf.domain.Book;

public interface BookRepository {
	
	List <Book> getAllBooks();
	
	Book getBookById(String bookId);
}
