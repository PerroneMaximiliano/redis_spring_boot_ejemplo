package com.example.redis.services;

import com.example.redis.models.ArticleResponse;

public interface ArticleService {

	ArticleResponse findByCategory(String category);
}
