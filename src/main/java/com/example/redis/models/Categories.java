package com.example.redis.models;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Categories implements Serializable {

	private static final long serialVersionUID = 1L;

	private String id;
	
	private String name;
}
