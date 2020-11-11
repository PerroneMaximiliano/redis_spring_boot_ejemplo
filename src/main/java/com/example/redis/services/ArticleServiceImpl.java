package com.example.redis.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.example.redis.models.ArticleResponse;
import com.example.redis.repository.ArticleDAO;

@Service
public class ArticleServiceImpl implements ArticleService {
	
	private static final Logger log = LoggerFactory.getLogger(ArticleServiceImpl.class);
	
	@Autowired
	private ArticleDAO articleDAO;


	@Cacheable(value = "articles")
	@Override
	public ArticleResponse findByCategory(String category) {
		log.info("-- Searching articles from ML api --");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return articleDAO.findByCategory(category);
	}
	
	/*
	@CacheEvict("articles")
	public void delete(String id) {
		articleRepository.delete(id);
	}
	
	@CachePut("articles")
	public User update(Article article) {
		return articleRepository.save(article);
	}
	 */

}
