package com.abbot.schimneylife.service.shopping;

import java.util.List;

import com.abbot.schimneylife.pojo.shopping.MarketProductInfo;
import com.abbot.schimneylife.pojo.shopping.SupermarketInfo;

public interface BenefitService {
	List<SupermarketInfo> findCoalition();
	/**
	 * 禁用
	 * 
	 * @param marketId
	 * @return
	 */
	boolean disable(Integer marketId);

	/**
	 * 启用
	 * 
	 * @param marketId
	 * @return
	 */
	boolean enable(Integer marketId);
	List<MarketProductInfo> findAllBenefit();
	/**
	 * 禁用
	 * 
	 * @param marketId
	 * @return
	 */
	boolean benefitstop(Integer marketId);

	/**
	 * 启用
	 * 
	 * @param marketId
	 * @return
	 */
	boolean benefitstart(Integer marketId);
	void addProduct(SupermarketInfo product);
	SupermarketInfo fetchById(Integer marketId);
	void updateProduct(SupermarketInfo product);
	void addBenefit(MarketProductInfo product);
	MarketProductInfo findBenefitByid(Integer marketId);
	void updateBenefit(MarketProductInfo product);


	boolean deletebit(Integer marketId);
	boolean deletecon(Integer marketId);
}
