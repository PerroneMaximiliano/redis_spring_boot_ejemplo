package com.example.redis.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.redis.models.Categories;
import com.example.redis.services.CategoriesService;

@RestController
@RequestMapping("/categories")
public class CategoriesController {

	@Autowired
	private CategoriesService categoriesService;
	
	@GetMapping("/list")
	public ResponseEntity<Categories[]> findAll() {
		return new ResponseEntity<Categories[]>(categoriesService.findAll(), 
				HttpStatus.OK);
	}
}
