package com.abbot.schimneylife.service.weixin;

import java.util.List;

import com.abbot.schimneylife.pojo.weixin.CommissionSettlement;

public interface CommissionSettlementService {
	/**
	 * 新增结算单
	 * @param settlement
	 */
	boolean insert(CommissionSettlement settlement);
	/**
	 *  已结算成功佣金求和
	 * @param product_id
	 * @param startTime
	 * @param endTime
	 * @return
	 */
	Integer sumSuccess(String product_id,String startTime,String endTime);
	/**
	 * 新建佣金结算单和交易单关联关系
	 * @param amountId
	 * @param settlementId
	 * @return
	 */
	boolean insertRelation(Integer amountId,String settlementId,Integer percent);
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
	 */
	List<CommissionSettlement> findByPage(String search,String startTime,String endTime,String order,String sort,Integer firstResult,Integer pageSize);
	/**
	 * 根据条件统计数量
	 * @param search
	 * @param startTime
	 * @param endTime
	 * @return
	 */
	Integer totalCount(String search,String startTime,String endTime);
}
