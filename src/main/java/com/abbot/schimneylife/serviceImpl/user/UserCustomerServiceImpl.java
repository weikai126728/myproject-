package com.abbot.schimneylife.serviceImpl.user;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.abbot.schimneylife.dao.user.IUserCustomerDao;
import com.abbot.schimneylife.pojo.user.UserCustomer;
import com.abbot.schimneylife.service.user.UserCustomerService;

@Service
public class UserCustomerServiceImpl implements UserCustomerService {
	private static final Logger logger = Logger.getLogger(UserCustomerServiceImpl.class);
	@Resource
	private IUserCustomerDao customerDao;

	@Transactional
	@Override
	public boolean addCustomer(UserCustomer customer) {
		try {
			
			customerDao.insert(customer);

		} catch (Exception e) {
			logger.error("新增客户信息异常！", e);
			return false;
		}
		return true;
	}

	@Override
	public UserCustomer fetchByUserId(Integer userInfoID) {
		try {
			return customerDao.fetchByUserId(userInfoID);
		} catch (Exception e) {
			logger.error("根据用户id查找客户信息异常！", e);
			return new UserCustomer();
		}
	}

	@Override
	public Integer updateCustomer(UserCustomer customer) {
		try {
			return customerDao.updateCustomer(customer);

		} catch (Exception e) {
			logger.error("修改客户信息异常！", e);
			return 0;
		}

	}

	@Override
	public Integer countTotal() {
		try {
			return customerDao.countTotal();
		} catch (Exception e) {
			logger.error("统计客户的数量异常！", e);
			return 0;
		}
	}

	@Override
	public boolean updateLastscan(UserCustomer customer) {
		try {
			customerDao.updateLastScan(customer);
			return true;
		} catch (Exception e) {
			logger.error("修改用户最后一次浏览我的消息时间异常",e);
		}
		return false;
	}

 

}
