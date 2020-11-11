package com.example.redis.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.redis.models.ArticleResponse;
import com.example.redis.services.ArticleService;

@RestController
@RequestMapping("/articles")
public class ArticleController {

	@Autowired
	private ArticleService articleService;
	
	@GetMapping("/search/{category}")
	public ResponseEntity<ArticleResponse> findAll(@PathVariable(value = "category") String category) {
		return new ResponseEntity<ArticleResponse>(articleService.findByCategory(category), 
				HttpStatus.OK);
	}
}

