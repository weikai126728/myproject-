package com.abbot.schimneylife.service.weixin;

import java.util.List;

import com.abbot.schimneylife.pojo.weixin.Receivers;
import com.abbot.schimneylife.pojo.weixin.TsServiceFee;

public interface FashionableService {

	List<Receivers> findfashionableByPage(Integer firstResult,Integer pageSize,String like,String column,String sort
			,String startTime,String endTime);
	/**
	 * 根据条件统计数量
	 * @param like
	 * @param startTime
	 * @param endTime
	 * @return
	 * @throws Exception
	 */
	Integer countTotal(String like,String startTime,String endTime);
	Receivers findfashionable(Integer id);
	boolean updatefindfashionable(Receivers receivers);
	boolean deletfashionable(Integer id);
	boolean addfindfashionable(Receivers receivers);
}
