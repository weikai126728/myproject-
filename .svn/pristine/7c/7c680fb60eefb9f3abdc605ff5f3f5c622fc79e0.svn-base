package com.abbot.schimneylife.controller.manager;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.abbot.schimneylife.controller.BaseController;
import com.abbot.schimneylife.pojo.user.User;
import com.abbot.schimneylife.pojo.weixin.Alliance;
import com.abbot.schimneylife.pojo.weixin.AllianceCommission;
import com.abbot.schimneylife.pojo.weixin.AmountOrder;
import com.abbot.schimneylife.pojo.weixin.BusinessType;
import com.abbot.schimneylife.pojo.weixin.Commission;
import com.abbot.schimneylife.pojo.weixin.CommissionSettlement;
import com.abbot.schimneylife.pojo.weixin.Fashionable;
import com.abbot.schimneylife.pojo.weixin.JoinModel;
import com.abbot.schimneylife.pojo.weixin.OrderMerchantPayment;
import com.abbot.schimneylife.pojo.weixin.OrderPayment;
import com.abbot.schimneylife.pojo.weixin.OrdermerRedpack;
import com.abbot.schimneylife.pojo.weixin.Receivers;
import com.abbot.schimneylife.pojo.weixin.TsServiceFee;
import com.abbot.schimneylife.pojo.weixin.TsSwitch;
import com.abbot.schimneylife.service.user.UserService;
import com.abbot.schimneylife.service.weixin.AllianceCommissionService;
import com.abbot.schimneylife.service.weixin.AllianceService;
import com.abbot.schimneylife.service.weixin.AllianceSwitchService;
import com.abbot.schimneylife.service.weixin.AmountorderService;
import com.abbot.schimneylife.service.weixin.BusinessTypeService;
import com.abbot.schimneylife.service.weixin.CommissionService;
import com.abbot.schimneylife.service.weixin.CommissionSettlementService;
import com.abbot.schimneylife.service.weixin.FashionableService;
import com.abbot.schimneylife.service.weixin.JoinModelService;
import com.abbot.schimneylife.service.weixin.OrderPaymentService;
import com.abbot.schimneylife.service.weixin.OrdermerRedpackService;
import com.abbot.schimneylife.service.weixin.RedpackService;
import com.abbot.schimneylife.util.CommonKey;
import com.abbot.schimneylife.util.ConfigNativeUtil;
import com.abbot.schimneylife.util.ExcelUtil;
import com.abbot.schimneylife.util.FashionableUtil;
import com.abbot.schimneylife.util.MerchantPaymentUtil;
import com.abbot.schimneylife.util.PaymentMessageUtil;
import com.abbot.schimneylife.util.SessionManager;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

@RequestMapping("/manager/alliance")
@Controller
public class AllianceManagerController extends BaseController{

