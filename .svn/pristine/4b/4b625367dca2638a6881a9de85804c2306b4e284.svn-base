package com.abbot.schimneylife.dao.weixin;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.abbot.schimneylife.pojo.weixin.CommissionSettlement;

@Repository
public interface ICommissionSettlementDao {

	/**
	 * 新增结算单
	 * @param settlement
	 * @throws Exception
	 */
	void insert(CommissionSettlement settlement)throws Exception;
	
	/**
	 * 已结算成功佣金求和
	 * @return
	 * @throws Exception
	 */
	Integer sumSuccess(@Param("product_id")String product_id,@Param("startTime")String startTime,@Param("endTime")String endTime)throws Exception;
	/**
	 * 新建佣金结算单和交易单关联关系
	 * @param amountId
	 * @param settlementId
	 * @throws Exception
	 */
	void insertRelation(@Param("amountId")Integer amountId,@Param("settlementId")String settlementId,@Param("percent")Integer percent)throws Exception;
	/**
	 * 根据条件分页查询
	 * @param search
	 * @param startTime
	 * @param endTime
	 * @param order
	 * @param sort
	 * @param firstResult
	 * @param pageSize
	 * @return
	 * @throws Exception
	 */
	List<CommissionSettlement> findByPage(@Param("search")String search,@Param("startTime")String startTime,@Param("endTime")String endTime
			,@Param("order")String order,@Param("sort")String sort,@Param("firstResult")Integer firstResult,@Param("pageSize")Integer pageSize)throws Exception;
	/**
	 * 根据条件统计数量
	 * @param search
	 * @param startTime
	 * @param endTime
	 * @return
	 * @throws Exception
	 */
	Integer totalCount(@Param("search")String search,@Param("startTime")String startTime,@Param("endTime")String endTime)throws Exception;
}
