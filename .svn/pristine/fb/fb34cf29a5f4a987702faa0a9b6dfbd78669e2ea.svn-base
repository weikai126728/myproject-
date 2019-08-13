package com.abbot.schimneylife.dao.weixin;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.abbot.schimneylife.pojo.weixin.OrdermerRedpack;

@Repository
public interface IOrdermerRedpackDao {

	/**
	 * 分页查询
	 * @param firstResult
	 * @param pageSize
	 * @param like
	 * @param column
	 * @param sort
	 * @param startTime
	 * @param endTime
	 * @return
	 * @throws Exception
	 */
	List<OrdermerRedpack> findByPage(@Param("firstResult")Integer firstResult,@Param("pageSize")Integer pageSize,@Param("like")String like,@Param("column")String column,@Param("sort")String sort
			,@Param("startTime")String startTime,@Param("endTime")String endTime)throws Exception;
	/**
	 * 统计数量
	 * @param like
	 * @param startTime
	 * @param endTime
	 * @return
	 * @throws Exception
	 */
	Integer countTotal(@Param("like")String like,@Param("startTime")String startTime,@Param("endTime")String endTime)throws Exception;
	/**
	 * 统计金额
	 * @param like
	 * @param startTime
	 * @param endTime
	 * @return
	 * @throws Exception
	 */
	Integer countRedpack(@Param("like")String like,@Param("startTime")String startTime,@Param("endTime")String endTime)throws Exception;
}