	private static final Logger logger = Logger.getLogger(AllianceManagerController.class);
	@Resource
	private AllianceService alService;
	@Resource
	private OrderPaymentService orderService;
	@Resource
	private UserService userService;
	@Resource
	private AmountorderService amountService;
	@Resource
	private OrdermerRedpackService redService;
	@Resource
	private RedpackService redPackService;
	@Resource
	private CommissionService commissionService;
	@Resource
	private CommissionSettlementService csetlementService;
	@Resource
	private BusinessTypeService busService;
	@Resource
	private JoinModelService modelService;
	@Resource
	private AllianceCommissionService acService;
	@Resource 
	private AllianceSwitchService asService;
	@Resource 
	private FashionableService fasService;
	@RequestMapping("/index")
	public ModelAndView index() {
		ModelAndView model = new ModelAndView("manager/alliance_list");
		return model;
	}
	/**
	 * 加盟商超分页查询
	 * @param draw
	 * @param createTime
	 * @param start
	 * @param length
	 */
	@RequestMapping("/findByPage")
	public void findByPage(Integer draw,String createTime,Integer start,Integer length,String startTime,String endTime) {
	    SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd"); 
	    String date= df.format(new Date());
		if(startTime!=null&&"".equals(startTime.trim())) {
			startTime = date;
		}
		if(endTime!=null&&"".equals(endTime.trim())) {
			endTime =date;
		}
		String search = request.getParameter("search[value]");
		if(search==null||search.isEmpty()) {
			search = null;
		}
		if(createTime!=null&&"".equals(createTime.trim())) {
			createTime = null;
		}
		Integer orderCol = Integer.valueOf(request.getParameter("order[0][column]"));
		String order = request.getParameter("order[0][dir]");
		String column = null;
		if(orderCol!=null) {
			switch(orderCol) {
			case 1:
				column = "product_id";
				break;
			case 12:
				column = "storecurrtime";
				break;
			}
		}
		List<Alliance> list = alService.findByPage(start, length, search, column, order,createTime);
		JSONArray array = (JSONArray) JSONArray.toJSON(list);
		//Map<String,Integer> cache = new HashMap<>();
		long begin = System.currentTimeMillis();
		for(int i=0;i<array.size();i++) {
			Integer allianceId = array.getJSONObject(i).getInteger("alid");
			String product_id = array.getJSONObject(i).getString("product_id");
			
//			//添加业务员
//			User user = userService.fetchUserByAllianceIdAndLevel(allianceId, CommonKey.Role.SALESMAN.getLevel());
//			//已结算佣金
//			Integer hasSettlement = csetlementService.sumSuccess(product_id, null, null);
//			array.getJSONObject(i).put("hasSettlement", hasSettlement);
//			//未结算佣金交易额
//			Integer noSettlementAmount = amountService.noCommissionSum(product_id, startTime, endTime);
//			//未结算佣金
//			List<AmountOrder> amountList = amountService.noCommissionList(product_id, startTime, endTime);
//			array.getJSONObject(i).put("noSettlementAmount", noSettlementAmount);	
//			Integer setlement = 0;
//			List<AllianceCommission> acs = acService.findByProductId(product_id);
//			for(AmountOrder arg0 : amountList) {
//				Integer percent = 0;
//				/*Integer pri = null;
//				for(int x = 0;x<acs.size();x++) {
//					if(acs.get(x).getBusiness_type_id()==arg0.getType_id()) {
//						pri = acs.get(x).getPercent();
//					}
//				}*/
//				//if(pri==null) {
//					String key;
//					if(cache.containsKey(key=(arg0.getType_id()+arg0.getModel_id().toString()))) {
//						percent = cache.get(key);
//					}else {
//						percent = commissionService.fetchByCondition(arg0.getType_id(), arg0.getModel_id(), null);						
//					}
//			/*	}else {
//					percent = pri;
//				}*/
//				setlement += arg0.getPayment()*percent/1000;
//			}
//			array.getJSONObject(i).put("setlement", setlement);
//			if(user!=null) {
//				array.getJSONObject(i).put("userName", user.getRealName());				
//			}else {
//				array.getJSONObject(i).put("userName", "");	
//			}
			Integer  sumamount=	amountService.sumAmount(product_id, startTime, endTime, null);
			Integer  countamount=	amountService.countAmount(product_id, startTime, endTime, null);
			/**
			 * 服务费
			 */
			TsServiceFee servicefee=amountService.findServiceFee(product_id);
			if(servicefee==null) {
				array.getJSONObject(i).put("servicefee", 0);
			}else {
				array.getJSONObject(i).put("servicefee",servicefee.getSefee());
			}
			array.getJSONObject(i).put("sumamount", sumamount);
			array.getJSONObject(i).put("countamount", countamount);
			/**
			 * 会员数量
			 */
			Integer  countp=alService.countUser(product_id);
			array.getJSONObject(i).put("countuser", countp);
	}
		long end = System.currentTimeMillis();
		System.out.println("耗时："+(end-begin)+"ms");
		JSONObject json = this.createJSONResult(CommonKey.SUCCESS_CODE, array);
		json.put("draw", draw);
		Integer totalResult = alService.countTotal(null, null);
		json.put("recordsTotal", totalResult);
		Integer totalFilterResult = alService.countTotal(search, createTime);
		json.put("recordsFiltered", totalFilterResult);
		this.writeJSON(json.toJSONString());
	}
	@RequestMapping("/settlement")
	public void settlement(String search,Integer orderCol,String order,String createTime,String startTime,String endTime) {
		if(search==null||search.isEmpty()) {
			search = null;
		}
		if(createTime!=null&&"".equals(createTime.trim())) {
			createTime = null;
		}
		if(startTime!=null&&"".equals(startTime.trim())) {
			startTime = null;
		}
		if(endTime!=null&&"".equals(endTime.trim())) {
			endTime = null;
		}
		String column = null;
		if(orderCol!=null) {
			switch(orderCol) {
			case 1:
				column = "product_id";
				break;
			case 12:
				column = "storecurrtime";
				break;
			}
		}
		List<Alliance> list = alService.findByPage(null, null, search, column, order,createTime);
		User user = SessionManager.getAttribute(request, SessionManager.Key.USER);
		for(int i=0;i<list.size();i++) {
			String product_id =list.get(i).getProduct_id();
			//未结算佣金
			List<AmountOrder> amountList = amountService.noCommissionList(product_id, startTime, endTime);
			//未结算佣金交易额
			Integer noSettlementAmount = amountService.noCommissionSum(product_id, startTime, endTime);
			Integer setlement = 0;
			List<Integer> perList = new ArrayList<>();
			for(AmountOrder arg0 : amountList) {
				Integer percent = 0;
				Integer pri = commissionService.fetchPriByCondition(arg0.getType_id(), product_id);
				if(pri==null) {
					percent = commissionService.fetchByCondition(arg0.getType_id(), arg0.getModel_id(), null);
				}else {
					percent = pri;
				}
				perList.add(percent);
				setlement += arg0.getPayment()*percent/1000;
			}
			if(setlement<=0) {
				//setlement =0 时不结算；
				continue;
			}
			logger.error("佣金结算的用户为："+list.get(i).getAlopenid()+" 金额为："+setlement+"操作人为:"+user.getNickName());
			SortedMap<Object, Object> map = new TreeMap<Object, Object>();
			try {
				map = (SortedMap<Object, Object>) MerchantPaymentUtil.merchantPayment(list.get(i).getAlopenid(), setlement);
				if (String.valueOf(map.get("return_code")).equalsIgnoreCase("SUCCESS")
						&& String.valueOf(map.get("result_code")).equalsIgnoreCase("SUCCESS")) {
					logger.error("佣金结算任务成功");
					OrderMerchantPayment orderMerchantPayment = new OrderMerchantPayment();
					orderMerchantPayment.setPayment_no(String.valueOf(map.get("payment_no")));
					orderMerchantPayment.setPartner_trade_no(String.valueOf(map.get("partner_trade_no")));
					orderMerchantPayment.setMchid(ConfigNativeUtil.MCH_ID);
					orderMerchantPayment.setMch_appid(ConfigNativeUtil.APP_ID);
					orderMerchantPayment.setMerchantpayment(setlement);
					orderMerchantPayment.setAlopenid(list.get(i).getAlopenid());
					orderMerchantPayment.setResult_code(String.valueOf(map.get("result_code")));
					orderMerchantPayment.setReturn_code(String.valueOf(map.get("return_code")));
					orderMerchantPayment.setPayment_time(String.valueOf(map.get("payment_time")));
					//发送模板消息
					PaymentMessageUtil.getMessage(list.get(i).getAlopenid(), setlement, map.get("payment_time").toString());
					boolean boo = redPackService.addCommissionSettlement(orderMerchantPayment);
					if (boo) {
						System.out.println("手动佣金结算信息存储成功");
					}
					CommissionSettlement settlement = new CommissionSettlement();
					settlement.setProduct_id(product_id);
					settlement.setAmount(setlement);
					settlement.setPaymentNo(String.valueOf(map.get("payment_no")));
					settlement.setStatus(1);
					settlement.setStorename(list.get(i).getStorename());
					settlement.setTotal(noSettlementAmount);
					csetlementService.insert(settlement);
					for(int j=0;j<amountList.size();j++) {
						csetlementService.insertRelation(amountList.get(j).getAmid(),settlement.getId(),perList.get(j));
					}
				} else {
					OrderMerchantPayment orderMerchantPayment = new OrderMerchantPayment();
					orderMerchantPayment.setMchid(ConfigNativeUtil.MCH_ID);
					orderMerchantPayment.setMch_appid(ConfigNativeUtil.APP_ID);
					orderMerchantPayment.setMerchantpayment(setlement);
					orderMerchantPayment.setAlopenid(list.get(i).getAlopenid());
					orderMerchantPayment.setResult_code(String.valueOf(map.get("result_code")));
					orderMerchantPayment.setReturn_code(String.valueOf(map.get("return_code")));
					orderMerchantPayment.setErr_code_des(String.valueOf(map.get("err_code_des")));
					boolean boo = redPackService.addCommissionSettlement(orderMerchantPayment);
					if (boo) {
						System.out.println("手动佣金结算信息存储成功");
					}
					logger.error("佣金结算失败");
					CommissionSettlement settlement = new CommissionSettlement();
					settlement.setProduct_id(product_id);
					settlement.setAmount(setlement);
					settlement.setPaymentNo(String.valueOf(map.get("payment_no")));
					settlement.setStatus(0);
					settlement.setStorename(list.get(i).getStorename());
					settlement.setTotal(noSettlementAmount);
					csetlementService.insert(settlement);
				}
			} catch (Exception e) {
				logger.error("佣金结算异常",e);
			}
		}
		this.writeJSON(this.createJSONResult(CommonKey.SUCCESS_CODE, true).toJSONString());
	}
	@RequestMapping("/allianceExcel")
	public void allianceExcel(String createTime,String search,Integer orderCol,String order) {
		if(search==null||search.isEmpty()) {
			search = null;
		}
		if(createTime!=null&&"".equals(createTime.trim())) {
			createTime = null;
		}
		String column = null;
		if(orderCol!=null) {
			switch(orderCol) {
			case 1:
				column = "product_id";
				break;
			case 12:
				column = "storecurrtime";
				break;
			}
		}
		List<Alliance> list = alService.findByPage(null, null, search, column, order,createTime);
		String[] header = new String[] {"商超编号","姓名","商超名称","业务员","联系方式","经营范围","地址","入驻时间"};
		List<Object[]> content = new ArrayList<>();
		for(Alliance alliance:list) {
			Object[] con = new Object[8];
			con[0] = alliance.getProduct_id();
			con[1] = alliance.getAlname();
			con[2] = alliance.getStorename();
			User user = userService.fetchUserByAllianceIdAndLevel(alliance.getAlid(), CommonKey.Role.SALESMAN.getLevel());
			if(user!=null) {
				con[3] = user.getRealName();				
			}else {
				con[3] = "";
			}
			con[4] = alliance.getAltel();
			con[5] = alliance.getAlproject();
			con[6] = alliance.getStoreaddress();
			con[7] = alliance.getCreateTime();
			content.add(con);
		}
		HSSFWorkbook wb = ExcelUtil.createExcel(header, content);
		this.writeExcel(wb, "商超列表");
	}
	@RequestMapping("/trade")
	public ModelAndView trade(Integer id,String openId) {
		ModelAndView model = new ModelAndView("manager/trade_list");
		model.addObject("userId",id);
		model.addObject("openId", openId);
		return model;
	}
	
