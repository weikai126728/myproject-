package com.abbot.schimneylife.serviceImpl.shopping;

import java.util.Collections;
import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.abbot.schimneylife.dao.shopping.IMallProductAlibabaDao;
import com.abbot.schimneylife.dao.shopping.IMallProductParameterDao;
import com.abbot.schimneylife.pojo.shopping.MallProductParameter;
import com.abbot.schimneylife.service.shopping.MallProductParameterService;

@Service
public class MallProductParameterServiceImpl implements MallProductParameterService {
	private static final Logger logger = Logger.getLogger(MallProductParameterServiceImpl.class);
	
	@Resource
	private IMallProductParameterDao paramDao;
	@Resource
	private IMallProductAlibabaDao aliDao;
	@Override
	public boolean addParameter(MallProductParameter param) {
		try {
			paramDao.insert(param);
			return true;
		} catch (Exception e) {
			logger.error("添加产品参数异常！",e);
			return false;
		}
	}
	@Override
	public MallProductParameter fetchLowerByProId(String proId) {
		try {
			return paramDao.fetchLowerPriceByProId(proId);
		} catch (Exception e) {
			logger.error("查找最低现价参数异常！",e);
			return new MallProductParameter();
		}
	}
	@Override
	public List<String> getSpecByProId(String proId) {
		List<String> specList = Collections.emptyList();
		try {
			specList = paramDao.groupBySecondParam(proId);
		} catch (Exception e) {
			logger.error("获取指定商品的规格列表异常！",e);
		}
		return specList;
	}
	@Override
	public List<String> getTasteByProId(String proId) {
		List<String> tasteList = Collections.emptyList();
		try {
			tasteList = paramDao.groupByFirstParam(proId);
		} catch (Exception e) {
			logger.error("获取指定商品的口味列表异常！",e);
		}
		return tasteList;
	}
	@Override
	public List<MallProductParameter> findByProductId(String productId) {
		List<MallProductParameter> params = Collections.emptyList();
		try {
			params = paramDao.findByProductId(productId);
		} catch (Exception e) {
			logger.error("查找指定商品的所有参数异常！",e);
		}
		return params;
	}
	@Transactional(rollbackFor=Exception.class)
	@Override
	public void deleteById(String id) throws Exception {
		paramDao.deleteById(id);
		aliDao.delete(id);
	}
	@Override
	public MallProductParameter fetchById(String id) {
		try {
			return paramDao.fetchById(id);
		}catch (Exception e) {
			logger.error("根据ID查找商品异常", e);
			return null;
		}
	}

}
