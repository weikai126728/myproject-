package com.abbot.schimneylife.controller.weixin;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.SortedMap;
import java.util.TreeMap;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.abbot.schimneylife.controller.BaseController;
import com.abbot.schimneylife.pojo.user.User;
import com.abbot.schimneylife.pojo.weixin.Activities;
import com.abbot.schimneylife.pojo.weixin.FzVorUser;
import com.abbot.schimneylife.pojo.weixin.OrderMerchantPayment;
import com.abbot.schimneylife.pojo.weixin.OrderMerchantRedpack;
import com.abbot.schimneylife.pojo.weixin.Probability_fz;
import com.abbot.schimneylife.pojo.weixin.Voucher;
import com.abbot.schimneylife.service.weixin.RedpackService;
import com.abbot.schimneylife.util.CommonKey;
import com.abbot.schimneylife.util.ConfigNativeUtil;
import com.abbot.schimneylife.util.MerchantPaymentUtil;
import com.abbot.schimneylife.util.RedPackUtil;
import com.abbot.schimneylife.util.SessionManager;
import com.abbot.schimneylife.util.VoucherInfoUtil;
import com.abbot.schimneylife.util.VoucherSendUtil;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

@Controller
@RequestMapping("/redpack")
public class RedpackController extends BaseController {
	Logger logger = Logger.getLogger(RedpackController.class);
	@Resource
	private RedpackService redService;

	@RequestMapping("/updateRedpackGailv")
	public ModelAndView updateRedpackGailv(Probability_fz probability_fz) {
		logger.info("红包概率所修改的编号为：" + probability_fz.getZipcode()+" 地区为:"+probability_fz.getMerername());
		boolean boo = redService.updateRedpackGailv(probability_fz);
		if (boo) {
			logger.info("修改成功！！");
			ModelAndView model = new ModelAndView("manager/tips");
			model.addObject("msg", "修改成功！！");
			return model;
		} else {
			logger.error("修改红包概率失败！！");
			ModelAndView model = new ModelAndView("manager/tips");
			model.addObject("msg", "修改失败");
			return model;
		}
	}

	@RequestMapping("/index")
	public ModelAndView index(String typeId) {
		ModelAndView model = new ModelAndView("manager/red_list");
		Integer totalCount = redService.countTotal();
		Probability_fz probability_fz=new Probability_fz();
		List<Probability_fz> listpro=redService.queryPromoneyByzipcode(probability_fz);
		model.addObject("listpro", listpro.get(0));
		model.addObject("totalCount", totalCount);
		if (typeId != null && !typeId.isEmpty()) {
			model.addObject("typeIde", typeId);
		}
		return model;
	}

	@RequestMapping("/redgailv_list")
	public void findByType(Integer draw, String typeId, Integer start, Integer length) {
		String search = request.getParameter("search[value]");
		if (search == null || search.isEmpty()) {
			search = null;
		}
		Integer orderCol = Integer.valueOf(request.getParameter("order[0][column]"));
		String order = request.getParameter("order[0][dir]");
		String column = "id";
		if (orderCol != null) {
			switch (orderCol) {
			case 6:
				column = "create_time";
				break;
			case 7:
				column = "param_status";
				break;
			}
		}
		List<Probability_fz> proList = redService.queryRedgailvList(search, column,
				"asc".equals(order) ? "asc" : "desc", typeId == null || typeId.trim().isEmpty() ? null : typeId, start,
				length);
		JSONObject json = this.createJSONResult(CommonKey.SUCCESS_CODE, JSONArray.toJSON(proList));
		json.put("draw", draw);
		Integer totalResult = redService.countTotal();
		json.put("recordsTotal", totalResult);
		Integer totalFilterResult = redService.countTotal();
		json.put("recordsFiltered", totalFilterResult);
		this.writeJSON(json.toJSONString());
	}

