package com.abbot.schimneylife.serviceImpl.weixin;

import java.util.Collections;
import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.abbot.schimneylife.dao.weixin.ICommissionDao;
import com.abbot.schimneylife.pojo.weixin.Commission;
import com.abbot.schimneylife.service.weixin.CommissionService;
@Service
public class CommissionServiceImpl implements CommissionService {

	private static final Logger logger = Logger.getLogger(CommissionServiceImpl.class);
	@Resource
	private ICommissionDao commissionDao;
	@Override
	public boolean insert(Commission commission) {
		boolean res =false;
		try {
			commissionDao.insert(commission);
			res =true;
		} catch (Exception e) {
			logger.error("新增佣金比例数据",e);
		}
		return res;
	}

	@Override
	public boolean delete(Integer id) {
		boolean res = false;
		try {
			commissionDao.delete(id);
			res = true;
		} catch (Exception e) {
			logger.error("根据id删除佣金比例数据",e);
		}
		return res;
	}

	@Override
	public boolean update(Commission commission) {
		boolean res = false;
		try {
			commissionDao.update(commission);
			res = true;
		} catch (Exception e) {
			logger.error("修改佣金比例数据",e);
		}
		return res;
	}

	@Override
	public List<Commission> findByPage(String search, Integer typeId, Integer modelId, String order, String sort,
			Integer firstResult, Integer pageSize) {
		List<Commission> commissionList = Collections.emptyList();
		try {
			commissionList = commissionDao.findByPage(search, typeId, modelId, order, sort, firstResult, pageSize);
		} catch (Exception e) {
			logger.error("分页查询",e);
		}
		return commissionList;
	}

	@Override
	public Integer totalCount(String search, Integer typeId, Integer modelId) {
		Integer total = 0;
		try {
			total = commissionDao.totalCount(search, typeId, modelId);
		} catch (Exception e) {
			logger.error("统计数量",e);
		}
		return total;
	}

	@Override
	public Integer fetchByCondition(Integer businessTypeId, Integer modelId, String zipCode) {
		Integer percent = 0;
		try {
			percent = commissionDao.fetchByCondition(businessTypeId, modelId, zipCode);
		} catch (Exception e) {
			logger.error("根据条件查询佣金比例",e);
		}
		return percent;
	}

	@Override
	public Integer fetchPriByCondition(Integer typeId, String product_id) {
		Integer percent = 0;
		try {
			percent = commissionDao.fetchPriByCondition(typeId, product_id);
		} catch (Exception e) {
			logger.error("根据条件查询私有可执行佣金比例",e);
		}
		return percent;
	}

	@Override
	public Commission fetchByTypeAndModel(Integer typeId, Integer modelId) {
		try {
			return commissionDao.fetchByTypeAndModel(typeId, modelId);
		} catch (Exception e) {
			logger.error("根据条件查询佣金比例",e);
			return null;
		}
	}

}
