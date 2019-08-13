package com.abbot.schimneylife.pojo.shopping;

import java.math.BigDecimal;

import com.abbot.schimneylife.util.DecimalFormatUtil;

/**
 * 在线商城订单列表
 * @author Administrator
 *
 */
public class MallOrder {

	private String id;
	private MallProduct product;
	private String productId;
	private String paramId;
	private String customerOrderId;
	private BigDecimal original;
	private BigDecimal current;
	private String currentStr;
	private BigDecimal settlement;
	private Integer total;
	private Integer status;//0 下单失败  1下单成功
	private String errorCode;
	private String errorMessage;
	private String createTime;
	private String updateTime;
	public MallOrder() {}
	public MallOrder(String customerOrderId,String productId,String paramId,BigDecimal original,BigDecimal current,Integer total) {
		this.productId = productId;
		this.paramId = paramId;
		this.original = original;
		this.current = current;
		this.total = total;
		this.customerOrderId = customerOrderId;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	public MallProduct getProduct() {
		return product;
	}
	public void setProduct(MallProduct product) {
		this.product = product;
	}
	public BigDecimal getOriginal() {
		return original;
	}
	public void setOriginal(BigDecimal original) {
		this.original = original;
	}
	public BigDecimal getCurrent() {
		return current;
	}
	public void setCurrent(BigDecimal current) {
		this.current = current;
	}
	public BigDecimal getSettlement() {
		return settlement;
	}
	public void setSettlement(BigDecimal settlement) {
		this.settlement = settlement;
	}
	public Integer getTotal() {
		return total;
	}
	public void setTotal(Integer total) {
		this.total = total;
	}
	public String getCreateTime() {
		return createTime.substring(0, 19);
	}
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	public String getUpdateTime() {
		return updateTime.substring(0, 19);
	}
	public void setUpdateTime(String updateTime) {
		this.updateTime = updateTime;
	}
	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}
	public String getParamId() {
		return paramId;
	}
	public void setParamId(String paramId) {
		this.paramId = paramId;
	}
	public String getCustomerOrderId() {
		return customerOrderId;
	}
	public void setCustomerOrderId(String customerOrderId) {
		this.customerOrderId = customerOrderId;
	}
	public String getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}
	public String getErrorMessage() {
		return errorMessage;
	}
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public String getCurrentStr() {
		return DecimalFormatUtil.format(this.current);
	}

	
}
