package com.abbot.schimneylife.pojo.shopping;

import com.abbot.schimneylife.pojo.user.UserCustomer;

public class CustomerOrderWarn {

	private String id;
	private UserCustomer customer;
	private CustomerOrder order;
	private String createTime;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public UserCustomer getCustomer() {
		return customer;
	}
	public void setCustomer(UserCustomer customer) {
		this.customer = customer;
	}
	public CustomerOrder getOrder() {
		return order;
	}
	public void setOrder(CustomerOrder order) {
		this.order = order;
	}
	public String getCreateTime() {
		return createTime;
	}
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	
}
