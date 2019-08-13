package com.abbot.schimneylife.serviceImpl.weixin;

import java.util.Collections;
import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.abbot.schimneylife.dao.weixin.IOrdermerRedpackDao;
import com.abbot.schimneylife.pojo.weixin.OrdermerRedpack;
import com.abbot.schimneylife.service.weixin.OrdermerRedpackService;
@Service
public class OrdermerRedpackServiceImpl implements OrdermerRedpackService {
	private static final Logger logger = Logger.getLogger(OrdermerRedpackServiceImpl.class);
	
	@Resource
	private IOrdermerRedpackDao redDao;
	@Override
	public List<OrdermerRedpack> findByPage(Integer firstResult, Integer pageSize, String like, String column,
			String sort, String startTime, String endTime) {
		List<OrdermerRedpack> list = Collections.emptyList();
		try {
			list = redDao.findByPage(firstResult, pageSize, like, column, sort, startTime, endTime);
		} catch (Exception e) {
			logger.error(e);
		}
		return list;
	}

	@Override
	public Integer countTotal(String like, String startTime, String endTime) {
		Integer total = 0;
		try {
			total = redDao.countTotal(like, startTime, endTime);
		} catch (Exception e) {
			logger.error(e);
		}
		return total;
	}

	@Override
	public Integer countRedpack(String like, String startTime, String endTime) {
		Integer total = 0;
		try {
			total = redDao.countRedpack(like, startTime, endTime);
		} catch (Exception e) {
			logger.error(e);
		}
		return total;
	}

}
