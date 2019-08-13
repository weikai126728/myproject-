package com.abbot.schimneylife.pojo.weixin;

public class WanghongTixian {
	private Integer id;
	private String alopenid;//收款人openid
	private String mch_appid;
	private Integer merchantpayment;// 企业支付加盟商金额
	private String payment_time;// 企业支付加盟商金额成功时间
	private String partner_trade_no;//商户订单号，需保持唯一性(只能是字母或者数字，不能包含有符号)
	private String payment_no;//企业付款成功，返回的微信订单号
	private String operator;//操作人
	private String nickName;//收款人姓名
	private String storename;//手动网红付款备注（外键）
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getAlopenid() {
		return alopenid;
	}
	public void setAlopenid(String alopenid) {
		this.alopenid = alopenid;
	}
	public String getMch_appid() {
		return mch_appid;
	}
	public void setMch_appid(String mch_appid) {
		this.mch_appid = mch_appid;
	}
	public Integer getMerchantpayment() {
		return merchantpayment;
	}
	public void setMerchantpayment(Integer merchantpayment) {
		this.merchantpayment = merchantpayment;
	}
	public String getPayment_time() {
		return payment_time;
	}
	public void setPayment_time(String payment_time) {
		this.payment_time = payment_time;
	}
	public String getPartner_trade_no() {
		return partner_trade_no;
	}
	public void setPartner_trade_no(String partner_trade_no) {
		this.partner_trade_no = partner_trade_no;
	}
	public String getPayment_no() {
		return payment_no;
	}
	public void setPayment_no(String payment_no) {
		this.payment_no = payment_no;
	}
	public String getOperator() {
		return operator;
	}
	public void setOperator(String operator) {
		this.operator = operator;
	}
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	public String getStorename() {
		return storename;
	}
	public void setStorename(String storename) {
		this.storename = storename;
	}
	
}
