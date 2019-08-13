package com.abbot.schimneylife.serviceImpl.weixin;

import java.util.Collections;
import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.abbot.schimneylife.dao.weixin.IJoinModelDao;
import com.abbot.schimneylife.pojo.weixin.JoinModel;
import com.abbot.schimneylife.service.weixin.JoinModelService;

@Service
public class JoinModelServiceImpl implements JoinModelService {

	private static final Logger logger = Logger.getLogger(JoinModelServiceImpl.class);
	@Resource
	private IJoinModelDao modelDao;
	@Override
	public boolean insert(JoinModel model) {
		boolean res = false;
		try {
			modelDao.insert(model);
			res = true;
		} catch (Exception e) {
			logger.error("新增加盟方式",e);
		}
		return res;
	}

	@Override
	public boolean update(JoinModel model) {
		boolean res = false;
		try {
			modelDao.update(model);
			res = true;
		} catch (Exception e) {
			logger.error("修改加盟方式",e);
		}
		return res;
	}

	@Override
	public boolean delete(Integer id) {
		boolean res = false;
		try {
			modelDao.delete(id);
			res = true;
		} catch (Exception e) {
			logger.error("根据id删除",e);
		}
		return res;
	}

	@Override
	public List<JoinModel> findAll(){
		List<JoinModel> list = Collections.emptyList();
		try {
			list = modelDao.findAll();
		} catch (Exception e) {
			logger.error("查询所有",e);
		}
		return list;
	}

}
