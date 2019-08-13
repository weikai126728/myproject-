package com.abbot.schimneylife.serviceImpl.fenxiao;

import java.util.Collections;
import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.abbot.schimneylife.dao.fenxiao.IFinancialDistributionDao;
import com.abbot.schimneylife.pojo.fenxiao.FinancialDistribution;
import com.abbot.schimneylife.pojo.fenxiao.OrdersDistribution;
import com.abbot.schimneylife.service.fenxiao.FinancialDistributionService;

@Service
public class FinancialDistributionServiceImpl implements FinancialDistributionService {

	private static final Logger logger = Logger.getLogger(FinancialDistributionServiceImpl.class);

	@Resource
	private IFinancialDistributionDao fDao;
	
	@Override
	public List<FinancialDistribution> selectFinancial() {
		try {
			return	fDao.selectFinancial();
		}catch (Exception e) {
			logger.error("分销财务查询异常", e);
			return null;
		}
	}

	@Override
	public List<FinancialDistribution> selectFinancialBy(String name) {
		try {
			return	fDao.selectFinancialBy(name);
		}catch (Exception e) {
			logger.error("分销财务查询异常", e);
			return null;
		}
	}

	@Override
	public Integer totalCount() {
		try {
			return fDao.totalCount();
		} catch (Exception e) {
			logger.error("分销订单数量异常", e);
			return 0;
		}
	}

	@Override
	public List<FinancialDistribution> findByPageAndType( String order, String sort, 
			Integer firstResult, Integer pageSize) {
		List<FinancialDistribution> fList = Collections.emptyList();
		try {
			fList = fDao.findByPageAndType(order, sort, firstResult, pageSize);
		} catch (Exception e) {
			logger.error("根据分类分页查询订单异常！", e);
		}
		return fList;
	}
  
	 
}
