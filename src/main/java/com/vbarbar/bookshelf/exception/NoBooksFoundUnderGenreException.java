package com.vbarbar.bookshelf.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.NOT_FOUND, reason="No books found under this genre. Try another one!")
public class NoBooksFoundUnderGenreException extends RuntimeException{
	
	private static final long serialVersionUID = 3935230281455340039L;

}
