package com.example.redis.repository;

import javax.annotation.PostConstruct;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.redis.config.properties.MLPropertiesConfiguration;
import com.example.redis.models.Categories;

@Repository
public class CategoriesDAOImpl implements CategoriesDAO {
	
	@Autowired
	private MLPropertiesConfiguration mlPropertiesConfiguration;
	
	private Client client;
	
    private WebTarget target;
	
	@PostConstruct
	public void init() {
		client = ClientBuilder.newClient();
        target = client.target(mlPropertiesConfiguration.getMercadolibreCategoriesUrl());
	}

	@Override
	public Categories[] findAll() {
		return target.request(MediaType.APPLICATION_JSON).get(Categories[].class);
	}

}
