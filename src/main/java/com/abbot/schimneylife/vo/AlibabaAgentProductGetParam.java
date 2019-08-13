package com.abbot.schimneylife.vo;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.ocean.rawsdk.client.APIId;
import com.alibaba.ocean.rawsdk.common.AbstractAPIRequest;

public class AlibabaAgentProductGetParam extends AbstractAPIRequest<JSONObject>{

	private Long productID;
	private String webSite;
	
	public AlibabaAgentProductGetParam() {
		this.oceanApiId = new APIId("com.alibaba.product","alibaba.agent.product.get",1);
	}
	

	public Long getProductID() {
		return productID;
	}


	public void setProductID(Long productID) {
		this.productID = productID;
	}


	public String getWebSite() {
		return webSite;
	}
	public void setWebSite(String webSite) {
		this.webSite = webSite;
	}
}
