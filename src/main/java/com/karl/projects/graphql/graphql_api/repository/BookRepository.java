package com.karl.projects.graphql.graphql_api.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.karl.projects.graphql.graphql_api.entity.Book;

public interface BookRepository extends JpaRepository<Book, String>{
	@Query(value = "Select a from Book a where a.authorId=:authorId")
	public Optional<List<Book>> findByAuthorId(@Param(value = "authorId") String authorId);

}
