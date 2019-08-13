package com.abbot.schimneylife.dao.shopping;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.abbot.schimneylife.pojo.shopping.AlibabaOrder;

@Repository
public interface IAlibabaOrderDao {

	/**
	 * 添加阿里订单信息
	 * @param order
	 * @throws Exception
	 */
	void insert(AlibabaOrder order)throws Exception;
	/**
	 * 根据customerorderid查找
	 * @param customerOrderId
	 * @return
	 * @throws Exception
	 */
	AlibabaOrder fetchByCustomerOrderId(@Param("customerOrderId")String customerOrderId)throws Exception;
}
