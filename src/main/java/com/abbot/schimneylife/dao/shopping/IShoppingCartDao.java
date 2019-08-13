package com.abbot.schimneylife.dao.shopping;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.abbot.schimneylife.pojo.shopping.ShoppingCart;

/**
 * 购物车
 * @author Administrator
 *
 */
@Repository
public interface IShoppingCartDao {

	/**
	 * 查找指定用户的购物车
	 * @param userInfoID
	 * @return
	 * @throws Exception
	 */
	List<ShoppingCart> getIdByUserId(@Param("userInfoID")Integer userInfoID,@Param("status")Integer status)throws Exception;
	/**
	 * 新增购物车
	 * @param cart
	 * @throws Exception
	 */
	void insert(ShoppingCart cart)throws Exception;
	/**
	 * 删除购物车
	 * @param cartId
	 * @throws Exception
	 */
	void delete(Map<String,Object> map)throws Exception;
	/**
	 * 根据id删除
	 * @param id
	 * @throws Exception
	 */
	void deleteById(@Param("id")String id)throws Exception;
	/**
	 * 查询所有商品
	 * @return
	 * @throws Exception
	 */
	List<ShoppingCart> findAll()throws Exception;
}
