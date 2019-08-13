package com.abbot.schimneylife.dao.shopping;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.abbot.schimneylife.pojo.shopping.WeiXinPayLog;

@Repository
public interface IWeiXinPayLogDao {

	void insert(WeiXinPayLog log)throws Exception;
	/**
	 * 
	 * @param customerOrderIs
	 * @param type
	 * @return
	 * @throws Exception
	 */
	WeiXinPayLog fetchByOrderId(@Param("customerOrderId")String customerOrderIs,@Param("type")Integer type)throws Exception;
}