	@RequestMapping("/tradeByPage")
	public void tradeByPage(Integer draw,String openId,String startTime,String endTime,Integer start,Integer length,Integer userId) {
		
	   SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
	   String date= df.format(new Date());
		if(startTime!=null&&"".equals(startTime.trim())) {
			startTime = date;
		}
		if(endTime!=null&&"".equals(endTime.trim())) {
			endTime =date;
		}
		if(openId!=null&&"".equals(openId.trim())) {
			openId = null;
		}
		String search = request.getParameter("search[value]");
		if(search==null||search.isEmpty()) {
			search = null;
		}
//		if(userId==0) {
//			userId = null;
//		}
		List<OrderPayment> list = orderService.findByPage(start, length, null, null, userId, startTime, endTime,openId,search);
		JSONObject json = this.createJSONResult(CommonKey.SUCCESS_CODE, JSONArray.toJSON(list));
		json.put("draw", draw);
		Integer totalResult = orderService.countTotal(userId, null, null,openId,null);
		json.put("recordsTotal", totalResult);
		Integer totalFilterResult = orderService.countTotal(userId, startTime, endTime,openId,search);
		Integer totalTrade = orderService.countTrade(userId, startTime, endTime, openId,search);
		json.put("recordsFiltered", totalFilterResult);
		json.put("totalTrade", totalTrade);
		this.writeJSON(json.toJSONString());
	}
	@RequestMapping("/tradeExcel")
	public void tradeExcel(String openId,String startTime,String endTime,Integer userId,String search) {
		if(startTime!=null&&"".equals(startTime.trim())) {
			startTime = null;
		}
		if(endTime!=null&&"".equals(endTime.trim())) {
			endTime = null;
		}
		if(openId!=null&&"".equals(openId.trim())) {
			openId = null;
		}
		List<OrderPayment> list = orderService.findByPage(null, null, null, null, userId, startTime, endTime,openId,search);
		String[] header = new String[] {"交易编号","付款编号","商超编号","姓名","商超名称","金额（元）","交易时间"};
		List<Object[]> content = new ArrayList<>();
		for(OrderPayment order:list) {
			Object[] con = new Object[7];
			con[0] = order.getTradeNo();
			con[1] = order.getPaymentNo();
			if(order.getAlliance()==null) {
				con[2] = "";
				con[4] = "";
			}else {
				con[2] = order.getAlliance().getProduct_id();
				con[4] = order.getAlliance().getStorename();				
			}
			if(order.getUser()==null) {
				con[3] = "";
			}else {
				con[3] = order.getUser().getRealName();				
			}
			con[5] = order.getMoney()/100d;
			con[6] = order.getPayTime();
			content.add(con);
		}
		HSSFWorkbook wb = ExcelUtil.createExcel(header, content);
		String fileName = "结算流水";
		if(userId!=null) {			
			User user = userService.findById(userId);
			fileName += "--"+user.getRealName();
		}
		this.writeExcel(wb,fileName);
	}
	@RequestMapping("/salesman")
	public ModelAndView salesman() {
		ModelAndView model = new ModelAndView("manager/salesman_list");
		return model;
	}
	@RequestMapping("/manByPage")
	public void manByPage(Integer draw,String startTime,String endTime,Integer start,Integer length) {
		if(startTime!=null&&"".equals(startTime.trim())) {
			startTime = null;
		}
		if(endTime!=null&&"".equals(endTime.trim())) {
			endTime = null;
		}
		String search = request.getParameter("search[value]");
		if(search==null||search.isEmpty()) {
			search = null;
		}
		List<User> list = userService.findByLevel(CommonKey.Role.SALESMAN.getLevel(), start, length, search, null);
		JSONArray result = (JSONArray) JSONArray.toJSON(list);
		for(int i=0;i<result.size();i++) {
			List<Integer> ids = alService.findIdsByUserId(result.getJSONObject(i).getInteger("id"));
			result.getJSONObject(i).put("num", ids.size());
			Integer amount = amountService.countAmountByAllianceIds(ids, startTime, endTime);
			result.getJSONObject(i).put("amount", amount);
		}
		JSONObject json = this.createJSONResult(CommonKey.SUCCESS_CODE, result);
		json.put("draw", draw);
		Integer totalResult = userService.countByLevel(CommonKey.Role.SALESMAN.getLevel(), null);
		json.put("recordsTotal", totalResult);
		Integer totalFilterResult = userService.countByLevel(CommonKey.Role.SALESMAN.getLevel(), search);
		json.put("recordsFiltered", totalFilterResult);
		this.writeJSON(json.toJSONString());
	}
	@RequestMapping("/manExcel")
	public void manExcel(String startTime,String endTime,String search) {
		if(startTime!=null&&"".equals(startTime.trim())) {
			startTime = null;
		}
		if(endTime!=null&&"".equals(endTime.trim())) {
			endTime = null;
		}
		if(search==null||search.isEmpty()) {
			search = null;
		}
		List<User> list = userService.findByLevel(CommonKey.Role.SALESMAN.getLevel(), null, null, search, null);
		String[] header = new String[] {"编号","姓名","联系方式","商家数量","交易额"};
		List<Object[]> content = new ArrayList<>();
		for(User user:list) {
			Object[] con = new Object[5];
			con[0]=user.getId();
			con[1]=user.getRealName();
			con[2]=user.getPhone();
			List<Integer> ids = alService.findIdsByUserId(user.getId());
			con[3]=ids.size();
			Integer amount = amountService.countAmountByAllianceIds(ids, startTime, endTime);
			con[4]=amount/100d;
			content.add(con);
		}
		HSSFWorkbook wb = ExcelUtil.createExcel(header, content);
		String fileName = "业务员列表";
		this.writeExcel(wb, fileName);
	}
	@RequestMapping("/allocation")
	public ModelAndView allocation(Integer id) {
		ModelAndView model = new ModelAndView("manager/salesman_market");
		List<Alliance> list = alService.findAllNotAllocation(id, CommonKey.Role.SALESMAN.getLevel());
		model.addObject("list", list);
		List<Integer> rel = alService.findIdsByUserId(id);
		model.addObject("rel",JSONArray.toJSON(rel));
		model.addObject("userId", id);
		return model;
	}
	@RequestMapping("/update")
	public ModelAndView update(Integer[] alliances,Integer userId) {
		try {
			if(alliances!=null) {
				alService.updateRel(alliances, userId);
			}
		} catch (Exception e) {
			logger.error(e);
			e.printStackTrace();
		}
		ModelAndView model = new ModelAndView("manager/salesman_list");
		return model;
	}
	@RequestMapping("/payment")
	public ModelAndView payment() {
		ModelAndView model = new ModelAndView("manager/trade_list");
		
		return model;
	}
	@RequestMapping("/amount")
	public ModelAndView amount(Integer salesmanId) {
		ModelAndView model = new ModelAndView("manager/amount_list");
		model.addObject("salesmanId", salesmanId);
		return model;
	}
	
