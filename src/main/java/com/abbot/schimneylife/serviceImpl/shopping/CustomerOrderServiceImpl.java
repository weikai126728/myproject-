package com.abbot.schimneylife.serviceImpl.shopping;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.abbot.schimneylife.dao.shopping.IAlibabaFailedOfferDao;
import com.abbot.schimneylife.dao.shopping.IAlibabaOrderDao;
import com.abbot.schimneylife.dao.shopping.ICustomerOrderDao;
import com.abbot.schimneylife.dao.shopping.IMallCartDao;
import com.abbot.schimneylife.dao.shopping.IMallOrderDao;
import com.abbot.schimneylife.dao.shopping.IMallProductAlibabaDao;
import com.abbot.schimneylife.dao.shopping.IShoppingCartDao;
import com.abbot.schimneylife.pojo.shopping.AlibabaFailedOffer;
import com.abbot.schimneylife.pojo.shopping.AlibabaOrder;
import com.abbot.schimneylife.pojo.shopping.CustomerOrder;
import com.abbot.schimneylife.pojo.shopping.CustomerShippingAddress;
import com.abbot.schimneylife.pojo.shopping.MallCart;
import com.abbot.schimneylife.pojo.shopping.MallOrder;
import com.abbot.schimneylife.pojo.shopping.MallProduct;
import com.abbot.schimneylife.pojo.shopping.MallProductAlibaba;
import com.abbot.schimneylife.pojo.shopping.MallProductParameter;
import com.abbot.schimneylife.service.shopping.AlibabaService;
import com.abbot.schimneylife.service.shopping.CustomerOrderService;
import com.abbot.schimneylife.util.CommonKey;
import com.alibaba.trade.param.AlibabaTradeCancelParam;
import com.alibaba.trade.param.AlibabaTradeCancelResult;
import com.alibaba.trade.param.AlibabaTradeFastAddress;
import com.alibaba.trade.param.AlibabaTradeFastCargo;
import com.alibaba.trade.param.AlibabaTradeFastCreateOrderParam;
import com.alibaba.trade.param.AlibabaTradeFastCreateOrderResult;
import com.alibaba.trade.param.AlibabaTradeFastOffer;


@Service
public class CustomerOrderServiceImpl implements CustomerOrderService {
	private static final Logger logger = Logger.getLogger(CustomerOrderServiceImpl.class);
	
