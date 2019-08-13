package com.abbot.schimneylife.service.weixin;

import java.util.List;

import com.abbot.schimneylife.pojo.weixin.OrderPayment;

public interface OrderPaymentService {

	/**
	 * 分页查询
	 * @param firstResult
	 * @param pageSize
	 * @param column
	 * @param sort
	 * @param userId
	 * @param startTime
	 * @param endTime
	 * @param openId
	 * @return
	 */
	List<OrderPayment> findByPage(Integer firstResult,Integer pageSize,String column
			,String sort,Integer userId,String startTime,String endTime,String openId,String search);
	/**
	 * 统计数量
	 * @param userId
	 * @param startTime
	 * @param endTime
	 * @param openId
	 * @return
	 */
	Integer countTotal(Integer userId,String startTime,String endTime,String openId,String search);
	/**
	 * 根据条件统计交易额
	 * @param userId
	 * @param startTime
	 * @param endTime
	 * @param openId
	 * @return
	 */
	Integer countTrade(Integer userId,String startTime,String endTime,String openId,String search);
}
