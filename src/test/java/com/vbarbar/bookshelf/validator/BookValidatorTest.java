package com.vbarbar.bookshelf.validator;

import java.math.BigDecimal;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.validation.BindException;
import org.springframework.validation.ValidationUtils;

import com.vbarbar.bookshelf.domain.Book;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("test-DispatcherServlet-context.xml")
@WebAppConfiguration
public class BookValidatorTest {
	
	@Autowired
	private BookValidator bookValidator;
	 
	@Test
	public void book_without_PricePerUnit_should_be_invalid() {
		//Arrange
		Book book = new Book();
		BindException bindException = new BindException(book, "bookId");

		//Act
		ValidationUtils.invokeValidator(bookValidator, book, bindException);
		
		//Assert
		Assert.assertEquals(2, bindException.getErrorCount()); 
		Assert.assertTrue(bindException.getLocalizedMessage().contains("Unit price is Invalid. It cannot be empty."));
	}
	
	@Test
	public void book_with_existing_bookId_invalid() {
		//Arrange
		Book book = new Book("B0001","Millenium-test", new BigDecimal(500));
		book.setGenre("Detective");
		
		BindException bindException = new BindException(book, "bookId");

		//Act
		ValidationUtils.invokeValidator(bookValidator, book, bindException);
		
		//Assert
		Assert.assertEquals(1, bindException.getErrorCount()); 
		Assert.assertTrue(bindException.getLocalizedMessage().contains("A book already exists with this book id"));
	}
	
	@Test
	public void a_valid_bookId_should_not_get_any_error_during_validation() {
		//Arrange
		Book book = new Book("B0001","Millenium-test", new BigDecimal(100));
		book.setGenre("Detective");
		
		BindException bindException = new BindException(book, "bookId");

		//Act
		ValidationUtils.invokeValidator(bookValidator, book, bindException);
		
		//Assert
		Assert.assertEquals(1, bindException.getErrorCount()); 
	}

}
