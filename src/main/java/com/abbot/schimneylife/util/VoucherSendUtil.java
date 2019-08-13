package com.abbot.schimneylife.util;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.abbot.schimneylife.pojo.weixin.Activities;


/**
 * 微信支付代金券发放
 * @author Administrator
 *
 */
public class VoucherSendUtil {
	/** 加入日志信息 */
	private static Logger logger = Logger.getLogger(VoucherSendUtil.class);
	public static Activities VoucherPayment(Activities voucher) throws IOException {
		// 设置发放代金券的参数
		logger.info("发放的openid为："+voucher.getOpenid()+"+代金券批次为:"+voucher.getCoupon_stock_id());
		SortedMap<String, String> signParams = new TreeMap<String, String>();
		signParams.put("coupon_stock_id",voucher.getCoupon_stock_id()); //代金券批次id
		signParams.put("openid_count", "1"); // openid记录数
		signParams.put("partner_trade_no", ConfigNativeUtil.MCH_ID+System.currentTimeMillis()+CommonNativeUtil.getNonce_str()); // 商户订单号，需保持唯一性
		signParams.put("openid", voucher.getOpenid()); //Openid信息，用户在appid下的openid。
		signParams.put("appid", ConfigNativeUtil.APP_ID); // 微信分配的公众账号ID（企业号corpid即为此appId）
		signParams.put("mch_id", ConfigNativeUtil.MCH_ID);// 微信支付分配的商户号
		signParams.put("nonce_str", CommonNativeUtil.getNonce_str()); // 随机字符串，不长于32位
		String sign0 = CommonNativeUtil.createSign("UTF-8", signParams, ConfigNativeUtil.API_KEY);
		signParams.put("sign", sign0);
		String requestXML = CommonNativeUtil.getRequestXml(signParams);
		// 获取证书，发送POST请求；
		String responseXML = new SslMerchtPostUtil().ssl(ConfigNativeUtil.URL_SEND_VOUCHER, requestXML);
		SortedMap<Object, Object> reParams = CommonNativeUtil.xmlConvertToMap(responseXML);
		//String msg=reParams.toString();
		String msg=(String) reParams.get("err_code_des");
		System.out.println("err_code_des:"+msg);
		logger.info("微信支付代金券发放结果:"+reParams.toString());
		Activities activity=new Activities();
		if (String.valueOf(reParams.get("return_code")).equalsIgnoreCase("SUCCESS")
				&& String.valueOf(reParams.get("result_code")).equalsIgnoreCase("SUCCESS")) {
			activity.setCoupon_stock_id(String.valueOf(reParams.get("coupon_stock_id")));	
			activity.setCoupon_id(String.valueOf(reParams.get("coupon_id")));	
			activity.setOpenid(String.valueOf(reParams.get("openid")));	
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");//设置日期格式
			activity.setGetTime(df.format(new Date()));// new Date()为获取当前系统时间
			activity.setMsg("成功");
			}
		activity.setMsg(msg);
		return activity;
	}
		
}
