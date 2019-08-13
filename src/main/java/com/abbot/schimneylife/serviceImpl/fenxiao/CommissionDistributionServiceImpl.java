package com.abbot.schimneylife.serviceImpl.fenxiao;

import java.util.Collections;
import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.abbot.schimneylife.dao.fenxiao.ICommissionDistributionDao;
import com.abbot.schimneylife.pojo.fenxiao.CommissionDistribution;
import com.abbot.schimneylife.pojo.fenxiao.FinancialDistribution;
import com.abbot.schimneylife.service.fenxiao.CommissionDistributionService;

@Service
public class CommissionDistributionServiceImpl implements CommissionDistributionService {

	private static final Logger logger = Logger.getLogger(CommissionDistributionServiceImpl.class);

	@Resource
	ICommissionDistributionDao commDao;
	
	@Override
	public List<CommissionDistribution> selectCommission() {
		try {
			return commDao.selectCommission();
		}catch (Exception e) {
		logger.error("分销佣金明细查询", e);
			return null;
		}
	}

	@Override
	public List<CommissionDistribution> selectCommissionBy(String name) {
		try {
			return commDao.selectCommissionBy(name);
		}catch (Exception e) {
			logger.error("分销佣金明细查询", e);
			return null;
		}
	}
	@Override
	public Integer totalCount() {
		try {
			return commDao.totalCount();
		} catch (Exception e) {
			logger.error("分销订单数量异常", e);
			return 0;
		}
	}

	@Override
	public List<CommissionDistribution> findByPageAndType( String order, String sort,
			Integer firstResult, Integer pageSize) {
		List<CommissionDistribution> commList = Collections.emptyList();
		try {
			commList = commDao.findByPageAndType(order, sort,  firstResult, pageSize);
		} catch (Exception e) {
			logger.error("根据分类分页查询订单异常！", e);
		}
		return commList;
	}

	@Override
	public Integer countByType(String like, String typeId) {
		try {
			return commDao.countByType(like, typeId);
		} catch (Exception e) {
			logger.error("根据分类统计订单数量", e);
			return 0;
		}
	}
	
	 
}
