package com.abbot.schimneylife.pojo.shopping;

import java.math.BigDecimal;

public class MallCart {

	private String id;
	private String shoppingCartId;
	private String mProductId;
	private String parameterId;
	private Integer totalCount;
	private String createTime;
	private MallProduct product;
	private BigDecimal totalMoney;
	public MallCart() {}
	public MallCart(String shoppingCartId,String mProductId,String parameterId,Integer totalCount) {
		this.shoppingCartId = shoppingCartId;
		this.mProductId = mProductId;
		this.parameterId = parameterId;
		this.totalCount = totalCount;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getShoppingCartId() {
		return shoppingCartId;
	}
	public void setShoppingCartId(String shoppingCartId) {
		this.shoppingCartId = shoppingCartId;
	}
	public String getmProductId() {
		return mProductId;
	}
	public void setmProductId(String mProductId) {
		this.mProductId = mProductId;
	}
	public Integer getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(Integer totalCount) {
		this.totalCount = totalCount;
	}
	public String getCreateTime() {
		return createTime;
	}
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	public MallProduct getProduct() {
		return product;
	}
	public void setProduct(MallProduct product) {
		this.product = product;
	}
	public String getParameterId() {
		return parameterId;
	}
	public void setParameterId(String parameterId) {
		this.parameterId = parameterId;
	}
	public BigDecimal getTotalMoney() {
		BigDecimal money = product.getParameter().getCur_price();
		BigDecimal count = new BigDecimal(this.totalCount);
		return money.multiply(count);
	}
	public void setTotalMoney(BigDecimal totalMoney) {
		this.totalMoney = totalMoney;
	}
	
}
