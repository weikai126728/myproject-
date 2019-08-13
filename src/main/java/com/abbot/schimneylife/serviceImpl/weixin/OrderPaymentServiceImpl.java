package com.abbot.schimneylife.serviceImpl.weixin;

import java.util.Collections;
import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.abbot.schimneylife.dao.weixin.IOrderPaymentDao;
import com.abbot.schimneylife.pojo.weixin.OrderPayment;
import com.abbot.schimneylife.service.weixin.OrderPaymentService;
@Service
public class OrderPaymentServiceImpl implements OrderPaymentService {

	private static final Logger logger = Logger.getLogger(OrderPaymentServiceImpl.class);
	
	@Resource
	private IOrderPaymentDao orderDao;
	
	@Override
	public List<OrderPayment> findByPage(Integer firstResult, Integer pageSize, String column, String sort,
			Integer userId, String startTime, String endTime,String openId,String search){
		List<OrderPayment> list = Collections.emptyList();
		try {
			list = orderDao.findByPage(firstResult, pageSize, userId, startTime, endTime, column, sort,openId,search);
		} catch (Exception e) {
			logger.error(e);
		}
		return list;
	}

	@Override
	public Integer countTotal(Integer userId, String startTime, String endTime,String openId,String search){
		Integer total = 0;
		try {
			total = orderDao.countTotal(userId, startTime, endTime,openId,search);
		} catch (Exception e) {
			logger.error(e);
		}
		return total;
	}

	@Override
	public Integer countTrade(Integer userId, String startTime, String endTime, String openId,String search) {
		Integer total = 0;
		try {
			total = orderDao.countTrade(userId, startTime, endTime,openId,search);
		} catch (Exception e) {
			logger.error(e);
		}
		return total;
	}

}
