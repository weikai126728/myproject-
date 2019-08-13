package com.abbot.schimneylife.pojo.shopping;

/**
 * 我的收藏
 * 
 * @author Administrator
 *
 */
public class CustomerHouse {

	private String id;
	private Integer type; // 收藏来源，0 在线商城商品 1线下超市
	private Integer customerId;
	private Integer supermarketId;
	private String productId;
	private String surplusId;
	private String createTime;
	private MallProduct product;

	public MallProduct getProduct() {
		return product;
	}

	public void setProduct(MallProduct product) {
		this.product = product;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}
	

	public Integer getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}

	public Integer getSupermarketId() {
		return supermarketId;
	}

	public void setSupermarketId(Integer supermarketId) {
		this.supermarketId = supermarketId;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public String getSurplusId() {
		return surplusId;
	}

	public void setSurplusId(String surplusId) {
		this.surplusId = surplusId;
	}

}