	@Resource
	private ICustomerOrderDao orderDao;
	@Resource
	private IMallProductAlibabaDao aliDao;
	@Resource
	private AlibabaService alibabaService;
	@Resource
	private IAlibabaOrderDao aliOrderDao;
	@Resource
	private IAlibabaFailedOfferDao failedDao;
	@Resource
	private IMallOrderDao mallOrderDao;
	@Resource
	private IShoppingCartDao shoppingDao;
	@Resource
	private IMallCartDao cartDao;
	@Transactional(rollbackFor=Exception.class)
	@Override
	public void addOrder(CustomerOrder order,List<MallCart> mallCartList,CustomerShippingAddress address) throws Exception{
		if(order.getSource()==CommonKey.ProductSource.SELFSUPPORT.getSource()) {//如果是自营商品则直接下单
			orderDao.insert(order);
		}else {
			AlibabaTradeFastCreateOrderResult result = alibabaService.fastCreateOrder(this.transfer(order, mallCartList, address));
			AlibabaOrder alibaba = new AlibabaOrder();
			alibaba.setResultCode(result.getSuccess()?1:0);//下单成功
			alibaba.setErrorCode(result.getCode());
			alibaba.setErrorMessage(result.getMessage());
			if(result.getSuccess()) {//阿里下单成功
				order.setStatus(CommonKey.Order.NO_PAY.getStatus());
				
			}else {//阿里下单失败
				order.setStatus(CommonKey.Order.FAILED.getStatus());//设置状态为下单失败
			}
			List<AlibabaFailedOffer> failedList = new ArrayList<>();
			if(result.getResult()!=null) {
				alibaba.setTotalSuccessAmount(result.getResult().getTotalSuccessAmount());
				AlibabaTradeFastOffer[] fasts = result.getResult().getFailedOfferList();
				if(fasts!=null&&fasts.length>0) {
					alibaba.setFailed(1);
					for(AlibabaTradeFastOffer fast:fasts) {
						AlibabaFailedOffer offer = new AlibabaFailedOffer();
						offer.setErrorCode(fast.getErrorCode());
						offer.setErrorMessage(fast.getErrorMessage());
						offer.setOfferID(fast.getOfferId());
						offer.setSpecID(fast.getSpecId());
						failedList.add(offer);
					}
				}else {
					alibaba.setFailed(0);
				}
				BigDecimal amount = new BigDecimal(result.getResult().getTotalSuccessAmount());
				order.setSuccessAmount(amount.divide(new BigDecimal(100)));
			}
			orderDao.insert(order);
			alibaba.setCustomerOrderId(order.getId());
			alibaba.setOrderID(result.getResult().getOrderId());
			aliOrderDao.insert(alibaba);
			for(AlibabaFailedOffer offer:failedList) {
				offer.setAlibabaOrderId(alibaba.getId());
				failedDao.insert(offer);
			}
		}
		int total = 0;
		BigDecimal amount = new BigDecimal(0);
		for(MallCart cart:mallCartList) {
			MallOrder mallOrder = new MallOrder();
			mallOrder.setCurrent(cart.getProduct().getParameter().getCur_price());
			mallOrder.setCustomerOrderId(order.getId());
			mallOrder.setOriginal(cart.getProduct().getParameter().getOriginal());
			mallOrder.setParamId(cart.getProduct().getParameter().getId());
			mallOrder.setProductId(cart.getProduct().getId());
			mallOrder.setSettlement(cart.getProduct().getParameter().getCur_price());
			mallOrder.setTotal(cart.getTotalCount());
			if(order.getSource()==CommonKey.ProductSource.SELFSUPPORT.getSource()) {
				mallOrder.setStatus(1);
				total += cart.getTotalCount();
				amount = amount.add(cart.getTotalMoney());
			}else {
				MallProductAlibaba proAli = aliDao.fetchByParamId(cart.getProduct().getParameter().getId());
				AlibabaFailedOffer failed = failedDao.fetchByOfferIDAndSpecID(proAli.getProductID(), proAli.getSpecID());
				if(failed!=null&&failed.getId()!=null) {
					mallOrder.setStatus(0);//设置此mallorder交易失败
				}else {
					mallOrder.setStatus(1);
					total += cart.getTotalCount();
					amount = amount.add(cart.getTotalMoney());
				}
			}
			
			mallOrderDao.insert(mallOrder);
		}
		order.setAmount(amount);
		order.setCount(total);
		orderDao.update(order);
		for(MallCart cart:mallCartList) {
			cartDao.delete(cart.getId());
			Integer count = cartDao.countByShoppingCartId(cart.getShoppingCartId());
			if(count==0) {
				shoppingDao.deleteById(cart.getShoppingCartId());
			}
		}
	}
	
