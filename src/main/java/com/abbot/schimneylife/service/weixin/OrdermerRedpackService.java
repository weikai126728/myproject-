package com.abbot.schimneylife.service.weixin;

import java.util.List;

import com.abbot.schimneylife.pojo.weixin.OrdermerRedpack;

public interface OrdermerRedpackService {

	/**
	 * 分页查询
	 * @param firstResult
	 * @param pageSize
	 * @param like
	 * @param column
	 * @param sort
	 * @param startTime
	 * @param endTime
	 * @return
	 */
	List<OrdermerRedpack> findByPage(Integer firstResult,Integer pageSize,String like
			,String column,String sort,String startTime,String endTime);
	/**
	 * 统计数量
	 * @param like
	 * @param startTime
	 * @param endTime
	 * @return
	 */
	Integer countTotal(String like,String startTime,String endTime);
	/**
	 * 统计红包总金额
	 * @param like
	 * @param startTime
	 * @param endTime
	 * @return
	 */
	Integer countRedpack(String like,String startTime,String endTime);
}
