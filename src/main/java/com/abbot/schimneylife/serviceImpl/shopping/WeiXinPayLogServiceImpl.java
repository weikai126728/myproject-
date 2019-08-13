package com.abbot.schimneylife.serviceImpl.shopping;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.abbot.schimneylife.dao.shopping.IWeiXinPayLogDao;
import com.abbot.schimneylife.pojo.shopping.WeiXinPayLog;
import com.abbot.schimneylife.service.shopping.WeiXinPayLogService;
@Service
public class WeiXinPayLogServiceImpl implements WeiXinPayLogService {
	private static final Logger logger = Logger.getLogger(WeiXinPayLogServiceImpl.class);
	
	@Resource
	private IWeiXinPayLogDao logDao; 
	@Override
	public boolean insert(WeiXinPayLog log) {
		boolean res = false;
		try {
			logDao.insert(log);
			res = true;
		} catch (Exception e) {
			logger.error("新增微信支付结果通知异常",e);
		}
		return res;
	}
	@Override
	public WeiXinPayLog fetchByOrderId(String orderId, Integer type) {
		try {
			return logDao.fetchByOrderId(orderId, type);
		} catch (Exception e) {
			logger.error("根据订单id和类型查找",e);
		}
		return null;
	}

}
