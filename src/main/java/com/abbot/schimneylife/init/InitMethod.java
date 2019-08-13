package com.abbot.schimneylife.init;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Timer;
import java.util.TimerTask;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import com.abbot.schimneylife.pojo.shopping.AlibabaTidingsLog;
import com.abbot.schimneylife.pojo.shopping.CustomerOrder;
import com.abbot.schimneylife.service.shopping.AlibabaService;
import com.abbot.schimneylife.service.shopping.AlibabaTidingsLogService;
import com.abbot.schimneylife.service.shopping.CustomerOrderService;
import com.abbot.schimneylife.util.AliMsgUtil;
import com.abbot.schimneylife.util.CommonKey;
import com.abbot.schimneylife.util.ConfigureUtil;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.trade.param.AlibabaTradeGetBuyerViewParam;
import com.alibaba.trade.param.AlibabaTradeGetBuyerViewResult;
import com.alibaba.tuna.websocket.client.TunaClient;
import com.alibaba.tuna.websocket.client.TunaException;
import com.alibaba.tuna.websocket.client.TunaMessage;
import com.alibaba.tuna.websocket.client.TunaMessageHandler;
import com.alibaba.tuna.websocket.client.TunaMessageType;

@Component
public class InitMethod {

	private static final Logger logger = Logger.getLogger(InitMethod.class);
	@Resource
	private CustomerOrderService orderService;
	@Resource
	private AlibabaTidingsLogService logService;
	@Resource
	private AlibabaService alibabaService;
	
