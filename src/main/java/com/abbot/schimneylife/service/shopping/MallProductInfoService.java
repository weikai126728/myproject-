package com.abbot.schimneylife.service.shopping;

import com.abbot.schimneylife.pojo.shopping.MallProductInfo;

/**
 * 商品详情信息
 * @author Administrator
 *
 */
public interface MallProductInfoService {

	/**
	 * 添加商品信息详情图片
	 * @param proInfo
	 * @return
	 */
	boolean add(MallProductInfo proInfo);
	/**
	 * 查找制定商品的详情图片
	 * @param proId
	 * @return
	 */
	MallProductInfo fetchByProId(String proId);
}
