package com.abbot.schimneylife.service.shopping;

import com.abbot.schimneylife.pojo.shopping.WeiXinPayLog;

public interface WeiXinPayLogService {
	/**
	 * 新增微信订单支付结果通知
	 * @param log
	 * @return
	 */
	boolean insert(WeiXinPayLog log);
	/**
	 * 根据订单id和类型查找
	 * @param orderId
	 * @param type
	 * @return
	 */
	WeiXinPayLog fetchByOrderId(String orderId,Integer type);
}
