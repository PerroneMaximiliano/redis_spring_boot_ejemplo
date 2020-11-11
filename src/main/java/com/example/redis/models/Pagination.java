package com.example.redis.models;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Pagination implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long total;

	private int offset;
	
	private int limit;

	private int primary_results;

}
