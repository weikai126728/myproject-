package com.abbot.schimneylife.util;

import java.util.SortedMap;
import java.util.TreeMap;

import org.apache.log4j.Logger;

import com.abbot.schimneylife.pojo.weixin.Faile_redp;
import com.abbot.schimneylife.pojo.weixin.OrderMerchantRedpack;

public class RedPackUtil {

	private static final Logger logger = Logger.getLogger(RedPackUtil.class);
	public static OrderMerchantRedpack sendRedPack(OrderMerchantRedpack orderRedpack) {
		OrderMerchantRedpack orderMerchantRedpack=new OrderMerchantRedpack();
		// 设置支付参数
		logger.info("传入金额为："+orderRedpack.getTotal_amount());
		String total_amount=orderRedpack.getTotal_amount()>=100?String.valueOf(new Double(orderRedpack.getTotal_amount()).intValue()):String.valueOf(new Double(Double.valueOf(String.valueOf(Math.random()*0.1).substring(0,4))*100).intValue()+100);
		System.out.println("红包发送的金额为："+total_amount);
		String mch_billno=ConfigNativeUtil.MCH_ID+CommonNativeUtil.getNonce_str();
		logger.info("红包补发的OPENID为："+orderRedpack.getRe_openid()+"红包发送的金额为："+orderRedpack.getTotal_amount());
		SortedMap<String, String> params = new TreeMap<String, String>();
		params.put("nonce_str", CommonNativeUtil.getNonce_str());// 随机字符串
		params.put("mch_billno", mch_billno);// 商户订单号（每个订单号必须唯一）组成：mch_id+yyyymmdd+10位一天内不能重复的数字
		params.put("mch_id", ConfigNativeUtil.MCH_ID);// 商户号
		params.put("wxappid", ConfigNativeUtil.APP_ID);// 公众号id
		params.put("send_name", "炊烟生活"); // 商户名称
		params.put("re_openid", orderRedpack.getRe_openid());// 用户公众号唯一识别
		params.put("total_amount",total_amount);// 因为微信的total_amount的单位是分，所有需要乘以100
		params.put("total_num", "1");// 红包发放总人数
		params.put("wishing", "恭喜发财，大吉大利");// 祝福语
		params.put("client_ip", ConfigNativeUtil.CREATE_IP);// Ip地址
		params.put("act_name", "扫码支付");// 活动名称
		params.put("remark", "王者猜猜猜兑大奖");// 备注
		String sign = CommonNativeUtil.createSign("UTF-8", params, ConfigNativeUtil.API_KEY);
		params.put("sign", sign);
		String requestXML = CommonNativeUtil.getRequestXml(params);
		String responseXML = new SslMerchtPostUtil().ssl(ConfigNativeUtil.MENU_REDENVELOPES_URL, requestXML);
		SortedMap<Object, Object> reParams = CommonNativeUtil.xmlConvertToMap(responseXML);
		logger.info("红包补发结果信息为："+reParams.toString());
		if (String.valueOf(reParams.get("return_code")).equalsIgnoreCase("SUCCESS")
				&& String.valueOf(reParams.get("result_code")).equalsIgnoreCase("SUCCESS")) {
			orderMerchantRedpack.setMchid(ConfigNativeUtil.MCH_ID);
			orderMerchantRedpack.setWxappid(ConfigNativeUtil.APP_ID);
			orderMerchantRedpack.setRe_openid(orderRedpack.getRe_openid());
			orderMerchantRedpack.setTotal_fee(0);
			orderMerchantRedpack.setTotal_amount(Integer.valueOf(String.valueOf(reParams.get("total_amount"))));
			orderMerchantRedpack.setMch_billno( (String)reParams.get("mch_billno"));
			orderMerchantRedpack.setSend_listid( (String)reParams.get("send_listid"));
			orderMerchantRedpack.setSendredPackamount(0.0D);
			orderMerchantRedpack.setProduct_id("手动发送");
			System.out.println("红包发送成功："+reParams.toString());
			return orderMerchantRedpack;
		}else {
			System.out.println("红包发送失败"+reParams.toString());
			return null; 
		}

	}
}
