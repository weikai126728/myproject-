package com.abbot.schimneylife.service.user;

import java.util.List;

import com.abbot.schimneylife.pojo.fenxiao.OrdersDistribution;
import com.abbot.schimneylife.pojo.user.Opinion;

public interface OpinionService {
	Integer insert(Opinion op);
	
	List<Opinion> checkOpinion();
	
	boolean deleteById(Integer id);
	
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
		List<Opinion> findByPageAndType(String order, String sort, Integer firstResult,
				Integer pageSize);
	 
}
