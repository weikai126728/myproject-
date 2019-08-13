package com.abbot.schimneylife.serviceImpl.shopping;

import java.util.Collections;
import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.abbot.schimneylife.dao.shopping.ISupermarketActivityDao;
import com.abbot.schimneylife.pojo.shopping.SupermarketActivity;
import com.abbot.schimneylife.service.shopping.SupermarketActivityService;

@Service
public class SupermarketActivityServiceImpl implements SupermarketActivityService {

	private static final Logger logger = Logger.getLogger(SupermarketActivityServiceImpl.class);
	
	@Resource
	private ISupermarketActivityDao activityDao;
	@Override
	public List<SupermarketActivity> findActivityByMarketId(Integer supermarketId) {
		List<SupermarketActivity> activityList = Collections.emptyList();
		try {
			activityList = activityDao.findActivityByMarketId(supermarketId);
		} catch (Exception e) {
			logger.error("查找指定超市的活动列表异常！",e);
		}
		return activityList;
	}

	@Override
	public boolean insert(SupermarketActivity activity) {
		boolean res = false;
			try {
				activityDao.insert(activity);
				res = true;
			} catch (Exception e) {
				logger.error("",e);
			}
			return res;
	}
	@Override
	public boolean update(SupermarketActivity activity){
		boolean res = false;
			try {
				activityDao.update(activity);
				res = true;
			} catch (Exception e) {
				logger.error("",e);
			}
			return res;
	}

	@Override
	public boolean delete(String id){
		boolean res = false;
		try {
			activityDao.delete(id);
			res = true;
		} catch (Exception e) {
			logger.error("",e);
		}
		return res;
	}

}