	@Override
	public void addOrder(CustomerOrder order, MallProduct product, CustomerShippingAddress address,
			MallProductParameter parameter,Integer count) throws Exception {
		if(order.getSource()==CommonKey.ProductSource.SELFSUPPORT.getSource()) {//如果是自营商品则直接下单
			orderDao.insert(order);
		}else {
			AlibabaTradeFastCreateOrderResult result = alibabaService.fastCreateOrder(this.transfer(order, product, address,parameter,count));
			AlibabaOrder alibaba = new AlibabaOrder();
			alibaba.setResultCode(result.getSuccess()?1:0);//下单成功
			alibaba.setErrorCode(result.getCode());
			alibaba.setErrorMessage(result.getMessage());
			if(result.getSuccess()) {//阿里下单成功
				order.setStatus(CommonKey.Order.NO_PAY.getStatus());
				
			}else {//阿里下单失败
				order.setStatus(CommonKey.Order.FAILED.getStatus());//设置状态为下单失败
			}
			List<AlibabaFailedOffer> failedList = new ArrayList<>();
			if(result.getResult()!=null) {
				alibaba.setTotalSuccessAmount(result.getResult().getTotalSuccessAmount());
				AlibabaTradeFastOffer[] fasts = result.getResult().getFailedOfferList();
				if(fasts!=null&&fasts.length>0) {
					alibaba.setFailed(1);
					for(AlibabaTradeFastOffer fast:fasts) {
						AlibabaFailedOffer offer = new AlibabaFailedOffer();
						offer.setErrorCode(fast.getErrorCode());
						offer.setErrorMessage(fast.getErrorMessage());
						offer.setOfferID(fast.getOfferId());
						offer.setSpecID(fast.getSpecId());
						failedList.add(offer);
					}
				}else {
					alibaba.setFailed(0);
				}
				BigDecimal amount = new BigDecimal(0);
				if(result.getResult().getTotalSuccessAmount()!=null) {
					amount = new BigDecimal(result.getResult().getTotalSuccessAmount());					
				}
				order.setSuccessAmount(amount.divide(new BigDecimal(100)));
			}
			orderDao.insert(order);
			alibaba.setCustomerOrderId(order.getId());
			alibaba.setOrderID(result.getResult().getOrderId());
			aliOrderDao.insert(alibaba);
			for(AlibabaFailedOffer offer:failedList) {
				offer.setAlibabaOrderId(alibaba.getId());
				failedDao.insert(offer);
			}
		}
		BigDecimal amount = parameter.getCur_price().multiply(new BigDecimal(count));
		MallOrder mallOrder = new MallOrder();
		mallOrder.setCurrent(parameter.getCur_price());
		mallOrder.setCustomerOrderId(order.getId());
		mallOrder.setOriginal(parameter.getOriginal());
		mallOrder.setParamId(parameter.getId());
		mallOrder.setProductId(product.getId());
		mallOrder.setSettlement(parameter.getCur_price());
		mallOrder.setTotal(count);
		if(order.getSource()==CommonKey.ProductSource.SELFSUPPORT.getSource()) {
			mallOrder.setStatus(1);
		}else {
			MallProductAlibaba proAli = aliDao.fetchByParamId(parameter.getId());
			AlibabaFailedOffer failed = failedDao.fetchByOfferIDAndSpecID(proAli.getProductID(), proAli.getSpecID());
			if(failed!=null&&failed.getId()!=null) {
				mallOrder.setStatus(0);//设置此mallorder交易失败
			}else {
				mallOrder.setStatus(1);
			}
		}
		
		mallOrderDao.insert(mallOrder);
		order.setAmount(amount);
		order.setCount(count);
		orderDao.update(order);
	}
	private AlibabaTradeFastCreateOrderParam transfer(CustomerOrder order,MallProduct product,CustomerShippingAddress shipping,MallProductParameter parameter,Integer count)throws Exception{
		AlibabaTradeFastCreateOrderParam param = new AlibabaTradeFastCreateOrderParam(); 
		param.setFlow("general");//大市场普通订单：general，代销订单：saleproxy 
		if(order.getMessage()!=null&&!order.getMessage().isEmpty()) {
			param.setMessage(order.getMessage()); 			
		}
		AlibabaTradeFastAddress address = new AlibabaTradeFastAddress();
		String[] places = shipping.getAddress().split(" ");
		if(places.length!=3) {
			throw new Exception("地址信息不完整    address "+shipping.getAddress());
		}
		if(shipping.getContactPhone()==null||shipping.getContactPhone().isEmpty()) {
			throw new Exception("联系方式不完整    phone "+shipping.getContactPhone());
		}
		address.setProvinceText(places[0]); 
		address.setCityText(places[1]); 
		address.setAreaText(places[2]); 
		address.setAddress(shipping.getPlace()); 
		address.setFullName(shipping.getContactUser()); 
		address.setMobile(shipping.getContactPhone()); 
		param.setAddressParam(address); 
		List<AlibabaTradeFastCargo> cargoList = new ArrayList<AlibabaTradeFastCargo>();
		MallProductAlibaba alibaba = aliDao.fetchByParamId(parameter.getId());
		AlibabaTradeFastCargo cargo = new AlibabaTradeFastCargo(); 
		cargo.setOfferId(Long.valueOf(alibaba.getProductID())); 
		cargo.setSpecId(alibaba.getSpecID()); 
		cargo.setQuantity(Double.valueOf(count)); 
		cargoList.add(cargo); 
		param.setCargoParamList(cargoList.toArray(new AlibabaTradeFastCargo[]{}));
		return param;
	}
	private AlibabaTradeFastCreateOrderParam transfer(CustomerOrder order,List<MallCart> mallCartList,CustomerShippingAddress shipping) throws Exception {
		AlibabaTradeFastCreateOrderParam param = new AlibabaTradeFastCreateOrderParam(); 
		param.setFlow("general");//大市场普通订单：general，代销订单：saleproxy 
		if(order.getMessage()!=null&&!order.getMessage().isEmpty()) {
			param.setMessage(order.getMessage()); 			
		}
		AlibabaTradeFastAddress address = new AlibabaTradeFastAddress();
		String[] places = shipping.getAddress().split(" ");
		if(places.length!=3) {
			throw new Exception("地址信息不完整    address "+shipping.getAddress());
		}
		if(shipping.getContactPhone()==null||shipping.getContactPhone().isEmpty()) {
			throw new Exception("联系方式不完整    phone "+shipping.getContactPhone());
		}
		address.setProvinceText(places[0]); 
		address.setCityText(places[1]); 
		address.setAreaText(places[2]); 
		address.setAddress(shipping.getPlace()); 
		address.setFullName(shipping.getContactUser()); 
		address.setMobile(shipping.getContactPhone()); 
		param.setAddressParam(address); 
		List<AlibabaTradeFastCargo> cargoList = new ArrayList<AlibabaTradeFastCargo>();
		for(MallCart cart:mallCartList) {
			MallProductAlibaba alibaba = aliDao.fetchByParamId(cart.getProduct().getParameter().getId());
			AlibabaTradeFastCargo cargo = new AlibabaTradeFastCargo(); 
			cargo.setOfferId(Long.valueOf(alibaba.getProductID())); 
			cargo.setSpecId(alibaba.getSpecID()); 
			cargo.setQuantity(Double.valueOf(cart.getTotalCount())); 
			cargoList.add(cargo); 
		}
		param.setCargoParamList(cargoList.toArray(new AlibabaTradeFastCargo[]{}));
		return param;
	}
	@Override
	public List<CustomerOrder> findByStatus(Integer cumstomerId, Integer status,Integer firstResult,Integer pageSize) {
		List<CustomerOrder> orderList = Collections.emptyList();
		try {
			orderList = orderDao.findByStatus(cumstomerId, status,firstResult,pageSize);
		} catch (Exception e) {
			logger.error("查找不同状态的订单列表异常！",e);
		}
		return orderList;
	}
	@Override
	public Integer countByStatus(Integer cumstomerId, Integer status) {
		try {
			return orderDao.countByStatus(cumstomerId, status);
		} catch (Exception e) {
			logger.error("计算不同状态的订单数量异常！",e);
			return 0;
		}
	}
	@Transactional(rollbackFor=Exception.class)
	@Override
	public void updateStatus(Integer customerId, String orderId, Integer status)throws Exception {
		CustomerOrder order = orderDao.findById(customerId, orderId);
		if(order.getSource()!=CommonKey.ProductSource.SELFSUPPORT.getSource()) {//如果不是自营，操作阿里订单
			if(status==CommonKey.Order.CANCEL.getStatus()&&order.getStatus()==CommonKey.Order.NO_PAY.getStatus()) {//只有待付款的订单取消时，同步阿里数据
				AlibabaOrder aliOrder = aliOrderDao.fetchByCustomerOrderId(orderId);
				AlibabaTradeCancelParam cancel = new AlibabaTradeCancelParam();
				cancel.setWebSite("1688");
				cancel.setCancelReason("买家取消订单");
				cancel.setTradeID(Long.valueOf(aliOrder.getOrderID()));
				AlibabaTradeCancelResult result=alibabaService.tradeCancel(cancel);
				if(result==null) {
					logger.error("取消阿里订单，阿里未响应，orderId:"+orderId+" 阿里订单orderID:"+aliOrder.getOrderID());
					throw new Exception();
				} else if(result.getSuccess()) {
							
				}else {
					logger.error("errorCode="+result.getErrorCode()+" errorMessage="+result.getErrorMessage());
				}				
			}
		}
		orderDao.updateStatus(customerId,orderId, status);			
	}
	@Override
	public CustomerOrder findById(Integer customerId, String orderId) {
		try {
			return orderDao.findById(customerId, orderId);
		} catch (Exception e) {
			logger.error("查找指定订单异常！",e);
			return new CustomerOrder();
		}
	}
	@Override
	public boolean setFlag(Integer customerId, String orderId, Integer flag) {
		try {
			orderDao.updateFlag(customerId, orderId, flag);
			return true;
		} catch (Exception e) {
			logger.error("设置订单flag状态异常！",e);
			return false;
		}
	}
	@Override
	public Integer countTotal() {
		try {
			return orderDao.countTotal();
		} catch (Exception e) {
			logger.error("统计总订单数量异常！",e);
			return 0;
		}
	}
	@Override
	public BigDecimal tradingVolume() {
		try {
			return orderDao.countMoney();
		} catch (Exception e) {
			return new BigDecimal(0);
		}
	}
	@Override
	public Integer countByStatusAndMonth(Integer status, Integer month) {
		try {
			return orderDao.countByStatusAndMonth(status, month);
		} catch (Exception e) {
			logger.error("统计指定状态，月份的订单数量异常！",e);
			return 0;
		}
	}
	@Override
	public Integer[] countByStatus(Integer status) {
		Integer[] orders = new Integer[12];
		try {
			for(int i=0;i<12;i++) {
				orders[i] = orderDao.countByStatusAndMonth(status, i+1);
			}
		} catch (Exception e) {
			logger.error("查询指定状态的订单在1-12月中的数量异常！",e);
		}
		return orders;
	}
	@Override
	public CustomerOrder fetchByOrderID(String orderID) {
		try {
			return orderDao.fetchByOrderID(orderID);
		} catch (Exception e) {
			logger.error("根据阿里巴巴订单ID查询",e);
			return null;
		}
	}
	@Override
	public List<CustomerOrder> findByPage(String createTime,String like, String order, String sort, Integer firstResult,
			Integer pageSize) {
		List<CustomerOrder> orderList = Collections.emptyList();
		try {
			orderList = orderDao.findByPage(createTime,like,null, order, sort, firstResult, pageSize);
		} catch (Exception e) {
			logger.error("分页查询异常",e);
		}
		return orderList;
	}
	@Override
	public Integer countTotal(String createTime,String like) {
		try {
			return orderDao.countTotalByLike(createTime,like,null);
		} catch (Exception e) {
			logger.error("统计总数量",e);
			return 0;
		}
	}
	@Override
	public List<CustomerOrder> findNoSendByPage(String createTime,String like, String order, String sort, Integer firstResult,
			Integer pageSize) {
		List<CustomerOrder> orderList = Collections.emptyList();
		try {
			orderList = orderDao.findByPage(createTime,like, CommonKey.Order.NO_SEND_NO_SETTLEMENT.getStatus()*10+CommonKey.Order.NO_SEND_SETTLEMENT.getStatus(), order, sort, firstResult, pageSize);
		} catch (Exception e) {
			logger.error("分页查询未发货",e);
		}
		return orderList;
	}
	@Override
	public Integer countNoSendTotal(String createTime,String like) {
		try {
			return orderDao.countTotalByLike(createTime,like, CommonKey.Order.NO_SEND_NO_SETTLEMENT.getStatus()*10+CommonKey.Order.NO_SEND_SETTLEMENT.getStatus());
		} catch (Exception e) {
			logger.error("统计未发货数量",e);
			return 0;
		}
	}
	
