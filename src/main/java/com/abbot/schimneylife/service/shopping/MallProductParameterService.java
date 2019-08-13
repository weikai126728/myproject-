package com.abbot.schimneylife.service.shopping;

import java.util.List;

import com.abbot.schimneylife.pojo.shopping.MallProductParameter;

public interface MallProductParameterService {

	/**
	 * 添加产品参数
	 * @param param
	 * @return
	 */
	boolean addParameter(MallProductParameter param);
	/**
	 * 查找最低现价参数
	 * @param proId
	 * @return
	 */
	MallProductParameter fetchLowerByProId(String proId);
	/**
	 * 获取指定商品的规格列表
	 * @param proId
	 * @return
	 */
	List<String> getSpecByProId(String proId);
	/**
	 * 获取指定商品的口味列表
	 * @param proId
	 * @return
	 */
	List<String> getTasteByProId(String proId);
	/**
	 * 查找指定商品的所有参数
	 * @param productId
	 * @return
	 */
	List<MallProductParameter> findByProductId(String productId);
	void deleteById(String id)throws Exception;
	MallProductParameter fetchById(String id);
}
