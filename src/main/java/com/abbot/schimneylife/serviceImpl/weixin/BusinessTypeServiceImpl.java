package com.abbot.schimneylife.serviceImpl.weixin;

import java.util.Collections;
import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.abbot.schimneylife.dao.weixin.IBusinessDao;
import com.abbot.schimneylife.pojo.weixin.BusinessType;
import com.abbot.schimneylife.service.weixin.BusinessTypeService;

@Service
public class BusinessTypeServiceImpl implements BusinessTypeService {

	private static final Logger logger = Logger.getLogger(BusinessTypeServiceImpl.class);
	@Resource
	private IBusinessDao businessDao;
	@Override
	public boolean insert(BusinessType type) {
		boolean res = false;
		try {
			businessDao.insert(type);
			res = true;
		} catch (Exception e) {
			logger.error("新增数据",e);
		}
		return res;
	}

	@Override
	public boolean update(BusinessType type) {
		boolean res = false;
		try {
			businessDao.update(type);
		} catch (Exception e) {
			logger.error("修改数据", e);
		}
		return res;
	}

	@Override
	public boolean delete(Integer id) {
		boolean res = false;
		try {
			businessDao.delete(id);
			res = true;
		} catch (Exception e) {
			logger.error("删除数据",e);
		}
		return res;
	}

	@Override
	public List<BusinessType> findAll() {
		List<BusinessType> list = Collections.emptyList();
		try {
			list = businessDao.findAll();
		} catch (Exception e) {
			logger.error("查询所有商业类型",e);
		}
		return list;
	}

}
