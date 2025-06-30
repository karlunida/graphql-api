package com.karl.projects.graphql.graphql_api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.karl.projects.graphql.graphql_api.entity.Book;
import com.karl.projects.graphql.graphql_api.repository.BookRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class BookService {
	
	@Autowired
	private BookRepository bookRepository;
	
	public Book getById(String id) {
		return bookRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Book Not Found!"));
	}
	
	public List<Book> getByAuthorId(String authorId){
		return bookRepository.findByAuthorId(authorId).orElseThrow(() -> new EntityNotFoundException("Book Not Found!"));
	}

}
