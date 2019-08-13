package com.abbot.schimneylife.serviceImpl.shopping;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.abbot.schimneylife.dao.shopping.ICustomerFootmarkDao;
import com.abbot.schimneylife.pojo.shopping.CustomerFootmark;
import com.abbot.schimneylife.service.shopping.CustomerFootmarkService;

@Service
public class CustomerFootmarkServiceImpl implements CustomerFootmarkService {
	private static final Logger logger = Logger.getLogger(CustomerFootmarkServiceImpl.class);
	
	@Resource
	private ICustomerFootmarkDao markDao;
	@Override
	public boolean addMark(CustomerFootmark mark) {
		try {
			markDao.insert(mark);
			return true;
		} catch (Exception e) {
			logger.error("新增足迹异常！",e);
			return false;
		}
	}

	@Override
	public boolean delete(Integer customerId, Integer days) {
		try {
			markDao.deleteBeforeDays(customerId, days);
			return true;
		} catch (Exception e) {
			logger.error("删除指定天数前的记录异常！",e);
			return false;
		}
	}

	@Override
	public List<CustomerFootmark> findByPage(Integer firstResult, Integer pageSize, Integer customerId) {
		List<CustomerFootmark> footmarks = Collections.emptyList();
		try {
			footmarks = markDao.findByPage(firstResult, pageSize, customerId);
		} catch (Exception e) {
			logger.error("分页查询异常！",e);
		}
		return footmarks;
	}

	@Override
	public boolean deleteByIds(String ids, Integer customerId) {
		Map<String,Object> map = new HashMap<>();
		map.put("customerId", customerId);
		map.put("ids", ids.split(","));
		try {
			markDao.deleteByIds(map);
			return true;
		} catch (Exception e) {
			logger.error("批量删除异常！",e);
			return false;
		}
	}

	@Override
	public boolean isNeedMark(Integer customerId, String productId) {
		try {
			Integer num = markDao.fetchNumToday(customerId, productId);
			return num==0?true:false;
		} catch (Exception e) {
			logger.error("是否需要记录异常！",e);
			return true;
		}
	}

	@Override
	public Integer countTotal(Integer customerId) {
		try {
			return markDao.countTotal(customerId);
		} catch (Exception e) {
			logger.error("查询总数量异常！",e);
			return 0;
		}
	}

	@Override
	public List<CustomerFootmark> findByDate(Integer customerId, String date) {
		List<CustomerFootmark> markList = Collections.emptyList();
		try {
			markList = markDao.findByDate(customerId, date);
		} catch (Exception e) {
			logger.error("根据日期查找足迹异常！",e);
		}
		return markList;
	}

	@Override
	public Integer countByDate(Integer customerId, String date) {
		try {
			return markDao.countByDate(customerId, date);
		} catch (Exception e) {
			logger.error("根据日期统计数量异常！",e);
			return 0;
		}
	}

}
