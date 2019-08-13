package com.abbot.schimneylife.dao.shopping;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.abbot.schimneylife.pojo.shopping.YingLiOrder;

@Repository
public interface IYingLiOrderDao {

	void insert(YingLiOrder order)throws Exception;
	/**
	 * 条件分页查询
	 * @param firstResult
	 * @param pageSize
	 * @param like
	 * @param startTime
	 * @param endTime
	 * @return
	 * @throws Exception
	 */
	List<YingLiOrder> findByPage(@Param("firstResult")Integer firstResult,@Param("pageSize")Integer pageSize
			,@Param("like")String like,@Param("startTime")String startTime,@Param("endTime")String endTime)throws Exception;
	/**
	 * 根据条件统计总数量
	 * @param like
	 * @param startTime
	 * @param endTime
	 * @return
	 * @throws Exception
	 */
	Integer countTotal(@Param("like")String like,@Param("startTime")String startTime,@Param("endTime")String endTime)throws Exception;
	/**
	 * 修改订单交易状态
	 * @param status
	 * @param id
	 * @throws Exception
	 */
	void updateStatus(@Param("status")Integer status,@Param("id")String id)throws Exception;
}
