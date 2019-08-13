package com.abbot.schimneylife.dao.weixin;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.abbot.schimneylife.pojo.weixin.TsSwitch;

public interface AllianceSwitchDao {

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
	List<TsSwitch> findByPage(@Param("firstResult")Integer firstResult,@Param("pageSize")Integer pageSize,@Param("like")String like,@Param("column")String column,@Param("sort")String sort
			,@Param("startTime")String startTime,@Param("endTime")String endTime,@Param("salesmanId")Integer salesmanId)throws Exception;
	/**
	 * 根据条件统计数量
	 * @param like
	 * @param startTime
	 * @param endTime
	 * @return
	 * @throws Exception
	 */
	Integer countTotal(@Param("like")String like,@Param("startTime")String startTime,@Param("endTime")String endTime,@Param("salesmanId")Integer salesmanId)throws Exception;
	/**
	 * 禁用
	 * 
	 * @param id
	 */
	void disable(@Param("id") Integer id) throws Exception;

	/**
	 * 启用
	 * 
	 * @param id
	 */
	void enable(@Param("id") Integer id) throws Exception;
}
