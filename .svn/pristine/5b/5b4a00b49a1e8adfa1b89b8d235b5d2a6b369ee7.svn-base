package com.abbot.schimneylife.serviceImpl.weixin;

import java.util.Collections;
import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.abbot.schimneylife.dao.weixin.IAllianceDao;
import com.abbot.schimneylife.pojo.weixin.Alliance;
import com.abbot.schimneylife.service.weixin.AllianceService;
@Service
public class AllianceServiceImpl implements AllianceService{

	private static final Logger logger = Logger.getLogger(AllianceServiceImpl.class);
	
	@Resource
	private IAllianceDao alDao;
	@Override
	public List<Alliance> findByPage(Integer firstResult, Integer pageSize, String like, String column, String sort,String createTime) {
		List<Alliance> list = Collections.emptyList();
		try {
			list = alDao.findByPage(firstResult, pageSize, like, column, sort,createTime);
		} catch (Exception e) {
			logger.error(e);
		}
		return list;
	}

	@Override
	public Integer countTotal(String like,String createTime) {
		Integer total = 0;
		try {
			total = alDao.countTotal(like,createTime);
		} catch (Exception e) {
			logger.error(e);
		}
		return total;
	}

	@Override
	public List<Integer> findIdsByUserId(Integer userId) {
		List<Integer> list = Collections.emptyList();
		try {
			list = alDao.findIdsByUserId(userId);
		} catch (Exception e) {
			logger.error(e);
		}
		return list;
	}

	@Transactional(noRollbackFor = Exception.class)
	@Override
	public void updateRel(Integer[] alids, Integer userId) throws Exception {
		// TODO Auto-generated method stub
		alDao.deleteRelByUserId(userId);
		for(Integer id:alids) {
			alDao.insertRel(userId, id);
		}
	}

	@Override
	public Alliance fetchByNumber(String product_id) {
		try {
			return alDao.fetchByNumber(product_id);
		} catch (Exception e) {
			logger.error(e);
			return null;
		}
	}

	@Override
	public List<Alliance> findAllNotAllocation(Integer userId, Integer level) {
		List<Alliance> list = Collections.emptyList();
		try {
			list = alDao.findAllNotAllocation(userId, level);
		} catch (Exception e) {
			logger.error("查找指定角色等级没有分配的加盟商超列表异常",e);
		}
		return list;
	}

	@Override
	public Integer countUser(String product_id) {
		try {
			return alDao.countUser(product_id);
		} catch (Exception e) {
			logger.info("查询商户推广的会员数量",e);
		}
		return 0;
	}

	@Override
	public boolean updatefzoff(String product_id) {
		try {
			alDao.updatefz(product_id);
			alDao.updatefzOff(product_id);
			return true;
		} catch (Exception e) {
			logger.info("修改分账",e);
		}
		return false;
	}

	
}
