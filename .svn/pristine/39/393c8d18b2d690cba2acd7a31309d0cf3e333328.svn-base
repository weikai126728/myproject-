package com.abbot.schimneylife.serviceImpl.weixin;

import java.util.Collections;
import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.abbot.schimneylife.dao.weixin.AllianceSwitchDao;
import com.abbot.schimneylife.dao.weixin.FashionableDao;
import com.abbot.schimneylife.pojo.weixin.Receivers;
import com.abbot.schimneylife.pojo.weixin.TsSwitch;
import com.abbot.schimneylife.service.weixin.FashionableService;
@Service
public class FashionableServiceImpl implements FashionableService {
	private static final Logger logger = Logger.getLogger(FashionableServiceImpl.class);
	@Resource
	private FashionableDao fDao;
	@Override
	public List<Receivers> findfashionableByPage(Integer firstResult, Integer pageSize, String like, String column,
			String sort, String startTime, String endTime) {
		List<Receivers> list = Collections.emptyList();
		try {
			list = fDao.findByPage(firstResult, pageSize, like, column, sort, startTime, endTime);
		} catch (Exception e) {
			logger.error(e);
		}
		return list;
	}
	@Override
	public Integer countTotal(String like, String startTime, String endTime) {
		Integer total = 0;
		try {
			total = fDao.countTotal(like, startTime, endTime);
		} catch (Exception e) {
			logger.error(e);
		}
		return total;
	}
	@Override
	public Receivers findfashionable(Integer id) {
		try {
			return fDao.findfashionable(id);
		} catch (Exception e) {
			logger.error(e);
		}
		return null;
	}
	@Override
	public boolean updatefindfashionable(Receivers receivers) {
		try {
			fDao.updatefindfashionable(receivers);
			return true;
		} catch (Exception e) {
			logger.error(e);
		}
		return false;
	}
	@Override
	public boolean deletfashionable(Integer id) {
		try {
			fDao.deletfashionable(id);
			return true;
		} catch (Exception e) {
			logger.error(e);
		}
		return false;
	}
	@Override
	public boolean addfindfashionable(Receivers receivers) {
		try {
			fDao.addfindfashionable(receivers);
			return true;
		} catch (Exception e) {
			logger.error(e);
		}
		return false;
	}

}
