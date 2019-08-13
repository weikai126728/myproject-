package com.abbot.schimneylife.util;

import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

import org.apache.log4j.Logger;

import com.abbot.schimneylife.pojo.weixin.Fashionable;
import com.alibaba.fastjson.JSONObject;
import com.github.wxpay.sdk.WXPayConstants;
import com.github.wxpay.sdk.WXPayConstants.SignType;
import com.github.wxpay.sdk.WXPayUtil;


public class FashionableUtil {
	private static Logger logger = Logger.getLogger(FashionableUtil.class);

	public static Map<Object, Object> addFashionable(Fashionable Fashionable) throws Exception {
		logger.info("执行企业向加盟商付款流程方法");
		// 设置支付参数
		SortedMap<String, String> signParams = new TreeMap<String, String>();
		JSONObject map1=new JSONObject();
		map1.put("type",Fashionable.getType());
		map1.put("account", Fashionable.getAccount());
		if(Fashionable.getName()!=null&&!"".equalsIgnoreCase(Fashionable.getName())) {
			map1.put("name",Fashionable.getName());
		}
		System.out.println(map1.toString());
		logger.info("企业向加盟商:" +  " Fashionable.getReceivers()：" + Fashionable.getReceivers());
		signParams.put("sub_mch_id", Fashionable.getSub_mch_id()); // 微信分配的公众账号ID（企业号corpid即为此appId）
		signParams.put("appid", Fashionable.getAppid()); // 微信分
		signParams.put("mch_id", Fashionable.getMch_id());// 微信支付分配的商户号
		signParams.put("nonce_str", CommonNativeUtil.getNonce_str()); // 随机字符串，不长于32位
		signParams.put("receiver",map1.toString()); // 企业付款金额，单位为分
		String sign0= WXPayUtil.generateSignature(signParams, "ae0c6db1cc8c76818a03f4b7c54c2dbb", WXPayConstants.SignType.HMACSHA256);
		signParams.put("sign", sign0);
		logger.info("企业向加盟商:" +  " signParams：" + signParams.toString());
		String requestXML = WXPayUtil.mapToXml(signParams);
		// 获取证书，发送POST请求；
		logger.info("企业向加盟商:" +  " requestXML：" + requestXML.toString());
		String responseXML =HttpPostNativeUtil.postData("https://api.mch.weixin.qq.com/pay/profitsharingaddreceiver", requestXML);
		logger.info("企业向加盟商:" +  " responseXML：" + responseXML);
		//String responseXML = new SslMerchtPostUtil().sslredpack(ConfigNativeUtil.MENU_PAYMENT_URL, requestXML);
		SortedMap<Object, Object> reParams = CommonNativeUtil.xmlConvertToMap(responseXML);
		logger.info("企业向加盟商:" +  " 付款微信返回结果：" + reParams.toString());
		return reParams;
	}
	public static Map<Object, Object> deletFashionable(Fashionable Fashionable) throws Exception {
		logger.info("执行企业向加盟商付款流程方法");
		// 设置支付参数
		SortedMap<String, String> signParams = new TreeMap<String, String>();
		JSONObject map1=new JSONObject();
		map1.put("type",Fashionable.getType());
		map1.put("account", Fashionable.getAccount());
		logger.info("企业向加盟商:" +  " Fashionable.getReceivers()：" + Fashionable.getReceivers());
		signParams.put("sub_mch_id", Fashionable.getSub_mch_id()); // 微信分配的公众账号ID（企业号corpid即为此appId）
		signParams.put("appid", Fashionable.getAppid()); // 微信分
		signParams.put("mch_id", Fashionable.getMch_id());// 微信支付分配的商户号
		signParams.put("nonce_str", CommonNativeUtil.getNonce_str()); // 随机字符串，不长于32位
		signParams.put("receiver",map1.toString()); // 企业付款金额，单位为分
		String sign0= WXPayUtil.generateSignature(signParams, "ae0c6db1cc8c76818a03f4b7c54c2dbb", WXPayConstants.SignType.HMACSHA256);
		signParams.put("sign", sign0);
		logger.info("企业向加盟商:" +  " signParams：" + signParams.toString());
		String requestXML = WXPayUtil.mapToXml(signParams);
		// 获取证书，发送POST请求；
		logger.info("企业向加盟商:" +  " requestXML：" + requestXML.toString());
		String responseXML =HttpPostNativeUtil.postData("https://api.mch.weixin.qq.com/pay/profitsharingremovereceiver", requestXML);
		logger.info("企业向加盟商:" +  " responseXML：" + responseXML);
		//String responseXML = new SslMerchtPostUtil().sslredpack(ConfigNativeUtil.MENU_PAYMENT_URL, requestXML);
		SortedMap<Object, Object> reParams = CommonNativeUtil.xmlConvertToMap(responseXML);
		logger.info("企业向加盟商:" +  " 付款微信返回结果：" + reParams.toString());
		return reParams;
	}
}
