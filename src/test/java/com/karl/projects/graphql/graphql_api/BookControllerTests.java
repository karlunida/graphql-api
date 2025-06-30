package com.karl.projects.graphql.graphql_api;

import java.util.Map;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.graphql.GraphQlTest;
import org.springframework.boot.test.autoconfigure.graphql.tester.AutoConfigureGraphQlTester;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.graphql.test.tester.GraphQlTester;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

//@GraphQlTest(controllers = BookController.class)
@SpringBootTest
@AutoConfigureGraphQlTester
public class BookControllerTests {
	
	@Autowired
	private GraphQlTester graphQlTester;
	@Autowired
	private ObjectMapper objectMapper;
	
	@Test
	void shouldGetFirstBook() {
		Map<String, Object> result = Map.of("id", "book-1", "name", "Effective Java", "pageCount", 416, "author", Map.of("id", "author-1", "firstName", "Joshua", "lastName", "Bloch"));
		var res = this.graphQlTester.documentName("bookDetails")
			.variable("id", "book-1")
			.execute();
		System.out.println(res.returnResponse());
		res.path("bookById").matchesJson(mapToJson(result));
	}
	
	String mapToJson(Map<String, Object> map) {
		try {
			return objectMapper.writeValueAsString(map);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