	@RequestMapping("/queryRedgailvByzipcode")
	public ModelAndView queryRedgailvByzipcode(String merername) {
		Probability_fz probability_fz = new Probability_fz();
		logger.info("红包概率所修改的地区为:" + merername);
		probability_fz.setMerername(merername);
		Probability_fz pro_fz = redService.queryRedgailvByzipcode(probability_fz);
		ModelAndView model = new ModelAndView("manager/red_update");
		model.addObject("probability_fz", pro_fz);
		return model;
	}

	@RequestMapping("/queryLikeRedpackGailvCount")
	public ModelAndView queryLikeRedpackGailvCount(Probability_fz probability_fz) {
		logger.info("红包概率所修改的搜索查询地区为（查询条数）:" + probability_fz.getMerername());
		int totalCount = redService.queryLikeRedpackGailvCuont(probability_fz);
		Probability_fz probability_f=new Probability_fz();
		List<Probability_fz> listpro=redService.queryPromoneyByzipcode(probability_f);
		ModelAndView model = new ModelAndView("manager/red_like");
		model.addObject("listpro", listpro.get(0));
		model.addObject("totalCount", totalCount);
		model.addObject("merername", probability_fz.getMerername());
		return model;
	}

	@RequestMapping("/queryLikeRedpackGailv")
	public void queryLikeRedpackGailv(Probability_fz probability_fz, Integer draw, String typeId, Integer start,
			Integer length) {
		String search = request.getParameter("search[value]");
		if (search == null || search.isEmpty()) {
			search = null;
		}
		Integer orderCol = Integer.valueOf(request.getParameter("order[0][column]"));
		String order = request.getParameter("order[0][dir]");
		String column = "id";
		if (orderCol != null) {
			switch (orderCol) {
			case 6:
				column = "create_time";
				break;
			case 7:
				column = "param_status";
				break;
			}
		}
		logger.info("红包概率所修改的搜索查询地区为:" + probability_fz.getMerername());
		String merername = probability_fz.getMerername();
		List<Probability_fz> proList = redService.queryLikeRedpackGailv(merername, search, column,
				"asc".equals(order) ? "asc" : "desc", typeId == null || typeId.trim().isEmpty() ? null : typeId, start,
				length);
		JSONObject json = this.createJSONResult(CommonKey.SUCCESS_CODE, JSONArray.toJSON(proList));
		json.put("draw", draw);
		Integer totalResult = redService.queryLikeRedpackGailvCuont(probability_fz);
		json.put("recordsTotal", totalResult);
		Integer totalFilterResult = redService.queryLikeRedpackGailvCuont(probability_fz);
		json.put("recordsFiltered", totalFilterResult);
		this.writeJSON(json.toJSONString());
	}

	@RequestMapping("/queryBufaRedCount")
	public ModelAndView queryBufaRedCount() {
		int totalCount = redService.queryBufaRedCount();
		ModelAndView model = new ModelAndView("manager/red_bufa");
		model.addObject("totalCount", totalCount);
		return model;
	}

	@RequestMapping("/queryBufaRedlist")
	public void queryBufaRedlist(Integer draw, String typeId, Integer start, Integer length) {
		String search = request.getParameter("search[value]");
		if (search == null || search.isEmpty()) {
			search = null;
		}
		Integer orderCol = Integer.valueOf(request.getParameter("order[0][column]"));
		String order = request.getParameter("order[0][dir]");
		String column = "id";
		if (orderCol != null) {
			switch (orderCol) {
			case 6:
				column = "create_time";
				break;
			case 7:
				column = "param_status";
				break;
			}
		}
		
		List<OrderMerchantRedpack> bufa_redpList = redService.queryBufaRedlist(search, column,
				"asc".equals(order) ? "asc" : "desc", typeId == null || typeId.trim().isEmpty() ? null : typeId, start,
				length);
		
		/**测试bufa_redpList返回数据*/
		for (OrderMerchantRedpack f : bufa_redpList) {
			logger.info("红包补发列表的用户OPENID为:" + f.getRe_openid());
		}
		
		JSONObject json = this.createJSONResult(CommonKey.SUCCESS_CODE, JSONArray.toJSON(bufa_redpList));
		json.put("draw", draw);
		Integer totalResult = redService.queryBufaRedCount();
		json.put("recordsTotal", totalResult);
		Integer totalFilterResult = redService.queryBufaRedCount();
		json.put("recordsFiltered", totalFilterResult);
		this.writeJSON(json.toJSONString());
	}

