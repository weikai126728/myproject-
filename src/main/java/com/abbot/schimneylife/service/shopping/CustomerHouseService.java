package com.abbot.schimneylife.service.shopping;

import java.util.List;

import com.abbot.schimneylife.pojo.shopping.CustomerHouse;

public interface CustomerHouseService {
	/**
	 * 添加收藏
	 * 
	 * @param customerHouse
	 * @return
	 */
	boolean addFavourites(CustomerHouse customerHouse);

	/**
	 * 我的收藏
	 * 
	 * @return
	 */
	List<CustomerHouse> checkFavourites();

	/**
	 * 取消收藏
	 * 
	 * @param id
	 * @return
	 */
	boolean deleteFavourites(String id, Integer customerId);
	/**
	 * 取消指定商品收藏
	 * @param proId
	 * @param customerId
	 * @return
	 */
	boolean deleteByProductId(String proId,Integer customerId);
	/**
	 * 批量删除
	 * @param ids
	 * @param customerId
	 */
	void deleteBatch(String ids,Integer customerId)throws Exception;
	/**
	 * 判断是否已经收藏指定商品
	 * @param customerId
	 * @param productId
	 * @return
	 */
	Integer isMyFavourites(Integer customerId,String productId);
	/**
	 * 批量添加我的收藏
	 * @param customerId
	 * @param proIds
	 * @return
	 * @throws Exception 
	 */
	void addBatch(Integer customerId,String proIds) throws Exception;
	/**
	 * 分页查询
	 * @param customerId
	 * @param firstResult
	 * @param pageSize
	 * @return
	 */
	List<CustomerHouse> findByPage(Integer customerId,Integer firstResult,Integer pageSize);
	/**
	 * 统计总数量
	 * @param customerId
	 * @return
	 */
	Integer countTotal(Integer customerId);
}
