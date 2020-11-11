package com.example.redis.config;

import java.util.HashMap;
import java.util.Map;

import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.redisson.spring.cache.RedissonSpringCacheManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.redis.config.properties.RedisPropertiesConfiguration;

@Configuration
@EnableCaching
public class CacheConfig {
	
	@Autowired
	private RedisPropertiesConfiguration redisProperties;

	@Bean
	public CacheManager cacheManager(RedissonClient redissonClient) {
		Map<String, CacheConfig> config = new HashMap<>();
		config.put("articles", new CacheConfig());
		return new RedissonSpringCacheManager(redissonClient);
	}
	
	@Bean(destroyMethod = "shutdown")
	public RedissonClient redisson() {
		Config config = new Config();
		config.useSingleServer()
			.setAddress(redisProperties.getHostName() + ":" + redisProperties.getPort());
		return Redisson.create(config);
	}
}
