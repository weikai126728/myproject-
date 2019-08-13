package com.abbot.schimneylife.serviceImpl.user;


import java.util.Collections;
import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.abbot.schimneylife.dao.user.IJoinDao;
import com.abbot.schimneylife.pojo.user.Join;
import com.abbot.schimneylife.pojo.user.Opinion;
import com.abbot.schimneylife.service.user.JoinService;

@Service
public class JoinServiceImpl implements JoinService {
	private static final Logger logger = Logger.getLogger(JoinServiceImpl.class); 
	@Resource
	IJoinDao jd;

	@Override
	public Integer insert(Join join) {
		try {

			return jd.insert(join);
		} catch (Exception e) {
			logger.error("加盟异常",e);
			return 0;
		}

	}

	@Override
	public List<Join> checkJoin() {
		try {
			return	jd.checkJoin();
		}catch (Exception e) {
			logger.error("加盟代理查询异常", e);
			return null;
		}
	}

	@Override
	public boolean deleteById(Integer id) {
		try {
			jd.deleteById(id);
			return true;
		}catch (Exception e) {
			logger.error("加盟代理删除异常", e);
			return false;
		}
	}
	@Override
	public Integer totalCount() {
		try {
			return jd.totalCount();
		} catch (Exception e) {
			logger.error("分销订单数量异常", e);
			return 0;
		}
	}

	@Override
	public List<Join> findByPageAndType(String order, String sort,
			Integer firstResult, Integer pageSize) {
		List<Join> orderList = Collections.emptyList();
		try {
			orderList = jd.findByPageAndType(order, sort, firstResult, pageSize);
		} catch (Exception e) {
			logger.error("根据分类分页查询订单异常！", e);
		}
		return orderList;
	}
}
