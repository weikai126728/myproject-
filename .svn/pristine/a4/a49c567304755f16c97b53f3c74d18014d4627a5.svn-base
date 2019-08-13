package com.abbot.schimneylife.serviceImpl.shopping;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.abbot.schimneylife.service.shopping.WeiXinService;
import com.abbot.schimneylife.util.ConfigureUtil;
import com.abbot.schimneylife.util.HttpRequestUtil;
import com.alibaba.fastjson.JSONObject;
import com.github.wxpay.sdk.WXPay;
import com.github.wxpay.sdk.WXPayConfig;
import com.github.wxpay.sdk.WXPayUtil;
@Service
public class WeiXinServiceImpl implements WeiXinService{
	private WXPay pay = null;
	{
		pay = new WXPay(new WXPayConfig() {
			
			@Override
			public String getMchID() {
				// TODO Auto-generated method stub
				return ConfigureUtil.WEIXIN_MCHID.toString();
			}
			
			@Override
			public String getKey() {
				// TODO Auto-generated method stub
				return ConfigureUtil.WEIXIN_MCHSEC.toString();
			}
			
			@Override
			public int getHttpReadTimeoutMs() {
				// TODO Auto-generated method stub
				return 8*1000;
			}
			
			@Override
			public int getHttpConnectTimeoutMs() {
				// TODO Auto-generated method stub
				return 6*1000;
			}
			
			@Override
			public InputStream getCertStream() {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public String getAppID() {
				// TODO Auto-generated method stub
				return ConfigureUtil.WEIXIN_APPKEY.toString();
			}
		});
	}
	@Override
	public Map<String, String> unifiedorder(Integer total_fee, String out_trade_no, String body,
			String spbill_create_ip, String trade_type,String openid) throws Exception {
		Map<String,String> reqData = new HashMap<>();
		reqData.put("total_fee", String.valueOf(total_fee));
		reqData.put("out_trade_no", out_trade_no);
		reqData.put("body", body);
		reqData.put("spbill_create_ip", spbill_create_ip);
		reqData.put("trade_type", trade_type);
		reqData.put("notify_url", ConfigureUtil.WEIXIN_NOTIFY_URL.toString());
		reqData.put("openid", openid);
		reqData.put("appid", ConfigureUtil.WEIXIN_APPKEY.toString());
		reqData.put("mch_id", ConfigureUtil.WEIXIN_MCHID.toString());
		String nonce_str = WXPayUtil.generateNonceStr();
		reqData.put("nonce_str", nonce_str);
		String sign = WXPayUtil.generateSignature(reqData, ConfigureUtil.WEIXIN_MCHSEC.toString());
		reqData.put("sign", sign);
		Map<String,String> response = this.pay.unifiedOrder(reqData);
		if(!this.pay.isResponseSignatureValid(response)) {//返回结果签名不正确抛出异常
			throw new Exception("统一下单接口（unifiedorder）返回数据签名不正确");
		}
		return response;
	}
	@Override
	public String getAccessToken() {
		Map<String,String> data = new HashMap<>();
		data.put("grant_type", "client_credential");
		data.put("appid", ConfigureUtil.WEIXIN_APPKEY.toString());
		data.put("secret", ConfigureUtil.WEIXIN_SECKEY.toString());
		String url = "https://api.weixin.qq.com/cgi-bin/token";
		JSONObject json = HttpRequestUtil.sendPost(url, data, null);
		return json.getString("access_token");
	}
	
}
