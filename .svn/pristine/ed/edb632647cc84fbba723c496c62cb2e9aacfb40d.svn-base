package com.abbot.schimneylife.dao.shopping;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.abbot.schimneylife.pojo.shopping.CustomerFootmark;

@Repository
public interface ICustomerFootmarkDao {

	/**
	 * 添加我的足迹
	 * @param footmark
	 * @throws Exception
	 */
	void insert(CustomerFootmark footmark)throws Exception;
	
	/**
	 * 删除指定用户几天前的数据
	 * @param customerId
	 * @param days
	 * @throws Exception
	 */
	void deleteBeforeDays(@Param("customerId")Integer customerId,@Param("days")Integer days)throws Exception;
	/**
	 * 分页查询我的足迹
	 * @param firstRsult
	 * @param pageSize
	 * @param customerId
	 * @return
	 * @throws Exception
	 */
	List<CustomerFootmark> findByPage(@Param("firstResult")Integer firstResult,@Param("pageSize")Integer pageSize,@Param("customerId")Integer customerId)throws Exception;
	/**
	 * 根据日期查询
	 * @param customerId
	 * @param date
	 * @return
	 * @throws Exception
	 */
	List<CustomerFootmark> findByDate(@Param("customerId")Integer customerId,@Param("date")String date)throws Exception;
	/**
	 * 统计指定日期的数据数量
	 * @param customerId
	 * @param date
	 * @return
	 * @throws Exception
	 */
	Integer countByDate(@Param("customerId")Integer customerId,@Param("date")String date)throws Exception;
	/**
	 * 查询总数量
	 * @param customerId
	 * @return
	 * @throws Exception
	 */
	Integer countTotal(@Param("customerId")Integer customerId)throws Exception;
	/**
	 * 批量删除我的足迹
	 * @param map
	 * @throws Exception
	 */
	void deleteByIds(Map<String,Object> map)throws Exception;
	/**
	 * 查询当天是否有重复数据
	 * @param customerId
	 * @param productId
	 * @return
	 * @throws Exception
	 */
	Integer fetchNumToday(@Param("customerId")Integer customerId,@Param("productId")String productId)throws Exception;
}
