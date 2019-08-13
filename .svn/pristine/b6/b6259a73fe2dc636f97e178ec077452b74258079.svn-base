package com.abbot.schimneylife.dao.shopping;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.abbot.schimneylife.pojo.shopping.CustomerShippingAddress;

/**
 * 客户常用地址
 * 
 * @author Administrator
 *
 */
@Repository
public interface ICustomerShippingAddressDao {

	/**
	 * 添加常用地址
	 * 
	 * @param address
	 * @throws Exception
	 */
	void insert(CustomerShippingAddress address) throws Exception;

	/**
	 * 查找指定用户的常用地址
	 * 
	 * @param customerId
	 * @return
	 * @throws Exception
	 */
	List<CustomerShippingAddress> queryCustomerShippingAddress(@Param("customerId") Integer customerId)
			throws Exception;

	/**
	 * 查找指定用户的默认地址
	 * 
	 * @param customerId
	 * @return
	 * @throws Exception
	 */
	CustomerShippingAddress fetchCommonUse(@Param("customerId") Integer customerId) throws Exception;

	/**
	 * 重置默认地址
	 * 
	 * @param id
	 */
	void updateAddressMessage(@Param("customerId") Integer customerId, @Param("id") Integer id)throws Exception;

	/**
	 * 更新默认地址
	 * 
	 * @param id
	 */
	void setAddressMessage(@Param("id") Integer id)throws Exception;

	/**
	 * 修改地址
	 * 
	 * @param address
	 */
	void updateAddress(CustomerShippingAddress address) throws Exception;

	/**
	 * 修改地址时查找
	 * 
	 * @param id
	 * @return
	 */
	CustomerShippingAddress fetchCommonId(@Param("id") Integer id) throws Exception;

	/**
	 * 删除地址
	 * 
	 * @param id
	 */
	void deleteAddress(@Param("id") Integer id) throws Exception;
	
	Integer selectId(@Param("customerId")Integer customerId) throws Exception;
	
	List<CustomerShippingAddress> selectStatu(@Param("id")Integer id)throws Exception;
}