	@Override
	public List<CustomerOrder> findNoSettlementByPage(String createTime, String like, String order, String sort,
			Integer firstResult, Integer pageSize) {
		List<CustomerOrder> orderList = Collections.emptyList();
		try {
			orderList = orderDao.findByPage(createTime, like, CommonKey.Order.NO_SEND_NO_SETTLEMENT.getStatus(), order, sort, firstResult, pageSize);
		} catch (Exception e) {
			logger.error("分页查询未结算订单",e);
		}
		return orderList;
	}
	@Override
	public Integer countNoSettlementTotal(String createTime, String like) {
		try {
			return orderDao.countTotalByLike(createTime, like, CommonKey.Order.NO_SEND_NO_SETTLEMENT.getStatus());
		} catch (Exception e) {
			logger.error("统计未结算订单数量",e);
			return 0;
		}
	}
	@Override
	public boolean closeOverdueNoPayOrder() {
		boolean res = false;
		try {
			orderDao.closeOverdueNoPayOrder();
			return true;
		} catch (Exception e) {
			logger.error("关闭超过7天的待付款订单失败",e);
		}
		return res;
	}
	@Override
	public boolean modifyOrderPrice(String customerOrderId, BigDecimal amount) {
		try {
			orderDao.modifyOrderPrice(customerOrderId, amount);
			return true;
		} catch (Exception e) {
			logger.error("卖家修改价格后订单同步",e);
			return false;
		}
	}
	@Override
	public boolean closeOverduiNoGotOrder() {
		try {
			orderDao.closeOverduiNoGotOrder();
			return true;
		} catch (Exception e) {
			logger.error("修改超过10天的待收货状态订单为已收货待评价",e);
			return false;
		}
	}

