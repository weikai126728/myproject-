package com.abbot.schimneylife.pojo.shopping;

import java.util.Date;


/**
 * 
 * @author Administrator 用户支付信息类
 */
public class CustomerBenefit {
	private Integer id;// 主键
	private String amopenid;// 用户（付款方）openid
	private Integer payment;// 付款金额
	private String amtime_end;// 用户付款支付时间
	private String alopenid;// 加盟商openid
	private String transaction_id;//微信支付订单号(用户付款到加盟商)
	private String out_trade_no;
	private String body;
	private Integer marketId;
	private Integer proId;
	private String storename;
	private String productname;
	private Integer count;
	private Integer firstTag;
	private String promotionTag;
	private double accountingRate;
	private String profit_sharing;//分账标记
	private String amname;
	private String amphone;
	private String h_openid;
	private Integer status;
	private Integer payAmount;
	private Integer integral;
	private Integer statustag;
	
	
	public Integer getStatustag() {
		return statustag;
	}
	public void setStatustag(Integer statustag) {
		this.statustag = statustag;
	}
	public Integer getIntegral() {
		return integral;
	}
	public void setIntegral(Integer integral) {
		this.integral = integral;
	}
	public Integer getPayAmount() {
		return payAmount;
	}
	public void setPayAmount(Integer payAmount) {
		this.payAmount = payAmount;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public String getH_openid() {
		return h_openid;
	}
	public void setH_openid(String h_openid) {
		this.h_openid = h_openid;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getAmopenid() {
		return amopenid;
	}
	public void setAmopenid(String amopenid) {
		this.amopenid = amopenid;
	}
	public Integer getPayment() {
		return payment;
	}
	public void setPayment(Integer payment) {
		this.payment = payment;
	}
	public String getAmtime_end() {
		return amtime_end;
	}
	public void setAmtime_end(String amtime_end) {
		this.amtime_end = amtime_end;
	}
	public String getAlopenid() {
		return alopenid;
	}
	public void setAlopenid(String alopenid) {
		this.alopenid = alopenid;
	}
	public String getTransaction_id() {
		return transaction_id;
	}
	public void setTransaction_id(String transaction_id) {
		this.transaction_id = transaction_id;
	}
	public String getOut_trade_no() {
		return out_trade_no;
	}
	public void setOut_trade_no(String out_trade_no) {
		this.out_trade_no = out_trade_no;
	}
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
	
	public Integer getMarketId() {
		return marketId;
	}
	public void setMarketId(Integer marketId) {
		this.marketId = marketId;
	}
	public Integer getProId() {
		return proId;
	}
	public void setProId(Integer proId) {
		this.proId = proId;
	}
	public String getStorename() {
		return storename;
	}
	public void setStorename(String storename) {
		this.storename = storename;
	}
	public String getProductname() {
		return productname;
	}
	public void setProductname(String productname) {
		this.productname = productname;
	}
	public Integer getCount() {
		return count;
	}
	public void setCount(Integer count) {
		this.count = count;
	}
	public Integer getFirstTag() {
		return firstTag;
	}
	public void setFirstTag(Integer firstTag) {
		this.firstTag = firstTag;
	}
	public String getPromotionTag() {
		return promotionTag;
	}
	public void setPromotionTag(String promotionTag) {
		this.promotionTag = promotionTag;
	}
	public double getAccountingRate() {
		return accountingRate;
	}
	public void setAccountingRate(double accountingRate) {
		this.accountingRate = accountingRate;
	}
	public String getProfit_sharing() {
		return profit_sharing;
	}
	public void setProfit_sharing(String profit_sharing) {
		this.profit_sharing = profit_sharing;
	}
	public String getAmname() {
		return amname;
	}
	public void setAmname(String amname) {
		this.amname = amname;
	}
	public String getAmphone() {
		return amphone;
	}
	public void setAmphone(String amphone) {
		this.amphone = amphone;
	}
	
	
}
