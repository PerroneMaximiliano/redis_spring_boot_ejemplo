package com.example.redis.repository;

import javax.annotation.PostConstruct;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.redis.config.properties.MLPropertiesConfiguration;
import com.example.redis.models.ArticleResponse;

@Repository
public class ArticleDAOImpl implements ArticleDAO {
	
	@Autowired
	private MLPropertiesConfiguration mlPropertiesConfiguration;

	private Client client;
	
    private WebTarget target;
	
	@PostConstruct
	public void init() {
		client = ClientBuilder.newClient();
		target = client.target(mlPropertiesConfiguration.getMercadolibreArticleUrl());
	}

	@Override
	public ArticleResponse findByCategory(String category) {
		return target.queryParam("category", category)
				.request(MediaType.APPLICATION_JSON)
				.get(ArticleResponse.class);
	}

}
