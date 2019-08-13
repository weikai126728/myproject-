package com.abbot.schimneylife.serviceImpl.weixin;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.abbot.schimneylife.dao.weixin.IAmountOrderDao;
import com.abbot.schimneylife.pojo.weixin.AmountOrder;
import com.abbot.schimneylife.pojo.weixin.TsServiceFee;
import com.abbot.schimneylife.service.weixin.AmountorderService;
@Service
public class AmountorderServiceImpl implements AmountorderService {
	private static final Logger logger = Logger.getLogger(AmountorderServiceImpl.class);
	
	
	@Resource
	private IAmountOrderDao amountDao;
	
	@Override
	public List<AmountOrder> findByPage(Integer firstResult, Integer pageSize, String like, String column, String sort,
			String startTime, String endTime,Integer salesmanId) {
		List<AmountOrder> list = Collections.emptyList();
		try {
			list = amountDao.findByPage(firstResult, pageSize, like, column, sort, startTime, endTime,salesmanId);
		} catch (Exception e) {
			logger.error(e);
		}
		return list;
	}
	
	@Override
	public List<AmountOrder> findByproduct_id(Integer firstResult, Integer pageSize, String like, String column, String sort,
			String startTime, String endTime,String product_id) {
		List<AmountOrder> list = Collections.emptyList();
		try {
			list = amountDao.findByproduct_id(firstResult, pageSize, like, column, sort, startTime, endTime,product_id);
		} catch (Exception e) {
			logger.error(e);
		}
		return list;
	}
	@Override
	public Integer countTotal(String like, String startTime, String endTime,Integer salesmanId) {
		Integer total = 0;
		try {
			total = amountDao.countTotal(like, startTime, endTime,salesmanId);
		} catch (Exception e) {
			logger.error(e);
		}
		return total;
	}
	@Override
	public Integer countTotal(String like, String startTime, String endTime,String product_id) {
		Integer total = 0;
		try {
			total = amountDao.countTotalByProduct_id(like, startTime, endTime,product_id);
		} catch (Exception e) {
			logger.error(e);
		}
		return total;
	}
	@Override
	public Integer totalAmount(String like, String startTime, String endTime,Integer salesmanId) {
		Integer total = 0;
		try {
			total = amountDao.totalAmount(like, startTime, endTime,salesmanId);
		} catch (Exception e) {
			logger.error(e);
		}
		return total;
	}
	@Override
	public Integer totalAmount(String like, String startTime, String endTime,String product_id) {
		Integer total = 0;
		try {
			total = amountDao.totalAmountByProduct_id(like, startTime, endTime,product_id);
		} catch (Exception e) {
			logger.error(e);
		}
		return total;
	}
	@Override
	public Integer countAmountByAllianceIds(List<Integer> alids, String startTime, String endTime) {
		Integer total = 0;
		Integer[] ids = new Integer[alids.size()];
		alids.toArray(ids);
		Map<String,Object> map = new HashMap<>();
		map.put("ids", ids);
		map.put("startTime", startTime);
		map.put("endTime", endTime);
		try {
			total = amountDao.countAmountByAllianceIds(map);
		} catch (Exception e) {
			logger.error("根据条件统计交易额异常",e);
		}
		return total;
	}

	@Override
	public Integer noCommissionSum(String product_id, String startTime, String endTime) {
		Integer total = 0;
		try {
			total =amountDao.noCommissionSum(product_id, startTime, endTime);
		} catch (Exception e) {
			logger.error("未结算佣金交易求和",e);
		}
		return total;
	}

	@Override
	public List<AmountOrder> noCommissionList(String product_id, String startTime, String endTime) {
		List<AmountOrder> list = Collections.emptyList();
		try {
			list = amountDao.noCommissionList(product_id, startTime, endTime);
		} catch (Exception e) {
			logger.error("未结算佣金交易列表", e);
		}
		return list;
	}

	@Override
	public Integer sumAmount(String product_id, String startTime, String endTime, Integer salesmanId) {
		try {
			return amountDao.sumAmount(product_id, startTime, endTime, salesmanId);
		} catch (Exception e) {
			logger.info("计算商户今天的交易额", e);
		}
		return 0;
	}
	@Override
	public Integer countAmount(String product_id, String startTime, String endTime, Integer salesmanId) {
		try {
			return amountDao.countAmount(product_id, startTime, endTime, salesmanId);
		} catch (Exception e) {
			logger.info("计算商户今天的交易笔数", e);
		}
		return 0;
	}

	@Override
	public TsServiceFee findServiceFee(String product_id) {
		try {
		return	amountDao.findServiceFee(product_id);
		} catch (Exception e) {
			logger.info("商家服务费", e);
		}
		return null;
	}

	@Override
	public void insertServicefee(String product_id) {
		try {
			amountDao.insertServicefee(product_id);
		} catch (Exception e) {
			logger.info("添加商家服务费", e);
		}
	}

	@Override
	public boolean updateSfee(TsServiceFee servicefee) {
		try {
			amountDao.updateSfee(servicefee);
			return true;
		} catch (Exception e) {
			logger.info("添加商家服务费", e);
		}
		return false;
		
	}

}
