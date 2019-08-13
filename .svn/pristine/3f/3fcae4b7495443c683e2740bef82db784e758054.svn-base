package com.abbot.schimneylife.service.company;

import java.util.List;

import com.abbot.schimneylife.pojo.company.news;

public interface NewsService {
	Integer totalCount(); 

	List<news> findByPage( String order, String sort,
			Integer firstResult, Integer pageSize);
	
	news findById(String id);
	
	boolean add(news news);
	
	boolean edit(news news);
	
	boolean deleteById(String id);
}
