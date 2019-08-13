package com.abbot.schimneylife.serviceImpl.company;

import java.util.Collections;
import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.abbot.schimneylife.dao.company.INewsDao;
import com.abbot.schimneylife.pojo.company.compOpinion;
import com.abbot.schimneylife.pojo.company.news;
import com.abbot.schimneylife.service.company.NewsService;

@Service
public class NewServiceImpl implements NewsService {
	
	private static final Logger logger = Logger.getLogger(CompOpinionServiceImpl.class);

	@Resource
	INewsDao newDao;

	@Override
	public Integer totalCount() {
		try {
			return newDao.totalCount();
		} catch (Exception e) {
			logger.error("网站意见反馈数量异常", e);
			return 0;
		}
	}

	@Override
	public List<news> findByPage(String order, String sort, Integer firstResult, Integer pageSize) {
		List<news> commList = Collections.emptyList();
		try {
			commList = newDao.findByPage(order, sort, firstResult, pageSize);
		} catch (Exception e) {
			logger.error("根据分类分页查询网站意见异常！", e);
		}
		return commList;
	}

	@Override
	public news findById(String id) {
		try {
			return newDao.findById(id);
		}catch (Exception e) {
			logger.error(e);
			return null;
		}
	}

	@Override
	public boolean add(news news) {
		try {
			newDao.add(news);
			return true;
		}catch (Exception e) {
			logger.error(e);
			return false;
		}
	}
	@Override
	public boolean edit(news news) {
		try {
			newDao.edit(news);
			return true;
		}catch (Exception e) {
			logger.error(e);
			return false;
		}
	}

	@Override
	public boolean deleteById(String id) {
		try {
			newDao.deleteById(id);
			return true;
		}catch (Exception e) {
			return false;
		}
	}

}
