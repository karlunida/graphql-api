package com.karl.projects.graphql.graphql_api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;

import com.karl.projects.graphql.graphql_api.entity.Author;
import com.karl.projects.graphql.graphql_api.entity.Book;
import com.karl.projects.graphql.graphql_api.service.AuthorService;
import com.karl.projects.graphql.graphql_api.service.BookService;

@Controller
public class BookController {
	
	@Autowired
	private BookService bookService;
	@Autowired
	private AuthorService authorService;
	
	@QueryMapping
	public Book bookById(@Argument String id) {
		return bookService.getById(id);
	}
	
	
	@SchemaMapping
	public Author author(Book book) {
		return authorService.getById(book.getAuthorId());
	}

}
