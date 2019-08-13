package com.abbot.schimneylife.serviceImpl.shopping;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.abbot.schimneylife.dao.shopping.ILogisticsInfoDao;
import com.abbot.schimneylife.pojo.shopping.LogisticsInfo;
import com.abbot.schimneylife.service.shopping.LogisticsInfoService;
@Service
public class LogisticsInfoServiceImpl implements LogisticsInfoService {

	private static final Logger logger = Logger.getLogger(LogisticsInfoServiceImpl.class);
	
	@Resource
	private ILogisticsInfoDao logisticsDao;
	@Override
	public boolean insert(String company, String waybill, String logisticsNo, String customerOrderId) {
		boolean res = false;
		try {
			logisticsDao.insert(company, waybill, logisticsNo, customerOrderId);
			res = true;
		} catch (Exception e) {
			logger.error("新建物流信息异常",e);
		}
		return res;
	}

	@Override
	public boolean update(String id, String company, String waybill, String logisticsNo) {
		boolean res = false;
		try {
			logisticsDao.update(id, company, waybill, logisticsNo);
			res = true;
		} catch (Exception e) {
			logger.error("修改物流信息异常",e);
		}
		return res;
	}

	@Override
	public LogisticsInfo fetchByOrderId(String orderId) {
		try {
			return logisticsDao.fetchByOrderId(orderId);
		} catch (Exception e) {
			logger.error("根据订单id查询物流信息异常！",e);
		}
		return null;
	}

}
