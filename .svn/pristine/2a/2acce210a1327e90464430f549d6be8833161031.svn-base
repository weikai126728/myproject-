package com.abbot.schimneylife.service.weixin;

import java.util.List;

import com.abbot.schimneylife.pojo.weixin.AmountOrder;
import com.abbot.schimneylife.pojo.weixin.TsServiceFee;

public interface AmountorderService {

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
	 */
	List<AmountOrder> findByPage(Integer firstResult,Integer pageSize,String like,String column,String sort
			,String startTime,String endTime,Integer salesmanId);
	List<AmountOrder> findByproduct_id(Integer firstResult,Integer pageSize,String like,String column,String sort
			,String startTime,String endTime,String product_id);
	/**
	 * 统计数量
	 * @param like
	 * @param startTime
	 * @param endTime
	 * @return
	 */
	Integer countTotal(String like,String startTime,String endTime,Integer salesmanId);
	Integer countTotal(String like,String startTime,String endTime,String product_id);
	/**
	 * 计算总金额
	 * @param like
	 * @param startTime
	 * @param endTime
	 * @return
	 */
	Integer totalAmount(String like,String startTime,String endTime,Integer salesmanId);
	Integer totalAmount(String like,String startTime,String endTime,String product_id);
	/**
	 * 计算总金额
	 * @param like
	 * @param startTime
	 * @param endTime
	 * @return
	 */
	Integer sumAmount(String product_id,String startTime,String endTime,Integer salesmanId);
	Integer countAmount(String product_id,String startTime,String endTime,Integer salesmanId);
	/**
	 * 根据条件统计交易额
	 * @param product_ids 商户编号合集
	 * @param startTime 开始统计时间
	 * @param endTime 结束统计时间
	 * @return
	 */
	Integer countAmountByAllianceIds(List<Integer> alids,String startTime,String endTime);
	/**
	 * 未结算佣金交易求和
	 * @param product_id
	 * @param startTime
	 * @param endTime
	 * @return
	 */
	Integer noCommissionSum(String product_id,String startTime,String endTime);
	/**
	 * 未结算佣金交易列表
	 * @param product_id
	 * @param startTime
	 * @param endTime
	 * @return
	 */
	List<AmountOrder> noCommissionList(String product_id,String startTime,String endTime);
	TsServiceFee findServiceFee(String product_id);
	void insertServicefee(String product_id);
	boolean updateSfee(TsServiceFee servicefee);
}
