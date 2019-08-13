package com.abbot.schimneylife.dao.shopping;

import org.apache.ibatis.annotations.Param;

import com.abbot.schimneylife.pojo.shopping.LogisticsInfo;

public interface ILogisticsInfoDao {

	/**
	 * 新建物流信息
	 * @param company
	 * @param waybill
	 * @param logisticsNo
	 * @param customerOrderId
	 * @throws Exception
	 */
	void insert(@Param("company")String company,@Param("waybill")String waybill
			,@Param("logisticsNo")String logisticsNo,@Param("customerOrderId")String customerOrderId)throws Exception;
	/**
	 * 修改物流信息
	 * @param id
	 * @param company
	 * @param waybill
	 * @param logisticsNo
	 * @throws Exception
	 */
	void update(@Param("id")String id,@Param("company")String company,@Param("waybill")String waybill
			,@Param("logisticsNo")String logisticsNo)throws Exception;
	/**
	 * 根据用户订单id查询
	 * @param orderId
	 * @return
	 * @throws Exception
	 */
	LogisticsInfo fetchByOrderId(@Param("orderId")String orderId)throws Exception;
}
