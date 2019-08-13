package com.abbot.schimneylife.service.shopping;

import java.util.Map;

/**
 * 微信接口调用
 * @author Administrator
 *
 */
public interface WeiXinService {
	/**
	 * 统一下单
	 * @param total_fee 订单总金额，单位为分
	 * @param out_trade_no 商户系统内部订单号，要求32个字符内，只能是数字、大小写字母_-|*@ ，且在同一个商户号下唯一
	 * @param body 商品简单描述，该字段请按照规范传递
	 * @param spbill_create_ip APP和网页支付提交用户端ip，Native支付填调用微信支付API的机器IP
	 * @param trade_type 取值如下：JSAPI，NATIVE，APP等
	 * @param openid 
	 * @return
	 */
	Map<String,String> unifiedorder(Integer total_fee,String out_trade_no,String body
			,String spbill_create_ip,String trade_type,String openid)throws Exception;
	String getAccessToken();
}
