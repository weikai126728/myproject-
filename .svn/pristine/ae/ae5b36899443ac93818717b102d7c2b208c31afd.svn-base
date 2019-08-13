package com.abbot.schimneylife.util;

import org.apache.log4j.Logger;

import com.alibaba.fastjson.JSONObject;


/**
 * 企业付款到加盟商信息模板工具类
 * 
 * @author Administrator
 *
 */
public class PaymentMessageUtil {
	private static Logger logger = Logger.getLogger(PaymentMessageUtil.class);

	public static JSONObject getMessage(String alopenid,Integer money,String payment_time) {
		double payment = money / 100;
		String templateurl = ConfigNativeUtil.URL_TEMPLATE_MESSAGE.replace("ACCESS_TOKEN",
				LongToShortUtil.getAccessToken());
		String data = "  {\r\n" + "           \"touser\":\"" + alopenid + "\",\r\n"
				+ "           \"template_id\":\"lSBgCoIQiNV5CMnlvGw6iJ6_vkA-rP1JBUrBJlOkj_M\",\r\n"
				+ "                 \r\n" + "           \"data\":{\r\n" + "                   \"first\": {\r\n"
				+ "                       \"value\":\"恭喜收款，本次佣金结算成功！\",\r\n"
				+ "                       \"color\":\"#173177\"\r\n" + "                   },\r\n"
				+ "                   \"keyword1\":{\r\n" + "                       \"value\":\"炊烟生活-佣金支付入账\",\r\n"
				+ "                       \"color\":\"#173177\"\r\n" + "                   },\r\n"
				+ "                   \"keyword2\": {\r\n" + "                       \"value\":\"" + payment + "元"
				+ "\",\r\n" + "                       \"color\":\"#173177\"\r\n" + "                   },\r\n"
				+ "                   \"keyword3\": {\r\n" + "                       \"value\":\""
				+ payment_time + "\",\r\n" + "                       \"color\":\"#173177\"\r\n"
				+ "                   },\r\n" + "                   \"remark\":{\r\n"
				+ "                       \"value\":\"\",\r\n" + "                       \"color\":\"#173177\"\r\n"
				+ "                   }\r\n" + "           }\r\n" + "       }";

		JSONObject checkInfo = JSONObject.parseObject(HttpPostNativeUtil.postData(templateurl, data));
		logger.error("用户:" + alopenid + " 付款模板消息发送结果：" + checkInfo.toString());
		return checkInfo;

	}

}
