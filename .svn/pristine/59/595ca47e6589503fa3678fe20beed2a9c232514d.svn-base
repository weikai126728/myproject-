package com.abbot.schimneylife.service.shopping;

import java.util.List;

import com.abbot.schimneylife.pojo.shopping.CustomerFootmark;

public interface CustomerFootmarkService {

	/**
	 * 新增足迹
	 * @param mark
	 * @return
	 */
	boolean addMark(CustomerFootmark mark);
	/**
	 * 删除指定天数前的记录
	 * @param customerId
	 * @param days
	 * @return
	 */
	boolean delete(Integer customerId,Integer days);
	/**
	 * 分页查询
	 * @param firstResult
	 * @param pageSize
	 * @param customerId
	 * @return
	 */
	List<CustomerFootmark> findByPage(Integer firstResult,Integer pageSize,Integer customerId);
	/**
	 * 根据日期查找足迹
	 * @param customerId
	 * @param date
	 * @return
	 */
	List<CustomerFootmark> findByDate(Integer customerId,String date);
	/**
	 * 根据日期统计数量
	 * @param customerId
	 * @param date
	 * @return
	 */
	Integer countByDate(Integer customerId,String date);
	/**
	 * 查询总数量
	 * @param customerId
	 * @return
	 */
	Integer countTotal(Integer customerId);
	/**
	 * 批量删除
	 * @param ids
	 * @param customerId
	 * @return
	 */
	boolean deleteByIds(String ids,Integer customerId);
	/**
	 * 是否需要记录
	 * @param customerId
	 * @param productId
	 * @return
	 */
	boolean isNeedMark(Integer customerId,String productId);
}
