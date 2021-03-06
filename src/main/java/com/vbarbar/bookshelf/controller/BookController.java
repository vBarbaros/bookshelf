package com.vbarbar.bookshelf.controller;

import java.io.File;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.MatrixVariable;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.vbarbar.bookshelf.domain.Book;
import com.vbarbar.bookshelf.exception.BookNotFoundException;
import com.vbarbar.bookshelf.exception.NoBooksFoundUnderGenreException;
import com.vbarbar.bookshelf.service.BookService;
import com.vbarbar.bookshelf.validator.BookValidator;

@Controller
@RequestMapping("/books")
public class BookController {

	@Autowired
	private BookService bookService;
	
	@Autowired
    private BookValidator bookValidator;
	
	@Autowired
	ServletContext context;
	
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
		
		List<Book> booksByGenre = bookService.getBooksByGenre(bookGenre);
		
		if (booksByGenre == null || booksByGenre.isEmpty()) {
			throw new NoBooksFoundUnderGenreException();
		}
		model.addAttribute("books", booksByGenre);
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
			@ModelAttribute("newBook") @Valid Book newBook,
			BindingResult result,
			HttpServletRequest request) {
		
		if(result.hasErrors()) {
			return "addBook";
		}
		
		String[] suppressedFields = result.getSuppressedFields();
		if(suppressedFields.length > 0) {
			throw new RuntimeException("Attempting to bind disallowed fields: " 
					+ StringUtils.arrayToCommaDelimitedString(suppressedFields));
		}
		
		MultipartFile bookImage = newBook.getBookImage();
		
		String resetRootPath = ""; 
	
		resetRootPath = this.getClass().getResource("/").getPath();
		
		//resetRootPath = resetRootPath.substring(0, resetRootPath.lastIndexOf("/bookshelf"));
//		System.out.println("EHWInit#75:resetRootPath=" + resetRootPath);
//		resetRootPath = resetRootPath + "/bookshelf/src/main/webapp/resources/images/";
//		System.out.println("EHWInit#75:resetRootPath=" + resetRootPath);

		if (bookImage!=null && !bookImage.isEmpty()) {
			try {
		        
		        File filePath = new File(
		        		resetRootPath + 
		        		newBook.getBookId() + 
		        		".png");
		        bookImage.transferTo(filePath);
		        
		    } catch (Exception e) {
		    	throw new RuntimeException("Book Image saving failed", e);
		    } 
		}
		
		bookService.addBook(newBook);
		return "redirect:/books";
	}
	
	@RequestMapping("/invalidPromoCode") 
	public String invalidPromoCode() {
        return "invalidPromoCode";
    }
	
	@InitBinder
	public void initializeBinder(WebDataBinder binder) {
		binder.setValidator(bookValidator);
		binder.setAllowedFields("bookId", "bookTitle","pricePerUnit",
				"review","editor", "genre","unitsInStock",
				"bookImage", "condition","language");
		
		binder.setDisallowedFields("unitsInOrder", "discontinued");
	}
	
	@ExceptionHandler(BookNotFoundException.class)
	public ModelAndView handleError(HttpServletRequest req, BookNotFoundException exception) {
		 ModelAndView mav = new ModelAndView();
		 mav.addObject("invalidBookId", exception.getBookId());
		 mav.addObject("exception", exception);
		 mav.addObject("url", req.getRequestURL() + "?"+ req.getQueryString());
		 mav.setViewName("bookNotFound");
		 return mav;
	}
}
