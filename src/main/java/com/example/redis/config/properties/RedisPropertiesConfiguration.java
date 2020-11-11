package com.example.redis.config.properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

@Configuration
@PropertySource("classpath:redis.properties")
public class RedisPropertiesConfiguration {

	@Autowired
	private Environment env;
	
	private static final String REDIS_HOSTNAME = "redis.hostname";
	
	private static final String REDIS_PORT = "redis.port";
	
	private static final String JEDIS_MAX_ACTIVE = "jedis.max.active";
	
	private static final String JEDIS_MAX_IDLE = "jedis.max.idle";
	
	private static final String JEDIS_MAX_WAIT = "jedis.max.wait";
	
	private static final String JEDIS_TIMEOUT = "jedis.timeout";
	
	public String getHostName() {
		return env.getProperty(REDIS_HOSTNAME);
	}
	
	public Integer getPort() {
		return Integer.valueOf(env.getProperty(REDIS_PORT));
	}
	
	public Integer getMaxActive() {
		return Integer.valueOf(env.getProperty(JEDIS_MAX_ACTIVE));
	}
	
	public Integer getMaxIdle() {
		return Integer.valueOf(env.getProperty(JEDIS_MAX_IDLE));
	}
	
	public Integer getMaxWait() {
		return Integer.valueOf(env.getProperty(JEDIS_MAX_WAIT));
	}
	
	public Integer getJedisTimeout() {
		return Integer.valueOf(env.getProperty(JEDIS_TIMEOUT));
	}
}
