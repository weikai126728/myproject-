package com.abbot.schimneylife.serviceImpl.shopping;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.abbot.schimneylife.dao.shopping.ILogisticsDao;
import com.abbot.schimneylife.pojo.shopping.Logistics;
import com.abbot.schimneylife.service.shopping.LogisticsService;

@Service
public class LogisticsServiceImpl implements LogisticsService {

	private static final Logger logger = Logger.getLogger(CustomerOrderWarnServiceImpl.class);
	
	@Resource
	ILogisticsDao logDao;
	
	@Override
	public Integer add(Logistics log) {
		try {
			return	logDao.add(log);
		}catch (Exception e) {
			logger.error("新增物流表单异常", e);
			return 0;
		}

	}

	@Override
	public Logistics queryLogById(String serviceId) {
		try {
			return	logDao.queryLogById(serviceId);
		}catch (Exception e) {
			logger.error("查询物流表单异常", e);
			return null;
		}
	}
	
	

}
