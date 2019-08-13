package com.abbot.schimneylife.util;

import java.io.IOException;
import java.util.Properties;

public enum ConfigureUtil {
	WAP_PRODCUT_IMAGE("productType_image"), PRODUCT_IMAGE("product_image"),FOOTMARK_DAYS("footmarkdays")
	,ALIBABA_APPKEY("alibabaAppKey"),ALIBABA_SECKEY("alibabaSecKey"),ALIBABA_SERVERHOST("alibabaServerHost")
	,ALIBABA_HTTPPORT("alibabaHttpPort"),ALIBABA_HTTPSPORT("alibabaHttpsPort"),ALIBABA_USERID("alibabaUserId")
	,PRODUCT_EVALUATE("product_evaluate"),WEIXIN_APPKEY("weixinAppKey"),WEIXIN_MCHID("weixinMchID")
	,WEIXIN_NOTIFY_URL("weixinNotify_url"),WEIXIN_SECKEY("weixinSecKey"),WEIXINREDIRECT_URL("weixinRedirect_url")
	,WEIXIN_MCHSEC("weixinMchSec"),MALLURL("mallURL"),LINEREDPRODUCT("line_red_product")
	,LINEREDPERCENTAGE("line_red_percentage"),COMPANY_IMAGE("company_image"),MCH_ID("MCH_ID"),URL_CERTIFICATE_CERT("URL_CERTIFICATE_CERT")
	,API_KEY("API_KEY");
	private Properties configure = new Properties();
	private String key;

	private ConfigureUtil(String key) {
		try {
			configure.load(ConfigureUtil.class.getClassLoader().getResourceAsStream("configure.properties"));
		} catch (IOException e) {
			System.out.println("configure.properties异常！");
			e.printStackTrace();
		}
		this.key = key;
	}

	@Override
	public String toString() {
		return configure.getProperty(key);
	}

}
