package com.abbot.schimneylife.serviceImpl.shopping;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.abbot.schimneylife.dao.shopping.IMallCartDao;
import com.abbot.schimneylife.dao.shopping.IMallProductDao;
import com.abbot.schimneylife.dao.shopping.IShoppingCartDao;
import com.abbot.schimneylife.pojo.shopping.MallCart;
import com.abbot.schimneylife.pojo.shopping.MallProduct;
import com.abbot.schimneylife.pojo.shopping.ShoppingCart;
import com.abbot.schimneylife.service.shopping.ShoppingCartService;
import com.abbot.schimneylife.util.CommonKey;

@Service
public class ShoppingCartServiceImpl implements ShoppingCartService {

	private static final Logger logger = Logger.getLogger(ShoppingCartServiceImpl.class);
	
	@Resource
	private IShoppingCartDao cartDao;
	@Resource
	private IMallCartDao mallCartDao;
	@Resource
	private IMallProductDao productDao;
	@Override
	public List<ShoppingCart> findEnabelByUserId(Integer userId) {
		List<ShoppingCart> cart = Collections.emptyList();
		try {
			cart = cartDao.getIdByUserId(userId,CommonKey.ENABLE_FLAG);
		} catch (Exception e) {
			logger.error("根据用户id，查找购物车异常！",e);
		}
		return cart;
	}
	/**
	 * 抛出异常时，spring才会回滚
	 */
	@Transactional(rollbackFor=Exception.class)
	@Override
	public boolean addCart(Integer customerId, String productId, String paramId, Integer num)throws Exception{
		//先判断是否已经存在此商品的购物车，有则累加
		MallCart mallcart = mallCartDao.fetchSameCart(customerId, productId, paramId);
		if(mallcart!=null&&mallcart.getId()!=null) {
			mallCartDao.setMallProNum(customerId, mallcart.getId(), num+mallcart.getTotalCount());
			return true;
		}
		//如果是自营的商品要进行合并，有相同的shoppingcart id，如果是第三方则新建
		MallProduct product = productDao.fetchByParamId(paramId);
		mallcart = mallCartDao.fetchFistSameType(customerId, product.getSource());
		if(CommonKey.ProductSource.SELFSUPPORT.getSource()==product.getSource()
				&&mallcart!=null&&mallcart.getId()!=null) {//如果是自营的要进行合并处理
			MallCart mc = new MallCart(mallcart.getShoppingCartId(),productId,paramId,num);
			mallCartDao.insert(mc);
		}else {//否则创建新的购物车
			ShoppingCart cart = new ShoppingCart(customerId);
			cartDao.insert(cart);
			MallCart mallCart = new MallCart(cart.getId(),productId,paramId,num);
			mallCartDao.insert(mallCart);
		}
		
		return true;
	}
	@Override
	public void delete(String cartId)throws Exception {
			Map<String,Object> map = new HashMap<>();
			String[] ids = cartId.split(",");
			map.put("ids", ids);
			cartDao.delete(map);
			
	}
	@Override
	public List<ShoppingCart> findDisableByUserId(Integer userId) {
		List<ShoppingCart> cart = Collections.emptyList();
		try {
			cart = cartDao.getIdByUserId(userId,CommonKey.DISABLE_FLAG);
		} catch (Exception e) {
			logger.error("根据用户id，查找禁用状态商品购物车异常！",e);
		}
		return cart;
	}
	

}
