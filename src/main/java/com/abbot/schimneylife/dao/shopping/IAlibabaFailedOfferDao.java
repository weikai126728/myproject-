package com.abbot.schimneylife.dao.shopping;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.abbot.schimneylife.pojo.shopping.AlibabaFailedOffer;

@Repository
public interface IAlibabaFailedOfferDao {

	/**
	 * 新增下单失败商品清单
	 * @param failedOffer
	 * @throws Exception
	 */
	void insert(AlibabaFailedOffer failedOffer)throws Exception;
	/**
	 * 根据offerid 和specid 查找
	 * @param offerID
	 * @param specID
	 * @return
	 * @throws Exception
	 */
	AlibabaFailedOffer fetchByOfferIDAndSpecID(@Param("offerID")String offerID,@Param("specID")String specID)throws Exception;
}