	@Override
	public List<CustomerOrder> findNoSendSettlement(String createTime, String like, String order, String sort,
			Integer firstResult, Integer pageSize) {
		List<CustomerOrder> orderList = Collections.emptyList();
		try {
			orderList = orderDao.findByPage(createTime,like, CommonKey.Order.NO_SEND_SETTLEMENT.getStatus(), order, sort, firstResult, pageSize);
		} catch (Exception e) {
			logger.error("分页查询未发货",e);
		}
		return orderList;
	}

	@Override
	public Integer countNoSendSettlement(String createTime, String like) {
		try {
			return orderDao.countTotalByLike(createTime,like, CommonKey.Order.NO_SEND_SETTLEMENT.getStatus());
		} catch (Exception e) {
			logger.error("统计未发货数量",e);
			return 0;
		}
	}

	@Override
	public List<CustomerOrder> findByPageAndProduct(String startTime, String endTime, Integer firstResult,
			Integer pageSize, String like, String[] productIds, Integer[] userIds, String column, String sort,
			boolean success,String create_time) {
		List<CustomerOrder> orderList = Collections.emptyList();
		Map<String,Object> map = new HashMap<>();
		map.put("startTime", startTime);
		map.put("endTime", endTime);
		map.put("firstResult", firstResult);
		map.put("pageSize", pageSize);
		map.put("like", like);
		map.put("productIds", productIds);
		map.put("userIds", userIds);
		map.put("column", column);
		map.put("sort", sort);
		map.put("success", success);
		map.put("create_time", create_time);
		try {
			orderList = orderDao.findByPageAndProduct(map);
		} catch (Exception e) {
			logger.error("根据产品和用户id筛选订单",e);
		}
		return orderList;
	}
	
