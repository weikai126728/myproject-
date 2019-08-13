package com.abbot.schimneylife.dao.shopping;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.abbot.schimneylife.pojo.shopping.MallCart;


@Repository
public interface IMallCartDao {

	/**
	 * 根据购物车id查询商城购物车列表
	 * @param shoppingCartId
	 * @return
	 * @throws Exception
	 */
	List<MallCart> fetchListByShoppingCart(@Param("shoppingCartId")String shoppingCartId)throws Exception;
	/**
	 * 设置指定用户指定产品的数量
	 * @param userInfoID
	 * @param proID
	 * @throws Exception
	 */
	void setMallProNum(@Param("customerId")Integer customerId,@Param("mallCartId")String mallCartId,@Param("num")Integer num)throws Exception;
	/**
	 * 删除指定用户购物车中的商品
	 * @param userInfoID
	 * @param proID
	 * @throws Exception
	 */
	void deleteMallPro(@Param("customerId")Integer customerId,@Param("paramID")String paramID)throws Exception;
	/**
	 * 查找指定购物车的商城购物车列表
	 * @param shoppingCartId
	 * @param ids 商城购物车ids串
	 * @return
	 * @throws Exception
	 */
	List<MallCart> findByIds(Map<String,Object> map)throws Exception;
	/**
	 * 添加购物车
	 * @param mallCart
	 * @throws Exception
	 */
	void insert(MallCart mallCart)throws Exception;
	/**
	 * 查找指定用户 相同类型产品的购物车
	 * @param customerId
	 * @param source
	 * @return
	 * @throws Exception
	 */
	MallCart fetchFistSameType(@Param("customerId")Integer customerId,@Param("source")Integer source)throws Exception;
	/**
	 * 查找相同的购物车
	 * @param customerId
	 * @param productId
	 * @param paramId
	 * @return
	 * @throws Exception
	 */
	MallCart fetchSameCart(@Param("customerId")Integer customerId,@Param("productId")String productId
			,@Param("paramId")String paramId)throws Exception;
	/**
	 * 根据id删除数据
	 * @param id
	 * @throws Exception
	 */
	void delete(@Param("id")String id)throws Exception;
	/**
	 * 根据id查找购物车
	 * @param id
	 * @return
	 * @throws Exception
	 */
	MallCart fetchById(@Param("id")String id)throws Exception;
	/**
	 * 统计
	 * @param id
	 * @return
	 * @throws Exception
	 */
	Integer countByShoppingCartId(@Param("id")String id)throws Exception;
}
