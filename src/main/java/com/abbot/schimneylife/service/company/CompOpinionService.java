package com.abbot.schimneylife.service.company;

import java.util.List;

import com.abbot.schimneylife.pojo.company.compOpinion;

public interface CompOpinionService {
	Integer totalCount(); 

	List<compOpinion> findByPage( String order, String sort,
			Integer firstResult, Integer pageSize);
	
	boolean deleteById(String id);
}
