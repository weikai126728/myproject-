package com.abbot.schimneylife.controller.manager;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.abbot.schimneylife.controller.BaseController;
import com.abbot.schimneylife.pojo.shopping.AlibabaOrder;
import com.abbot.schimneylife.pojo.shopping.AlibabaTidingsLog;
import com.abbot.schimneylife.pojo.shopping.CustomerOrder;
import com.abbot.schimneylife.pojo.shopping.MallOrder;
import com.abbot.schimneylife.pojo.shopping.WeiXinPayLog;
import com.abbot.schimneylife.pojo.user.User;
import com.abbot.schimneylife.service.shopping.AlibabaOrderService;
import com.abbot.schimneylife.service.shopping.AlibabaService;
import com.abbot.schimneylife.service.shopping.AlibabaTidingsLogService;
import com.abbot.schimneylife.service.shopping.CustomerOrderService;
import com.abbot.schimneylife.service.shopping.WeiXinPayLogService;
import com.abbot.schimneylife.service.user.UserOperationLogService;
import com.abbot.schimneylife.service.user.UserService;
import com.abbot.schimneylife.util.CommonKey;
import com.abbot.schimneylife.util.ConfigureUtil;
import com.abbot.schimneylife.util.ExcelUtil;
import com.abbot.schimneylife.util.SessionManager;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.trade.param.AlibabaAlipayUrlGetParam;
import com.alibaba.trade.param.AlibabaAlipayUrlGetResult;

@RequestMapping("/manager/order")
@Controller
public class CustomerOrderManagerController extends BaseController {

	private static final Logger logger = Logger.getLogger(CustomerOrderManagerController.class);
	/**
	 * 1688订单发货
	 */
	private final String ORDER_ANNOUNCE_SENDGOODS = "ORDER-ANNOUNCE_SENDGOODS";// 1688订单发货
	private final String ORDER_ORDER_BOPS_CLOSE = "ORDER-ORDER_BOPS_CLOSE";// 1688运营后台关闭订单
	private final String ORDER_ORDER_PRICE_MODIFY = "ORDER-ORDER_PRICE_MODIFY";// 1688修改订单价格
	private final String ORDER_ORDER_SELLER_CLOSE = "ORDER-ORDER_SELLER_CLOSE";// 1688卖家关闭订单
	private final String ORDER_ORDER_COMFIRM_RECEIVEGOODS = "ORDER-ORDER_COMFIRM_RECEIVEGOODS";// 1688订单确认收货
	private final String ORDER_ORDER_SUCCESS = "ORDER-ORDER_SUCCESS";// 1688交易成功
	private final String ORDER_PAY = "ORDER_PAY";// 1688交易付款

	@Resource
	private CustomerOrderService orderService;
	@Resource
	private AlibabaTidingsLogService logService;
	@Resource
	private AlibabaOrderService alibabaOrderService;
	@Resource
	private AlibabaService alibabaService;
	@Resource
	private UserOperationLogService operationLogService;
	@Resource
	private UserService userService;
	@Resource
	private WeiXinPayLogService wxLogService;
	
