package com.karl.projects.graphql.graphql_api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.karl.projects.graphql.graphql_api.entity.Author;
import com.karl.projects.graphql.graphql_api.service.AuthorService;

@Controller
public class AuthorController {
	
	@Autowired
	private AuthorService authorService;
	
}
