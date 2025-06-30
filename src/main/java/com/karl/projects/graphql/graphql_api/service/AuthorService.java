package com.karl.projects.graphql.graphql_api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.karl.projects.graphql.graphql_api.entity.Author;
import com.karl.projects.graphql.graphql_api.repository.AuthorRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class AuthorService {
	
	@Autowired
	private AuthorRepository authorRepository;
	
	public Author getById(String id) {
		return authorRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Author Not Found!"));
	}
}
