package com.abbot.schimneylife.dao.shopping;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.abbot.schimneylife.pojo.shopping.MarketProductInfo;
import com.abbot.schimneylife.pojo.shopping.SupermarketInfo;

public interface BenefitDao {
	List<SupermarketInfo> findCoalition()throws Exception;
	/**
	 * 禁用
	 * 
	 * @param marketId
	 * @return
	 */
	boolean disable(@Param("id")Integer marketId)throws Exception;

	/**
	 * 启用
	 * 
	 * @param marketId
	 * @return
	 */
	boolean enable(@Param("id")Integer marketId)throws Exception;
	List<MarketProductInfo> findAllBenefit()throws Exception;
	/**
	 * 禁用
	 * 
	 * @param marketId
	 * @return
	 */
	boolean benefitstop(@Param("id")Integer marketId)throws Exception;

	/**
	 * 启用
	 * 
	 * @param marketId
	 * @return
	 */
	boolean benefitstart(@Param("id")Integer marketId)throws Exception;
	
	void addProduct(SupermarketInfo product)throws Exception;
	SupermarketInfo fetchById(@Param("id")Integer marketId)throws Exception;
	void updateProduct(SupermarketInfo product)throws Exception;
	void addBenefit(MarketProductInfo product)throws Exception;
	MarketProductInfo findBenefitByid(@Param("id")Integer marketId)throws Exception;
	void updateBenefit(MarketProductInfo product)throws Exception;

	boolean deletebit(@Param("id")Integer marketId);
	boolean deletecon(@Param("id")Integer marketId);
}
