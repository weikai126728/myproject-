package com.abbot.schimneylife.util;

import java.io.IOException;

import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.ObjectMapper;

import com.alibaba.fastjson.JSONObject;

/**
 * 二维码长连接转短连接工具类
 * 
 * @author Administrator
 *
 */
public class LongToShortUtil {
	/**
	 * 获取AccessToken类
	 * @return
	 */
	public static String getAccessToken() {
		String url = ConfigNativeUtil.URL_GET_ACCESSTOEKN.replace("APPID", ConfigNativeUtil.APP_ID).replace("APPSECRET",
				ConfigNativeUtil.APP_SECRET);
		JSONObject jsonobect = JSONObject.parseObject(HttpGetNativeUtil.sendGet(url));
		System.out.println(jsonobect.toString());
		String AccessToken = jsonobect.getString("access_token");
		return AccessToken;
	}
	public static JSONObject getJsapiTicket()  {
		String url = ConfigNativeUtil.URL_GET_JS_API_TICKET.replace("ACCESS_TOKEN", getAccessToken());
		JSONObject jsonobect = JSONObject.parseObject(HttpGetNativeUtil.sendGet(url));
		return jsonobect;
	}public static JSONObject getApiTicket()  {
		String url = ConfigNativeUtil.URL_GET_JS_API_wx_card.replace("ACCESS_TOKEN", getAccessToken());
		JSONObject jsonobect = JSONObject.parseObject(HttpGetNativeUtil.sendGet(url));
		return jsonobect;
	}
	
	
	public static String getShortUrl(String long_url) {
		String url = ConfigNativeUtil.URL_LONGURL_TO_SHORTURL.replace("ACCESS_TOKEN", getAccessToken());
		String json = "{\"action\":\"long2short\",\"long_url\":\"" + long_url + "\"}";
		String postResult = HttpPostNativeUtil.postData(url, json);
		ObjectMapper mapper = new ObjectMapper();
		JsonNode node = null;
		try {
			node = mapper.readTree(postResult);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String shortUrl = node.get("short_url").asText();
		return shortUrl;
	}
}
