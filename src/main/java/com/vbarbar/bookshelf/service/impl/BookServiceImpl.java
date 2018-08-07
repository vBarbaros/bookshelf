package com.vbarbar.bookshelf.service.impl;

import java.util.List;

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

}
