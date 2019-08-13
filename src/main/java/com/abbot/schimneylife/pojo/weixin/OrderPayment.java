package com.abbot.schimneylife.pojo.weixin;

import com.abbot.schimneylife.pojo.user.User;

/**
 * 订单交易
 * @author Administrator
 *
 */
public class OrderPayment {

	private Integer id;
	private Integer money;
	private String payTime;
	private String tradeNo;
	private String paymentNo;
	private String openId;
	private User user;
	private Alliance alliance;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getMoney() {
		return money;
	}
	public void setMoney(Integer money) {
		this.money = money;
	}
	public String getPayTime() {
		if(this.payTime==null) {
			return "";
		}
		return payTime.substring(0, 19);
	}
	public void setPayTime(String payTime) {
		this.payTime = payTime;
	}
	public String getTradeNo() {
		return tradeNo;
	}
	public void setTradeNo(String tradeNo) {
		this.tradeNo = tradeNo;
	}
	public String getPaymentNo() {
		return paymentNo;
	}
	public void setPaymentNo(String paymentNo) {
		this.paymentNo = paymentNo;
	}
	public String getOpenId() {
		return openId;
	}
	public void setOpenId(String openId) {
		this.openId = openId;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Alliance getAlliance() {
		return alliance;
	}
	public void setAlliance(Alliance alliance) {
		this.alliance = alliance;
	}
	
}
