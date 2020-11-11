package com.example.redis.models;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Article implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String id;
	
	private String site_id;
	
	private String title;
	
	private Double price;

	private String currency_id;
	
	private int available_quantity;
	
	private String condition;
	
	private Installments installments;
	
	private Address address;

}
