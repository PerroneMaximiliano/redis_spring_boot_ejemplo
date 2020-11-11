package com.example.redis.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.redis.models.Categories;
import com.example.redis.repository.CategoriesDAO;

@Service
public class CategoriesServiceImpl implements CategoriesService {
	
	private static final Logger log = LoggerFactory.getLogger(CategoriesServiceImpl.class);

	@Autowired
	private CategoriesDAO categoriesDao;
	
	@Override
	public Categories[] findAll() {
		log.info("-- Searching categories from ML api --");
		return categoriesDao.findAll();
	}
}
