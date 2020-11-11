package com.example.redis.models;

import java.io.Serializable;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RedisWrap implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private String key;

	private Date createdDate;
	
	private Object data;

}
