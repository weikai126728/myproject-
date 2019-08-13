package com.abbot.schimneylife.serviceImpl.shopping;

import java.util.Collections;
import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.abbot.schimneylife.dao.shopping.IYingLiOrderDao;
import com.abbot.schimneylife.pojo.shopping.YingLiOrder;
import com.abbot.schimneylife.service.shopping.YingLiOrderService;
@Service
public class YingLiOrderServiceImpl implements YingLiOrderService {

	private static final Logger logger = Logger.getLogger(YingLiOrderServiceImpl.class);
	
	@Resource
	private IYingLiOrderDao orderDao;
	@Override
	public boolean insert(YingLiOrder order) {
		boolean res = false;
		try {
			orderDao.insert(order);
			res = true;
		} catch (Exception e) {
			logger.error("插入英利订单",e);
		}
		return res;
	}

	@Override
	public List<YingLiOrder> findByPage(Integer firstResult, Integer pageSize, String like, String startTime,
			String endTime) {
		List<YingLiOrder> orders = Collections.emptyList();
		try {
			orders = orderDao.findByPage(firstResult, pageSize, like, startTime, endTime);
		} catch (Exception e) {
			logger.error("根据条件分页查询英利订单",e);
		}
		return orders;
	}

	@Override
	public Integer countTotal(String like, String startTime, String endTime) {
		Integer total = 0;
		try {
			total = orderDao.countTotal(like, startTime, endTime);
		} catch (Exception e) {
			logger.error("根据条件统计英利订单数量",e);
		}
		return total;
	}

	@Override
	public boolean updateStatus(String id, Integer status) {
		boolean res = false;
		try {
			orderDao.updateStatus(status, id);
			res = true;
		} catch (Exception e) {
			logger.error("修改订单交易状态",e);
		}
		return res;
	}

}