	@RequestMapping("/redpackBufa")
	public ModelAndView redpackBufa(OrderMerchantRedpack orderMerchantRedpack) {
		logger.info("红包补发的OPENID为：" + orderMerchantRedpack.getRe_openid() + " 红包金额为："
				+ orderMerchantRedpack.getTotal_amount());
		OrderMerchantRedpack orderRedpack = RedPackUtil.sendRedPack(orderMerchantRedpack);
		if (orderRedpack != null && !orderRedpack.equals("")) {
			logger.info("红包补发成功！！");
			ModelAndView model = new ModelAndView("manager/tips");
			model.addObject("msg", "补发成功！！");
			model.addObject("path", "redpack/queryBufaRedCount.do");
			orderRedpack.setRedid(orderMerchantRedpack.getRedid());
			boolean boo = redService.redBufaUpdate(orderRedpack);
			if (boo) {
				logger.info("红包补发成功后状态修改成功");
			}
			return model;
		} else {
			logger.info("红包补发失败！！");
			ModelAndView model = new ModelAndView("manager/tips");
			model.addObject("msg", "补发失败");
			return model;
		}
	}

	@RequestMapping("/redpackFafang")
	public void redpackFafang(OrderMerchantRedpack orderMerchantRedpack) {
		logger.info("红包手动发放的"+orderMerchantRedpack.getRe_openid() +" 金额为："+orderMerchantRedpack.getTotal_amount());
		OrderMerchantRedpack orderRedpack = RedPackUtil.sendRedPack(orderMerchantRedpack);
		if (orderRedpack != null && !orderRedpack.equals("")) {
			logger.info("红包手动发放成功");
			JSONObject json = this.createJSONResult(CommonKey.SUCCESS_CODE, "true");
			this.writeJSON(json.toJSONString());
			boolean boo = redService.addRedpackFafang(orderRedpack);
			if (boo) {
				logger.info("红包手动发放信息存储成功");
			}
		} else {
			logger.info("红包手动发放失败");
			JSONObject json = this.createJSONResult(CommonKey.SUCCESS_CODE, "false");
			this.writeJSON(json.toJSONString());
		}
	}

	@RequestMapping("/redpackQiyezhuanzhang")
	public void redpackQiyezhuanzhang(String alopenid, Integer merchantpayment) {
		User user = SessionManager.getAttribute(request, SessionManager.Key.USER);
		logger.info("企业转账的用户为："+alopenid+" 金额为："+merchantpayment+"操作人为:"+user.getNickName());
		SortedMap<Object, Object> map = new TreeMap<Object, Object>();
		try {
			map = (SortedMap<Object, Object>) MerchantPaymentUtil.merchantPayment(alopenid, merchantpayment);
			if (String.valueOf(map.get("return_code")).equalsIgnoreCase("SUCCESS")
					&& String.valueOf(map.get("result_code")).equalsIgnoreCase("SUCCESS")) {
				logger.info("企业付款加盟商任务成功");
				OrderMerchantPayment orderMerchantPayment = new OrderMerchantPayment();
				orderMerchantPayment.setPayment_no(String.valueOf(map.get("payment_no")));
				orderMerchantPayment.setPartner_trade_no(String.valueOf(map.get("partner_trade_no")));
				orderMerchantPayment.setMchid(ConfigNativeUtil.MCH_ID);
				orderMerchantPayment.setMch_appid(ConfigNativeUtil.APP_ID);
				orderMerchantPayment.setMerchantpayment(merchantpayment);
				orderMerchantPayment.setStorename("企业手动转账");
				orderMerchantPayment.setAlname("操作人为："+user.getNickName());
				orderMerchantPayment.setAlopenid(alopenid);
				boolean boo = redService.addMerchantPayment(orderMerchantPayment);
				if (boo) {
					System.out.println("手动企业付款存储成功");
				}
				JSONObject json = this.createJSONResult(CommonKey.SUCCESS_CODE, "true");
				this.writeJSON(json.toJSONString());
			} else {
				logger.info("企业付款加盟商任务失败");
				JSONObject json = this.createJSONResult(CommonKey.SUCCESS_CODE, "false");
				this.writeJSON(json.toJSONString());
			}
		} catch (IOException e) {
			logger.error("企业付款加盟商任务是异常",e);
		}
	}

