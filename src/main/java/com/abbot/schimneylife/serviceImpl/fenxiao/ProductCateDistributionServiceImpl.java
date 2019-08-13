package com.abbot.schimneylife.serviceImpl.fenxiao;

import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.abbot.schimneylife.dao.fenxiao.IProductCateDistributionDao;
import com.abbot.schimneylife.pojo.fenxiao.ProductCateDistribution;
import com.abbot.schimneylife.service.fenxiao.ProductCateDistributionService;

@Service
public class ProductCateDistributionServiceImpl implements ProductCateDistributionService {

	private static final Logger logger = Logger.getLogger(ProductCateDistributionServiceImpl.class);

	@Resource
	private IProductCateDistributionDao proCateDao;

	@Override
	public List<ProductCateDistribution> selectProCate() {
		try {
			return proCateDao.selectProCate();
		} catch (Exception e) {
			logger.error("分销分类查询异常", e);
			return null;
		}

	}

	@Override
	public ProductCateDistribution fetchById(Integer id) {
		try {
			return proCateDao.fetchById(id);
		} catch (Exception e) {
			logger.error("分销单品查询", e);
			return null;
		}
	}

	@Override
	public boolean addPro(ProductCateDistribution pro) {
		try {
			proCateDao.addPro(pro);
			return true;
		} catch (Exception e) {
			logger.error("分销商品新增异常", e);
			return false;
		}

	}

	@Override
	public boolean delete(Integer id) {
		try {
			proCateDao.delete(id);
			return true;
		} catch (Exception e) {
			logger.error("分销商品删除异常", e);
			return false;
		}
	}

	@Override
	public boolean updatePro(String name, Integer id) {
		boolean bool=false;
		try {
			if(proCateDao.updatePro(id,name)==1) {				
				bool=true;
			}
		}catch (Exception e) {
			logger.error("分销商品修改异常", e);
		}
		return bool;
	}

}
