package com.abbot.schimneylife.serviceImpl.user;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.abbot.schimneylife.dao.user.IUserOperationLogDao;
import com.abbot.schimneylife.service.user.UserOperationLogService;
@Service
public class UserOperationLogServiceImpl implements UserOperationLogService {

	private static final Logger logger = Logger.getLogger(UserOperationLogServiceImpl.class);
	
	@Resource
	private IUserOperationLogDao logDao;
	@Override
	public boolean insert(Integer userId, String msg, Integer type, String targetId, String targetName) {
		try {
			logDao.insert(userId, msg, type, targetId, targetName);
			return true;
		} catch (Exception e) {
			logger.error("添加用户操作日志",e);
		}
		return false;
	}

}