	@RequestMapping("/CommissionSettlement")
	public void  CommissionSettlement(String alopenid, Integer merchantpayment) {
		User user = SessionManager.getAttribute(request, SessionManager.Key.USER);
		logger.error("佣金结算的用户为："+alopenid+" 金额为："+merchantpayment+"操作人为:"+user.getNickName());
		
		SortedMap<Object, Object> map = new TreeMap<Object, Object>();
		try {
			map = (SortedMap<Object, Object>) MerchantPaymentUtil.merchantPayment(alopenid, merchantpayment);
			if (String.valueOf(map.get("return_code")).equalsIgnoreCase("SUCCESS")
					&& String.valueOf(map.get("result_code")).equalsIgnoreCase("SUCCESS")) {
				logger.error("佣金结算任务成功");
				OrderMerchantPayment orderMerchantPayment = new OrderMerchantPayment();
				orderMerchantPayment.setPayment_no(String.valueOf(map.get("payment_no")));
				orderMerchantPayment.setPartner_trade_no(String.valueOf(map.get("partner_trade_no")));
				orderMerchantPayment.setMchid(ConfigNativeUtil.MCH_ID);
				orderMerchantPayment.setMch_appid(ConfigNativeUtil.APP_ID);
				orderMerchantPayment.setMerchantpayment(merchantpayment);
				orderMerchantPayment.setAlopenid(alopenid);
				orderMerchantPayment.setResult_code(String.valueOf(map.get("result_code")));
				orderMerchantPayment.setReturn_code(String.valueOf(map.get("return_code")));
				orderMerchantPayment.setPayment_time(String.valueOf(map.get("payment_time")));
				boolean boo = redService.addCommissionSettlement(orderMerchantPayment);
				if (boo) {
					System.out.println("手动佣金结算信息存储成功");
				}
				JSONObject json = this.createJSONResult(CommonKey.SUCCESS_CODE, "true");
				this.writeJSON(json.toJSONString());
			} else {
				OrderMerchantPayment orderMerchantPayment = new OrderMerchantPayment();
				orderMerchantPayment.setMchid(ConfigNativeUtil.MCH_ID);
				orderMerchantPayment.setMch_appid(ConfigNativeUtil.APP_ID);
				orderMerchantPayment.setMerchantpayment(merchantpayment);
				orderMerchantPayment.setAlopenid(alopenid);
				orderMerchantPayment.setResult_code(String.valueOf(map.get("result_code")));
				orderMerchantPayment.setReturn_code(String.valueOf(map.get("return_code")));
				orderMerchantPayment.setErr_code_des(String.valueOf(map.get("err_code_des")));
				boolean boo = redService.addCommissionSettlement(orderMerchantPayment);
				if (boo) {
					System.out.println("手动佣金结算信息存储成功");
				}
				logger.error("佣金结算失败");
				JSONObject json = this.createJSONResult(CommonKey.SUCCESS_CODE, "false");
				this.writeJSON(json.toJSONString());
			}
		} catch (IOException e) {
			logger.error("佣金结算异常",e);
		}
	}

	@RequestMapping("/addVoucher")
	public void addVoucher(Voucher voucher) {
		boolean boo = redService.addVoucher(voucher);
		if (boo) {
			logger.info("添加代金券批次信息成功");
			JSONObject json = this.createJSONResult(CommonKey.SUCCESS_CODE, "true");
			this.writeJSON(json.toJSONString());
		} else {
			logger.info("添加代金券批次信息失败");
			JSONObject json = this.createJSONResult(CommonKey.SUCCESS_CODE, "false");
			this.writeJSON(json.toJSONString());
		}
	}