	/**
	 * 收款列表
	 * @param draw
	 * @param salesmanId
	 * @param startTime
	 * @param endTime
	 * @param start
	 * @param length
	 */
	@RequestMapping("/findAmountByPage")
	public void findAmountByPage(Integer draw,Integer salesmanId,String startTime,String endTime,Integer start,Integer length) {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd"); 
		String date= df.format(new Date());
		if(startTime!=null&&"".equals(startTime.trim())) {
			startTime = date;
		}
		if(endTime!=null&&"".equals(endTime.trim())) {
			endTime = date;
		}
		String search = request.getParameter("search[value]");
		if(search==null||search.isEmpty()) {
			search = null;
		}
		if(salesmanId!=null&&salesmanId==0) {
			salesmanId = null;
		}
		List<AmountOrder> list = amountService.findByPage(start, length, search, null, null, startTime, endTime,salesmanId);
		for(AmountOrder order:list) {
			Alliance alliance = alService.fetchByNumber(order.getProduct_id());
			order.setAlliance(alliance);
		}
		JSONObject json = this.createJSONResult(CommonKey.SUCCESS_CODE, JSONArray.toJSON(list));
		json.put("draw", draw);
		Integer totalResult = amountService.countTotal(null, startTime, endTime,salesmanId);
		json.put("recordsTotal", totalResult);
		Integer totalFilterResult = amountService.countTotal(search, startTime, endTime,salesmanId);
		Integer totalAmount = amountService.totalAmount(search, startTime, endTime,salesmanId);
		json.put("recordsFiltered", totalFilterResult);
		json.put("totalAmount", totalAmount);
		this.writeJSON(json.toJSONString());
	}
	@RequestMapping("/amount1")
	public ModelAndView amount1(String product_id) {
		ModelAndView model = new ModelAndView("manager/amount_list1");
		model.addObject("product_id", product_id);
		return model;
	}
	/**
	 * 收款列表
	 * @param draw
	 * @param salesmanId
	 * @param startTime
	 * @param endTime
	 * @param start
	 * @param length
	 */
	@RequestMapping("/findAmountByPage1")
	public void findAmountByPage1(Integer draw,String  product_id,String startTime,String endTime,Integer start,Integer length) {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd"); 
		String date= df.format(new Date());
		if(startTime!=null&&"".equals(startTime.trim())) {
			startTime = date;
		}
		if(endTime!=null&&"".equals(endTime.trim())) {
			endTime = date;
		}
		String search = request.getParameter("search[value]");
		if(search==null||search.isEmpty()) {
			search = null;
		}
		if(product_id!=null&&"".equals(product_id)) {
			product_id = null;
		}
		List<AmountOrder> list = amountService.findByproduct_id(start, length, search, null, null, startTime, endTime,product_id);
		for(AmountOrder order:list) {
			Alliance alliance = alService.fetchByNumber(order.getProduct_id());
			order.setAlliance(alliance);
		}
		JSONObject json = this.createJSONResult(CommonKey.SUCCESS_CODE, JSONArray.toJSON(list));
		json.put("draw", draw);
		Integer totalResult = amountService.countTotal(null, startTime, endTime,product_id);
		json.put("recordsTotal", totalResult);
		Integer totalFilterResult = amountService.countTotal(search, startTime, endTime,product_id);
		Integer totalAmount = amountService.totalAmount(search, startTime, endTime,product_id);
		json.put("recordsFiltered", totalFilterResult);
		json.put("totalAmount", totalAmount);
		this.writeJSON(json.toJSONString());
	}
	@RequestMapping("/amountExcel")
	public void amountExcel(Integer salesmanId,String startTime,String endTime,String search) {
		if(startTime!=null&&"".equals(startTime.trim())) {
			startTime = null;
		}
		if(endTime!=null&&"".equals(endTime.trim())) {
			endTime = null;
		}
		if(search==null||search.isEmpty()) {
			search = null;
		}
		if(salesmanId!=null&&salesmanId==0) {
			salesmanId = null;
		}
		List<AmountOrder> list = amountService.findByPage(null, null, search, null, null, startTime, endTime,salesmanId);
		for(AmountOrder order:list) {
			Alliance alliance = alService.fetchByNumber(order.getProduct_id());
			order.setAlliance(alliance);
		}
		String[] header = new String[] {"加盟商编号","姓名","商超名称","金额(元)","结算","交易时间"};
		List<Object[]> content = new ArrayList<>();
		for(AmountOrder order:list){
			Object[] con = new Object[6];
			con[0]=order.getProduct_id();
			if(order.getAlliance()==null) {
				con[1]="";
				con[2]="";		
			}else {
				con[1]=order.getAlliance().getAlname();
				con[2]=order.getAlliance().getStorename();				
			}
			con[3]=order.getPayment()/100d;
			con[4]=order.getCount()==1?"否":"是";
			con[5]=order.getAmtime_end();
			content.add(con);
		}
		HSSFWorkbook wb = ExcelUtil.createExcel(header, content);
		String fileName = "收款列表";
		if(salesmanId!=null) {
			User user = userService.findById(salesmanId);
			fileName += "--"+user.getRealName();
		}
		this.writeExcel(wb, fileName);
	}
	/**
	 * 红包
	 * @return
	 */
	@RequestMapping("/redpack")
	public ModelAndView redpack() {
		ModelAndView model = new ModelAndView("manager/redpack_list");
		return model;
	}
	/**
	 * 红包列表分页
	 * @param draw
	 * @param startTime
	 * @param endTime
	 * @param start
	 * @param length
	 */
	@RequestMapping("/findRedByPage")
	public void findRedByPage(Integer draw,String startTime,String endTime,Integer start,Integer length) {
		if(startTime!=null&&"".equals(startTime.trim())) {
			startTime = null;
		}
		if(endTime!=null&&"".equals(endTime.trim())) {
			endTime = null;
		}
		String search = request.getParameter("search[value]");
		if(search==null||search.isEmpty()) {
			search = null;
		}
		List<OrdermerRedpack> list = redService.findByPage(start, length, search, null, null, startTime, endTime);
		for(OrdermerRedpack order:list) {
			Alliance alliance = alService.fetchByNumber(order.getProduct_id());
			order.setAlliance(alliance);
		}
		JSONObject json = this.createJSONResult(CommonKey.SUCCESS_CODE, JSONArray.toJSON(list));
		json.put("draw", draw);
		Integer totalResult = redService.countTotal(null, null, null);
		json.put("recordsTotal", totalResult);
		Integer totalFilterResult = redService.countTotal(search, startTime, endTime);
		Integer totalAmount = redService.countRedpack(search, startTime, endTime);
		json.put("recordsFiltered", totalFilterResult);
		json.put("totalAmount", totalAmount);
		this.writeJSON(json.toJSONString());
	}
	@RequestMapping("/redExcel")
	public void redExcel(String startTime,String endTime,String search) {
		if(startTime!=null&&"".equals(startTime.trim())) {
			startTime = null;
		}
		if(endTime!=null&&"".equals(endTime.trim())) {
			endTime = null;
		}
		if(search==null||search.isEmpty()) {
			search = null;
		}
		List<OrdermerRedpack> list = redService.findByPage(null, null, search, null, null, startTime, endTime);
		for(OrdermerRedpack order:list) {
			Alliance alliance = alService.fetchByNumber(order.getProduct_id());
			order.setAlliance(alliance);
		}
		String[] header = new String[] {"加盟商编号","商户","金额(元)","发放时间"};
		List<Object[]> content = new ArrayList<>();
		for(OrdermerRedpack order : list) {
			Object[] con = new Object[4];
			con[0]=order.getProduct_id();
			if(order.getAlliance()==null) {
				con[1]="";
			}else {
				con[1]=order.getAlliance().getStorename();				
			}
			if(order.getTotal_amount()==null) {
				con[2]="轮空";
			}else {
				con[2]=order.getTotal_amount()/100d;				
			}
			con[3]=order.getRe_time();
			content.add(con);
		}
		HSSFWorkbook wb = ExcelUtil.createExcel(header, content);
		this.writeExcel(wb, "红包列表");
	}
	
	
	/* 佣金commission start */
	@RequestMapping("/commission")
	public ModelAndView commission() {
		ModelAndView model = new ModelAndView("manager/commission_list");
		List<BusinessType> typeList = busService.findAll();
		model.addObject("typeList", typeList);
		List<JoinModel> modelList = modelService.findAll();
		model.addObject("modelList", modelList);
		if(typeList!=null&&!typeList.isEmpty()&&modelList!=null&&!modelList.isEmpty()) {
			Integer percent = commissionService.fetchByCondition(typeList.get(0).getId(), modelList.get(0).getId(), null);
			model.addObject("percent", percent);
		}
		return model;
	}
	/**
	 * 佣金比例查询
	 * @param typeId
	 * @param modelId
	 */
	@RequestMapping("/typeAndmodel")
	public void typeAndModel(Integer typeId,Integer modelId) {
		Integer percent = commissionService.fetchByCondition(typeId, modelId, null);
		this.writeJSON(this.createJSONResult(CommonKey.SUCCESS_CODE, percent==null?-1:percent).toJSONString());
	}
	/**
	 * 修改佣金比例
	 * @param typeId
	 * @param modelId
	 * @param percent
	 */
	@RequestMapping("/commission/edit")
	public void commissionEdit(Integer typeId,Integer modelId,Integer percent) {
		Commission commission = commissionService.fetchByTypeAndModel(typeId, modelId);
		boolean res =false;
		if(commission==null) {
			commission = new Commission();
			commission.setModelId(modelId);
			commission.setBusinessTypeId(typeId);
			commission.setPercent(percent);
			res = commissionService.insert(commission);
		}else {
			commission.setPercent(percent);
			res = commissionService.update(commission);
		}
		this.writeJSON(this.createJSONResult(CommonKey.SUCCESS_CODE, res).toJSONString());
	}
	/**
	 * 商业模式列表
	 * @return
	 */
	@RequestMapping("/business/type")
	public ModelAndView business() {
		ModelAndView model = new ModelAndView("manager/businesstype_list");
		List<BusinessType> typeList = busService.findAll();
		model.addObject("typeList", typeList);
		return model;
	}
	/**
	 * 新增商业模式
	 * @param name
	 * @param details
	 */
	@RequestMapping("/business/add")
	public void addBusiness(String name,String details) {
		BusinessType type = new BusinessType();
		type.setDetails(details);
		type.setName(name);
		boolean res = busService.insert(type);
		this.writeJSON(this.createJSONResult(CommonKey.SUCCESS_CODE, res).toString());
	}
	/**
	 * 删除商业模式
	 * @param id
	 */
	@RequestMapping("/business/del")
	public void businessDel(Integer id) {
		boolean res = busService.delete(id);
		this.writeJSON(this.createJSONResult(CommonKey.SUCCESS_CODE, res).toString());
	}
	@RequestMapping("/business/edit")
	public void businessEdit(Integer id,String name,String details) {
		BusinessType type = new BusinessType(id,name,details);
		boolean res = busService.update(type);
		this.writeJSON(this.createJSONResult(CommonKey.SUCCESS_CODE, res).toJSONString());
	}
	@RequestMapping("/model")
	public ModelAndView model() {
		ModelAndView model = new ModelAndView("manager/joinmodel_list");
		List<JoinModel> modelList = modelService.findAll();
		model.addObject("modelList", modelList);
		return model;
	}
	/**
	 * 删除加盟方式
	 * @param id
	 */
	@RequestMapping("/model/del")
	public void del(Integer id) {
		boolean res = modelService.delete(id);
		this.writeJSON(this.createJSONResult(CommonKey.SUCCESS_CODE, res).toJSONString());
	}
	/**
	 * 新增加盟方式
	 * @param name
	 * @param details
	 */
	@RequestMapping("/model/add")
	public void addModel(String name,String details) {
		JoinModel model = new JoinModel();
		model.setDetails(details);
		model.setName(name);
		boolean res = modelService.insert(model);
		this.writeJSON(this.createJSONResult(CommonKey.SUCCESS_CODE, res).toJSONString());
	}
	/**
	 * 修改加盟方式
	 * @param id
	 * @param name
	 * @param details
	 */
	@RequestMapping("/model/edit")
	public void edit(Integer id,String name,String details) {
		JoinModel model = new JoinModel(id,name,details);
		boolean res = modelService.update(model);
		this.writeJSON(this.createJSONResult(CommonKey.SUCCESS_CODE, res).toJSONString());
	} 
	/**
	 * 佣金比例列表
	 * @param draw
	 * @param startTime
	 * @param endTime
	 * @param start
	 * @param length
	 * @param type
	 * @param product_id
	 */
	@RequestMapping("/commission/page")
	public void commissionByPage(Integer draw,String startTime,String endTime,Integer start,Integer length) {
		if(startTime!=null&&"".equals(startTime.trim())) {
			startTime = null;
		}
		if(endTime!=null&&"".equals(endTime.trim())) {
			endTime = null;
		}
		String search = request.getParameter("search[value]");
		if(search==null||search.isEmpty()) {
			search = null;
		}
		Integer orderCol = Integer.valueOf(request.getParameter("order[0][column]"));
		String order = null;
		if(orderCol!=null) {
			switch(orderCol) {
			case 1:
				order = "business_type_id";
				break;
			case 2:
				order = "join_model_id";
				break;
			}
		}
		String sort = request.getParameter("order[0][dir]");
		List<Commission> list = commissionService.findByPage(search, null, null, order, sort, start, length);
		JSONObject json = this.createJSONResult(CommonKey.SUCCESS_CODE, JSONArray.toJSON(list));
		json.put("draw", draw);
		Integer totalResult = commissionService.totalCount(null, null, null);
		json.put("recordsTotal", totalResult);
		Integer totalFilterResult = commissionService.totalCount(search, null, null);
		json.put("recordsFiltered", totalFilterResult);
		this.writeJSON(json.toJSONString());
	}
	/**
	 * 佣金结算单列表
	 * @return
	 */
	@RequestMapping("/commissionSettlement")
	public ModelAndView commissionSettlement() {
		ModelAndView model =new ModelAndView("manager/settlement_commission");
		return model;
	}
	@RequestMapping("/settlementByPage")
	public void settlementByPage(Integer draw,String startTime,String endTime,Integer start,Integer length) {
		if(startTime!=null&&"".equals(startTime.trim())) {
			startTime = null;
		}
		if(endTime!=null&&"".equals(endTime.trim())) {
			endTime = null;
		}
		String search = request.getParameter("search[value]");
		if(search==null||search.isEmpty()) {
			search = null;
		}
		Integer orderCol = Integer.valueOf(request.getParameter("order[0][column]"));
		String order = null;
		if(orderCol!=null) {
			switch(orderCol) {
			case 0:
				order = "product_id";
				break;
			case 2:
				order = "payment_no";
				break;
			case 3:
				order = "settlement_status";
				break;
			case 4:
				order = "total_payment";
				break;
			case 5:
				order = "settlement_amount";
				break;
			}
		}
		String sort = request.getParameter("order[0][dir]");
		List<CommissionSettlement> list = csetlementService.findByPage(search, startTime, endTime, order, sort, start, length);
		JSONObject json = this.createJSONResult(CommonKey.SUCCESS_CODE, JSONArray.toJSON(list));
		json.put("draw", draw);
		Integer totalResult = csetlementService.totalCount(null, null, null);
		json.put("recordsTotal", totalResult);
		Integer totalFilterResult = csetlementService.totalCount(search, startTime, endTime);
		json.put("recordsFiltered", totalFilterResult);
		this.writeJSON(json.toJSONString());
	}
	/**
	 * 私有佣金查询
	 * @param productId
	 */
	@RequestMapping("/typeByProductId")
	public void typeByProductId(String product_id) {
		List<AllianceCommission> list = acService.findByProductId(product_id);
		List<BusinessType> typeList = busService.findAll();
		List<AllianceCommission> res = new ArrayList<>();
		for(int j=0;j<typeList.size();j++) {
			BusinessType arg0 = typeList.get(j);
			AllianceCommission ac = new AllianceCommission();
			ac.setBusiness_type_id(arg0.getId());
			ac.setTypeName(arg0.getName());
			for(int i=0;i<list.size();i++) {
				if(list.get(i).getBusiness_type_id()==arg0.getId()) {
					ac.setId(list.get(i).getId());
					ac.setPercent(list.get(i).getPercent());
					ac.setPri_status(list.get(i).getPri_status());
				}
			}
			res.add(ac);
		}
		this.writeJSON(this.createJSONResult(CommonKey.SUCCESS_CODE, JSONArray.toJSON(res)).toJSONString());
	}
	/**
	 * 新建私有佣金
	 * @param json
	 */
	@RequestMapping("/pri/insert")
	public void priInsert(String array) {
		JSONArray json = JSONArray.parseArray(array);
		boolean res = false;
		String product_id = "";
		AllianceCommission[] acs = new AllianceCommission[json.size()];
		for(int i=0;i<json.size();i++) {
			JSONObject obj = json.getJSONObject(i);
			AllianceCommission ac = new AllianceCommission();
			ac.setPercent(obj.getInteger("percent"));
			ac.setPri_status(obj.getInteger("pri_status"));
			ac.setBusiness_type_id(obj.getInteger("business_type_id"));
			ac.setProduct_id(product_id=obj.getString("product_id"));
			acs[i] = ac;
		}
		try {
			boolean r = acService.delete(product_id);
			if(r) {
				acService.insert(acs);				
			}
			res = true;
		} catch (Exception e) {
			logger.error("新建私有佣金",e);
		}
		this.writeJSON(this.createJSONResult(CommonKey.SUCCESS_CODE, res).toJSONString());
	}
	/* 佣金commission end  */
	/**
	 * 佣金结算单列表
	 * @return
	 */
	@RequestMapping("/ceiling")
	public ModelAndView toCeiling() {
		ModelAndView model =new ModelAndView("manager/ceiling_list");
		return model;
	}
	@RequestMapping("/fashionable")
	public ModelAndView tofashionable() {
		ModelAndView model =new ModelAndView("manager/fashionable_list");
		return model;
	}
	@RequestMapping("/findSwitchByPage")
	public void querySwitchList(Integer draw,Integer salesmanId,String startTime,String endTime,Integer start,Integer length) {
		if(startTime!=null&&"".equals(startTime.trim())) {
			startTime = null;
		}
		if(endTime!=null&&"".equals(endTime.trim())) {
			endTime = null;
		}
		String search = request.getParameter("search[value]");
		if(search==null||search.isEmpty()) {
			search = null;
		}
		if(salesmanId!=null&&salesmanId==0) {
			salesmanId = null;
		}
		List<TsSwitch> list = asService.findByPage(start, length, search, null, null, startTime, endTime,salesmanId);
		
		JSONObject json = this.createJSONResult(CommonKey.SUCCESS_CODE, JSONArray.toJSON(list));
		json.put("draw", draw);
		Integer totalResult = asService.countTotal(null, null, null,salesmanId);
		json.put("recordsTotal", totalResult);
		Integer totalFilterResult = asService.countTotal(null, null, null,null);
		json.put("recordsFiltered", totalFilterResult);
		this.writeJSON(json.toJSONString());
	}
	
