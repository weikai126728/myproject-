package com.abbot.schimneylife.serviceImpl.shopping;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.abbot.schimneylife.dao.shopping.IMallProductAlibabaDao;
import com.abbot.schimneylife.pojo.shopping.MallProductAlibaba;
import com.abbot.schimneylife.service.shopping.MallProductAlibabaService;
@Service
public class MallProductAlibabaServiceImpl implements MallProductAlibabaService {

	private static final Logger logger = Logger.getLogger(MallProductAlibabaServiceImpl.class);
	
	@Resource
	private IMallProductAlibabaDao aliDao;
	@Override
	public MallProductAlibaba fetchByParamId(String paramId) {
		try {
			return aliDao.fetchByParamId(paramId);
		} catch (Exception e) {
			logger.error("根据paramid查找数据",e);
			return new MallProductAlibaba();
		}
	}

}
