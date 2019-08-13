package com.abbot.schimneylife.pojo.weixin;

import java.util.Date;

/**
 * 
 * @author Administrator
 *	企业付款到个人订单类
 */
public class OrderMerchantPayment {
	private Integer pyid;
	private String mchid;//微信支付分配的商户号
	private String mch_appid;//微信分配的公众账号ID（企业号corpid即为此appId）
	private String alopenid;// 加盟商openid
	private Integer merchantpayment;// 企业支付加盟商金额
	private String payment_time;// 企业支付加盟商金额成功时间
	private String partner_trade_no;//商户订单号，需保持唯一性(只能是字母或者数字，不能包含有符号)
	private String payment_no;//企业付款成功，返回的微信订单号
	private String transaction_id;//微信支付订单号(用户付款到加盟商)(外键)
	private String product_id;
	private String storename;//店名
	private String alname;//商户老板名
	private String return_code;
	private String result_code;
	private String err_code_des;
	
	public String getReturn_code() {
		return return_code;
	}
	public void setReturn_code(String return_code) {
		this.return_code = return_code;
	}
	public String getResult_code() {
		return result_code;
	}
	public void setResult_code(String result_code) {
		this.result_code = result_code;
	}
	public String getErr_code_des() {
		return err_code_des;
	}
	public void setErr_code_des(String err_code_des) {
		this.err_code_des = err_code_des;
	}
	public String getStorename() {
		return storename;
	}
	public void setStorename(String storename) {
		this.storename = storename;
	}
	public String getAlname() {
		return alname;
	}
	public void setAlname(String alname) {
		this.alname = alname;
	}
	public String getProduct_id() {
		return product_id;
	}
	public void setProduct_id(String product_id) {
		this.product_id = product_id;
	}
	public Integer getPyid() {
		return pyid;
	}
	public void setPyid(Integer pyid) {
		this.pyid = pyid;
	}
	public String getMchid() {
		return mchid;
	}
	public void setMchid(String mchid) {
		this.mchid = mchid;
	}
	public String getMch_appid() {
		return mch_appid;
	}
	public void setMch_appid(String mch_appid) {
		this.mch_appid = mch_appid;
	}
	public String getAlopenid() {
		return alopenid;
	}
	public void setAlopenid(String alopenid) {
		this.alopenid = alopenid;
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
	public String getTransaction_id() {
		return transaction_id;
	}
	public void setTransaction_id(String transaction_id) {
		this.transaction_id = transaction_id;
	}

}
