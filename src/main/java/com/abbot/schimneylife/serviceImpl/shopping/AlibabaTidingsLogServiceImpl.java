package com.abbot.schimneylife.serviceImpl.shopping;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.abbot.schimneylife.dao.shopping.IAlibabaTidingsLogDao;
import com.abbot.schimneylife.pojo.shopping.AlibabaTidingsLog;
import com.abbot.schimneylife.service.shopping.AlibabaTidingsLogService;
@Service
public class AlibabaTidingsLogServiceImpl implements AlibabaTidingsLogService {

	private static final Logger logger = Logger.getLogger(AlibabaTidingsLogServiceImpl.class);
	
	@Resource
	private IAlibabaTidingsLogDao logDao;
	@Override
	public boolean insert(AlibabaTidingsLog log) {
		try {
			logDao.insert(log);
			return true;
		} catch (Exception e) {
			logger.error("新增消息订阅日志",e);
			return false;
		}
	}

}
