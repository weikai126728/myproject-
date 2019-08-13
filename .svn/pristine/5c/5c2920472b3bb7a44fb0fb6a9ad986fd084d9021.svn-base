package com.abbot.schimneylife.dao.shopping;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.abbot.schimneylife.pojo.shopping.CustomerOrderWarn;

@Repository
public interface ICustomerOrderWarnDao {

	void insert(@Param("customerId")Integer customerId,@Param("orderId")String orderId)throws Exception;
	/**
	 * 分页查询
	 * @param like
	 * @param createTime
	 * @param sort
	 * @param firstResult
	 * @param pageSize
	 * @return
	 * @throws Exception
	 */
	List<CustomerOrderWarn> findByPage(@Param("like")String like,@Param("createTime")String createTime
			,@Param("sort")String sort,@Param("firstResult")Integer firstResult,@Param("pageSize")Integer pageSize)throws Exception;
	/**
	 * 统计数量
	 * @param like
	 * @param createTime
	 * @return
	 * @throws Exception
	 */
	Integer countTotal(@Param("like")String like,@Param("createTime")String createTime)throws Exception;
}
