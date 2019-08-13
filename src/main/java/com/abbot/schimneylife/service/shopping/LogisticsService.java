package com.abbot.schimneylife.service.shopping;

import com.abbot.schimneylife.pojo.shopping.Logistics;

public interface LogisticsService {
 
	Integer add(Logistics log);
	
	Logistics queryLogById(String serviceId);
}
