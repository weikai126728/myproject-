package com.abbot.schimneylife.pojo.shopping;

import java.math.BigDecimal;

/**
 * 售后服务
 * 
 * @author Administrator
 *
 */
public class Refund {

	private String id;
	private String customerOrderId;
	private String mallOrderId;
	private BigDecimal amount;
	private int serviceType;
	private String describe;
	private String imagePpath;
	private int isSubmit;
	private String subTime;
	private int isAgree;
	private String agreeTime;
	private int serviceStatus;
	private String createTime;
	private String updateTime;
	private String reason;
	private CustomerOrder cOrder;
	private String refuseReason;
	private MallOrder mallOrder;
	private String endTime;
	private String refundNum;

	public String getRefundNum() {
		return refundNum;
	}

	public void setRefundNum(String refundNum) {
		this.refundNum = refundNum;
	}

	public String getEndTime() {
		return endTime.substring(0, 19);
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public String getSubTime() {
		return subTime.substring(0, 19);
	}

	public void setSubTime(String subTime) {
		this.subTime = subTime;
	}

	public int getIsAgree() {
		return isAgree;
	}

	public void setIsAgree(int isAgree) {
		this.isAgree = isAgree;
	}

	public String getAgreeTime() {
		return agreeTime.substring(0, 19);
	}

	public void setAgreeTime(String agreeTime) {
		this.agreeTime = agreeTime;
	}

	public MallOrder getMallOrder() {
		return mallOrder;
	}

	public void setMallOrder(MallOrder mallOrder) {
		this.mallOrder = mallOrder;
	}

	public String getRefuseReason() {
		return refuseReason;
	}

	public void setRefuseReason(String refuseReason) {
		this.refuseReason = refuseReason;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public int getIsSubmit() {
		return isSubmit;
	}

	public void setIsSubmit(int isSubmit) {
		this.isSubmit = isSubmit;
	}

	public CustomerOrder getcOrder() {
		return cOrder;
	}

	public void setcOrder(CustomerOrder cOrder) {
		this.cOrder = cOrder;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCustomerOrderId() {
		return customerOrderId;
	}

	public void setCustomerOrderId(String customerOrderId) {
		this.customerOrderId = customerOrderId;
	}

	public int getServiceType() {
		return serviceType;
	}

	public void setServiceType(int serviceType) {
		this.serviceType = serviceType;
	}

	public String getMallOrderId() {
		return mallOrderId;
	}

	public void setMallOrderId(String mallOrderId) {
		this.mallOrderId = mallOrderId;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public String getDescribe() {
		return describe;
	}

	public void setDescribe(String describe) {
		this.describe = describe;
	}

	public String getImagePpath() {
		return imagePpath;
	}

	public void setImagePpath(String imagePpath) {
		this.imagePpath = imagePpath;
	}

	public int getServiceStatus() {
		return serviceStatus;
	}

	public void setServiceStatus(int serviceStatus) {
		this.serviceStatus = serviceStatus;
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

}
