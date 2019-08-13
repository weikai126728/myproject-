package com.abbot.schimneylife.service.shopping;

import java.math.BigDecimal;
import java.util.List;

import javax.validation.constraints.NotNull;

import com.abbot.schimneylife.pojo.shopping.CustomerOrder;
import com.abbot.schimneylife.pojo.shopping.CustomerShippingAddress;
import com.abbot.schimneylife.pojo.shopping.MallCart;
import com.abbot.schimneylife.pojo.shopping.MallProduct;
import com.abbot.schimneylife.pojo.shopping.MallProductParameter;

public interface CustomerOrderService {

	/**
	 * 新增用户订单
	 * @param order
	 * @return
	 */
	void addOrder(CustomerOrder order,List<MallCart> mallCartList,CustomerShippingAddress address)throws Exception;
	/**
	 * 立即下单时，对单个商品下单接口
	 * @param order
	 * @param product
	 * @param address
	 * @param parameter
	 * @throws Exception
	 */
	void addOrder(CustomerOrder order,MallProduct product,CustomerShippingAddress address,MallProductParameter parameter,Integer count)throws Exception;
	/**
	 * 查找不同状态的订单列表
	 * @param cumstomerId
	 * @param status
	 * @return
	 */
	List<CustomerOrder> findByStatus(Integer cumstomerId,Integer status,Integer firstResult,Integer pageSize);
	/**
	 * 计算不同状态的订单数量
	 * @param cumstomerId
	 * @param status
	 * @return
	 */
	Integer countByStatus(Integer cumstomerId,Integer status);
	/**
	 * 修改订单状态
	 * @param orderId
	 * @param status
	 * @return
	 */
	void updateStatus(Integer customerId, String orderId,Integer status)throws Exception;
	/**
	 * 查找指定订单
	 * @param customerId
	 * @param orderId
	 * @return
	 */
	CustomerOrder findById(Integer customerId, String orderId);
	/**
	 * 设置订单flag状态
	 * @param customerId
	 * @param orderId
	 * @param flag
	 * @return
	 */
	boolean setFlag(Integer customerId, String orderId,Integer flag);
	/**
	 * 统计总订单数量
	 * @return
	 */
	Integer countTotal();
	/**
	 * 统计总交易额
	 * @return
	 */
	BigDecimal tradingVolume();
	/**
	 * 统计指定状态，月份的订单数量
	 * @param status
	 * @param month
	 * @return
	 */
	Integer countByStatusAndMonth(Integer status,Integer month);
	/**
	 * 查询指定状态的订单在1-12月中的数量
	 * @param status
	 * @return
	 */
	Integer[] countByStatus(Integer status);
	/**
	 * 根据阿里巴巴订单ID查询
	 * @param orderID
	 * @return
	 */
	CustomerOrder fetchByOrderID(String orderID);
	/**
	 * 分页查询
	 * @param like
	 * @param order
	 * @param sort
	 * @param firstResult
	 * @param pageSize
	 * @return
	 */
	List<CustomerOrder> findByPage(String createTime,String like,String order,String sort,Integer firstResult,Integer pageSize);
	/**
	 * 统计总数量
	 * @param like
	 * @return
	 */
	Integer countTotal(String createTime,String like);
	/**
	 * 分页查询未发货
	 * @param like
	 * @param order
	 * @param sort
	 * @param firstResult
	 * @param pageSize
	 * @return
	 */
	List<CustomerOrder> findNoSendByPage(String createTime,String like,String order,String sort,Integer firstResult,Integer pageSize);
	/**
	 * 统计未发货数量
	 * @param like
	 * @return
	 */
	Integer countNoSendTotal(String createTime,String like);
	/**
	 * 分页查询未结算订单
	 * @param createTime
	 * @param like
	 * @param order
	 * @param sort
	 * @param firstResult
	 * @param pageSize
	 * @return
	 */
	List<CustomerOrder> findNoSettlementByPage(String createTime,String like,String order,String sort,Integer firstResult,Integer pageSize);
	/**
	 * 分页查询已结算订单
	 * @param createTime
	 * @param like
	 * @param order
	 * @param sort
	 * @param firstResult
	 * @param pageSize
	 * @return
	 */
	List<CustomerOrder> findSettlementByPage(String createTime,String like,String order,String sort,Integer firstResult,Integer pageSize);
	/**
	 * 统计已结算订单
	 * @param createTime
	 * @param like
	 * @return
	 */
	Integer countSettlementTotal(String createTime,String like);
	/**
	 * 统计未结算订单
	 * @param createTime
	 * @param like
	 * @return
	 */
	Integer countNoSettlementTotal(String createTime,String like);
	/**
	 * 关闭超过5天的待付款订单
	 * @return
	 */
	boolean closeOverdueNoPayOrder();
	/**
	 * 卖家修改价格后订单同步
	 * @param customerOrderId
	 * @param amount 卖家修改后价格
	 * @return
	 */
	boolean modifyOrderPrice(String customerOrderId,BigDecimal amount);
	/**
	 * 修改超过10天的待收货状态订单为已收货待评价
	 * @return
	 */
	boolean closeOverduiNoGotOrder();
	/**
	 * 分页查询已结算未发货订单
	 * @param createTime
	 * @param like
	 * @param order
	 * @param sort
	 * @param firstResult
	 * @param pageSize
	 * @return
	 */
	List<CustomerOrder> findNoSendSettlement(String createTime,String like,String order,String sort,Integer firstResult,Integer pageSize);
	/**
	 * 统计已结算未发货订单
	 * @param createTime
	 * @param like
	 * @return
	 */
	Integer countNoSendSettlement(String createTime,String like);
	/**
	 * 根据产品和用户id筛选订单
	 * @param startTime 开始搜索时间
	 * @param endTime 结束搜索时间
	 * @param firstResult 开始查询条数
	 * @param pageSize 每页数据量
	 * @param like 模糊查询
	 * @param productIds 指定商品集合
	 * @param userIds 指定用户集合
	 * @param column 排序字段
	 * @param sort 排序规则
	 * @param success 是否只查询交易成功的数据
	 * @return
	 */
	List<CustomerOrder> findByPageAndProduct(String startTime,String endTime,Integer firstResult,Integer pageSize,String like,String[] productIds,Integer[] userIds,String column,String sort,@NotNull boolean success,String create_time);
	List<CustomerOrder> findByPageAndProductByTime(String startTime,String endTime,Integer firstResult,Integer pageSize,String like,String[] productIds,Integer[] userIds,String column,String sort,@NotNull boolean success,String create_time);
	/**
	 * 根据产品和用户id统计订单数量
	 * @param startTime 开始搜索时间
	 * @param endTime 结束搜索时间
	 * @param like 模糊查询
	 * @param productIds指定商品集合
	 * @param userIds 指定用户集合
	 * @param success是否只查询交易成功的数据
	 * @return
	 */
	Integer countTotalByProduct(String startTime,String endTime,String like,String[] productIds,Integer[] userIds,@NotNull boolean success);
	/**
	 * 根据产品和用户id统计总金额
	 * @param startTime 开始搜索时间
	 * @param endTime 结束搜索时间
	 * @param like 模糊查询
	 * @param productIds 指定商品集合
	 * @param userIds 指定用户集合
	 * @param success 是否只查询交易成功的数据
	 * @return
	 */
	Double sumTotalByProduct(String startTime,String endTime,String like,String[] productIds,Integer[] userIds,@NotNull boolean success);
	Double sumTotalByWanghonProduct(String startTime,String endTime,String like,String[] productIds,Integer[] userIds,@NotNull boolean success);
	boolean updateCashbackStatus(String customerOrderId ,Integer cashbackStatus);
}
