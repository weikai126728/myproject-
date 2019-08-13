package com.abbot.schimneylife.serviceImpl.shopping;

import java.util.Collections;
import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.abbot.schimneylife.dao.shopping.IMallProductBannerDao;
import com.abbot.schimneylife.pojo.shopping.MallProductBanner;
import com.abbot.schimneylife.service.shopping.MallProductBannerService;
@Service
public class MallProductBannerServiceImpl implements MallProductBannerService {

	private static final Logger logger = Logger.getLogger(MallProductBannerServiceImpl.class);
	
	@Resource
	private IMallProductBannerDao bannerDao;
	@Override
	public List<MallProductBanner> findByProId(String proId) {
		List<MallProductBanner> bannerList = Collections.emptyList();
		try {
			bannerList = bannerDao.findByProId(proId);
		} catch (Exception e) {
			logger.error("查找指定商品的轮播图异常！",e);
		}
		return bannerList;
	}

}
