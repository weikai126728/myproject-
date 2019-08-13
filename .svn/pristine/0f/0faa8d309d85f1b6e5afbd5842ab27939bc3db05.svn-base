package com.abbot.schimneylife.serviceImpl.fenxiao;

import java.util.Collections;
import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.abbot.schimneylife.dao.fenxiao.IOrderDistributionDao;
import com.abbot.schimneylife.pojo.fenxiao.OrdersDistribution;
import com.abbot.schimneylife.pojo.fenxiao.ProductDistribution;
import com.abbot.schimneylife.service.fenxiao.OrdersDistributionService;

@Service
public class OrdersDistributionServiceImpl implements OrdersDistributionService {

	private static final Logger logger = Logger.getLogger(OrdersDistributionServiceImpl.class);

	@Resource
	private	IOrderDistributionDao orderDao;
	
	@Override
	public boolean deleteById(Integer orderId) {
		try {
			orderDao.deleteById(orderId);
			return true;
		}catch (Exception e) {
			logger.error("分销订单删除失败", e);
			return false;
		}
	}

	@Override
	public List<OrdersDistribution> selectOrder() {
		try {
		return	orderDao.selectOrder();
		}catch (Exception e) {
			logger.error("分销订单查询失败", e);
			return null;
		}
	}

	@Override
	public List<OrdersDistribution> selectOrderBy(String name) {
		try {
			return	orderDao.selectOrderBy(name);
			}catch (Exception e) {
				logger.error("分销订单查询失败", e);
				return null;
			}
	}

	@Override
	public Integer totalCount() {
		try {
			return orderDao.totalCount();
		} catch (Exception e) {
			logger.error("分销订单数量异常", e);
			return 0;
		}
	}

	@Override
	public List<OrdersDistribution> findByPageAndType(String order, String sort, 
			Integer firstResult, Integer pageSize) {
		List<OrdersDistribution> orderList = Collections.emptyList();
		try {
			orderList = orderDao.findByPageAndType(order, sort,  firstResult, pageSize);
		} catch (Exception e) {
			logger.error("根据分类分页查询订单异常！", e);
		}
		return orderList;
	}
 
}
