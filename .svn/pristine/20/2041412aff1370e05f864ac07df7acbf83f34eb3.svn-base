package com.abbot.schimneylife.serviceImpl.shopping;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.abbot.schimneylife.controller.manager.HouseController;
import com.abbot.schimneylife.dao.shopping.HouseDao;
import com.abbot.schimneylife.pojo.shopping.HouseInfo;
import com.abbot.schimneylife.service.shopping.HouseSerivce;
@Service
public class HouseSerivceImpl implements HouseSerivce {
	private static final Logger logger = Logger.getLogger(HouseSerivceImpl.class);
	@Resource
	HouseDao houseDao;
	@Override
	public void addHosue(HouseInfo product) {
		try {
			houseDao.addHosue(product);
		} catch (Exception e) {
			logger.info("添加房产信息", e);
		}

	}

}
