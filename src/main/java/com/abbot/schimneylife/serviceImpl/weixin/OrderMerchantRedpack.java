package com.abbot.schimneylife.serviceImpl.weixin;

import java.util.Date;

/**
 * 
 * @author Administrator
 *	企业红包现金类
 */
public class OrderMerchantRedpack {
	private Integer redid;
	private String mchid;//微信支付分配的商户号
	private String wxappid;//商户appid，接口传入的所有appid应该为公众号的appid（在mp.weixin.qq.com申请的），不能为APP的appid（在open.weixin.qq.com申请的）
	private String re_openid;// 用户openid
	private Integer total_fee;//用户付款（到加盟商）金额
	private Integer total_amount;// 发放的红包金额
	private String re_time;// 企业支付红包金额时间
	private String mch_billno;//商户订单号（每个订单号必须唯一）组成：mch_id+yyyymmdd+10位一天内不能重复的数字
	private String send_listid;//红包订单的微信单号
	private String transaction_id;//微信支付订单号(用户付款到加盟商)
	private String alOpenid;
	private String product_id;
	private Double	sendredPackamount;
	
	
	public Double getSendredPackamount() {
		return sendredPackamount;
	}
	public void setSendredPackamount(Double sendredPackamount) {
		this.sendredPackamount = sendredPackamount;
	}
	public String getProduct_id() {
		return product_id;
	}
	public void setProduct_id(String product_id) {
		this.product_id = product_id;
	}
	public String getAlOpenid() {
		return alOpenid;
	}
	public void setAlOpenid(String alOpenid) {
		this.alOpenid = alOpenid;
	}
	public Integer getRedid() {
		return redid;
	}
	public void setRedid(Integer redid) {
		this.redid = redid;
	}
	public String getMchid() {
		return mchid;
	}
	public void setMchid(String mchid) {
		this.mchid = mchid;
	}
	public String getWxappid() {
		return wxappid;
	}
	public void setWxappid(String wxappid) {
		this.wxappid = wxappid;
	}
	public String getRe_openid() {
		return re_openid;
	}
	public void setRe_openid(String re_openid) {
		this.re_openid = re_openid;
	}
	public Integer getTotal_amount() {
		return total_amount;
	}
	public void setTotal_amount(Integer total_amount) {
		this.total_amount = total_amount;
	}
	public String getRe_time() {
		return re_time;
	}
	public void setRe_time(String re_time) {
		this.re_time = re_time;
	}
	public String getMch_billno() {
		return mch_billno;
	}
	public void setMch_billno(String mch_billno) {
		this.mch_billno = mch_billno;
	}
	public String getSend_listid() {
		return send_listid;
	}
	public void setSend_listid(String send_listid) {
		this.send_listid = send_listid;
	}
	public String getTransaction_id() {
		return transaction_id;
	}
	public void setTransaction_id(String transaction_id) {
		this.transaction_id = transaction_id;
	}
	public Integer getTotal_fee() {
		return total_fee;
	}
	public void setTotal_fee(Integer total_fee) {
		this.total_fee = total_fee;
	}

}
