package com.vbarbar.bookshelf.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.MatrixVariable;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.vbarbar.bookshelf.domain.Book;
import com.vbarbar.bookshelf.service.BookService;

@Controller
@RequestMapping("/books")
public class BookController {

	@Autowired
	private BookService bookService;
	
	@RequestMapping
    public String list(Model model) {
		model.addAttribute("books", bookService.getAllBooks());
		return "books";
    }
	
	@RequestMapping("/all")
	public String allBooks(Model model) {
		model.addAttribute("books", bookService.getAllBooks());
		return "books";
	}
	
	@RequestMapping("/{genre}")
	public String getBooksByGenre(Model model, @PathVariable("genre") String bookGenre) {
		model.addAttribute("books", bookService.getBooksByGenre(bookGenre));
		return "books";
	}
	
	@RequestMapping("/filter/{byCriteria}")
	public String getBooksByFilter(@MatrixVariable(pathVar="byCriteria") Map<String, List<String>> filterParams, Model model) {
		model.addAttribute("books", bookService.getBooksByFilter(filterParams));
		return "books";
	}
	
	@RequestMapping("/book")
	public String getBookById(@RequestParam("id") String bookId, Model model) {
		model.addAttribute("book", bookService.getBookById(bookId));
		return "book";
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String getAddNewBookForm(Model model) {
		Book newBook = new Book();
		model.addAttribute("newBook", newBook);
		return "addBook";
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String processAddNewBookForm(
			@ModelAttribute("newBook") Book newBook,
			BindingResult result) {
		
		String[] suppressedFields = result.getSuppressedFields();
		if(suppressedFields.length > 0) {
			throw new RuntimeException("Attempting to bind disallowed fields: " 
					+ StringUtils.arrayToCommaDelimitedString(suppressedFields));
		}
		
		bookService.addBook(newBook);
		return "redirect:/books";
	}
	
	@InitBinder
	public void initializeBinder(WebDataBinder binder) {
		binder.setDisallowedFields("unitsInOrder", "discontinued");
	}
}
