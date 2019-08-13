package com.abbot.schimneylife.dao.weixin;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.abbot.schimneylife.pojo.weixin.OrderPayment;

@Repository
public interface IOrderPaymentDao {

	List<OrderPayment> findByPage(@Param("firstResult")Integer firstResult,@Param("pageSize")Integer pageSize
			,@Param("userId")Integer userId,@Param("startTime")String startTime,@Param("endTime")String endTime
			,@Param("column")String column,@Param("sort")String sort,@Param("openId")String openId,@Param("search")String search)throws Exception;
	Integer countTotal(@Param("userId")Integer userId,@Param("startTime")String startTime
			,@Param("endTime")String endTime,@Param("openId")String openId,@Param("search")String search)throws Exception;
	Integer countTrade(@Param("userId")Integer userId,@Param("startTime")String startTime
			,@Param("endTime")String endTime,@Param("openId")String openId,@Param("search")String search)throws Exception;
}
