package com.abbot.schimneylife.serviceImpl.fenxiao;

import java.util.Collections;
import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.abbot.schimneylife.dao.fenxiao.IUserDistributionDao;
import com.abbot.schimneylife.pojo.fenxiao.OrdersDistribution;
import com.abbot.schimneylife.pojo.fenxiao.UserDistribution;
import com.abbot.schimneylife.service.fenxiao.UserDistributionService;

@Service
public class UserDistributionServiceImpl implements UserDistributionService {
	private static final Logger logger = Logger.getLogger(UserDistributionServiceImpl.class);

	@Resource
	IUserDistributionDao udDao;

	@Override
	public List<UserDistribution> selectUser() {
		try {
			return udDao.selectUser();
		} catch (Exception e) {
			logger.error("分销用户查询异常", e);
			return null;
		}
	}

	@Override
	public boolean stop(int id) {
		try {
			udDao.stop(id);
			return true;
		} catch (Exception e) {
			logger.error("分销用户禁用异常", e);
			return false;
		}
	}

	@Override
	public boolean start(int id) {
		try {
			udDao.start(id);
			return true;
		} catch (Exception e) {
			logger.error("分销用户启用异常", e);
			return false;
		}
	}

	@Override
	public boolean deleteById(int id) {
		try {
			udDao.deleteById(id);
			return true;
		} catch (Exception e) {
			logger.error("分销用户删除异常", e);
			return false;
		}
	}

	@Override
	public List<UserDistribution> selectUserBy(UserDistribution user) {
		try {
			return udDao.selectUserBy(user);
		}catch (Exception e) {
			logger.error("分销用户查询异常", e);
			return null;
		}
	}
	@Override
	public Integer totalCount() {
		try {
			return udDao.totalCount();
		} catch (Exception e) {
			logger.error("分销订单数量异常", e);
			return 0;
		}
	}

	@Override
	public List<UserDistribution> findByPageAndType( String order, String sort,
			Integer firstResult, Integer pageSize) {
		List<UserDistribution> userList = Collections.emptyList();
		try {
			userList = udDao.findByPageAndType( order, sort,  firstResult, pageSize);
		} catch (Exception e) {
			logger.error("根据分类分页查询订单异常！", e);
		}
		return userList;
	}
}
