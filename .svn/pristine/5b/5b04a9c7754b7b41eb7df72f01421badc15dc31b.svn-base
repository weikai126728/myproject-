package com.abbot.schimneylife.serviceImpl.fenxiao;

import java.util.Collections;
import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.abbot.schimneylife.dao.fenxiao.IWithdrawDistributionDao;
import com.abbot.schimneylife.pojo.fenxiao.OrdersDistribution;
import com.abbot.schimneylife.pojo.fenxiao.WithdrawDistribution;
import com.abbot.schimneylife.service.fenxiao.WithdrawDistributionService;

@Service
public class WithdrawDistributionServiceImpl implements WithdrawDistributionService {

	private static final Logger logger = Logger.getLogger(WithdrawDistributionServiceImpl.class);

	@Resource
	private IWithdrawDistributionDao withdrawDao;

	@Override
	public List<WithdrawDistribution> selectWithdraw() {
		try {
			return withdrawDao.selectWithdraw();
		} catch (Exception e) {
			logger.error("分销提现查询异常", e);
			return null;
		}
	}

	@Override
	public List<WithdrawDistribution> selectWithdrawBy(String name) {
		try {
			return withdrawDao.selectWithdrawBy(name);
		} catch (Exception e) {
			logger.error("分销提现查询异常", e);
			return null;
		}
	}

	@Override
	public boolean update(Integer id) {
		try {
			withdrawDao.update(id);
			return true;
		} catch (Exception e) {
			logger.error("分销提现修改", e);
			return false;
		}
	}

	@Override
	public boolean delete(Integer id) {
		try {
			withdrawDao.delete(id);
			return true;
		} catch (Exception e) {
			logger.error("分销提现删除", e);
			return false;
		}

	}

	@Override
	public Integer totalCount() {
		try {
			return withdrawDao.totalCount();
		} catch (Exception e) {
			logger.error("分销提现统计异常", e);
			return 0;
		}
	}

	@Override
	public List<WithdrawDistribution> findByPageAndType( String order, String sort,
			Integer firstResult, Integer pageSize) {
		List<WithdrawDistribution> withList = Collections.emptyList();
		try {
			withList = withdrawDao.findByPageAndType( order, sort, firstResult, pageSize);
		} catch (Exception e) {
			logger.error("根据分类分页查询订单异常！", e);
		}
		return withList;
	}

	@Override
	public Integer countByType(String like, String typeId) {
		try {
			return withdrawDao.countByType(like, typeId);
		} catch (Exception e) {
			logger.error("根据分类统计订单数量", e);
			return 0;
		}
	}

}
