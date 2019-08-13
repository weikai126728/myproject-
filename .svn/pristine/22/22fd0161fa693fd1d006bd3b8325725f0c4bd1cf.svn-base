package com.abbot.schimneylife.serviceImpl.shopping;

import java.util.Collections;
import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.abbot.schimneylife.dao.shopping.IRefundDao;
import com.abbot.schimneylife.pojo.shopping.MallOrder;
import com.abbot.schimneylife.pojo.shopping.Refund;
import com.abbot.schimneylife.pojo.user.User;
import com.abbot.schimneylife.service.shopping.RefundService;

@Service
public class RefundServiceImp implements RefundService {
	private static final Logger logger = Logger.getLogger(RefundServiceImp.class);

	@Resource
	IRefundDao refundDao;

	@Override
	public List<Refund> selectAll(Integer customerid) {
		try {
			return refundDao.selectAll(customerid);
		} catch (Exception e) {
			logger.error("查询售后列表异常", e);
			return null;
		}
	}

	@Override
	public List<Refund> findByPageAndType(String order, String sort, Integer firstResult, Integer pageSize) {
		List<Refund> refundList = Collections.emptyList();
		try {
			refundList = refundDao.findByPageAndType(order, sort, firstResult, pageSize);
		} catch (Exception e) {
			logger.error("根据分类分页查询订单异常！", e);
		}
		return refundList;
	}

	@Override
	public Integer selectCount() {
		try {
			return refundDao.selectCount();
		} catch (Exception e) {
			logger.error("查询总数异常", e);
			return 0;
		}
	}

	@Override
	public boolean add(Refund refund) {
		try {
			refundDao.add(refund);
			return true;
		} catch (Exception e) {
			logger.error("申请售后异常", e);
			return false;
		}

	}

	@Override
	public boolean delete(String id) {
		try {
			refundDao.delete(id);
			return true;
		} catch (Exception e) {
			logger.error("取消申请异常", e);
			return false;
		}
	}

	@Override
	public List<Refund> selectAllRefund() {
		try {
			return refundDao.selectAllRefund();
		} catch (Exception e) {
			logger.error("查询所有申请异常", e);
			return null;
		}
	}

	@Override
	public boolean agreeRefund(String id, Integer serviceStatus) {
		try {
			refundDao.agreeRefund(id, serviceStatus);
			return true;
		} catch (Exception e) {
			logger.error("同意异常", e);
			return false;
		}
	}

	@Override
	public String getImgName(String id) {
		try {
			return refundDao.getImgName(id);

		} catch (Exception e) {
			logger.error("售后查询图片异常", e);
			return null;
		}
	}

	@Override
	public Refund selectMsg(String mallOrderId) {
		try {
			return refundDao.selectMsg(mallOrderId);
		} catch (Exception e) {
			logger.error("查询售后详情异常", e);
			return null;
		}
	}

	@Override
	public Refund checkMsg(String id) {
		try {
			return refundDao.checkMsg(id);
		} catch (Exception e) {
			logger.error("查询售后状态异常", e);
			return null;
		}
	}

	@Override
	public void updateSub(Integer sub, String serviceId) {
		try {
			refundDao.updateSub(sub, serviceId);
		} catch (Exception e) {
			logger.error("修改售后状态异常", e);
		}
	}

	@Override
	public boolean addReason(String id, String refuseReason) {
		try {
			Integer i = refundDao.addReason(id, refuseReason);
			if (i == 1) {
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
			logger.error("添加原因异常", e);
			return false;
		}
	}

	@Override
	public boolean agreegoods(String id, Integer isAgree) {
		try {
			refundDao.agreegoods(id, isAgree);
			return true;
		} catch (Exception e) {
			logger.error("确认异常", e);
			return false;
		}
	}

}
