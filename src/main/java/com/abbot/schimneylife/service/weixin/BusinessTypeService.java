package com.abbot.schimneylife.service.weixin;

import java.util.List;

import com.abbot.schimneylife.pojo.weixin.BusinessType;

public interface BusinessTypeService {

	/**
	 * 新增数据
	 * @param type
	 * @return
	 */
	boolean insert(BusinessType type);
	/**
	 * 修改数据
	 * @param type
	 * @return
	 */
	boolean update(BusinessType type);
	/**
	 * 删除数据
	 * @param id
	 * @return
	 */
	boolean delete(Integer id);
	/**
	 * 查询所有商业类型
	 * @return
	 */
	List<BusinessType> findAll();
}
