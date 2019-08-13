package com.abbot.schimneylife.dao.shopping;

import java.math.BigDecimal;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.abbot.schimneylife.pojo.shopping.MallOrder;

@Repository
public interface IMallOrderDao {

	/**
	 * 新增在线商城订单
	 * @param order
	 * @throws Exception
	 */
	void insert(MallOrder order)throws Exception;
	/**
	 * 查找用户订单中在线商城订单列表
	 * @param customerOrderID
	 * @return
	 * @throws Exception
	 */
	List<MallOrder> findMallOrderList(@Param("customerOrderID")String customerOrderID)throws Exception;
	MallOrder selectMsg(@Param("id") String id)throws Exception;
	
	BigDecimal selectAmount(@Param("id") String id) throws Exception;
}
