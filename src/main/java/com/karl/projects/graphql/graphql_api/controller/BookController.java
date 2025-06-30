package com.karl.projects.graphql.graphql_api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;

import com.karl.projects.graphql.graphql_api.entity.Author;
import com.karl.projects.graphql.graphql_api.entity.Book;
import com.karl.projects.graphql.graphql_api.service.BookService;

@Controller
public class BookController {
	
	@Autowired
	private BookService bookService;
	
	@QueryMapping
	public Book bookById(@Argument String id) {
		return bookService.getById(id);
	}
	
	@SchemaMapping(typeName = "Author", field = "books")
	public List<Book> books(Author author) {
		return bookService.getByAuthorId(author.getId());
	}

}