	@RequestMapping("/queryVoucherlist")
	public void queryVoucherlist(Integer draw, String typeId, Integer start, Integer length) {
		String search = request.getParameter("search[value]");
		if (search == null || search.isEmpty()) {
			search = null;
		}
		Integer orderCol = Integer.valueOf(request.getParameter("order[0][column]"));
		String order = request.getParameter("order[0][dir]");
		String column = "id";
		if (orderCol != null) {
			switch (orderCol) {
			case 6:
				column = "create_time";
				break;
			case 7:
				column = "param_status";
				break;
			}
		}
		Date d = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String sendTime = String.valueOf(sdf.format(d));
		logger.info("查询代金券批次时获取的当前时间为（sendTime）:"+sendTime);
		List<Voucher> voucherList = redService.queryVoucherlist(sendTime, search, column,
				"asc".equals(order) ? "asc" : "desc", typeId == null || typeId.trim().isEmpty() ? null : typeId, start,
				length);
		JSONObject json = this.createJSONResult(CommonKey.SUCCESS_CODE, JSONArray.toJSON(voucherList));
		json.put("draw", draw);
		Integer totalResult = redService.queryVoucherCount(sendTime);
		json.put("recordsTotal", totalResult);
		Integer totalFilterResult = redService.queryVoucherCount(sendTime);
		json.put("recordsFiltered", totalFilterResult);
		this.writeJSON(json.toJSONString());
	}

	@RequestMapping("/queryVoucherCount")
	public ModelAndView queryVoucherCount() {
		Date d = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String sendTime = String.valueOf(sdf.format(d));
		logger.info("查询代金券批次数量时获取的当前时间为（sendTime）:"+sendTime);
		int totalCount = redService.queryVoucherCount(sendTime);
		ModelAndView model = new ModelAndView("manager/red_voucher_list");
		model.addObject("totalCount", totalCount);
		return model;
	}

