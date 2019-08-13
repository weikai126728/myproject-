package com.abbot.schimneylife.serviceImpl.company;

import java.util.Collections;
import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.abbot.schimneylife.dao.company.ICompOpinionDao;
import com.abbot.schimneylife.pojo.company.compOpinion;
import com.abbot.schimneylife.service.company.CompOpinionService;

@Service
public class CompOpinionServiceImpl implements CompOpinionService {
	
	private static final Logger logger = Logger.getLogger(CompOpinionServiceImpl.class);

	@Resource
	ICompOpinionDao opinionDao;

	@Override
	public Integer totalCount() {
		try {
			return opinionDao.totalCount();
		} catch (Exception e) {
			logger.error("网站意见反馈数量异常", e);
			return 0;
		}
	}

	@Override
	public List<compOpinion> findByPage(String order, String sort, Integer firstResult, Integer pageSize) {
		List<compOpinion> commList = Collections.emptyList();
		try {
			commList = opinionDao.findByPage(order, sort, firstResult, pageSize);
		} catch (Exception e) {
			logger.error("根据分类分页查询网站意见异常！", e);
		}
		return commList;
	}

	@Override
	public boolean deleteById(String id) {
		try {
			opinionDao.deleteById(id);
			return true;
		}catch (Exception e) {
			logger.error(e);
			return false;
		}
	}

}
