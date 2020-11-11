package com.example.redis.models;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Installments implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private int quantity;
	
	private Double amount;
	
	private String currency_id;

}