	@RequestMapping("/findfashionable")
	public void findfashionable(Integer draw,String startTime,String endTime,Integer start,Integer length) {
		if(startTime!=null&&"".equals(startTime.trim())) {
			startTime = null;
		}
		if(endTime!=null&&"".equals(endTime.trim())) {
			endTime = null;
		}
		String search = request.getParameter("search[value]");
		if(search==null||search.isEmpty()) {
			search = null;
		}
		
		List<Receivers> list = fasService.findfashionableByPage(start, length, search, null, null, startTime, endTime);
		
		JSONObject json = this.createJSONResult(CommonKey.SUCCESS_CODE, JSONArray.toJSON(list));
		json.put("draw", draw);
		Integer totalResult = fasService.countTotal(null, null, null);
		json.put("recordsTotal", totalResult);
		json.put("recordsFiltered", totalResult);
		this.writeJSON(json.toJSONString());
	}
	
	@RequestMapping("/updatefashionable")
	public ModelAndView updatefashionable(int id) {
		ModelAndView model =new ModelAndView("manager/updatefashionable");
		Receivers receivers=fasService.findfashionable(id);
		model.addObject("receivers", receivers);
		return model;
	}
	/**
	 * 停用
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping("/disable")
	public void disable(int id) {
		
		boolean used = asService.disable(id);
		JSONObject object = this.createJSONResult(0, String.valueOf(used));
		this.writeJSON(object.toJSONString());
		// ModelAndView model = new ModelAndView("redirect:userList.do");
		// return model;
	}

	/**
	 * 启用
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping("/enable")
	public void enable(int id) {
	
		boolean used = asService.enable(id);
		JSONObject object = this.createJSONResult(0, String.valueOf(used));
		this.writeJSON(object.toJSONString());
		// ModelAndView model = new ModelAndView("forword:userList.do");
		// return model;
	}
	@RequestMapping("/updateserviceFee")
	public ModelAndView updateserviceFee(String product_id) {
		ModelAndView model =new ModelAndView("manager/updateSfee");
		TsServiceFee servicefee=amountService.findServiceFee(product_id);
		if(servicefee==null) {
			amountService.insertServicefee(product_id);
			model.addObject("sefee", 0);
		}else {
			model.addObject("sefee", servicefee.getSefee());
		}
		model.addObject("product_id", product_id);
		return model;
	}
	
	@RequestMapping("/updatefashion")
	public void updatefashion(Integer id,String product_id,String type,String account,Double amount ,String description) {
		Receivers receivers=new Receivers();
		receivers.setId(id);
		receivers.setProduct_id(product_id);
		receivers.setType(type);
		receivers.setAccount(account);
		receivers.setAmount(amount);
		receivers.setDescription(description);
		boolean res=fasService.updatefindfashionable(receivers);
		JSONObject object = this.createJSONResult(0, res);
		this.writeJSON(object.toJSONString());
	}
	@RequestMapping("/updateSfee")
	public void updateSfee(String product_id,int sfee) {
		TsServiceFee servicefee=new TsServiceFee();
		servicefee.setProduct_id(product_id);
		servicefee.setSefee(sfee);
		boolean res=amountService.updateSfee(servicefee);
		JSONObject object = this.createJSONResult(0, res);
		this.writeJSON(object.toJSONString());
	}
	
	@RequestMapping("/deletfashionable")
	public void deletfashionable(Integer id) {
		Receivers receivers=fasService.findfashionable(id);
		Fashionable fash=new Fashionable();
		fash.setAppid("wxafec8350ab48fedc");
		fash.setMch_id("1503678581");
		fash.setSub_mch_id(receivers.getProduct_id());
		fash.setType(receivers.getType());
		fash.setAccount(receivers.getAccount());
		boolean res=false;
		Map<Object, Object> map;
		try {
			map = FashionableUtil.deletFashionable(fash);
			if (String.valueOf(map.get("return_code")).equalsIgnoreCase("SUCCESS")
					&& String.valueOf(map.get("result_code")).equalsIgnoreCase("SUCCESS")) {
				fash.setStatus("SUCCESS");
				 res=fasService.deletfashionable(id);
			}
		} catch (Exception e) {
			logger.error(e);
		}
		JSONObject object = this.createJSONResult(0, res);
		this.writeJSON(object.toJSONString());
	}
	@RequestMapping("/toAddFash")
	public ModelAndView toAddFash() {
		ModelAndView model =new ModelAndView("manager/toAddFash");
		return model;
	}
	
	@RequestMapping("/addfashionable")
	public void addfashionable(String product_id,String type,String account,Double amount,String description,String name) {
		Receivers receivers=new Receivers();
		receivers.setProduct_id(product_id);
		receivers.setType(type);
		receivers.setAccount(account);
		receivers.setAmount(amount);
		receivers.setDescription(description);
		receivers.setName(name);
		Fashionable fash=new Fashionable();
		fash.setAppid("wxafec8350ab48fedc");
		fash.setMch_id("1503678581");
		fash.setSub_mch_id(product_id);
			fash.setName(name);
		fash.setType(type);
		fash.setAccount(account);
		boolean res=false;
		try {
			Map<Object, Object> map=	FashionableUtil.addFashionable(fash);
			if (String.valueOf(map.get("return_code")).equalsIgnoreCase("SUCCESS")
					&& String.valueOf(map.get("result_code")).equalsIgnoreCase("SUCCESS")) {
				fash.setStatus("SUCCESS");
				res=fasService.addfindfashionable(receivers);
			}
		} catch (Exception e) {
			logger.error(e);
		}
		
		JSONObject object = this.createJSONResult(0, res);
		this.writeJSON(object.toJSONString());
	}
	/**
	 * 分账
	 */
	
	@RequestMapping("/addfash")
	public void addfash(String  product_id) {
		boolean res=false;
		res=alService.updatefzoff(product_id);
		JSONObject object = this.createJSONResult(0, res);
		this.writeJSON(object.toJSONString());
	}
}
