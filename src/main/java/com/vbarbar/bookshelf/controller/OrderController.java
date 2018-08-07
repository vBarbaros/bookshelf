package com.vbarbar.bookshelf.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.vbarbar.bookshelf.service.OrderService;

@Controller
public class OrderController {

	@Autowired
    private OrderService orderService;
	
    @RequestMapping("/order")
    public String process() {
    	orderService.processOrder("B0001", 2);
        return "redirect:/books";
    }
}
