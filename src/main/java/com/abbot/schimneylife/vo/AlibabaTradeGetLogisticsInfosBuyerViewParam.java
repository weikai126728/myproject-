package com.abbot.schimneylife.vo;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.ocean.rawsdk.client.APIId;
import com.alibaba.ocean.rawsdk.common.AbstractAPIRequest;

public class AlibabaTradeGetLogisticsInfosBuyerViewParam extends AbstractAPIRequest<JSONObject>{

	private Long orderId;
	private String webSite;
	private String fields;
	public AlibabaTradeGetLogisticsInfosBuyerViewParam() {
		this.oceanApiId = new APIId("com.alibaba.logistics","alibaba.trade.getLogisticsInfos.buyerView",1);
		this.fields = "company.name,sender,receiver,sendgood";
	}
	public Long getOrderId() {
		return orderId;
	}
	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}
	public String getWebSite() {
		return webSite;
	}
	public void setWebSite(String webSite) {
		this.webSite = webSite;
	}
	public String getFields() {
		return fields;
	}
	public void setFields(String fields) {
		this.fields = fields;
	}
	
}
