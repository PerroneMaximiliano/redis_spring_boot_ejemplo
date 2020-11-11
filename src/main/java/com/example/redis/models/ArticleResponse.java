package com.example.redis.models;

import java.io.Serializable;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ArticleResponse implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String site_id;
	
	private Pagination paging;
	
	private List<Article> results;

}
