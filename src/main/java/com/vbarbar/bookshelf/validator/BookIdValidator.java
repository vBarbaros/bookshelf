package com.vbarbar.bookshelf.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import com.vbarbar.bookshelf.domain.Book;
import com.vbarbar.bookshelf.exception.BookNotFoundException;
import com.vbarbar.bookshelf.service.BookService;

public class BookIdValidator implements ConstraintValidator<BookId, String>{
	
	@Autowired
	private BookService bookService;

	public void initialize(BookId constraintAnnotation) {
		//  intentionally left blank; this is the place to initialize the constraint annotation for any sensible default values.
	}

	public boolean isValid(String value, ConstraintValidatorContext context) {
		Book book;
		try {
			book = bookService.getBookById(value);
			
		} catch (BookNotFoundException e) {
			return true;
		}
		
		if(book!= null) {
			return false;
		}
		
		return true;
	}
	
}
