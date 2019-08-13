package com.abbot.schimneylife.util;

import java.util.HashMap;
import java.util.Map;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.zto.Util.DigestUtil;
import com.zto.Util.HttpUtil;

/**
 * 中通快递
 * 
 * @author Administrator
 *
 */
public class ZTOUtil {

	private static final String company_id = "556e0707c05f4aca9a08fdc97453f5a6";
	private static final String key = "215355e7e1e9";

	public static JSONObject getGateWay(JSONArray data) {
		String url = "http://japi.zto.cn/gateway.do";
		String charset = "utf8";
		String msg_type = "TRACEINTERFACE_NEW_TRACES";
		String response = "";
		try {
			String data_digest = DigestUtil.digest(data.toJSONString(), key, charset);
			Map<String, Object> params = new HashMap<String, Object>();
			params.put("data", data.toJSONString());
			params.put("data_digest", data_digest);
			params.put("company_id", company_id);
			params.put("msg_type", msg_type);
			// 向跟踪信息接口发送请求
			response = HttpUtil.post(url, charset, params);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return JSONObject.parseObject(response);
	}
	public static void main(String[] args) {
//		getTraceInfo("['405251767014']");
		JSONArray data = new JSONArray();
		data.add("680000000000");
		getGateWay(data);
	}
}
