package com.vbarbar.bookshelf.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;

import java.math.BigDecimal;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.vbarbar.bookshelf.domain.Book;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("test-DispatcherServlet-context.xml")
@WebAppConfiguration
public class BookControllerTest {

	@Autowired
    private WebApplicationContext wac;

    private MockMvc mockMvc;

    @Before
    public void setup() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
    }

    @Test
    public void testGetBooks() throws Exception {
        this.mockMvc.perform(get("/books")).andExpect(model().attributeExists("books"));
    }
    
    @Test
    public void testGetBookById() throws Exception {
    	//Arrange
		Book book = new Book("B0001","Millenium-test", new BigDecimal(500));
		
		//Act & Assert
		this.mockMvc.perform(get("/books/book")
        					.param("id", "B0001"))
            		.andExpect(model().attributeExists("book"))
            		.andExpect(model().attribute("book", book));
    }
}
