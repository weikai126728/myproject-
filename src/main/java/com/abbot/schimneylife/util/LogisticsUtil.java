package com.abbot.schimneylife.util;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.logistics.param.AlibabaLogisticsOpenPlatformLogisticsStep;

/**
 * 物流信息，返回数据统一工具
 * @author Administrator
 *
 */
public class LogisticsUtil {
/*
 * 
 * 统一格式为jsonarray：[{remark:'',acceptTime:''}]
 * 
 * 
 */
	
	
	/**
	 * 阿里巴巴物流信息统一
	 * @return
	 */
	public static JSONArray transforAlibaba(AlibabaLogisticsOpenPlatformLogisticsStep[] steps) {
		JSONArray data = new JSONArray();
		if(steps!=null&&steps.length>0) {
			for(int i=steps.length-1;i>=0;i--) {
				JSONObject obj = new JSONObject();
				obj.put("remark", steps[i].getRemark());
				obj.put("acceptTime", steps[i].getAcceptTime());
				data.add(obj);
			}
//			for(AlibabaLogisticsOpenPlatformLogisticsStep step:steps) {
//				JSONObject obj = new JSONObject();
//				obj.put("remark", step.getRemark());
//				obj.put("acceptTime", step.getAcceptTime());
//				data.add(obj);
//			}
		}
		return data;
	}
	/**
	 * 中通物流信息统一
	 * @return
	 */
	public static JSONArray transforZTO(JSONObject obj) {
		JSONArray data = new JSONArray();
		if(obj.getBooleanValue("status")) {
			JSONArray datas = obj.getJSONArray("data").getJSONObject(0).getJSONArray("traces");
			for(int i=0;i<datas.size();i++) {
				JSONObject o = new JSONObject();
				o.put("remark", datas.getJSONObject(i).getString("desc"));
				o.put("acceptTime", datas.getJSONObject(i).getString("scanDate"));
				data.add(o);
			}
		}
		return data;
	}
}