	@Override
	public List<CustomerOrder> findByPageAndProductByTime(String startTime, String endTime, Integer firstResult,
			Integer pageSize, String like, String[] productIds, Integer[] userIds, String column, String sort,
			boolean success,String create_time) {
		List<CustomerOrder> orderList = Collections.emptyList();
		Map<String,Object> map = new HashMap<>();
		map.put("startTime", startTime);
		map.put("endTime", endTime);
		map.put("firstResult", firstResult);
		map.put("pageSize", pageSize);
		map.put("like", like);
		map.put("productIds", productIds);
		map.put("userIds", userIds);
		map.put("column", column);
		map.put("sort", sort);
		map.put("success", success);
		map.put("create_time", create_time);
		try {
			orderList = orderDao.findByPageAndProductByTime(map);
		} catch (Exception e) {
			logger.error("根据产品和用户id筛选订单",e);
		}
		return orderList;
	}

	@Override
	public Integer countTotalByProduct(String startTime, String endTime, String like, String[] productIds,
			Integer[] userIds, boolean success) {
		Integer total = 0;
		Map<String,Object> map = new HashMap<>();
		map.put("startTime", startTime);
		map.put("endTime", endTime);
		map.put("like", like);
		map.put("productIds", productIds);
		map.put("userIds", userIds);
		map.put("success", success);
		try {
			total = orderDao.countTotalByProduct(map);
		} catch (Exception e) {
			logger.error("根据产品和用户id统计订单数量异常",e);
		}
		return total;
	}

