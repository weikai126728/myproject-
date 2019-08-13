package com.abbot.schimneylife.service.shopping;

import java.util.List;

import com.abbot.schimneylife.pojo.shopping.YingLiOrder;

public interface YingLiOrderService {

	/**
	 * 插入订单
	 * @param order
	 * @return
	 */
	boolean insert(YingLiOrder order);
	/**
	 * 根据条件分页查询英利订单
	 * @param firstResult
	 * @param pageSize
	 * @param like
	 * @param startTime
	 * @param endTime
	 * @return
	 */
	List<YingLiOrder> findByPage(Integer firstResult,Integer pageSize,String like,String startTime,String endTime);
	/**
	 * 根据条件统计英利订单数量
	 * @param like
	 * @param startTime
	 * @param endTime
	 * @return
	 */
	Integer countTotal(String like,String startTime,String endTime);
	/**
	 * 修改订单交易状态
	 * @param id
	 * @param status
	 * @return
	 */
	boolean updateStatus(String id,Integer status);
}
