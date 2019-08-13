package com.abbot.schimneylife.util;

import java.io.IOException;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

import org.apache.log4j.Logger;



/**
 * 
 * @author Administrator 企业支付工具类
 */
public class MerchantPaymentUtil {
	
	private static Logger logger = Logger.getLogger(MerchantPaymentUtil.class);
	

	/**
	 * @Description：微信支付，企业向个人付款
	 * @param openid
	 *            收款人的openID(微信的openID)
	 * @param amount
	 *            付款金额
	 * @param desc
	 *            付款描述
	 * @param partner_trade_no
	 *            订单号(系统业务逻辑用到的订单号)
	 * @return map{state:SUCCESS/FAIL}{payment_no:
	 *         '支付成功后，微信返回的订单号'}{payment_time:'支付成功的时间'}{err_code:'支付失败后，返回的错误代码'}{err_code_des:'支付失败后，返回的错误描
	 *         述 ' }
	 * @throws IOException 
	 */
	
	public static Map<Object, Object> merchantPayment(String alopenid,Integer merchantpayment) throws IOException {
		logger.info("执行企业向加盟商付款流程方法");
		// 设置支付参数
		SortedMap<String, String> signParams = new TreeMap<String, String>();
		signParams.put("mch_appid", ConfigNativeUtil.APP_ID); // 微信分配的公众账号ID（企业号corpid即为此appId）
		signParams.put("mchid", ConfigNativeUtil.MCH_ID);// 微信支付分配的商户号
		signParams.put("nonce_str", CommonNativeUtil.getNonce_str()); // 随机字符串，不长于32位
		signParams.put("partner_trade_no", String.valueOf(System.currentTimeMillis())); // 商户订单号，需保持唯一性
		signParams.put("openid", alopenid); // 商户appid下，某用户(加盟商)的openid
		signParams.put("check_name", "NO_CHECK");
		signParams.put("amount", String.valueOf(merchantpayment)); // 企业付款金额，单位为分
		signParams.put("desc", "扫码支付到账"); // 企业付款操作说明信息。必填。
		signParams.put("spbill_create_ip", ConfigNativeUtil.CREATE_IP); // 调用接口的机器Ip地址
		String sign0 = CommonNativeUtil.createSign("UTF-8", signParams, ConfigNativeUtil.API_KEY);
		signParams.put("sign", sign0);
		String requestXML = CommonNativeUtil.getRequestXml(signParams);
		// 获取证书，发送POST请求；
		String responseXML = new SslMerchtPostUtil().ssl(ConfigNativeUtil.MENU_PAYMENT_URL, requestXML);
		SortedMap<Object, Object> reParams = CommonNativeUtil.xmlConvertToMap(responseXML);
		logger.info("企业向加盟商付款微信返回结果："+reParams.toString());
		return reParams;
		
	}
}