package com.vbarbar.bookshelf.exception;

public class BookNotFoundException extends RuntimeException{

private static final long serialVersionUID = -694354952032299587L;
	
	private String bookId;

	public BookNotFoundException(String bookId) {
		this.bookId = bookId;
	}
	
	public String getBookId() {
		return bookId;
	}
}
