package com.abbot.schimneylife.dao.weixin;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.abbot.schimneylife.pojo.weixin.AmountOrder;
import com.abbot.schimneylife.pojo.weixin.TsServiceFee;

@Repository
public interface IAmountOrderDao {

	/**
	 * 分页查询
	 * @param firstResult
	 * @param pageSize
	 * @param like
	 * @param column
	 * @param sort
	 * @param startTime
	 * @param endTime
	 * @return
	 * @throws Exception
	 */
	List<AmountOrder> findByPage(@Param("firstResult")Integer firstResult,@Param("pageSize")Integer pageSize,@Param("like")String like,@Param("column")String column,@Param("sort")String sort
			,@Param("startTime")String startTime,@Param("endTime")String endTime,@Param("salesmanId")Integer salesmanId)throws Exception;
	List<AmountOrder> findByproduct_id(@Param("firstResult")Integer firstResult,@Param("pageSize")Integer pageSize,@Param("like")String like,@Param("column")String column,@Param("sort")String sort
			,@Param("startTime")String startTime,@Param("endTime")String endTime,@Param("product_id")String product_id)throws Exception;
	/**
	 * 根据条件统计数量
	 * @param like
	 * @param startTime
	 * @param endTime
	 * @return
	 * @throws Exception
	 */
	Integer countTotal(@Param("like")String like,@Param("startTime")String startTime,@Param("endTime")String endTime,@Param("salesmanId")Integer salesmanId)throws Exception;
	Integer countTotalByProduct_id(@Param("like")String like,@Param("startTime")String startTime,@Param("endTime")String endTime,@Param("product_id")String product_id)throws Exception;
	Integer totalAmount(@Param("like")String like,@Param("startTime")String startTime,@Param("endTime")String endTime,@Param("salesmanId")Integer salesmanId)throws Exception;
	Integer totalAmountByProduct_id(@Param("like")String like,@Param("startTime")String startTime,@Param("endTime")String endTime,@Param("product_id")String product_id)throws Exception;
	/**
	 * 根据时间，统计指定商户集合的营业额
	 * @param map ids必须，startTime endTime
	 * @return
	 * @throws Exception
	 */
	Integer countAmountByAllianceIds(Map<String,Object> map)throws Exception;
	/**
	 * 未结算佣金交易额
	 * @param product_id
	 * @return
	 * @throws Exception
	 */
	Integer noCommissionSum(@Param("product_id")String product_id,@Param("startTime")String startTime,@Param("endTime")String endTime)throws Exception;
	/**
	 * 未结算佣金交易列表
	 * @param product_id
	 * @param startTime
	 * @param endTime
	 * @return
	 * @throws Exception
	 */
	List<AmountOrder> noCommissionList(@Param("product_id")String product_id,@Param("startTime")String startTime,@Param("endTime")String endTime)throws Exception;
	/**
	 * 计算商户今天的交易额
	 * @param product_id
	 * @param startTime
	 * @param endTime
	 * @param salesmanId
	 * @return
	 */
	Integer sumAmount(@Param("product_id")String product_id,@Param("startTime")String startTime,@Param("endTime")String endTime,@Param("salesmanId")Integer salesmanId)throws Exception;
	Integer countAmount(@Param("product_id")String product_id,@Param("startTime")String startTime,@Param("endTime")String endTime,@Param("salesmanId")Integer salesmanId)throws Exception;
	TsServiceFee findServiceFee(@Param("product_id")String product_id)throws Exception;
	void insertServicefee(@Param("product_id")String product_id)throws Exception;
	void updateSfee(TsServiceFee servicefee)throws Exception;
}
