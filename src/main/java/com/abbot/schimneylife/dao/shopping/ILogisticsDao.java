package com.abbot.schimneylife.dao.shopping;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.abbot.schimneylife.pojo.shopping.Logistics;

@Repository
public interface ILogisticsDao {

	Integer add(Logistics log) throws Exception;
	
	Logistics queryLogById(@Param("id")String serviceId)throws Exception;
}
