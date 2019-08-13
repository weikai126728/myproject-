package com.abbot.schimneylife.serviceImpl.user;

import java.util.Collections;
import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.abbot.schimneylife.dao.user.IOpinionDao;
import com.abbot.schimneylife.pojo.fenxiao.OrdersDistribution;
import com.abbot.schimneylife.pojo.user.Opinion;
import com.abbot.schimneylife.service.user.OpinionService;

@Service
public class OpinionServiceImpl implements OpinionService {
	private static final Logger logger = Logger.getLogger(JoinServiceImpl.class); 
	@Resource
	IOpinionDao od;
	
	@Override
	public Integer insert(Opinion op) {
		  
		try {
			return od.insert(op);
		} catch (Exception e) {
		logger.error("添加意见异常",e);
			return 0;
		}
	}

	@Override
	public List<Opinion> checkOpinion() {
		try {
			return od.checkOpinion();
		}catch (Exception e) {
			logger.error("查询所有意见异常",e);
			return null;	
		}
	}

	@Override
	public boolean deleteById(Integer id) {
		try {
			od.deleteById(id);
			return true;
		}catch (Exception e) {
			logger.error("删除意见异常", e);
			return false;
		}
	}
	@Override
	public Integer totalCount() {
		try {
			return od.totalCount();
		} catch (Exception e) {
			logger.error("分销订单数量异常", e);
			return 0;
		}
	}

	@Override
	public List<Opinion> findByPageAndType(String order, String sort,
			Integer firstResult, Integer pageSize) {
		List<Opinion> orderList = Collections.emptyList();
		try {
			orderList = od.findByPageAndType( order, sort,firstResult, pageSize);
		} catch (Exception e) {
			logger.error("根据分类分页查询订单异常！", e);
		}
		return orderList;
	}
 
}
