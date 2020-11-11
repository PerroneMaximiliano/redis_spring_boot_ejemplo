package com.example.redis.config.properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

@Configuration
@PropertySource("classpath:mercadolibre.properties")
public class MLPropertiesConfiguration {

	@Autowired
	private Environment env;
	
	private static final String CATEGORIES_URL = "mercadolibre.url.categories";
	private static final String ARTICLE_URL = "mercadolibre.url.article";
	
	public String getMercadolibreCategoriesUrl() {
		return env.getProperty(CATEGORIES_URL);
	}
	
	public String getMercadolibreArticleUrl() {
		return env.getProperty(ARTICLE_URL);
	}
}
