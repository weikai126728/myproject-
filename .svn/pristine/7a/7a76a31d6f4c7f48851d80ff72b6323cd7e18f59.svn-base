package com.abbot.schimneylife.service.shopping;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.abbot.schimneylife.pojo.shopping.ShoppingCart;

public interface ShoppingCartService {

	/**
	 * 根据用户id，查找购物车(启用状态商品)
	 * @param userId
	 * @return
	 */
	List<ShoppingCart> findEnabelByUserId(Integer userId);
	/**
	 * 根据用户id，查找购物车(禁用状态商品)
	 * @param userId
	 * @return
	 */
	List<ShoppingCart> findDisableByUserId(Integer userId);
	/**
	 * 新增购物车
	 * @param cart
	 * @return
	 */
	boolean addCart(@Param("customerId")Integer customerId,@Param("productId")String productId,@Param("paramId")String paramId,@Param("num")Integer num)throws Exception;
	/**
	 * 删除指定购物车
	 * @param cartId
	 * @return
	 */
	void delete(String cartId) throws Exception;
}
