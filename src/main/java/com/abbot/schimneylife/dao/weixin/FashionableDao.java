package com.abbot.schimneylife.dao.weixin;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.abbot.schimneylife.pojo.weixin.Receivers;

public interface FashionableDao {
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
	List<Receivers> findByPage(@Param("firstResult")Integer firstResult,@Param("pageSize")Integer pageSize,@Param("like")String like,@Param("column")String column,@Param("sort")String sort
			,@Param("startTime")String startTime,@Param("endTime")String endTime)throws Exception;

	/**
	 * 根据条件统计数量
	 * @param like
	 * @param startTime
	 * @param endTime
	 * @return
	 * @throws Exception
	 */
	Integer countTotal(@Param("like")String like,String startTime,String endTime)throws Exception;
	Receivers findfashionable(@Param("id")Integer id)throws Exception;
	void updatefindfashionable(Receivers receivers)throws Exception;
	void deletfashionable(@Param("id")Integer id)throws Exception;
	void addfindfashionable(Receivers receivers)throws Exception;
}
