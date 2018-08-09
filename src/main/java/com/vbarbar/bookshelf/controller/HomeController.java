package com.vbarbar.bookshelf.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
  
	@RequestMapping("/")
	public String welcome(Model model) {
		model.addAttribute("greeting", "Welcome to Bookshelf!");
		model.addAttribute("tagline", "The Greatest Place To Find The Greatest Books!");
		return "welcome";
	}
	
	@RequestMapping("/welcome/greeting")
    public String greeting() {
		return "welcome";
	}
}
