package com.abbot.schimneylife.serviceImpl.shopping;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.abbot.schimneylife.dao.shopping.IMallOrderDao;
import com.abbot.schimneylife.pojo.shopping.MallOrder;
import com.abbot.schimneylife.service.shopping.MallOrderService;

@Service
public class MallOrderServiceImpl implements MallOrderService {
	private static final Logger logger = Logger.getLogger(MallOrderServiceImpl.class);
	
	@Resource
	private IMallOrderDao mallOrderDao;

	@Override
	public boolean addMallOrder(MallOrder order) {
		try {
			mallOrderDao.insert(order);
			return true;
		} catch (Exception e) {
			logger.error("新增在线商城订单异常！",e);
			return false;
		}
	}

	@Override
	public List<MallOrder> findMallOrderList(String customerOrderID) {
		List<MallOrder> mallOrderList = Collections.emptyList();
		try {
			mallOrderList = mallOrderDao.findMallOrderList(customerOrderID);
		} catch (Exception e) {
			logger.error("查找用户订单中在线商城订单列表异常！",e);
		}
		return mallOrderList;
	}

	@Override
	public BigDecimal selectAmount(String id) {
		try {
			return mallOrderDao.selectAmount(id);
		}catch (Exception e) {
			return null;
		}
	}

}
