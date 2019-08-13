package com.abbot.schimneylife.dao.user;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.abbot.schimneylife.pojo.user.UserCustomer;

@Repository
public interface IUserCustomerDao {

	/**
	 * 新增客户信息
	 * 
	 * @param customer
	 * @throws Exception
	 */
	void insert(UserCustomer customer) throws Exception;

	/**
	 * 根据用户id查找客户信息
	 * 
	 * @param userInfoID
	 * @return
	 * @throws Exception
	 */
	UserCustomer fetchByUserId(@Param("userID")Integer userInfoID) throws Exception;
	/**
	 * 根据userid删除数据
	 * @param userId
	 * @throws Exception
	 */
	void deleteByUserId(@Param("userID")Integer userId)throws Exception;
	/**
	 * 根据id查询
	 * @param id
	 * @return
	 * @throws Exception
	 */
	UserCustomer fetchById(@Param("id")Integer id) throws Exception;
	/**
	 * 修改客户信息
	 * 
	 * @param customer
	 * @return
	 */
	Integer updateCustomer(UserCustomer customer) throws Exception;

	/**
	 * 统计总数量
	 * 
	 * @return
	 * @throws Exception
	 */
	Integer countTotal() throws Exception;
	/**
	 * 修改浏览时间
	 * @param customer
	 * @throws Exception
	 */
	void updateLastScan(UserCustomer customer)throws Exception;

}
