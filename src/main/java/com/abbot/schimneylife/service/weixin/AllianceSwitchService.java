package com.abbot.schimneylife.service.weixin;

import java.util.List;

import com.abbot.schimneylife.pojo.weixin.TsSwitch;

public interface AllianceSwitchService {

	List<TsSwitch> findByPage(Integer firstResult,Integer pageSize,String like,String column,String sort
			,String startTime,String endTime,Integer salesmanId);
	
	
	
	/**
	 * 根据条件统计数量
	 * @param like
	 * @param startTime
	 * @param endTime
	 * @return
	 * @throws Exception
	 */
	Integer countTotal(String like,String startTime,String endTime,Integer salesmanId);

	/**
	 * 禁用用户
	 * 
	 * @param id
	 */
	boolean disable(Integer id);

	/**
	 * 启用用户
	 * 
	 * @param id
	 */
	boolean enable(Integer id);
}