	@PostConstruct
	public void init() {
		this.initTimer();
//		this.initAlibabaWebsocket();
	}
	/**
	 * 启动定时器 每天 23:59:30执行
	 */
	private void initTimer() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Calendar calendar = Calendar.getInstance();
		calendar.set(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH), 23, 59, 30);
		long time = 1000*60*60*24;
		logger.error("timer start....");
		logger.error("timer run time："+sdf.format(calendar.getTime()));
		new Timer().schedule(new TimerTask() {
			@Override
			public void run() {
				logger.error("timer error");
				//关闭超过5天的待付款订单
				orderService.closeOverdueNoPayOrder();
				//修改超过10天的待收货为已收货待评价
				orderService.closeOverduiNoGotOrder();
			}
			
		}, calendar.getTime(),time);
	}
	/**
	 * 启动阿里巴巴websocket链接
	 */
	public void initAlibabaWebsocket() {
		String url = "ws://message.1688.com/websocket";
        //1688环境为ws://message.1688.com/websocket,
       TunaClient client = new TunaClient(ConfigureUtil.ALIBABA_APPKEY.toString(), ConfigureUtil.ALIBABA_SECKEY.toString(), url);
       TunaMessageHandler mhandler = new TunaMessageHandler() {
           @Override
           public boolean onMessage(TunaMessage message) throws Exception {
              boolean success = true;
              try {
				  /*说明，服务端推送的消息分为2种，
				  业务数据和系统消息，类型分别SERVER_PUSH和SYSTEM,
				  其中系前者是业务消息，
				  后者是系统消息，如appkey与secret不匹配等。*/
				   
				  if(TunaMessageType. SERVER_PUSH.name().equals(message.getType())){//如果是业务数据
				  //此处填写业务逻辑，数据存储在message.getContent()中
					  logger.error(JSONObject.toJSON(message).toString());
					  JSONObject context = JSONObject.parseObject(message.getContent());
					  JSONObject data = context.getJSONObject("data");
					  CustomerOrder order = null;
					  if(data.containsKey("orderId")) {
						  order = orderService.fetchByOrderID(data.getString("orderId"));						  
					  }
				      AlibabaTidingsLog log = new AlibabaTidingsLog();
					  log.setCustomerOrderId(order.getId());
					  log.setMsgSendTime(data.getString("msgSendTime"));
					  log.setOrderID(data.getString("orderId"));
					  String type = context.getString("type");
					  if(CommonKey.ORDER_ANNOUNCE_SENDGOODS.equals(type)) {//发货通知
			        		if(order!=null&&order.getStatus()==CommonKey.Order.NO_SEND_SETTLEMENT.getStatus()) {
			        			try {
									orderService.updateStatus(order.getCustomerId(), order.getId(), CommonKey.Order.NO_GOT.getStatus());
								} catch (Exception e) {
									logger.error("接受订阅消息，将订单 customer_order_id="+order.getId()+" 修改为待收货状态失败！",e);
								}
			        		}
			        		log.setMessageType("1688订单发货");
			        	}else if(CommonKey.ORDER_ORDER_BOPS_CLOSE.equals(type)) {//1688运营后台关闭订单
			        		log.setMessageType("1688运营后台关闭订单");
			        	}else if(CommonKey.ORDER_ORDER_PRICE_MODIFY.equals(type)) {//1688修改订单价格
			        		if(order!=null&&order.getStatus()==CommonKey.Order.NO_SEND_NO_SETTLEMENT.getStatus()) {
			        			try {
			        				AlibabaTradeGetBuyerViewParam param = new AlibabaTradeGetBuyerViewParam();
			        				param.setOrderId(data.getString("orderId"));
			        				param.setWebSite("1688");
			        				AlibabaTradeGetBuyerViewResult result = alibabaService.getBuyerView(param);
			        				if("success".equals(result.getErrorCode())) {
			        					BigDecimal amount = result.getResult().getBaseInfo().getTotalAmount();
			        					orderService.modifyOrderPrice(order.getId(), amount);
			        				}
								} catch (Exception e) {
									logger.error("接受订阅消息，将订单 customer_order_id="+order.getId()+" 修改为待收货状态失败！",e);
								}
			        		}
			        		log.setMessageType("1688修改订单价格");
			        	}else if(CommonKey.ORDER_ORDER_SELLER_CLOSE.equals(type)) {//1688卖家关闭订单
			        		log.setMessageType("1688卖家关闭订单");
			        	}else if(CommonKey.ORDER_ORDER_COMFIRM_RECEIVEGOODS.equals(type)) {//1688订单确认收货
			        		log.setMessageType("买家确认收货");
			        	}else if(CommonKey.ORDER_ORDER_SUCCESS.equals(type)) {//1688交易成功
			        		log.setMessageType("交易成功");
			        	}else if(CommonKey.ORDER_PAY.equals(type)) {//1688交易付款
			        			try {
			        				if(order!=null&&order.getStatus()==CommonKey.Order.NO_SEND_NO_SETTLEMENT.getStatus()) {
			        					orderService.updateStatus(order.getCustomerId(), order.getId(), CommonKey.Order.NO_SEND_SETTLEMENT.getStatus());
			        				}
								} catch (Exception e) {
									logger.error("接受订阅消息，将订单 customer_order_id="+order.getId()+" 修改为待发货已结算状态失败！",e);
								}
			        			
			        		log.setMessageType("交易付款");
			        	}else if(CommonKey.PRODUCT_DELETE.equals(type)) {//1688产品删除
			        		log.setMessageType("产品删除");
			        		AliMsgUtil.sendSms("产品删除:"+message.getContent(), "13963758111");
			        	}else if(CommonKey.PRODUCT_EXPIRE.equals(type)) {//1688产品下架
			        		log.setMessageType("产品下架");
			        		AliMsgUtil.sendSms("产品下架:"+message.getContent(), "13963758111");
			        	}else if(CommonKey.PRODUCT_NEW_OR_MODIFY.equals(type)) {//1688产品新增或修改
			        		log.setMessageType("产品新增或修改");
			        		AliMsgUtil.sendSms("产品新增或修改:"+message.getContent(), "13963758111");
			        	}else {
			        		log.setMessageType(type);
			        	}
					  logService.insert(log);
				  }
              } catch (Exception e) {
                
              }
              return success;
           }
       };
       client.setTunaMessageHandler(mhandler);
       try {
		client.connect();
		} catch (TunaException e) {
			logger.error("阿里巴巴websocket连接失败",e);
		}
       System.out.println("alibaba websocket connect");
	}
}
