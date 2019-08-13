package com.abbot.schimneylife.service.fenxiao;

import java.util.List;

import com.abbot.schimneylife.pojo.fenxiao.OrdersDistribution;
import com.abbot.schimneylife.pojo.fenxiao.UserDistribution;

public interface UserDistributionService {

	List<UserDistribution> selectUser();

	boolean stop(int id);

	boolean start(int id);

	boolean deleteById(int id);
	
	List<UserDistribution> selectUserBy(UserDistribution user);
	  
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
		List<UserDistribution> findByPageAndType(String order, String sort,  Integer firstResult,
				Integer pageSize);
}