	@Override
	public Double sumTotalByProduct(String startTime, String endTime, String like, String[] productIds,
			Integer[] userIds, boolean success) {
		Double money = 0d;
		Map<String,Object> map = new HashMap<>();
		map.put("startTime", startTime);
		map.put("endTime", endTime);
		map.put("like", like);
		map.put("productIds", productIds);
		map.put("userIds", userIds);
		map.put("success", success);
		try {
			money = orderDao.sumTotalByProduct(map);
		} catch (Exception e) {
			logger.error("根据产品和用户id统计总金额",e);
		}
		return money==null?0d:money;
	}

	@Override
	public boolean updateCashbackStatus(String customerOrderId, Integer cashbackStatus) {
		CustomerOrder order = new CustomerOrder();
		order.setId(customerOrderId);
		order.setCashbackStatus(cashbackStatus);
		boolean res = false;
		try {
			orderDao.update(order);
			res = true;
		} catch (Exception e) {
			logger.error(e);
		}
		return res;
	}

	@Override
	public Double sumTotalByWanghonProduct(String startTime, String endTime, String like, String[] productIds,
			Integer[] userIds, boolean success) {
		Double money = 0d;
		Map<String,Object> map = new HashMap<>();
		map.put("startTime", startTime);
		map.put("endTime", endTime);
		map.put("like", like);
		map.put("productIds", productIds);
		map.put("userIds", userIds);
		map.put("success", success);
		try {
			money = orderDao.sumTotalByWanghonProduct(map);
		} catch (Exception e) {
			logger.error("根据产品和用户id统计总金额",e);
		}
		return money;
	}

	@Override
	public List<CustomerOrder> findSettlementByPage(String createTime, String like, String order, String sort,
			Integer firstResult, Integer pageSize) {
		List<CustomerOrder> orderList = Collections.emptyList();
		try {
			orderList = orderDao.findSettlementByPage(createTime, like, order, sort, firstResult, pageSize);
		} catch (Exception e) {
			logger.error("分页查询已结算订单",e);
		}
		return orderList;
	}

	@Override
	public Integer countSettlementTotal(String createTime, String like) {
		Integer total = 0;
		try {
			total = orderDao.countSettlementByLike(createTime, like);
		} catch (Exception e) {
			logger.error("统计已结算订单",e);
		}
		return total;
	}

}
