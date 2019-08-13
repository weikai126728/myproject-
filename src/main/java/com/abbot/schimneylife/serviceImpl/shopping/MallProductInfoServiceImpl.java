package com.abbot.schimneylife.serviceImpl.shopping;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.abbot.schimneylife.dao.shopping.IMallProductInfoDao;
import com.abbot.schimneylife.pojo.shopping.MallProductInfo;
import com.abbot.schimneylife.service.shopping.MallProductInfoService;
@Service
public class MallProductInfoServiceImpl implements MallProductInfoService {
	private static final Logger logger = Logger.getLogger(MallProductServiceImpl.class);
	
	@Resource
	private IMallProductInfoDao proInfoDao;
	@Override
	public boolean add(MallProductInfo proInfo) {
		try {
			proInfoDao.insert(proInfo);
			return true;
		} catch (Exception e) {
			logger.error("添加商品信息详情图片异常！",e);
			return false;
		}
	}
	@Override
	public MallProductInfo fetchByProId(String proId) {
		
		try {
			return proInfoDao.fetchByProId(proId);
		} catch (Exception e) {
			logger.error("查找制定商品的详情图片异常！",e);
			return new MallProductInfo();
		}
	}

}
