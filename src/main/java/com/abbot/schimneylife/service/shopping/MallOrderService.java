package com.abbot.schimneylife.service.shopping;

import java.math.BigDecimal;
import java.util.List;

import com.abbot.schimneylife.pojo.shopping.MallOrder;

public interface MallOrderService {
	
	/**
	 * 新增在线商城订单
	 * @param order
	 * @return
	 */
	boolean addMallOrder(MallOrder order);
	/**
	 * 查找用户订单中在线商城订单列表
	 * @param customerOrderID
	 * @return
	 */
	List<MallOrder> findMallOrderList(String customerOrderID);
	
	BigDecimal selectAmount(String id);
}
