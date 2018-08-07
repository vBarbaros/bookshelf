package com.vbarbar.bookshelf.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.vbarbar.bookshelf.service.BookService;

@Controller
public class BookController {

	@Autowired
	private BookService bookService;
	
	@RequestMapping("/books")
    public String list(Model model) {
		model.addAttribute("books", bookService.getAllBooks());
		return "books";
    }
}
