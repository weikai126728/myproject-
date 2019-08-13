package com.abbot.schimneylife.serviceImpl.weixin;

import java.util.Collections;
import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.abbot.schimneylife.dao.weixin.IMembersDao;
import com.abbot.schimneylife.pojo.weixin.Alliance;
import com.abbot.schimneylife.pojo.weixin.Mcars;
import com.abbot.schimneylife.service.weixin.MembersService;
@Service
public class MembersServiceImp implements MembersService{
	private static final Logger logger = Logger.getLogger(MembersServiceImp.class);
	@Resource
	private IMembersDao mlDao;
	@Override
	public List<Alliance> findByPage(Integer firstResult, Integer pageSize, String like, String column, String sort,String createTime) {
		List<Alliance> list = Collections.emptyList();
		try {
			list = mlDao.findByPage(firstResult, pageSize, like, column, sort,createTime);
		} catch (Exception e) {
			logger.error(e);
		}
		return list;
	}
	@Override
	public List<Mcars> findByalopenid(Integer firstResult, Integer pageSize,String search, String alopenid) {
		List<Mcars> list = Collections.emptyList();
		try {
			list = mlDao.findByalopenid(firstResult, pageSize, search,alopenid);
		} catch (Exception e) {
			logger.error(e);
		}
		return list;
	}
	@Override
	public Integer countTotal(String like, String startTime, String endTime, String alopenid) {
		try {
			return	mlDao.countTotal(like, alopenid);
		} catch (Exception e) {
			logger.error(e);
		}
		return 0;
	}
}
