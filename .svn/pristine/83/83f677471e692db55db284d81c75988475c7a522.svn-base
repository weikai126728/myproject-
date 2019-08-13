package com.abbot.schimneylife.serviceImpl.shopping;

import java.util.Collections;
import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.abbot.schimneylife.dao.shopping.ICustomerEvaluateDao;
import com.abbot.schimneylife.pojo.shopping.CustomerEvaluate;
import com.abbot.schimneylife.service.shopping.CustomerEvaluateService;
@Service
public class CustomerEvaluateServiceImpl implements CustomerEvaluateService{

	private static final Logger logger = Logger.getLogger(CustomerEvaluateServiceImpl.class);
	@Resource
	private ICustomerEvaluateDao evaluateDao;
	@Override
	public List<CustomerEvaluate> findByProduct(String proId, Integer firstResult, Integer pageSize,String type) {
		List<CustomerEvaluate> evaluateList = Collections.emptyList();
		try {
			switch(type) {
			case "ALL":
				evaluateList = evaluateDao.findByProduct(proId, firstResult, pageSize);
				break;
			case "GOOD":
				evaluateList = evaluateDao.findGoodByProduct(proId, firstResult, pageSize);
				break;
			case "BAD":
				evaluateList = evaluateDao.findBadByProduct(proId, firstResult, pageSize);
				break;
		}
		} catch (Exception e) {
			logger.error("分页查询商品评价异常！",e);
		}
		return evaluateList;
	}

	@Override
	public Integer countByProduct(String proId,String type) {
		try {
			switch(type) {
				case "ALL":
					return evaluateDao.countByProduct(proId);
				case "GOOD":
					return evaluateDao.countGoodByProduct(proId);
				case "BAD":
					return evaluateDao.countBadByProduct(proId);
				default:
					return 0;
			}
			
		} catch (Exception e) {
			logger.error("统计商品的评价总数量异常！",e);
			return 0;
		}
	}

	@Override
	public String getPraise(String proId) {
		try {
			return evaluateDao.getPraise(proId);
		} catch (Exception e) {
			logger.error("获取指定商品的好评度异常！",e);
			return "100";
		}
	}

	@Override
	public List<CustomerEvaluate> findByPage(String createTime,String like, String sort, Integer type, Integer status,
			Integer firstResult, Integer pageSize) {
		List<CustomerEvaluate> list = Collections.emptyList();
		try {
			list = evaluateDao.findByPage(createTime,like, type, status, sort, firstResult, pageSize);
		} catch (Exception e) {
			logger.error("分页查询",e);
		}
		return list;
	}

	@Override
	public Integer countTotal(String createTime,String like, Integer type, Integer status) {
		try {
			return evaluateDao.countTotal(createTime,like, type, status);
		} catch (Exception e) {
			logger.error("统计数量",e);
			return 0;
		}
	}

	@Override
	public boolean reply(String reply, String author, String id) {
		boolean res = false;
		try {
			evaluateDao.updateReply(reply, author, id);
			res = true;
		} catch (Exception e) {
			logger.error("回复评价",e);
		}
		return res;
	}

	@Override
	public boolean updateStatus(Integer status, String id) {
		try {
			evaluateDao.updateStatus(status, id);
			return true;
		} catch (Exception e) {
			logger.error("修改状态",e);
			return false;
		}
	}

	@Override
	public boolean delete(String id) {
		try {
			evaluateDao.delete(id);
			return true;
		} catch (Exception e) {
			logger.error("删除评价",e);
			return false;
		}
		
	}

	@Override
	public boolean insert(CustomerEvaluate evaluate) {
		boolean res = false;
		try {
			evaluateDao.insert(evaluate);
			res = true;
		} catch (Exception e) {
			logger.error("新增评价异常",e);
		}
		return res;
	}

	@Transactional(rollbackFor=Exception.class)
	@Override
	public void insertBatch(List<CustomerEvaluate> evaluateList) throws Exception {
		for(CustomerEvaluate evaluate:evaluateList) {
			evaluateDao.insert(evaluate);
		}
	}

	
}