	/**
	 * 
	 * @param orderID
	 *            订单ID
	 * @param currentStatus
	 *            当前订单状态
	 * @param msgSendTime
	 *            消息发送时间
	 * @param buyerMemberId
	 *            买家中文站会员ID
	 */
	@RequestMapping("/alibaba")
	public void alibabaTidings() {
		int totalBytes = request.getContentLength();
		byte[] data = new byte[totalBytes];
		DataInputStream in = null;
		try {
			in = new DataInputStream(request.getInputStream());
			in.readFully(data); // 根据长度，将消息实体的内容读入字节数组dataOrigin中
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (in != null)
				try {
					in.close();// 关闭数据流
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}

		Map<String, String> map = new HashMap<>();
		String reqcontent = new String(data); // 从字节数组中得到表示实体的字符串
		try {
			String str = URLDecoder.decode(reqcontent, "utf-8");
			String[] keys = str.split("&");
			for (String k : keys) {
				String[] kv = k.split("=");
				if (kv.length == 2) {
					map.put(kv[0], kv[1]);
				}
			}
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		JSONObject message = JSONObject.parseObject(map.get("message"));
		String userInfo = message.getString("userInfo");
		String type = message.getString("type");
		JSONObject datas = message.getJSONObject("data");
		String orderId = datas.getString("orderId");
		CustomerOrder order = orderService.fetchByOrderID(orderId);
		AlibabaTidingsLog log = new AlibabaTidingsLog();
		log.setAop_signature(map.get("_aop_signature"));
		log.setCustomerOrderId(order.getId());
		log.setMsgSendTime(datas.getString("msgSendTime"));
		log.setOrderID(orderId);
		if (ConfigureUtil.ALIBABA_USERID.toString().equals(userInfo)) {// 判断是否是同一个userid
			if (this.ORDER_ANNOUNCE_SENDGOODS.equals(type)) {// 发货通知
				if (order != null && order.getStatus() == CommonKey.Order.NO_SEND_SETTLEMENT.getStatus()) {
					try {
						orderService.updateStatus(order.getCustomerId(), order.getId(),
								CommonKey.Order.NO_GOT.getStatus());
					} catch (Exception e) {
						logger.error("接受订阅消息，将订单 customer_order_id=" + order.getId() + " 修改为待收货状态失败！", e);
					}
				}
				log.setMessageType("1688订单发货");
				logService.insert(log);
			} else if (this.ORDER_ORDER_BOPS_CLOSE.equals(type)) {// 1688运营后台关闭订单
				log.setMessageType("1688运营后台关闭订单");
				logService.insert(log);
			} else if (this.ORDER_ORDER_PRICE_MODIFY.equals(type)) {// 1688修改订单价格
				log.setMessageType("1688修改订单价格");
				logService.insert(log);
			} else if (this.ORDER_ORDER_SELLER_CLOSE.equals(type)) {// 1688卖家关闭订单
				log.setMessageType("1688卖家关闭订单");
				logService.insert(log);
			} else if (this.ORDER_ORDER_COMFIRM_RECEIVEGOODS.equals(type)) {// 1688订单确认收货
				log.setMessageType("买家确认收货");
				logService.insert(log);
			} else if (this.ORDER_ORDER_SUCCESS.equals(type)) {// 1688交易成功
				log.setMessageType("交易成功");
				logService.insert(log);
			} else if (this.ORDER_PAY.equals(type)) {// 1688交易付款
				try {
					if (order != null && order.getStatus() == CommonKey.Order.NO_SEND_NO_SETTLEMENT.getStatus()) {
						orderService.updateStatus(order.getCustomerId(), order.getId(),
								CommonKey.Order.NO_SEND_SETTLEMENT.getStatus());
					}
				} catch (Exception e) {
					logger.error("接受订阅消息，将订单 customer_order_id=" + order.getId() + " 修改为待发货已结算状态失败！", e);
				}

				log.setMessageType("交易付款");
				logService.insert(log);
			}
		}
	}

	/**
	 * 订单管理
	 * 
	 * @return
	 */
	@RequestMapping("/orderList")
	public ModelAndView orderList() {
		ModelAndView model = new ModelAndView("manager/order_manager");
		return model;
	}

	/**
	 * 发货处理
	 * 
	 * @return
	 */
	@RequestMapping("/orderSend")
	public ModelAndView orderSend() {
		ModelAndView model = new ModelAndView("manager/order_send");
		return model;
	}

	/**
	 * 订单管理分页查询
	 * 
	 * @param draw
	 * @param typeId
	 * @param start
	 * @param length
	 */
	@RequestMapping("/findByPage")
	public void findByPage(Integer draw, String createTime, Integer start, Integer length) {
		String search = request.getParameter("search[value]");
		if (search == null || search.isEmpty()) {
			search = null;
		}
		if ("".equals(createTime)) {
			createTime = null;
		}
		Integer orderCol = Integer.valueOf(request.getParameter("order[0][column]"));
		String order = request.getParameter("order[0][dir]");
		String column = "create_time";
		switch (orderCol) {

		}
		List<CustomerOrder> orderList = orderService.findByPage(createTime, search, column, order, start, length);
		JSONObject json = this.createJSONResult(CommonKey.SUCCESS_CODE, JSONArray.toJSON(orderList));
		json.put("draw", draw);
		Integer totalResult = orderService.countTotal();
		json.put("recordsTotal", totalResult);
		Integer totalFilterResult = orderService.countTotal(createTime, search);
		json.put("recordsFiltered", totalFilterResult);
		this.writeJSON(json.toJSONString());
	}
	/**
	 * 订单管理excel导出
	 */
	@RequestMapping("/excel")
	public void excel(String createTime,String search) {
		if (search == null || search.isEmpty()) {
			search = null;
		}
		if ("".equals(createTime)) {
			createTime = null;
		}
		List<CustomerOrder> orderList = orderService.findByPage(createTime, search, null, null, null, null);
		String[] header = new String[] {"订单编号","产品名称","总价","联系电话","联系人","数量","类型","状态"};
		List<Object[]> content = new ArrayList<>();
		for(CustomerOrder order:orderList) {
			Object[] obj = new Object[8];
			obj[0] = order.getNumber();
			StringBuffer productNames = new StringBuffer();
			List<MallOrder> mallList = order.getMallOrder();
			mallList.forEach(n->productNames.append(n.getProduct().getProductName()));
			obj[1] = productNames.toString();
			obj[2] = order.getAmount();
			obj[3] = order.getContactPhone();
			obj[4] = order.getContactUser();
			obj[5] = order.getCount();
			String source = "";
			if(order.getSource()==CommonKey.ProductSource.SELFSUPPORT.getSource()) {
				source = "自营";
			}else if(order.getSource()==CommonKey.ProductSource.AliBUY.getSource()) {
				source = "阿里采购";
			}else if(order.getSource()==CommonKey.ProductSource.AliPROXY.getSource()) {
				source = "阿里分销";
			}
			obj[6] = source;
			String status = "";
			if(order.getStatus()==CommonKey.Order.CANCEL.getStatus()) {
				status = "订单取消";
			}else if(order.getStatus()==CommonKey.Order.FAILED.getStatus()) {
				status = "交易失败";
			}else if(order.getStatus()==CommonKey.Order.NO_GOT.getStatus()) {
				status = "未收货";
			}else if(order.getStatus()==CommonKey.Order.NO_PAY.getStatus()) {
				status = "未付款";
			}else if(order.getStatus()==CommonKey.Order.NO_SEND_NO_SETTLEMENT.getStatus()) {
				status = "已付款未结算";
			}else if(order.getStatus()==CommonKey.Order.NO_SEND_SETTLEMENT.getStatus()) {
				status = "已结算未发货";
			}else if(order.getStatus()==CommonKey.Order.SUCCESS_EVALUATE.getStatus()) {
				status = "交易成功已评价";
			}else if(order.getStatus()==CommonKey.Order.SUCCESS_NO_EVALUATE.getStatus()) {
				status = "交易成功未评价";
			}
			obj[7] = status;
			content.add(obj);
		}
		HSSFWorkbook wb = ExcelUtil.createExcel(header, content);
		this.writeExcel(wb, "订单管理列表");
	}
	/**
	 * 发货处理分页查询
	 */
	@RequestMapping("/findNoSendByPage")
	public void findNoSendByPage(Integer draw, String createTime, Integer start, Integer length) {
		String search = request.getParameter("search[value]");
		if (search == null || search.isEmpty()) {
			search = null;
		}
		if ("".equals(createTime)) {
			createTime = null;
		}
		Integer orderCol = Integer.valueOf(request.getParameter("order[0][column]"));
		String order = request.getParameter("order[0][dir]");
		String column = "create_time";
		switch (orderCol) {

		}
		List<CustomerOrder> orderList = orderService.findNoSendSettlement(createTime, search, column, order, start,
				length);
		JSONObject json = this.createJSONResult(CommonKey.SUCCESS_CODE, JSONArray.toJSON(orderList));
		json.put("draw", draw);
		Integer totalResult = orderService.countNoSendSettlement(null, null);
		json.put("recordsTotal", totalResult);
		Integer totalFilterResult = orderService.countNoSendTotal(createTime, search);
		json.put("recordsFiltered", totalFilterResult);
		this.writeJSON(json.toJSONString());
	}

	/**
	 * 订单详情页
	 * 
	 * @param id
	 * @param customerId
	 * @return
	 */
	@RequestMapping("/details")
	public ModelAndView details(String id, Integer customerId) {
		ModelAndView model = new ModelAndView("manager/order_details");
		CustomerOrder order = orderService.findById(customerId, id);
		model.addObject("order", order);
		return model;
	}

	@RequestMapping("/sendGood")
	public void sendGood(String orderId, Integer customerId) {
		CustomerOrder order = orderService.findById(customerId, orderId);
		boolean res = false;
		try {
			if (order != null && order.getStatus() == CommonKey.Order.NO_SEND_SETTLEMENT.getStatus()) {
				orderService.updateStatus(customerId, orderId, CommonKey.Order.NO_GOT.getStatus());
				res = true;
				User user = SessionManager.getAttribute(request, SessionManager.Key.USER);
				operationLogService.insert(user.getId(), "确认发货", CommonKey.UserOperationLog.ORDER.getType(), orderId, "");
			}
		} catch (Exception e) {
			logger.error("修改为已发货状态异常", e);
		}
		this.writeJSON(this.createJSONResult(CommonKey.SUCCESS_CODE, res).toJSONString());
	}

	/**
	 * 发货处理
	 * 
	 * @return
	 */
	@RequestMapping("/orderSettlement")
	public ModelAndView orderSettlement() {
		ModelAndView model = new ModelAndView("manager/order_settlement");
		return model;
	}

	/**
	 * 获取未结算订单
	 * 
	 * @param draw
	 * @param createTime
	 * @param start
	 * @param length
	 */
	@RequestMapping("/findNoSettlementByPage")
	public void findNoSettlementByPage(Integer draw, String createTime, Integer start, Integer length) {
		String search = request.getParameter("search[value]");
		if (search == null || search.isEmpty()) {
			search = null;
		}
		if ("".equals(createTime)) {
			createTime = null;
		}
		Integer orderCol = Integer.valueOf(request.getParameter("order[0][column]"));
		String order = request.getParameter("order[0][dir]");
		String column = "create_time";
		switch (orderCol) {

		}
		List<CustomerOrder> orderList = orderService.findNoSettlementByPage(createTime, search, column,
				"asc".equals(order) ? "asc" : "desc", start, length);
		for (CustomerOrder o : orderList) {
			if (o.getSource() != CommonKey.ProductSource.SELFSUPPORT.getSource()) {
				AlibabaOrder ali = alibabaOrderService.fetchByCustomerOrderId(o.getId());
				o.setAlibaba(ali);
				;
			}
		}
		JSONObject json = this.createJSONResult(CommonKey.SUCCESS_CODE, JSONArray.toJSON(orderList));
		json.put("draw", draw);
		Integer totalResult = orderService.countNoSettlementTotal(null, null);
		json.put("recordsTotal", totalResult);
		Integer totalFilterResult = orderService.countNoSettlementTotal(createTime, search);
		json.put("recordsFiltered", totalFilterResult);
		this.writeJSON(json.toJSONString());
	}
	/**
	 * 跳往商城微信对账页面
	 * @return
	 */
	@RequestMapping("/wxAccount")
	public ModelAndView wxAccount() {
		ModelAndView model = new ModelAndView("manager/order_settlementwx");
		return model;
	}
	/**
	 * 获取已结算订单对账数据
	 * 
	 * @param draw
	 * @param createTime
	 * @param start
	 * @param length
	 */
	@RequestMapping("/findSettlementByPage")
	public void findSettlementByPage(Integer draw, String createTime, Integer start, Integer length) {
		String search = request.getParameter("search[value]");
		if (search == null || search.isEmpty()) {
			search = null;
		}
		if ("".equals(createTime)) {
			createTime = null;
		}
		Integer orderCol = Integer.valueOf(request.getParameter("order[0][column]"));
		String order = request.getParameter("order[0][dir]");
		String column = "create_time";
		switch (orderCol) {
		
		}
		List<CustomerOrder> orderList = orderService.findSettlementByPage(createTime, search, column,
				"asc".equals(order) ? "asc" : "desc", start, length);
		for (CustomerOrder o : orderList) {
			if (o.getSource() != CommonKey.ProductSource.SELFSUPPORT.getSource()) {
				AlibabaOrder ali = alibabaOrderService.fetchByCustomerOrderId(o.getId());
				o.setAlibaba(ali);
			}
			WeiXinPayLog log = wxLogService.fetchByOrderId(o.getId(), 0);
			o.setWxLog(log);
		}
		JSONObject json = this.createJSONResult(CommonKey.SUCCESS_CODE, JSONArray.toJSON(orderList));
		json.put("draw", draw);
		Integer totalResult = orderService.countSettlementTotal(null, null);
		json.put("recordsTotal", totalResult);
		Integer totalFilterResult = orderService.countSettlementTotal(createTime, search);
		json.put("recordsFiltered", totalFilterResult);
		this.writeJSON(json.toJSONString());
	}
	/**
	 * 已结算订单对账数据excel导出
	 */
	@RequestMapping("/wxExcel")
	public void wxExcel(String createTime,String search) {
		if (search == null || search.isEmpty()) {
			search = null;
		}
		if (createTime!=null&&"".equals(createTime.trim())) {
			createTime = null;
		}
		List<CustomerOrder> orderList = orderService.findSettlementByPage(createTime, search, "create_time",
				"desc", null, null);
		String[] header = new String[] {"订单编号","流水单号","总价","结算金额(阿里)","状态"};
		List<Object[]> content = new ArrayList<>();
		for(CustomerOrder order:orderList) {
			Object[] obj = new Object[5];
			WeiXinPayLog payLog = wxLogService.fetchByOrderId(order.getId(), 0);
			
			obj[0] = order.getNumber();
			obj[1] = payLog==null?"":payLog.getTransaction_id();
			obj[2] = order.getAmount();
			if (order.getSource() != CommonKey.ProductSource.SELFSUPPORT.getSource()) {
				AlibabaOrder ali = alibabaOrderService.fetchByCustomerOrderId(order.getId());
				obj[3] = ali==null?-1L:ali.getTotalSuccessAmount();
			}else {
				obj[3] = 0;
			}
			String status = "";
			if(order.getStatus()==CommonKey.Order.CANCEL.getStatus()) {
				status = "订单取消";
			}else if(order.getStatus()==CommonKey.Order.FAILED.getStatus()) {
				status = "交易失败";
			}else if(order.getStatus()==CommonKey.Order.NO_GOT.getStatus()) {
				status = "未收货";
			}else if(order.getStatus()==CommonKey.Order.NO_PAY.getStatus()) {
				status = "未付款";
			}else if(order.getStatus()==CommonKey.Order.NO_SEND_NO_SETTLEMENT.getStatus()) {
				status = "已付款未结算";
			}else if(order.getStatus()==CommonKey.Order.NO_SEND_SETTLEMENT.getStatus()) {
				status = "已结算未发货";
			}else if(order.getStatus()==CommonKey.Order.SUCCESS_EVALUATE.getStatus()) {
				status = "交易成功已评价";
			}else if(order.getStatus()==CommonKey.Order.SUCCESS_NO_EVALUATE.getStatus()) {
				status = "交易成功未评价";
			}
			obj[4] = status;
			content.add(obj);
		}
		HSSFWorkbook wb = ExcelUtil.createExcel(header, content);
		this.writeExcel(wb, "微信对账（商城）");
	}
	@RequestMapping("/settlement")
	public void settlement(String orderIDs) {
		AlibabaAlipayUrlGetParam param = new AlibabaAlipayUrlGetParam();
		JSONObject res = new JSONObject();
		if (orderIDs != null && !"".equals(orderIDs)) {
			String[] ids = orderIDs.split(",");
			long[] orderList = new long[ids.length];
			for (int i = 0; i < ids.length; i++) {
				orderList[i] = Long.valueOf(ids[i]);
			}
			param.setOrderIdList(orderList);
			try {
				AlibabaAlipayUrlGetResult result = alibabaService.getAlipayUrl(param);
				res.put("errorMsg", result.getErroMsg());
				res.put("success", result.getSuccess());
				res.put("payUrl", result.getPayUrl());
			} catch (Exception e) {
				logger.error("获取支付宝结算链接异常", e);
				res.put("success", false);
				res.put("errorMsg", "获取支付宝结算链接异常");
			}
		}
		User user = SessionManager.getAttribute(request, SessionManager.Key.USER);
		operationLogService.insert(user.getId(), "获取支付宝结算链接", CommonKey.UserOperationLog.ORDER.getType(), orderIDs, "");
		this.writeJSON(this.createJSONResult(CommonKey.SUCCESS_CODE, res).toJSONString());
	}

	/**
	 * 审核订单，确认收款
	 * 
	 * @param orderId
	 * @param customerId
	 */
	@RequestMapping("/checkOrder")
	public void checkOrder(String orderId, Integer customerId) {
		boolean res = false;
		try {
			orderService.updateStatus(customerId, orderId, CommonKey.Order.NO_SEND_SETTLEMENT.getStatus());
			res = true;
			User user = SessionManager.getAttribute(request, SessionManager.Key.USER);
			operationLogService.insert(user.getId(), "审核订单，确认收款", CommonKey.UserOperationLog.ORDER.getType(), orderId, "");
		} catch (Exception e) {
			logger.error("审核订单，确认收款异常", e);
		}
		this.writeJSON(this.createJSONResult(CommonKey.SUCCESS_CODE, res).toJSONString());
	}
	@RequestMapping("/cancel")
	public void cancel(String orderId,Integer customerId) {
		boolean res = false;
		try {
			orderService.updateStatus(customerId, orderId, CommonKey.Order.CANCEL.getStatus());
			res = true;
			User user = SessionManager.getAttribute(request, SessionManager.Key.USER);
			operationLogService.insert(user.getId(), "取消订单", CommonKey.UserOperationLog.ORDER.getType(), orderId, "");
		} catch (Exception e) {
			logger.error("审核订单，确认收款异常",e);
		}
		this.writeJSON(this.createJSONResult(CommonKey.SUCCESS_CODE, res).toJSONString());
	}
	@RequestMapping("/cashback")
	public void cashback(String orderId,Integer customerId) {
		boolean res = false;
		try {
			orderService.updateCashbackStatus(orderId, CommonKey.Order.CASHBACK_OK.getStatus());
			res = true;
			User user = SessionManager.getAttribute(request, SessionManager.Key.USER);
			operationLogService.insert(user.getId(), "确认订单返现", CommonKey.UserOperationLog.ORDER.getType(), orderId, "");
		} catch (Exception e) {
			logger.error("确认订单返现",e);
		}
		this.writeJSON(this.createJSONResult(CommonKey.SUCCESS_CODE, res).toJSONString());
	}
	/**
	 * 网络销售订单列表跳转接口
	 * @param userId
	 * @param linered
	 * @return
	 */
	@RequestMapping("/redOrderList")
	public ModelAndView redOrderList(Integer userId,Integer linered) {
		ModelAndView model = new ModelAndView("manager/redOrder_manager");
		if(linered==null) {
			linered = 0;
		}
		String[] productIds = null;
		if(ConfigureUtil.LINEREDPRODUCT.toString()!=null&&!"".equals(ConfigureUtil.LINEREDPRODUCT.toString().trim())) {
			productIds = ConfigureUtil.LINEREDPRODUCT.toString().split(",");
		}
		Double percent = 0d;
		if(ConfigureUtil.LINEREDPERCENTAGE.toString()!=null&&!"".equals(ConfigureUtil.LINEREDPERCENTAGE.toString().trim())) {
			percent = Double.valueOf(ConfigureUtil.LINEREDPERCENTAGE.toString());
		}
		Double money = 0d;
 		if(linered == 0) {//表示userId为网红id
			User red = userService.findById(userId);
			List<User> fans = userService.findRedDetailByType(null, null, null, null, red.getNumber());
			Integer[] userIds = new Integer[fans.size()];
			for(int i = 0;i<fans.size();i++) {
				userIds[i] = fans.get(i).getId();
			}
			money=orderService.sumTotalByProduct(null, null, null, productIds, userIds, true);
		}else {
			Integer[] userIds = new Integer[] {userId};
			money=orderService.sumTotalByProduct(null, null, null, productIds, userIds, true);
		}
 		model.addObject("userId",userId);
 		model.addObject("linered", linered);
 		model.addObject("money", money*percent);
		return model;
	}
	@RequestMapping("/redOrderPage")
	public void redOrderPage(String startTime,String endTime,Integer draw,Integer start,Integer length,Integer userId,Integer linered) {
		String search = request.getParameter("search[value]");
		if (search == null || search.isEmpty()) {
			search = null;
		}
		if(startTime!=null&&"".equals(startTime.trim())) {
			startTime = null;
		}
		if(endTime!=null&&"".equals(endTime.trim())) {
			endTime = null;
		}
		if(linered==null) {
			linered = 0;
		}
		String[] productIds = null;
		if(ConfigureUtil.LINEREDPRODUCT.toString()!=null&&!"".equals(ConfigureUtil.LINEREDPRODUCT.toString().trim())) {
			productIds = ConfigureUtil.LINEREDPRODUCT.toString().split(",");
		}
		Integer[] userIds = null;
		if(linered == 0) {//表示userId为网红id
			User red = userService.findById(userId);
			List<User> fans = userService.findRedDetailByType(null, null, null, null, red.getNumber());
			userIds = new Integer[fans.size()];
			for(int i = 0;i<fans.size();i++) {
				userIds[i] = fans.get(i).getId();
			}
		}else {
			userIds = new Integer[] {userId};
		}
		
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");// 设置日期格式
		String datell = df.format(new Date());// new Date()为获取当前系统时间
		SessionManager.addAttribute(request, SessionManager.Key.DATELL,datell);
		List<CustomerOrder> orderList = orderService.findByPageAndProduct(startTime, endTime, start, length, search, productIds, userIds, null, null, true,datell);
		Double percent = 0d;
		if(ConfigureUtil.LINEREDPERCENTAGE.toString()!=null&&!"".equals(ConfigureUtil.LINEREDPERCENTAGE.toString().trim())) {
			percent = Double.valueOf(ConfigureUtil.LINEREDPERCENTAGE.toString());
		}	
		JSONArray array = (JSONArray) JSONArray.toJSON(orderList);
		for(int i=0;i<array.size();i++) {
			array.getJSONObject(i).put("percent", array.getJSONObject(i).getDouble("amount")*percent);
		}
		JSONObject json = this.createJSONResult(CommonKey.SUCCESS_CODE, array);
		json.put("draw", draw);
		Integer totalResult = orderService.countTotalByProduct(null, null, null, productIds, userIds, true);
		json.put("recordsTotal", totalResult);
		Integer totalFilterResult = orderService.countTotalByProduct(startTime, endTime, search, productIds, userIds, true);
		json.put("recordsFiltered", totalFilterResult);
		Double money = orderService.sumTotalByProduct(startTime, endTime, search, productIds, userIds, true);
		json.put("money", money);
		json.put("datell", datell);
		this.writeJSON(json.toJSONString());
	}
	
	/**
	 * 网络销售订单列表跳转接口
	 * @param userId
	 * @param linered
	 * @return
	 */
	@RequestMapping("/wanghongOrderList")
	public ModelAndView wanghongOrderList(Integer userId,Integer linered,String openid,String nickName) {
		System.out.println("openid为:"+openid+"nickName为:"+nickName);
		ModelAndView model = new ModelAndView("manager/red_wanghong_order");
		if(linered==null) {
			linered = 0;
		}
		String[] productIds = null;
		if(ConfigureUtil.LINEREDPRODUCT.toString()!=null&&!"".equals(ConfigureUtil.LINEREDPRODUCT.toString().trim())) {
			productIds = ConfigureUtil.LINEREDPRODUCT.toString().split(",");
		}
		Double percent = 0d;
		if(ConfigureUtil.LINEREDPERCENTAGE.toString()!=null&&!"".equals(ConfigureUtil.LINEREDPERCENTAGE.toString().trim())) {
			percent = Double.valueOf(ConfigureUtil.LINEREDPERCENTAGE.toString());
		}
		Double money = 0d;
 		if(linered == 0) {//表示userId为网红id
			User red = userService.findById(userId);
			List<User> fans = userService.findRedDetailByType(null, null, null, null, red.getNumber());
			Integer[] userIds = new Integer[fans.size()];
			for(int i = 0;i<fans.size();i++) {
				userIds[i] = fans.get(i).getId();
			}
			money=orderService.sumTotalByWanghonProduct(null, null, null, productIds, userIds, true);
		}else {
			Integer[] userIds = new Integer[] {userId};
			money=orderService.sumTotalByWanghonProduct(null, null, null, productIds, userIds, true);
		}
 		if(money==null||money.equals("")) {
 			money=0d;
 		}
 		System.out.println("money为:"+money);
 		model.addObject("userId",userId);
 		model.addObject("linered", linered);
 		model.addObject("money", money*percent);
 		model.addObject("openid", openid);
 		model.addObject("nickName", nickName);
		return model;
	}
	
}