	@RequestMapping("/addUserActivities")
	public ModelAndView addUserActivities(Activities voucher) {

		/** 根据当前时间查询代金券批次 */
		Voucher vouchers = new Voucher();
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");// 设置日期格式
		String date1 = df.format(new Date());// new Date()为获取当前系统时间
		logger.info("用户发放代金券所查询批次时获取的当前时间为（date1）:"+date1);
		vouchers.setSendTime(date1);
		List<Voucher> coupon_stock_idlist = redService.getSendCoupon_stock_id(vouchers);
		logger.info("代金券查询可用批次数量（coupon_stock_idlist.size()）："+coupon_stock_idlist.size());
		
		Activities activity = new Activities();
		Activities activity1 = new Activities();
		Activities Activities = new Activities();
		activity.setOpenid(voucher.getOpenid());
		
		ModelAndView model = new ModelAndView("manager/tips");
		
		if(coupon_stock_idlist!=null&&coupon_stock_idlist.size()>0) {
		int b=coupon_stock_idlist.size();
		for (int i = 0; i < b && i < 4; i++) {
			logger.info("循环发放的批次号(coupon_stock_idlist.get(i).getCoupon_stock_id()):"+coupon_stock_idlist.get(i).getCoupon_stock_id());
			activity.setCoupon_stock_id(coupon_stock_idlist.get(i).getCoupon_stock_id());
				try {
					activity1 = VoucherSendUtil.VoucherPayment(activity);
					String msg=activity1.getMsg();
					if(msg!=null&&msg.equals("成功")) {
						Activities = VoucherInfoUtil.VoucherPayment(activity1);
						Activities.setOpenid(activity1.getOpenid());
						Activities.setCoupon_stock_id(activity1.getCoupon_stock_id());
						Activities.setGetTime(activity1.getGetTime());
						Activities.setCoupon_id(activity1.getCoupon_id());
						if (Activities != null) {
							Activities.setCount(1);
							Activities.setCadeId(coupon_stock_idlist.get(i).getCadeId());
							boolean boo = redService.addUserVoucher(Activities);
							logger.info("存储领券信息结果:"+boo);
							if (boo) {
								logger.info("存储领券信息成功");
								model.addObject("msg", "代金券发送成功");
								model.addObject("path", "redpack/getActivitiesCountList.do");
							} else {
								logger.info("存储领券信息失败");
								model.addObject("msg", "代金券发送失败");
								model.addObject("path", "redpack/queryFzvoruserCount.do");
							}
						}
						logger.error("微信支付代金券信息查询时异常");
					}else {
						logger.error("微信代金券发送失败");
						activity.setMsg("领券失败，查看原因："+msg);
						redService.addNoGetVouchers(activity);
						
						model.addObject("path", "redpack/queryFzvoruserCount.do");
						model.addObject("msg", "代金券发送失败");
					}
					} catch (IOException e) {
						logger.error("代金券发放时异常",e);
					}
						
		}
		}else {
			activity.setMsg("领券失败，查看原因：无可有代金券");
			redService.addNoGetVouchers(activity);
			model.addObject("path", "redpack/queryFzvoruserCount.do");
			model.addObject("msg", "代金券发送失败");
		}
		return model;
	}
	@RequestMapping("/getActivitiesCountList")
	public ModelAndView getActivitiesCountList() {
		Activities activity = new Activities();
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");// 设置日期格式
		String date2 = df.format(new Date());// new Date()为获取当前系统时间
		logger.info("查询用户代金券数量时当前时间为(date2):"+date2);
		activity.setEndTime(date2);
		int totalCount = redService.getActivitiesCountList(activity);
		ModelAndView model = new ModelAndView("manager/red_activity_zhengchang_list");
		model.addObject("totalCount", totalCount);
		return model;
	}
	@RequestMapping("/getActivitiesList")
	public void getActivitiesList(Integer draw, String typeId, Integer start, Integer length) {
		String search = request.getParameter("search[value]");
		if (search == null || search.isEmpty()) {
			search = null;
		}
		Integer orderCol = Integer.valueOf(request.getParameter("order[0][column]"));
		String order = request.getParameter("order[0][dir]");
		String column = "aid";
		if (orderCol != null) {
			switch (orderCol) {
			case 6:
				column = "create_time";
				break;
			case 7:
				column = "param_status";
				break;
			}
		}
		Activities activity = new Activities();
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");// 设置日期格式
		String date3 = df.format(new Date());// new Date()为获取当前系统时间
		logger.info("查询用户代金券时当前时间为(date3):"+date3);
		activity.setEndTime(date3);
		List<Activities> voucherList = redService.getActivitiesList(date3, search, column,
				"asc".equals(order) ? "asc" : "desc", typeId == null || typeId.trim().isEmpty() ? null : typeId, start,
				length);
		/**测试查询用户代金券结果voucherList*/
		for (Activities a : voucherList) {
			logger.info("用户代金券的EndTime:"+a.getEndTime());
		}
		
		JSONObject json = this.createJSONResult(CommonKey.SUCCESS_CODE, JSONArray.toJSON(voucherList));
		json.put("draw", draw);
		Integer totalResult = redService.getActivitiesCountList(activity);
		json.put("recordsTotal", totalResult);
		Integer totalFilterResult = redService.getActivitiesCountList(activity);
		json.put("recordsFiltered", totalFilterResult);
		this.writeJSON(json.toJSONString());
	}
	@RequestMapping("/getActivitiesCountLikeList")
	public ModelAndView getActivitiesCountLikeList(String activitsName) {
		int totalCount = redService.getActivitiesCountLikeList(activitsName);
		ModelAndView model = new ModelAndView("manager/red_activity_zhengchang_likelist");
		model.addObject("totalCount", totalCount);
		model.addObject("activitsName", activitsName);
		return model;
	}
	@RequestMapping("/getActivitiesLikeList")
	public void getActivitiesLikeList(String activitsName,Integer draw, String typeId, Integer start, Integer length) {
		String search = request.getParameter("search[value]");
		if (search == null || search.isEmpty()) {
			search = null;
		}
		Integer orderCol = Integer.valueOf(request.getParameter("order[0][column]"));
		String order = request.getParameter("order[0][dir]");
		String column = "aid";
		if (orderCol != null) {
			switch (orderCol) {
			case 6:
				column = "create_time";
				break;
			case 7:
				column = "param_status";
				break;
			}
		}
		System.out.println("activitsName为:"+activitsName);
		List<Activities> voucherList = redService.getActivitiesLikeList(activitsName, search, column,
				"asc".equals(order) ? "asc" : "desc", typeId == null || typeId.trim().isEmpty() ? null : typeId, start,
				length);
		
		/**快速查询用户代金券结果voucherList*/
		for (Activities a : voucherList) {
			logger.info("快速查询用户代金券EndTime:"+a.getEndTime());
		}
		JSONObject json = this.createJSONResult(CommonKey.SUCCESS_CODE, JSONArray.toJSON(voucherList));
		json.put("draw", draw);
		Integer totalResult = redService.getActivitiesCountLikeList(activitsName);
		json.put("recordsTotal", totalResult);
		Integer totalFilterResult = redService.getActivitiesCountLikeList(activitsName);
		json.put("recordsFiltered", totalFilterResult);
		this.writeJSON(json.toJSONString());
	}
	
