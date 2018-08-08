package com.vbarbar.bookshelf.domain.repository.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.stereotype.Repository;

import com.vbarbar.bookshelf.domain.Book;
import com.vbarbar.bookshelf.domain.repository.BookRepository;

@Repository
public class InMemoryBookRepository implements BookRepository{

	private List<Book> listOfBooks = new ArrayList<Book>();
	
	public InMemoryBookRepository() {
		
		Book bookOne = new Book("B0001","The Story of a Crime", new BigDecimal(100));
		bookOne.setReview("The stories are frequently referred to as the Martin Beck stories. All of the "
				+ "novels have been adapted to films between 1967 and 1994, six of which featured Gösta Ekman "
				+ "as Martin Beck. Between 1997 and 2018 there have also been 38 films (some only broadcast on "
				+ "television) based on the characters, with Peter Haber as Martin Beck.Sjöwall and Wahlöö's "
				+ "technique of mixing traditional crime fiction with "
				+ "a focus on the social issues in the Swedish welfare state received a great deal of "
				+ "attention. The concept has been updated in the 1990s with Henning Mankell's "
				+ "detective character Kurt Wallander and in the 2000s with Stieg Larsson's Millennium "
				+ "trilogy featuring Lisbeth Salander.The basic concept has, by extension, given rise to "
				+ "the entire Scandinavian noir scene.");
		bookOne.setGenre("Detective");
		bookOne.setEditor("Edition House A");
		bookOne.setUnitsInStock(1000);
		
		Book bookTwo = new Book("B0002","Millennium", new BigDecimal(200));
		bookTwo.setReview("The first novel won Sweden's Glass Key award in 2006, that same year the second "
				+ "book won the Best Swedish Crime Novel Award, and in 2008 the third novel also won the "
				+ "Glass Key award. In the 2012 revised edition of Japan's Tozai Mystery Best 100, the "
				+ "Millennium series was ranked the twelfth best mystery from the West. By May 2010, "
				+ "27 million copies of the trilogy had been sold worldwide, a number that would grow to "
				+ "more than 46 million over the next five months, and reach 65 million in December 2011. "
				+ "In July 2010 the series made Larsson the first author to sell a million electronic copies "
				+ "of his work on the Amazon Kindle. Sales reached 75 million copies throughout fifty "
				+ "countries by December 2013, and 80 million by March 2015.");
		bookTwo.setGenre("Detective");
		bookTwo.setEditor("Edition House B");
		bookTwo.setUnitsInStock(2000);
		
		Book bookThree = new Book("B0003","Bourne", new BigDecimal(300));
		bookThree.setReview("Peter Cannon of Publishers Weekly named The Bourne Identity among the best "
				+ "spy novels of all time, after John le Carré's The Spy Who Came in from the Cold." 
				+ "The novel was the basis for the scripts of the 1988 television movie of the same "
				+ "name starring Richard Chamberlain and Jaclyn Smith, and the 2002 film of the same "
				+ "name, starring Matt Damon, Franka Potente and Chris Cooper.");
		bookThree.setGenre("Thriller");
		bookThree.setEditor("Edition House C");
		bookThree.setUnitsInStock(3000);
		
		this.listOfBooks.add(bookOne);
		this.listOfBooks.add(bookTwo);
		this.listOfBooks.add(bookThree);
	}
	
	public List<Book> getAllBooks() {
		// TODO Auto-generated method stub
		return this.listOfBooks;
	}
	
	public Book getBookById(String bookId) {
		Book bookById = null;
		
		for(Book book : this.listOfBooks) {
			if(book != null && book.getBookId() != null && book.getBookId().equals(bookId)) {
				bookById = book;
				break;
			}
		}
		
		if(bookById == null) {
			throw new IllegalArgumentException("No books found with the book id: " + bookId);
		}
		
		return bookById;
	}

	public List<Book> getBooksByGenre(String genre) {
		// TODO Auto-generated method stub
		List<Book> booksByGenre = new ArrayList<Book>();
		
		for(Book book : listOfBooks) {
			if(genre.equalsIgnoreCase(book.getGenre())) {
				booksByGenre.add(book);
			}
		}
		
		return booksByGenre;
	}

	public Set<Book> getBooksByFilter(Map<String, List<String>> filterParams) {
		// TODO Auto-generated method stub
		Set<Book> booksByEditor = new HashSet<Book>();
		Set<Book> booksByGenre = new HashSet<Book>();
		
		Set<String> criteria = filterParams.keySet();
		
		if(criteria.contains("editor")) {
			for(String editorName : filterParams.get("editor")) {
				for(Book book : this.listOfBooks) {
					if(editorName.equalsIgnoreCase(book.getEditor())) {
						booksByEditor.add(book);
					}
				}
			}
		}
		
		if(criteria.contains("genre")) {
			for(String genreName : filterParams.get("genre")) {
				for(Book book : this.listOfBooks) {
					if(genreName.equalsIgnoreCase(book.getGenre())) {
						booksByGenre.add(book);
					}
				}
			}
		}
		
		booksByGenre.retainAll(booksByEditor);
		
		return booksByGenre;
	}
}
