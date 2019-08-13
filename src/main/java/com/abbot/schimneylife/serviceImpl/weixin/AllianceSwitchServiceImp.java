package com.abbot.schimneylife.serviceImpl.weixin;

import java.util.Collections;
import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.abbot.schimneylife.dao.weixin.AllianceSwitchDao;
import com.abbot.schimneylife.pojo.weixin.TsSwitch;
import com.abbot.schimneylife.service.weixin.AllianceSwitchService;

@Service
public class AllianceSwitchServiceImp implements AllianceSwitchService {
	private static final Logger logger = Logger.getLogger(AllianceSwitchServiceImp.class);
	@Resource
	private AllianceSwitchDao switchDao;
	@Override
	public List<TsSwitch> findByPage(Integer firstResult, Integer pageSize, String like, String column, String sort,
			String startTime, String endTime, Integer salesmanId){
		List<TsSwitch> list = Collections.emptyList();
		try {
			list = switchDao.findByPage(firstResult, pageSize, like, column, sort, startTime, endTime,salesmanId);
		} catch (Exception e) {
			logger.error(e);
		}
		return list;
	}
	@Override
	public Integer countTotal(String like, String startTime, String endTime, Integer salesmanId) {
		Integer total = 0;
		try {
			total = switchDao.countTotal(like, startTime, endTime,salesmanId);
		} catch (Exception e) {
			logger.error(e);
		}
		return total;
	}
	@Override
	public boolean disable(Integer id) {
		try {
			switchDao.disable(id);
			return true;
		} catch (Exception e) {
			logger.error("禁用异常", e);
			return false;
		}
	}
	@Override
	public boolean enable(Integer id) {
		try {
			switchDao.enable(id);
			return true;
		} catch (Exception e) {
			logger.error("启用异常", e);
			return false;
		}
	}
}
