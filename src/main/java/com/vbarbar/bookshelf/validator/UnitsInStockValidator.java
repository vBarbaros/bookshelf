package com.vbarbar.bookshelf.validator;

import java.math.BigDecimal;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.vbarbar.bookshelf.domain.Book;

@Component
public class UnitsInStockValidator implements Validator{

	public boolean supports(Class<?> clazz) {
        return Book.class.isAssignableFrom(clazz);  
	}

	public void validate(Object target, Errors errors) {
		Book book = (Book) target;

		if(book.getPricePerUnit()!= null && 
				new BigDecimal(10000).compareTo(book.getPricePerUnit())<=0 && 
						book.getUnitsInStock()>99) {
			errors.rejectValue("unitsInStock", "com.vbarbar.bookshelf.validator.UnitsInStockValidator.message");
		}
	}

}
