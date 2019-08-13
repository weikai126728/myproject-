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
import com.abbot.schimneylife.dao.shopping.IShoppingCartDao;
import com.abbot.schimneylife.pojo.shopping.MallCart;
import com.abbot.schimneylife.service.shopping.MallCartListService;

@Service
public class MallCartListServiceImpl implements MallCartListService {
	private static final Logger logger = Logger.getLogger(MallCartListServiceImpl.class);

	@Resource
	private IMallCartDao cartDao;
	@Resource
	private IShoppingCartDao shoppingDao;
	@Override
	public List<MallCart> findListByShoppingCartId(String shoppingCartId) {
		List<MallCart> cartList = Collections.emptyList();
		try {
			cartList = cartDao.fetchListByShoppingCart(shoppingCartId);
		} catch (Exception e) {
			logger.error("根据购物车id查询商城购物车列表异常！", e);
		}
		return cartList;
	}

	@Override
	public boolean setMallProNum(Integer customerId, String mallCartId, Integer num) {
		try {
			cartDao.setMallProNum(customerId, mallCartId, num);
			return true;
		} catch (Exception e) {
			logger.error("设置指定用户指定产品的数量异常！", e);
			return false;
		}
	}

	@Override
	public boolean deleteMallPro(Integer customerId, String paramID) {
		try {
			cartDao.deleteMallPro(customerId, paramID);
			return true;
		} catch (Exception e) {
			logger.error("删除指定用户购物车中的商品异常！", e);
			return false;
		}
	}

	@Override
	public List<MallCart> findListByIds(String ids) {
		List<MallCart> mallCartList = Collections.emptyList();
		Map<String, Object> map = new HashMap<>();
		String[] str = ids.split(",");
		map.put("ids", str);
		try {
			mallCartList = cartDao.findByIds(map);
		} catch (Exception e) {
			logger.error("查找指定用户的商城购物车列表异常！", e);
		}
		return mallCartList;
	}

	@Override
	public boolean addMallCart(MallCart cart) {
		try {
			cartDao.insert(cart);
			return true;
		} catch (Exception e) {
			logger.error("新增购物车异常！",e);
			return false;
		}

	}
	@Transactional(rollbackFor=Exception.class)
	@Override
	public void deleteById(String mallCartId) throws Exception {
		if(mallCartId!=null) {
			String[] ids = mallCartId.split(",");
			MallCart mallCart = null;
			for(String id:ids) {
				mallCart = cartDao.fetchById(id);
				if(mallCart!=null) {
					cartDao.delete(id);
					Integer count = cartDao.countByShoppingCartId(mallCart.getShoppingCartId());
					if(count==0) {
						shoppingDao.deleteById(mallCart.getShoppingCartId());
					}
				}
			}
		}
	}

}
