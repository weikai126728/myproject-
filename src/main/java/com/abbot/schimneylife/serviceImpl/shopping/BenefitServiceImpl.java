package com.abbot.schimneylife.serviceImpl.shopping;

import java.util.Collections;
import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.abbot.schimneylife.controller.manager.BenefitController;
import com.abbot.schimneylife.dao.shopping.BenefitDao;
import com.abbot.schimneylife.pojo.shopping.MarketProductInfo;
import com.abbot.schimneylife.pojo.shopping.SupermarketInfo;
import com.abbot.schimneylife.service.shopping.BenefitService;
@Service
public class BenefitServiceImpl implements BenefitService {
	private static final Logger logger = Logger.getLogger(BenefitController.class);
	@Resource
	BenefitDao benefitDao;
	@Override
	public List<SupermarketInfo> findCoalition() {
		 List<SupermarketInfo> list=Collections.emptyList();
		 try {
			 list=benefitDao.findCoalition();
		} catch (Exception e) {
			logger.info("查询所有联盟", e);
		}
		return list;
	}
	@Override
	public boolean disable(Integer marketId) {
		try {
			benefitDao.disable(marketId);
			return true;
		} catch (Exception e) {
			logger.info("关闭联盟", e);
		}
		return false;
	}
	@Override
	public boolean enable(Integer marketId) {
		try {
			benefitDao.enable(marketId);
			return true;
		} catch (Exception e) {
			logger.info("打开联盟", e);
		}
		return false;
	}
	@Override
	public List<MarketProductInfo> findAllBenefit() {
		 List<MarketProductInfo> list=Collections.emptyList();
		 try {
			 list=benefitDao.findAllBenefit();
		} catch (Exception e) {
			logger.info("查询所有子联盟", e);
		}
		return list;
	}
	@Override
	public boolean benefitstop(Integer marketId) {
		try {
			benefitDao.benefitstop(marketId);
			return true;
		} catch (Exception e) {
			logger.info("关闭联盟", e);
		}
		return false;
	}
	@Override
	public boolean benefitstart(Integer marketId) {
		try {
			benefitDao.benefitstart(marketId);
			return true;
		} catch (Exception e) {
			logger.info("关闭联盟", e);
		}
		return false;
	}
	@Override
	public void addProduct(SupermarketInfo product) {
		try {
			benefitDao.addProduct(product);
		} catch (Exception e) {
			logger.info("创建联盟", e);
		}
	}
	@Override
	public SupermarketInfo fetchById(Integer marketId) {
		try {
			return	benefitDao.fetchById(marketId);
		} catch (Exception e) {
			logger.info("创建联盟", e);
		}
		return null;
	}
	@Override
	public void updateProduct(SupermarketInfo product) {
		try {
			benefitDao.updateProduct(product);
		} catch (Exception e) {
			logger.info("创建联盟", e);
		}
		
	}
	@Override
	public void addBenefit(MarketProductInfo product) {
		try {
			benefitDao.addBenefit(product);
		} catch (Exception e) {
			logger.info("创建子联盟", e);
		}
		
	}
	@Override
	public MarketProductInfo findBenefitByid(Integer marketId) {
		try {
			return benefitDao.findBenefitByid(marketId);
		} catch (Exception e) {
			logger.info("创建子联盟", e);
		}
		return null;
	}
	@Override
	public void updateBenefit(MarketProductInfo product) {
		try {
			benefitDao.updateBenefit(product);
		} catch (Exception e) {
			logger.info("创建子联盟", e);
		}
		
	}
	@Override
	public boolean deletebit(Integer marketId) {
		try {
			benefitDao.deletebit(marketId);
			return true;
		} catch (Exception e) {
			logger.info("关闭联盟", e);
		}
		return false;
	}
	@Override
	public boolean deletecon(Integer marketId) {
		try {
			benefitDao.deletecon(marketId);
			return true;
		} catch (Exception e) {
			logger.info("关闭联盟", e);
		}
		return false;
	}
	
	
}
