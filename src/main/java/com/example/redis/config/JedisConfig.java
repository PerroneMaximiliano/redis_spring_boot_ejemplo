package com.example.redis.config;

import java.io.Serializable;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.SerializationUtils;

import com.example.redis.config.properties.RedisPropertiesConfiguration;
import com.example.redis.models.RedisWrap;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;
import redis.clients.jedis.exceptions.JedisConnectionException;

@Configuration
public class JedisConfig {
	
	@Autowired
	private RedisPropertiesConfiguration redisProperties;
	
	private static JedisPool jedisPool = null;
	
	private static final String OK = "OK";

	public RedisWrap find(String key) {
		byte[] hashData = getResource().get(key.getBytes());
		validateExpirationTime(hashData);
		return (RedisWrap) deserialize(hashData);
	}
	
	public boolean save(RedisWrap redisWrap) {
		String resultSave = getResource().set(redisWrap.getKey().getBytes(), serialize(redisWrap));
		return OK.equals(resultSave) ? true : false;
	}
	
	public boolean saveWithExpirationTime(RedisWrap redisWrap, int expirationTime) {
		boolean result = save(redisWrap);
		if (result) {
			getResource().expire(redisWrap.getKey().getBytes(), expirationTime);
		}
		return result;
	}
	
	private void initPool() {
    	if (jedisPool == null) {  
    		JedisPoolConfig config = new JedisPoolConfig();
    		config.setMaxTotal(redisProperties.getMaxActive());
            config.setMaxIdle(redisProperties.getMaxIdle());
            config.setMaxWaitMillis(redisProperties.getMaxWait());
            jedisPool = new JedisPool(config, redisProperties.getHostName(), 
            		redisProperties.getPort(), redisProperties.getJedisTimeout());
        }
    }
	
	private void validateExpirationTime(byte[] data) {
		if (data != null) {
			RedisWrap redisWrap = (RedisWrap) deserialize(data);
			long milliseconds = new Date().getTime() - redisWrap.getCreatedDate().getTime();
		    int minutes = (int) ((milliseconds / (1000 * 60)) % 60);
		    if (minutes > 25) {
		    	getResource().del(redisWrap.getKey().getBytes());
		    }
		}
	}
	
	private Jedis getResource() {
		initPool();
    	Jedis jedis = null;
    	try {
    		jedis = jedisPool.getResource();
    	} catch (JedisConnectionException ex) {
    		ex.printStackTrace();
    	} finally {
    		close(jedis);
        }
    	return jedis;
	}
	
	private void close(final Jedis jedis) {
        if (jedis != null && jedisPool != null) {
            jedis.close();
        }
    }
	
	private byte[] serialize(Serializable object) {
	     return SerializationUtils.serialize(object);
	}
	
	private Object deserialize(byte[] bytes) {
	     return SerializationUtils.deserialize(bytes);
	}
}