	@RequestMapping("/queryOverdueVouchersCountBytime")
	public ModelAndView queryOverdueVouchersCountBytime() {
		int totalCount = redService.queryOverdueVouchersCountBytime();
		ModelAndView model = new ModelAndView("manager/red_activity_guoqi_list");
		model.addObject("totalCount", totalCount);
		return model;
	}
	@RequestMapping("/queryOverdueVouchersBytime")
	public void queryOverdueVouchersBytime(Integer draw, String typeId, Integer start, Integer length) {
		String search = request.getParameter("search[value]");
		if (search == null || search.isEmpty()) {
			search = null;
		}
		Integer orderCol = Integer.valueOf(request.getParameter("order[0][column]"));
		String order = request.getParameter("order[0][dir]");
		String column = "aid";
		if (orderCol != null) {
			switch (orderCol) {
			case 6:
				column = "create_time";
				break;
			case 7:
				column = "param_status";
				break;
			}
		}
		
		List<Activities> voucherList = redService.queryOverdueVouchersBytime(search, column,
				"asc".equals(order) ? "asc" : "desc", typeId == null || typeId.trim().isEmpty() ? null : typeId, start,
				length);
		
		/**根据时间查询需发送代金券的用户voucherList*/
		for (Activities a : voucherList) {
			logger.info("根据时间查询代金券的批次EndTime:"+a.getEndTime());
		}
		JSONObject json = this.createJSONResult(CommonKey.SUCCESS_CODE, JSONArray.toJSON(voucherList));
		json.put("draw", draw);
		Integer totalResult = redService.queryOverdueVouchersCountBytime();
		json.put("recordsTotal", totalResult);
		Integer totalFilterResult = redService.queryOverdueVouchersCountBytime();
		json.put("recordsFiltered", totalFilterResult);
		this.writeJSON(json.toJSONString());
	}
	
	
	@RequestMapping("/queryFzvoruserCount")
	public ModelAndView queryFzvoruserCount() {
		int totalCount = redService.queryFzvoruserCount();
		ModelAndView model = new ModelAndView("manager/red_fzvoruser_fafang");
		model.addObject("totalCount", totalCount);
		return model;
	}
	@RequestMapping("/queryFzvoruserList")
	public void queryFzvoruserList(Integer draw, String typeId, Integer start, Integer length) {
		String search = request.getParameter("search[value]");
		if (search == null || search.isEmpty()) {
			search = null;
		}
		Integer orderCol = Integer.valueOf(request.getParameter("order[0][column]"));
		String order = request.getParameter("order[0][dir]");
		String column = "fid";
		if (orderCol != null) {
			switch (orderCol) {
			case 6:
				column = "create_time";
				break;
			case 7:
				column = "param_status";
				break;
			}
		}
		
		List<FzVorUser> voucherList = redService.queryFzvoruserList(search, column,
				"asc".equals(order) ? "asc" : "desc", typeId == null || typeId.trim().isEmpty() ? null : typeId, start,
				length);
		
		/**查询需要发送代金券的用户voucherList*/
		for (FzVorUser a : voucherList) {
			logger.info("查询需要发送代金券的用户的openid为："+a.getOpenid()+" 的状态为:"+a.getTag());
		}
		JSONObject json = this.createJSONResult(CommonKey.SUCCESS_CODE, JSONArray.toJSON(voucherList));
		json.put("draw", draw);
		Integer totalResult = redService.queryFzvoruserCount();
		json.put("recordsTotal", totalResult);
		Integer totalFilterResult = redService.queryFzvoruserCount();
		json.put("recordsFiltered", totalFilterResult);
		this.writeJSON(json.toJSONString());
	}
	
