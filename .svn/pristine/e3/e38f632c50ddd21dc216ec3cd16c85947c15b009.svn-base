package com.abbot.schimneylife.util;

import java.io.IOException;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.SortedMap;
import java.util.TreeMap;

import org.apache.log4j.Logger;

import com.abbot.schimneylife.pojo.weixin.Activities;


/**
 * 微信支付代金券信息查询
 * @author Administrator
 *
 */
public class VoucherInfoUtil {
	/** 加入日志信息 */
	private static Logger logger = Logger.getLogger(VoucherInfoUtil.class);
	public static Activities VoucherPayment(Activities voucher) throws IOException {
		// 设置发放代金券的参数
		SortedMap<String, String> signParams = new TreeMap<String, String>();
		signParams.put("stock_id",voucher.getCoupon_stock_id()); //代金券批次id
		signParams.put("coupon_id", voucher.getCoupon_id()); // openid记录数
		signParams.put("openid", voucher.getOpenid()); //Openid信息，用户在appid下的openid。
		signParams.put("appid", ConfigNativeUtil.APP_ID); // 微信分配的公众账号ID（企业号corpid即为此appId）
		signParams.put("mch_id", ConfigNativeUtil.MCH_ID);// 微信支付分配的商户号
		signParams.put("nonce_str", CommonNativeUtil.getNonce_str()); // 随机字符串，不长于32位
		String sign0 = CommonNativeUtil.createSign("UTF-8", signParams, ConfigNativeUtil.API_KEY);
		signParams.put("sign", sign0);
		String requestXML = CommonNativeUtil.getRequestXml(signParams);
		// 获取证书，发送POST请求；
		String responseXML = HttpPostNativeUtil.postData(ConfigNativeUtil.URL_VOUCHER_INFO, requestXML);
		SortedMap<Object, Object> reParams = CommonNativeUtil.xmlConvertToMap(responseXML);
		logger.info("微信支付代金券信息查询结果:"+reParams.toString());
		String resXml = ""; // 反馈给微信服务器
		Activities vouchers=new Activities();
		if (String.valueOf(reParams.get("return_code")).equalsIgnoreCase("SUCCESS")
				&& String.valueOf(reParams.get("result_code")).equalsIgnoreCase("SUCCESS")) {
			
			vouchers.setCoupon_desc(String.valueOf(reParams.get("coupon_desc")));
			vouchers.setCoupon_mininum(Integer.valueOf(String.valueOf(reParams.get("coupon_minimum"))));
			vouchers.setCoupon_name(String.valueOf(reParams.get("coupon_name")));
			vouchers.setCoupon_state(String.valueOf(reParams.get("coupon_state")));
			vouchers.setCoupon_stock_id(String.valueOf(reParams.get("coupon_stock_id")));
			vouchers.setCoupon_value(Integer.valueOf(String.valueOf(reParams.get("coupon_value"))));
			vouchers.setScope(String.valueOf(reParams.get("scope")));
			vouchers.setSend_source(String.valueOf(reParams.get("send_source")));
			String s1=String.valueOf(reParams.get("end_time_t")).substring(0,4);
			String s2=String.valueOf(reParams.get("end_time_t")).substring(4,6);
			String s3=String.valueOf(reParams.get("end_time_t")).substring(6,8);
			String s4=s1+"-"+s2+"-"+s3;
			vouchers.setEndTime(s4);
			long time=TimeUtil.getTimeCha(s4);
			if("USED".equals(String.valueOf(reParams.get("coupon_state")))) {
				vouchers.setCoupon_state("USED");
			}else {
			if(time>0) {
				vouchers.setCoupon_state("EXPIRED");
			}else {
				vouchers.setCoupon_state("SENDED");
			}
			}
			vouchers.setBeginTime(String.valueOf(reParams.get("begin_time_t")));
			return vouchers;
			}
		return null;
	}
		
}
