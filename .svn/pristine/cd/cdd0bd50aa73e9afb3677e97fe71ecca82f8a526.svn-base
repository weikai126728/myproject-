package com.abbot.schimneylife.serviceImpl.shopping;

import java.util.Collections;
import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.abbot.schimneylife.dao.shopping.IMallProductTypeDao;
import com.abbot.schimneylife.pojo.shopping.MallProductType;
import com.abbot.schimneylife.service.shopping.MallProductTypeService;
@Service
public class MallProductTypeServiceImpl implements MallProductTypeService {

	private static final Logger logger = Logger.getLogger(MallProductTypeServiceImpl.class);
	@Resource
	private IMallProductTypeDao typeDao; 
	@Override
	public boolean insert(MallProductType type) {
		try {
			typeDao.insert(type);
			return true;
		} catch (Exception e) {
			logger.error("新增商品分类异常！",e);
			return false;
		}
	}

	@Override
	public boolean update(MallProductType type) {
		try {
			typeDao.update(type);
			return true;
		} catch (Exception e) {
			logger.error("修改分类信息异常！",e);
			return false;
		}
	}

	@Override
	public List<MallProductType> firstType() {
		List<MallProductType> typeList = Collections.emptyList();
		try {
			typeList = typeDao.firstType();
		} catch (Exception e) {
			logger.error("查找一级分类异常！",e);
		}
		return typeList;
	}

	@Override
	public List<MallProductType> childType(String pid) {
		List<MallProductType> typeList = Collections.emptyList();
		try {
			typeList = typeDao.childType(pid);
		} catch (Exception e) {
			logger.error("查找子类异常！",e);
		}
		return typeList;
	}

	@Override
	public MallProductType fetchById(Integer id) {
		try {
			return typeDao.fetchById(id);
		} catch (Exception e) {
			logger.error("根据id查找分类信息异常！",e);
			return new MallProductType();
		}
	}

	@Override
	public Integer products(String id) {
		try {
			return typeDao.countProByTypeId(id);
		} catch (Exception e) {
			logger.error("",e);
			return 0;
		}
	}

	@Override
	public boolean delete(Integer id) {
		try {
			typeDao.delete(id);
			return true;
		} catch (Exception e) {
			logger.error("删除分类异常！",e);
			return false;
		}
		
	}

	
}
