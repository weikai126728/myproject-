package com.abbot.schimneylife.service.shopping;

import java.util.List;

import com.abbot.schimneylife.pojo.shopping.MallCart;

public interface MallCartListService {

	/**
	 * 根据购物车id查询商城购物车列表
	 * @param shoppingCartId
	 * @return
	 */
	public List<MallCart> findListByShoppingCartId(String shoppingCartId) ;
	/**
	 * 设置指定用户指定产品的数量
	 * 
	 * @param userID
	 * @param paramID
	 * @param num
	 * @return
	 */
	boolean setMallProNum(Integer customerId, String mallCartId, Integer num);

	/**
	 * 删除指定用户购物车中的商品
	 * 
	 * @param customerId
	 * @param paramID
	 * @return
	 */
	boolean deleteMallPro(Integer customerId, String paramID);
	/**
	 * 查找指定用户的商城购物车列表
	 * @param ids
	 * @return
	 */
	List<MallCart> findListByIds(String ids);
	/**
	 * 新增购物车
	 * @param cart
	 * @return
	 */
	boolean addMallCart(MallCart cart);
	/**
	 * 根据id删除
	 * @param mallCartId
	 * @throws Exception
	 */
	void deleteById(String mallCartId)throws Exception;
}
