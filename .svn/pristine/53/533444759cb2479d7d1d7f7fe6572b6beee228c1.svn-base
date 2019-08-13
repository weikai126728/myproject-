package com.abbot.schimneylife.service.fenxiao;

import java.util.List;

import com.abbot.schimneylife.pojo.fenxiao.OrdersDistribution;
import com.abbot.schimneylife.pojo.fenxiao.ProductDistribution;

public interface OrdersDistributionService {

	  boolean deleteById(Integer orderId);
	  
	  List<OrdersDistribution> selectOrder();

	  List<OrdersDistribution> selectOrderBy(String name);
	  
	  Integer totalCount();// 商品总数量
		/**
		 * 根据分类分页查询商品
		 * 
		 * @param typeId
		 *            商品分类id
		 * @param firstResult
		 * @param pageSize
		 * @return
		 */
		List<OrdersDistribution> findByPageAndType(String order, String sort, Integer firstResult,
				Integer pageSize);
	 
}
