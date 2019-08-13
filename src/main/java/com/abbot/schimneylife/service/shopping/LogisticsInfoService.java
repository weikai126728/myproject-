package com.abbot.schimneylife.service.shopping;

import com.abbot.schimneylife.pojo.shopping.LogisticsInfo;

public interface LogisticsInfoService {

	/**
	 * 新建物流信息
	 * @param company
	 * @param waybill
	 * @param logisticsNo
	 * @param customerOrderId
	 * @return
	 */
	boolean insert(String company,String waybill,String logisticsNo,String customerOrderId);
	/**
	 * 修改物流信息
	 * @param id
	 * @param company
	 * @param waybill
	 * @param logisticsNo
	 * @param customerOrderId
	 * @return
	 */
	boolean update(String id,String company,String waybill,String logisticsNo);
	/**
	 * 根据订单id查询物流信息
	 * @param orderId
	 * @return
	 */
	LogisticsInfo fetchByOrderId(String orderId);
}
