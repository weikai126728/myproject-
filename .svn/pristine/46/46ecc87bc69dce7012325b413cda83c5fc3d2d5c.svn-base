package com.abbot.schimneylife.serviceImpl.shopping;

import java.util.Collections;
import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.abbot.schimneylife.dao.shopping.ICustomerHouseDao;
import com.abbot.schimneylife.pojo.shopping.CustomerHouse;
import com.abbot.schimneylife.service.shopping.CustomerHouseService;

@Service
public class CustomerHouseServiceImpl implements CustomerHouseService {
	private static final Logger logger = Logger.getLogger(CustomerOrderServiceImpl.class);
	@Resource
	private ICustomerHouseDao chd;

	@Override
	public boolean addFavourites(CustomerHouse customerHouse) {
		try {
			chd.insert(customerHouse);
			return true;
		} catch (Exception e) {
			logger.error("添加收藏异常！", e);
			return false;
		}
	}

	@Override
	public List<CustomerHouse> checkFavourites() {
		return chd.checkFavourites();
	}

	@Override
	public boolean deleteFavourites(String pid, Integer customerId) {
		try {
			chd.deleteFavourites(pid, customerId);
			return true;
		} catch (Exception e) {
			logger.error("取消收藏异常", e);
			return false;
		}
	}

	@Override
	public Integer isMyFavourites(Integer customerId, String productId) {
		try {
			return chd.isMyFavourites(customerId, productId);
		} catch (Exception e) {
			logger.error("判断是否已经收藏指定商品失败！",e);
			return 0;
		}
	}
	@Transactional(rollbackFor=Exception.class)
	@Override
	public void addBatch(Integer customerId,String proIds) throws Exception{
		String[] ids = proIds.split(",");
		for(int i=0;i<ids.length;i++) {
			int fav = this.isMyFavourites(customerId, ids[i]);
			if(fav==0) {//如果没有收藏则添加收藏
				CustomerHouse house = new CustomerHouse();
				house.setCustomerId(customerId);
				house.setProductId(ids[i]);
				chd.insert(house);
			}
		}
	}
	@Transactional(rollbackFor=Exception.class)
	@Override
	public void deleteBatch(String ids, Integer customerId) throws Exception{
		String[] id = ids.split(",");
		for(int i=0;i<id.length;i++) {
			chd.deleteFavourites(id[i], customerId);
		}
	}

	@Override
	public List<CustomerHouse> findByPage(Integer customerId, Integer firstResult, Integer pageSize) {
		List<CustomerHouse> houseList = Collections.emptyList();
		try {
			houseList = chd.findByPage(customerId, firstResult, pageSize);
		} catch (Exception e) {
			logger.error("分页查询异常！",e);
		}
		return houseList;
	}

	@Override
	public Integer countTotal(Integer customerId) {
		try {
			return chd.countTotal(customerId);
		} catch (Exception e) {
			logger.error("统计总数量异常！",e);
			return 0;
		}
	}

	@Override
	public boolean deleteByProductId(String proId, Integer customerId) {
		try {
			chd.deleteByProductId(proId, customerId);
			return true;
		} catch (Exception e) {
			logger.error("取消指定商品收藏异常！",e);
			return false;
		}
	}

}
