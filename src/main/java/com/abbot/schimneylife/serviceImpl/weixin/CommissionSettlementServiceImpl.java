package com.abbot.schimneylife.serviceImpl.weixin;

import java.util.Collections;
import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.abbot.schimneylife.dao.weixin.ICommissionSettlementDao;
import com.abbot.schimneylife.pojo.weixin.CommissionSettlement;
import com.abbot.schimneylife.service.weixin.CommissionSettlementService;

@Service
public class CommissionSettlementServiceImpl implements CommissionSettlementService {

	private static final Logger logger = Logger.getLogger(CommissionSettlementServiceImpl.class);
	
	@Resource
	private ICommissionSettlementDao settlementDao;
	@Override
	public boolean insert(CommissionSettlement settlement) {
		boolean res = false;
		try {
			settlementDao.insert(settlement);
			res = true;
		} catch (Exception e) {
			logger.error("新增结算单",e);
		}
		return res;
	}

	@Override
	public Integer sumSuccess(String product_id, String startTime, String endTime) {
		Integer total = 0;
		try {
			total = settlementDao.sumSuccess(product_id, startTime, endTime);
		} catch (Exception e) {
			logger.error("已结算成功佣金求和",e);
		}
		return total==null?0:total;
	}

	@Override
	public boolean insertRelation(Integer amountId, String settlementId,Integer percent) {
		boolean res = false;
		try {
			settlementDao.insertRelation(amountId, settlementId,percent);
			res = true;
		} catch (Exception e) {
			logger.error("新建佣金结算单和交易单关联关系",e);
		}
		return res;
	}

	@Override
	public List<CommissionSettlement> findByPage(String search, String startTime, String endTime, String order,
			String sort, Integer firstResult, Integer pageSize) {
		List<CommissionSettlement> list = Collections.emptyList();
		try {
			list = settlementDao.findByPage(search, startTime, endTime, order, sort, firstResult, pageSize);
		} catch (Exception e) {
			logger.error("根据条件分页查询",e);
		}
		return list;
	}

	@Override
	public Integer totalCount(String search, String startTime, String endTime) {
		Integer total = 0;
		try {
			total = settlementDao.totalCount(search, startTime, endTime);
		} catch (Exception e) {
			logger.error("根据条件统计数量",e);
		}
		return total;
	}

}
