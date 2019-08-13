package com.abbot.schimneylife.serviceImpl.shopping;

import java.util.Collections;
import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.abbot.schimneylife.dao.shopping.ICustomerShippingAddressDao;
import com.abbot.schimneylife.pojo.shopping.CustomerShippingAddress;
import com.abbot.schimneylife.service.shopping.CustomerShippingAddressService;

@Service
public class CustomerShippingAddressServiceImpl implements CustomerShippingAddressService {

	private static final Logger logger = Logger.getLogger(CustomerShippingAddressServiceImpl.class);

	@Resource
	private ICustomerShippingAddressDao addressDao;

	@Override
	public boolean addAddress(CustomerShippingAddress address) {
		try {
			addressDao.insert(address);
			return true;
		} catch (Exception e) {
			logger.error("新增常用地址异常！", e);
			return false;
		}
	}

	@Override
	public CustomerShippingAddress fetchCommonUse(Integer customerId) {

		try {
			return addressDao.fetchCommonUse(customerId);
		} catch (Exception e) {
			logger.error("查找指定用户的默认送货地址异常！", e);
			return new CustomerShippingAddress();
		}
	}

	@Transactional
	@Override
	public List<CustomerShippingAddress> queryCustomerShippingAddress(Integer customerId) {
		List<CustomerShippingAddress> listAddress = Collections.emptyList();
		try {
			List<CustomerShippingAddress> list=addressDao.selectStatu(customerId);
			if(list.size()==0 || list == null) {		
				Integer Nid=addressDao.selectId(customerId);
				addressDao.setAddressMessage(Nid);
			}
			listAddress = addressDao.queryCustomerShippingAddress(customerId);
		} catch (Exception e) {
			logger.error("查找指定用户的默认送货地址异常！", e);
		}
		return listAddress;
	}

	@Transactional
	@Override
	public boolean updateAddressMessage(Integer customerId, Integer id) {
		try {
			addressDao.updateAddressMessage(customerId, id);
			return true;
		} catch (Exception e) {
			logger.error("修改用户的默认送货地址异常！", e);
			return false;
		}
	}

	@Override
	public CustomerShippingAddress fetchCommonId(Integer id) {
		try {
			return addressDao.fetchCommonId(id);
		} catch (Exception e) {
			logger.error("根据ID查找用户的送货地址异常！", e);
			return new CustomerShippingAddress();
		}
	}
	
	@Override
	public boolean updateAddress(CustomerShippingAddress address) {
		try {
			addressDao.updateAddress(address);
			return true;
		} catch (Exception e) {
			logger.error("修改用户的送货地址异常！", e);
			return false;
		}

	}

	@Transactional(rollbackFor=Exception.class)
	@Override
	public Integer deleteAddress(Integer id,Integer customerId) {
		try {
			addressDao.deleteAddress(id);
			List<CustomerShippingAddress> list=addressDao.selectStatu(customerId);
			if(list.size()==0 || list == null) {		
				Integer Nid=addressDao.selectId(customerId);
				addressDao.setAddressMessage(Nid);
				return Nid;
			}
			return id;
		} catch (Exception e) {
			logger.error("刪除地址异常！", e);
			return null;
		}
	}

	@Override
	public void setAddressMessage(Integer id) {
		try {
			addressDao.setAddressMessage(id);
		} catch (Exception e) {
			logger.error("刪除用户的送货地址异常！", e);

		}

	}
}
