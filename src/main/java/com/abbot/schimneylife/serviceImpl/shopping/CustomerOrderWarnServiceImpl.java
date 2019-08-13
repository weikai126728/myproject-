package com.abbot.schimneylife.serviceImpl.shopping;

import java.util.Collections;
import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.abbot.schimneylife.dao.shopping.ICustomerOrderWarnDao;
import com.abbot.schimneylife.pojo.shopping.CustomerOrderWarn;
import com.abbot.schimneylife.service.shopping.CustomerOrderWarnService;
@Service
public class CustomerOrderWarnServiceImpl implements CustomerOrderWarnService {

	private static final Logger logger = Logger.getLogger(CustomerOrderWarnServiceImpl.class);
	
	@Resource
	private ICustomerOrderWarnDao warnDao;
	@Override
	public List<CustomerOrderWarn> findByPage(String like, String createTime, String sort, Integer firstResult,
			Integer pageSize) {
		List<CustomerOrderWarn> warnList = Collections.emptyList();
		try {
			warnList = warnDao.findByPage(like, createTime, sort, firstResult, pageSize);
		} catch (Exception e) {
			logger.error("",e);
		}
		return warnList;
	}

	@Override
	public Integer countTotal(String like, String createTime) {
		try {
			return warnDao.countTotal(like, createTime);
		} catch (Exception e) {
			logger.error("",e);
			return 0;
		}
	}

	@Override
	public boolean insert(Integer customerId, String orderId) {
		try {
			warnDao.insert(customerId, orderId);
			return true;
		} catch (Exception e) {
			logger.error("",e);
			return false;
		}
	}

}
