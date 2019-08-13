package com.abbot.schimneylife.serviceImpl.fenxiao;

import java.util.Collections;
import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.abbot.schimneylife.dao.fenxiao.IProductDistributionDao;
import com.abbot.schimneylife.pojo.fenxiao.ProductDistribution;
import com.abbot.schimneylife.pojo.shopping.MallProduct;
import com.abbot.schimneylife.service.fenxiao.ProductDistributionService;

@Service
public class ProductDistributionServiceImpl implements ProductDistributionService {

	private static final Logger logger = Logger.getLogger(ProductDistributionServiceImpl.class);

	@Resource
	private IProductDistributionDao proDao;

	@Override
	public List<ProductDistribution> hasmore(Integer proCateId) {
		try {
			return proDao.hasmore(proCateId);
		} catch (Exception e) {
			logger.error("分销商品根据一级分类查询二级分类异常", e);
			return null;
		}
	}

	@Override
	public Integer totalCount() {
		try {
			return proDao.totalCount();
		} catch (Exception e) {
			logger.error("分销商品数量查询异常", e);
			return 0;
		}
	}

	@Override
	public List<ProductDistribution> findByPageAndType(String like, String order, String sort, String typeId,
			Integer firstResult, Integer pageSize) {
		List<ProductDistribution> productList = Collections.emptyList();
		try {
			productList = proDao.findByPageAndType(like, order, sort, typeId, firstResult, pageSize);
		} catch (Exception e) {
			logger.error("根据分类分页查询商品异常！", e);
		}
		return productList;
	}

	@Override
	public Integer countByType(String like, String typeId) {
		try {
			return proDao.countByType(like, typeId);
		} catch (Exception e) {
			logger.error("根据分类统计数量", e);
			return 0;
		}
	}

	@Override
	public boolean delete(Integer proId) {
		try {
			proDao.delete(proId);
			return true;
		}catch (Exception e) {
			logger.error("分销商品删除", e);
			return false;
		}
	}

	@Override
	public boolean upload(ProductDistribution pro) {
		boolean bool=false;
		try {
				if(proDao.upload(pro)==1) {					
					bool= true;
				}
		}catch (Exception e) {
				logger.error("分销添加商品异常", e);
		}
		return bool;
	}

	@Override
	public ProductDistribution toEdit(Integer proId) {
		try {
			return proDao.toEdit(proId);
		}catch (Exception e) {
			logger.error("分销商品修改单查", e);
			return null;
		}
	}

	@Override
	public boolean update(ProductDistribution pro) {
		boolean bool=false;
		try {
				if(proDao.update(pro)==1) {					
					bool= true;
				}
		}catch (Exception e) {
				logger.error("分销添加商品异常", e);
		}
		return bool;
	}

}
