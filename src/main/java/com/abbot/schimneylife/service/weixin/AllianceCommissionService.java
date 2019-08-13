package com.abbot.schimneylife.service.weixin;

import java.util.List;

import com.abbot.schimneylife.pojo.weixin.AllianceCommission;

public interface AllianceCommissionService {

	/**
	 * 新增数据
	 * @throws Exception
	 */
	void insert(AllianceCommission[] acs)throws Exception;
	/**
	 * 根据编号删除数据
	 * @throws Exception
	 */
	boolean delete(String product_id);
	/**
	 * 根据编号查找数据
	 * @param product_id
	 * @return
	 * @throws Exception
	 */
	List<AllianceCommission> findByProductId(String product_id);
}
