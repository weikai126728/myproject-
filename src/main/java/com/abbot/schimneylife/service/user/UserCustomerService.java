package com.abbot.schimneylife.service.user;

import com.abbot.schimneylife.pojo.user.UserCustomer;

public interface UserCustomerService {

	/**
	 * 新增客户信息
	 * 
	 * @param customer
	 */
	boolean addCustomer(UserCustomer customer);

	/**
	 * 根据用户id查找客户信息
	 * 
	 * @param userInfoID
	 * @return
	 */
	UserCustomer fetchByUserId(Integer userInfoID);

	/**
	 * 修改客户信息
	 * 
	 * @param customer
	 */
	Integer updateCustomer(UserCustomer customer);

	/**
	 * 统计客户的数量
	 * 
	 * @return
	 */
	Integer countTotal();

	boolean updateLastscan(UserCustomer customer);
}
