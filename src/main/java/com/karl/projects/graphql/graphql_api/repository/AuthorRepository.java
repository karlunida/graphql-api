package com.karl.projects.graphql.graphql_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.karl.projects.graphql.graphql_api.entity.Author;

public interface AuthorRepository extends JpaRepository<Author, String>{

}
