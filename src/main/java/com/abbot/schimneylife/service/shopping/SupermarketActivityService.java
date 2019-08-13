package com.abbot.schimneylife.service.shopping;

import java.util.List;

import com.abbot.schimneylife.pojo.shopping.SupermarketActivity;

public interface SupermarketActivityService {

	/**
	 * 查找指定超市的活动列表
	 * @param supermarketId
	 * @return
	 */
	List<SupermarketActivity> findActivityByMarketId(Integer supermarketId);
	boolean insert(SupermarketActivity activityList);
	boolean update(SupermarketActivity activityList);
	boolean delete(String id);
}
