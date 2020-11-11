package com.example.redis.repository;

import com.example.redis.models.ArticleResponse;

public interface ArticleDAO {

	ArticleResponse findByCategory(String category);
}
