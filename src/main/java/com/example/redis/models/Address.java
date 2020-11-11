package com.example.redis.models;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Address implements Serializable {

	private static final long serialVersionUID = 1L;

	private String state_id;
	
	private String state_name;

	private String city_id;

}
