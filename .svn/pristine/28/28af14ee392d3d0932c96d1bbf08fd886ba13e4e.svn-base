package com.abbot.schimneylife.serviceImpl.shopping;

import java.util.Collections;
import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.abbot.schimneylife.dao.shopping.IMallHomeBannerDao;
import com.abbot.schimneylife.pojo.shopping.MallHomeBanner;
import com.abbot.schimneylife.service.shopping.MallHomeBannerService;
@Service
public class MallHomeBannerServiceImpl implements MallHomeBannerService {
	private static final Logger logger = Logger.getLogger(MallHomeBannerServiceImpl.class);
	
	@Resource
	private IMallHomeBannerDao bannerDao;
	
	@Override
	public boolean updateImage(String id, String images) {
		boolean res = false;
		try {
			bannerDao.updateImage(id, images);
			res = true;
		} catch (Exception e) {
			logger.error("",e);
		}
		return res;
	}

	@Override
	public MallHomeBanner fetchById(String id) {
		try {
			return bannerDao.fetchById(id);
		} catch (Exception e) {
			logger.error("",e);
			return null;
		}
	}

	@Override
	public boolean updatePath(String id, String path) {
		boolean res = false;
		try {
			bannerDao.updatePath(id, path);
			res = true;
		} catch (Exception e) {
			logger.error("",e);
		}
		return res;
	}

	@Override
	public boolean delete(String id) {
		boolean res =false;
		try {
			bannerDao.delete(id);
			res = true;
		} catch (Exception e) {
			logger.error("",e);
		}
		return res;
	}

	@Override
	public List<MallHomeBanner> findByType(Integer type) {
		List<MallHomeBanner> banners = Collections.emptyList();
		try {
			banners = bannerDao.findByType(type);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return banners;
	}

	@Override
	public boolean insert(MallHomeBanner banner) {
		boolean res = false;
		try {
			bannerDao.insert(banner);
			res = true;
		} catch (Exception e) {
			logger.error("",e);
		}
		return res;
	}

}
