package com.abbot.schimneylife.dao.shopping;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.abbot.schimneylife.pojo.shopping.CustomerHouse;

@Repository
public interface ICustomerHouseDao {

	/**
	 * 添加我的收藏
	 * 
	 * @param house
	 * @throws Exception
	 */
	void insert(CustomerHouse house) throws Exception;

	/**
	 * 我的收藏
	 * 
	 * @return
	 */
	List<CustomerHouse> checkFavourites();

	/**
	 * 取消收藏
	 * 
	 * @param pid
	 */
	void deleteFavourites(@Param("id") String id, @Param("customerId") Integer customerId);
	/**
	 * 删除指定商品的收藏
	 * @param proId
	 * @param customerId
	 */
	void deleteByProductId(@Param("proId") String proId, @Param("customerId") Integer customerId) throws Exception;
	/**
	 * 判断是否已经收藏指定商品
	 * @param customerId
	 * @param productId
	 * @return
	 * @throws Exception
	 */
	Integer isMyFavourites(@Param("customerId")Integer customerId,@Param("productId")String productId)throws Exception;
	/**
	 * 分页查询我的收藏
	 * @param customerId
	 * @param firstResult
	 * @param pageSize
	 * @return
	 * @throws Exception
	 */
	List<CustomerHouse> findByPage(@Param("customerId")Integer customerId,@Param("firstResult")Integer firstResult,@Param("pageSize")Integer pageSize)throws Exception;
	/**
	 * 统计总数量
	 * @return
	 * @throws Exception
	 */
	Integer countTotal(@Param("customerId")Integer customerId)throws Exception;
}
