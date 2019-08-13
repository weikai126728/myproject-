package com.abbot.schimneylife.dao.shopping;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.abbot.schimneylife.pojo.shopping.CustomerOrder;

@Repository
public interface ICustomerOrderDao {

	/**
	 * 新建订单
	 * @param order
	 * @throws Exception
	 */
	void insert(CustomerOrder order)throws Exception;
	/**
	 * 查找指定用户，指定状态的订单列表
	 * @param cumstomerId
	 * @param status
	 * @return
	 * @throws Exception
	 */
	List<CustomerOrder> findByStatus(@Param("customerId")Integer customerId,@Param("status")Integer status,@Param("firstResult")Integer firstResult,@Param("pageSize")Integer pageSize)throws Exception;
	/**
	 * 计算指定用户，指定状态的订单数量
	 * @param cumstomerId
	 * @param status
	 * @return
	 * @throws Exception
	 */
	Integer countByStatus(@Param("customerId")Integer customerId,@Param("status")Integer status)throws Exception;
	/**
	 * 修改指定订单的状态
	 * @param orderId
	 * @param status
	 * @param cumstomerId
	 * @throws Exception
	 */
	void updateStatus(@Param("customerId")Integer customerId,@Param("orderId")String orderId,@Param("status")Integer status)throws Exception;
	/**
	 * 获取指定订单信息
	 * @param cumstomerId
	 * @param orderId
	 * @return
	 * @throws Exception
	 */
	CustomerOrder findById(@Param("customerId")Integer customerId,@Param("orderId")String orderId)throws Exception;
	/**
	 * 根据id查找
	 * @param id
	 * @return
	 * @throws Exception
	 */
	CustomerOrder fetchById(@Param("id")String id)throws Exception;
	/**
	 * 修改flag状态
	 * @param customerId
	 * @param orderId
	 * @param flag
	 * @throws Exception
	 */
	void updateFlag(@Param("customerId")Integer customerId,@Param("orderId")String orderId,@Param("flag")Integer flag)throws Exception;
	/**
	 * 统计总订单数
	 * @return
	 * @throws Exception
	 */
	Integer countTotal()throws Exception;
	/**
	 * 统计总交易金额 （1,2,3,4状态统计）
	 * @return
	 * @throws Exception
	 */
	BigDecimal countMoney()throws Exception;
	/**
	 * 统计指定状态，指定月份的订单数量
	 * @param status
	 * @param month
	 * @return
	 * @throws Exception
	 */
	Integer countByStatusAndMonth(@Param("status")Integer status,@Param("month")Integer month)throws Exception;
	void update(CustomerOrder order)throws Exception;
	/**
	 * 根据阿里巴巴订单id查询
	 * @param orderID
	 * @return
	 * @throws Exception
	 */
	CustomerOrder fetchByOrderID(String orderID)throws Exception;
	/**
	 * 分页查询
	 * @param like
	 * @param order
	 * @param sort
	 * @param firstResult
	 * @param pageSize
	 * @return
	 * @throws Exception
	 */
	List<CustomerOrder> findByPage(@Param("createTime")String createTime,@Param("like")String like,@Param("status")Integer status,@Param("order")String order,@Param("sort")String sort
			,@Param("firstResult")Integer firstResult,@Param("pageSize")Integer pageSize)throws Exception;
	/**
	 * 根据条件统计总数量
	 * @param like
	 * @return
	 * @throws Exception
	 */
	Integer countTotalByLike(@Param("createTime")String createTime,@Param("like")String like,@Param("status")Integer status)throws Exception;
	/**
	 * 关闭超过5天的待付款订单
	 * @throws Exception
	 */
	void closeOverdueNoPayOrder()throws Exception;
	/**
	 * 卖家修改价格后订单同步
	 * @param customerOrderId
	 * @param amount
	 * @throws Exception
	 */
	void modifyOrderPrice(@Param("id")String customerOrderId,@Param("amount")BigDecimal amount)throws Exception;
	/**
	 * 修改超过10天的待收货状态订单为已收货待评价
	 * @throws Exception
	 */
	void closeOverduiNoGotOrder()throws Exception;
	/**
	 * 根据产品和用户id筛选订单
	 * @param map
	 * @return
	 * @throws Exception
	 */
	List<CustomerOrder> findByPageAndProduct(Map<String,Object> map)throws Exception;
	List<CustomerOrder> findByPageAndProductByTime(Map<String,Object> map)throws Exception;
	/**
	 * 根据产品和用户id统计订单数量
	 * @param map
	 * @return
	 * @throws Exception
	 */
	Integer countTotalByProduct(Map<String,Object> map)throws Exception;
	/**
	 * 根据产品和用户id统计总金额
	 * @param map
	 * @return
	 * @throws Exception
	 */
	Double sumTotalByProduct(Map<String,Object> map)throws Exception;
	Double sumTotalByWanghonProduct(Map<String,Object> map)throws Exception;
	/**
	 * 分页查询已结算订单
	 * @param createTime
	 * @param like
	 * @param order
	 * @param sort
	 * @param firstResult
	 * @param pageSize
	 * @return
	 * @throws Exception
	 */
	List<CustomerOrder> findSettlementByPage(@Param("createTime")String createTime,@Param("like")String like,@Param("order")String order,@Param("sort")String sort
			,@Param("firstResult")Integer firstResult,@Param("pageSize")Integer pageSize)throws Exception;
	/**
	 * 统计已结算订单数量
	 * @param createTime
	 * @param like
	 * @return
	 * @throws Exception
	 */
	Integer countSettlementByLike(@Param("createTime")String createTime,@Param("like")String like)throws Exception;
}