	@RequestMapping("/queryPromoneyByzipcode")
	public ModelAndView queryPromoneyByzipcode() {
		Probability_fz probability_fz = new Probability_fz();
		Probability_fz probability_f=new Probability_fz();
		List<Probability_fz> list = redService.queryPromoneyByzipcode(probability_fz);
		if(list!=null&&list.size()>0) {
			probability_f=list.get(0);
		}
		ModelAndView model = new ModelAndView("manager/red_update_promoney");
		model.addObject("probability_fz", probability_f);
		return model;
	} 
	@RequestMapping("/queryPromoneyByzipcode2")
	public ModelAndView queryPromoneyByzipcode2() {
		Probability_fz probability_fz = new Probability_fz();
		Probability_fz probability_f=new Probability_fz();
		List<Probability_fz> list = redService.queryPromoneyByzipcode(probability_fz);
		if(list!=null&&list.size()>0) {
			probability_f=list.get(0);
		}
		ModelAndView model = new ModelAndView("manager/red_update_promoney2");
		model.addObject("probability_fz", probability_f);
		return model;
	} 
	@RequestMapping("/queryPromoneyByzipcode3")
	public ModelAndView queryPromoneyByzipcode3() {
		Probability_fz probability_fz = new Probability_fz();
		Probability_fz probability_f=new Probability_fz();
		List<Probability_fz> list = redService.queryPromoneyByzipcode(probability_fz);
		if(list!=null&&list.size()>0) {
			probability_f=list.get(0);
		}
		ModelAndView model = new ModelAndView("manager/red_update_promoney3");
		model.addObject("probability_fz", probability_f);
		return model;
	} 
	@RequestMapping("/updatePromoney")
	public ModelAndView updatePromoney(Probability_fz probability_fz) {
		List<Probability_fz> list = redService.queryPromoneyByzipcode(probability_fz);
		list.get(0).getLowMoney();list.get(0).getMiddleMoney();list.get(0).getSeniorMoney();
		boolean bo=false;
		if(probability_fz.getLowMoney()!=null) {
			if(probability_fz.getLowMoney()<list.get(0).getMiddleMoney()) {
				bo=true;
			}
		}
		if(probability_fz.getMiddleMoney()!=null) {
			if(probability_fz.getMiddleMoney()<list.get(0).getSeniorMoney()&&probability_fz.getMiddleMoney()>list.get(0).getLowMoney()) {
				bo=true;
			}
		}
		if(probability_fz.getSeniorMoney()!=null) {
			if(probability_fz.getSeniorMoney()>list.get(0).getMiddleMoney()) {
				bo=true;
			}
		}
		if(!bo) {
			logger.error("修改红包概率失败！！");
			ModelAndView model = new ModelAndView("manager/tips");
			model.addObject("msg", "修改失败");
			return model;
		}
		boolean bool=redService.updatePromoney(probability_fz);
		if (bool) {
			logger.info("修改成功！！");
			ModelAndView model = new ModelAndView("manager/tips");
			model.addObject("msg", "修改成功！！");
			return model;
		} else {
			logger.error("修改红包概率失败！！");
			ModelAndView model = new ModelAndView("manager/tips");
			model.addObject("msg", "修改失败");
			return model;
		}
	}
	
	
}
