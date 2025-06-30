package com.karl.projects.graphql.graphql_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.karl.projects.graphql.graphql_api.entity.Book;

public interface BookRepository extends JpaRepository<Book, String>{

}
