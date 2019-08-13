package com.abbot.schimneylife.serviceImpl.weixin;

import java.util.Collections;
import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.abbot.schimneylife.dao.weixin.IAllianceCommissionDao;
import com.abbot.schimneylife.pojo.weixin.AllianceCommission;
import com.abbot.schimneylife.service.weixin.AllianceCommissionService;

@Service
public class AllianceCommissionServiceImpl implements AllianceCommissionService {

	private static final Logger logger = Logger.getLogger(AllianceCommissionServiceImpl.class);
	@Resource
	private IAllianceCommissionDao acDao;
	
	@Transactional
	@Override
	public void insert(AllianceCommission[] acs) throws Exception {
		for(AllianceCommission ac:acs) {
			acDao.insert(ac);
		}
	}


	@Override
	public boolean delete(String product_id){
		boolean res = false;
		try {
			acDao.deleteByProductId(product_id);
			res = true;
		} catch (Exception e) {
			logger.error("根据编号删除数据",e);
		}
		return res;
	}

	@Override
	public List<AllianceCommission> findByProductId(String product_id){
		List<AllianceCommission> list = Collections.emptyList();
		try {
			list = acDao.findByProductId(product_id);
		} catch (Exception e) {
			logger.error("根据编号查找数据",e);
		}
		return list;
	}

}
