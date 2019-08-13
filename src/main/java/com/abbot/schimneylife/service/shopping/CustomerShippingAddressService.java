package com.abbot.schimneylife.service.shopping;

import java.util.List;

import com.abbot.schimneylife.pojo.shopping.CustomerShippingAddress;

public interface CustomerShippingAddressService {

	/**
	 * 新增常用地址
	 * 
	 * @param address
	 * @return
	 */
	boolean addAddress(CustomerShippingAddress address);

	/**
	 * 查询所有地址
	 * 
	 * @param customerId
	 * @return
	 */
	List<CustomerShippingAddress> queryCustomerShippingAddress(Integer customerId);

	/**
	 * 重置默认地址
	 * 
	 * @param id
	 */
	boolean updateAddressMessage(Integer customerId, Integer id);

	/**
	 * 更新默认地址
	 * 
	 * @param id
	 */
	void setAddressMessage(Integer id);

	/**
	 * 修改地址
	 * 
	 * @param address
	 */
	boolean updateAddress(CustomerShippingAddress address);

	/**
	 * 查找指定用户的默认送货地址
	 * 
	 * @param customerId
	 * @return
	 */
	CustomerShippingAddress fetchCommonUse(Integer customerId);

	/**
	 * 查询需要修改的地址
	 * 
	 * @param customerId
	 * @return
	 */
	CustomerShippingAddress fetchCommonId(Integer id);

	/**
	 * 删除地址
	 * 
	 * @param id
	 */
	Integer deleteAddress(Integer id,Integer customerId);
}
