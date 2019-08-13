package com.abbot.schimneylife.dao.shopping;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.abbot.schimneylife.pojo.shopping.SupermarketActivity;

@Repository
public interface ISupermarketActivityDao {

	/**
	 * 查询指定超市的活动列表
	 * @param supermarketId
	 * @return
	 * @throws Exception
	 */
	List<SupermarketActivity> findActivityByMarketId(@Param("supermarketId")Integer supermarketId)throws Exception;
	void insert(SupermarketActivity activity)throws Exception;
	void update(SupermarketActivity activity)throws Exception;
	void delete(@Param("id")String id)throws Exception;
}
