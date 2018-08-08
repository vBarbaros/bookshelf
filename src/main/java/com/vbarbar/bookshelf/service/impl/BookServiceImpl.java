package com.vbarbar.bookshelf.service.impl;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vbarbar.bookshelf.domain.Book;
import com.vbarbar.bookshelf.domain.repository.BookRepository;
import com.vbarbar.bookshelf.service.BookService;

@Service
public class BookServiceImpl implements BookService{

	@Autowired
    private BookRepository bookRepository;

	public List<Book> getAllBooks() {
		// TODO Auto-generated method stub
		return bookRepository.getAllBooks();
	}

	public Book getBookById(String bookId) {
		// TODO Auto-generated method stub
		return bookRepository.getBookById(bookId);
	}

	public List<Book> getBooksByGenre(String genre) {
		// TODO Auto-generated method stub
		return bookRepository.getBooksByGenre(genre);
	}

	public Set<Book> getBooksByFilter(Map<String, List<String>> filterParams) {
		// TODO Auto-generated method stub
		return bookRepository.getBooksByFilter(filterParams);
	}

}
