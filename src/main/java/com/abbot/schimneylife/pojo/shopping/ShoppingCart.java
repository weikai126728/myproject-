package com.abbot.schimneylife.pojo.shopping;

import java.util.List;

public class ShoppingCart {

	private String id;
	private Integer customerId;
	private String createTime;
	private MallCart mallCart;
	private List<MallCart> mallList;
	public ShoppingCart() {}
	public ShoppingCart(Integer customerId) {
		this.customerId = customerId;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Integer getCustomerId() {
		return customerId;
	}
	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}
	public String getCreateTime() {
		return createTime;
	}
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	public MallCart getMallCart() {
		return mallCart;
	}
	public void setMallCart(MallCart mallCart) {
		this.mallCart = mallCart;
	}
	public List<MallCart> getMallList() {
		return mallList;
	}
	public void setMallList(List<MallCart> mallList) {
		this.mallList = mallList;
	}
	
}
