package com.abbot.schimneylife.service.shopping;

import java.util.List;

import com.abbot.schimneylife.pojo.shopping.MallProductBanner;

public interface MallProductBannerService {

	/**
	 * 查找指定商品的轮播图
	 * @param proId
	 * @return
	 */
	List<MallProductBanner> findByProId(String proId);
}
