package com.abbot.schimneylife.service.weixin;

import java.util.List;

import com.abbot.schimneylife.pojo.weixin.Commission;

public interface CommissionService {

	/**
	 * 新增佣金比例数据
	 * @param commission
	 * @return
	 */
	boolean insert(Commission commission);
	/**
	 * 根据id删除佣金比例数据
	 * @param id
	 * @return
	 */
	boolean delete(Integer id);
	/**
	 * 修改佣金比例数据
	 * @param commission
	 * @return
	 */
	boolean update(Commission commission);
	/**
	 * 分页查询
	 * @param search
	 * @param typeId
	 * @param modelId
	 * @param order
	 * @param sort
	 * @param firstResult
	 * @param pageSize
	 * @return
	 */
	List<Commission> findByPage(String search,Integer typeId,Integer modelId,String order,String sort,Integer firstResult,Integer pageSize);
	/**
	 * 统计数量
	 * @param search
	 * @param typeId
	 * @param modelId
	 * @return
	 */
	Integer totalCount(String search,Integer typeId,Integer modelId);
	/**
	 * 根据条件查询佣金比例
	 * @param businessTypeId
	 * @param modelId
	 * @param zipCode
	 * @return
	 */
	Integer fetchByCondition(Integer businessTypeId,Integer modelId,String zipCode);
	/**
	 * 根据条件查询私有可执行佣金比例
	 * @param typeId
	 * @param product_id
	 * @return
	 */
	Integer fetchPriByCondition(Integer typeId,String product_id);
	/**
	 * 根据条件查询佣金比例
	 * @param typeId
	 * @param modelId
	 * @return
	 */
	Commission fetchByTypeAndModel(Integer typeId,Integer modelId);
}
