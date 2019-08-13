package com.abbot.schimneylife.pojo.weixin;

public class OrdermerRedpack {

	private Integer redid;
	private String re_openid;
	private Integer total_fee;
	private String product_id;
	private Integer total_amount;
	private String re_time;
	private String mch_billno;
	private Alliance alliance;
	public Integer getRedid() {
		return redid;
	}
	public void setRedid(Integer redid) {
		this.redid = redid;
	}
	public String getRe_openid() {
		return re_openid;
	}
	public void setRe_openid(String re_openid) {
		this.re_openid = re_openid;
	}
	public Integer getTotal_fee() {
		return total_fee;
	}
	public void setTotal_fee(Integer total_fee) {
		this.total_fee = total_fee;
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
	public Alliance getAlliance() {
		return alliance;
	}
	public void setAlliance(Alliance alliance) {
		this.alliance = alliance;
	}
	public String getProduct_id() {
		return product_id;
	}
	public void setProduct_id(String product_id) {
		this.product_id = product_id;
	}	
}
