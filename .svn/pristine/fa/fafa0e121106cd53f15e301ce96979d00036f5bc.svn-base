package com.abbot.schimneylife.pojo.shopping;

import java.math.BigDecimal;
import java.util.Iterator;

import com.abbot.schimneylife.util.DecimalFormatUtil;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

/**
 * 产品参数
 * @author Administrator
 *
 */
public class MallProductParameter {

	private String id;
	private String productId;
	private Integer qualityDay;//保质天数
	private Integer qualityMonth;//保质月数
	private Integer qualityYear;//保质年数
	private BigDecimal original;//原价
	private BigDecimal cur_price;//现价
	private String strOriginal;
	private String strCurprice;
	private String json;
	private String firstParam;
	private String secondParam;
	private Integer status;
	private Integer repertory;//库存
	private String specId;//第三方规格id
	private String showSpec;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Integer getQualityDay() {
		return qualityDay;
	}
	public void setQualityDay(Integer qualityDay) {
		this.qualityDay = qualityDay;
	}
	public Integer getQualityMonth() {
		return qualityMonth;
	}
	public void setQualityMonth(Integer qualityMonth) {
		this.qualityMonth = qualityMonth;
	}
	public Integer getQualityYear() {
		return qualityYear;
	}
	public void setQualityYear(Integer qualityYear) {
		this.qualityYear = qualityYear;
	}
	public BigDecimal getOriginal() {
		return original;
	}
	public void setOriginal(BigDecimal original) {
		this.original = original;
	}
	public BigDecimal getCur_price() {
		return cur_price;
	}
	public void setCur_price(BigDecimal cur_price) {
		this.cur_price = cur_price;
	}
	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}
	public String getStrOriginal() {
		strOriginal = DecimalFormatUtil.format(original);
		return strOriginal;
	}
	public String getStrCurprice() {
		strCurprice = DecimalFormatUtil.format(cur_price);
		return strCurprice;
	}
	public void setStrOriginal(String strOriginal) {
		this.strOriginal = strOriginal;
	}
	public void setStrCurprice(String strCurprice) {
		this.strCurprice = strCurprice;
	}
	public String getJson() {
		return json;
	}
	public void setJson(String json) {
		this.json = json;
	}
	public String getFirstParam() {
		return firstParam;
	}
	public void setFirstParam(String firstParam) {
		this.firstParam = firstParam;
	}
	public String getSecondParam() {
		return secondParam;
	}
	public void setSecondParam(String secondParam) {
		this.secondParam = secondParam;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public Integer getRepertory() {
		return repertory;
	}
	public void setRepertory(Integer repertory) {
		this.repertory = repertory;
	}
	public String getSpecId() {
		return specId;
	}
	public void setSpecId(String specId) {
		this.specId = specId;
	}
	public String getShowSpec() {
		if(this.firstParam==null) {
			return null;
		}
		JSONArray array = JSONArray.parseArray(this.firstParam);
		StringBuffer str = new StringBuffer();
		String g="";
		Iterator<Object> iterator = null;
		for(int i=0;i<array.size();i++) {
			JSONObject obj = array.getJSONObject(i);
			iterator = obj.values().iterator();
			while(iterator.hasNext()) {
				str.append(g);
				g = "<i>&#43;</i>";
				str.append(iterator.next().toString());
			}
		}		
		return str.toString();
	}
	
}
