package com.abbot.schimneylife.pojo.shopping;

import java.math.BigDecimal;
import java.util.List;

import com.abbot.schimneylife.pojo.user.User;
import com.abbot.schimneylife.util.DecimalFormatUtil;

/**
 * 客户订单表
 * @author Administrator
 *
 */
public class CustomerOrder {

	private String id;
	private Integer customerId;
	private String shippingAddress;
	private String contactPhone;
	private String contactUser;
	private String number;//订单编号
	private BigDecimal amount;
	private String amountStr;
	private BigDecimal successAmount;//下单成功总金额
	private String updateTotalAmountStr;
	private BigDecimal updateTotalAmount;//订单更改后金额
	private Integer count;
	private List<MallOrder> mallOrder;
	private Integer status;//订单状态
	private Integer flag;//0禁用 1启用
	private String message;
	private String createTime;
	private String lastTime;
	private Integer source;//0 自营  1 阿里分销 2阿里代购（需要商家调整订单价格）后付款
	private Integer cashbackStatus;//0 网红未返现 1 网红已返现
	private String cashbackTime;
	private AlibabaOrder alibaba;
	private WeiXinPayLog wxLog;
	private MallOrder mOrder;
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	private User user;
	private LogisticsInfo logistics;
	private Integer payment;//1微信支付  2支付宝支付
	public CustomerOrder() {}
	public CustomerOrder(Integer customerId,String shippingAddress,String contactPhone,String contactUser,BigDecimal amount,Integer count
			,String number,Integer status,Integer flag) {
		this.customerId = customerId;
		this.shippingAddress = shippingAddress;
		this.contactPhone = contactPhone;
		this.contactUser = contactUser;
		this.amount = amount;
		this.count = count;
		this.number = number;
		this.status = status;
		this.flag = flag;
	}
	
 
	public MallOrder getmOrder() {
		return mOrder;
	}
	public void setmOrder(MallOrder mOrder) {
		this.mOrder = mOrder;
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
	
	public String getShippingAddress() {
		return shippingAddress;
	}
	public void setShippingAddress(String shippingAddress) {
		this.shippingAddress = shippingAddress;
	}
	public String getContactPhone() {
		return contactPhone;
	}
	public void setContactPhone(String contactPhone) {
		this.contactPhone = contactPhone;
	}
	public String getContactUser() {
		return contactUser;
	}
	public void setContactUser(String contactUser) {
		this.contactUser = contactUser;
	}
	public BigDecimal getAmount() {
		return amount;
	}
	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}
	public Integer getCount() {
		return count==null?0:count;
	}
	public void setCount(Integer count) {
		this.count = count;
	}
	public String getCreateTime() {
		return this.createTime.substring(0, 19);
	}
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public List<MallOrder> getMallOrder() {
		return mallOrder;
	}
	public void setMallOrder(List<MallOrder> mallOrder) {
		this.mallOrder = mallOrder;
	}
	public Integer getFlag() {
		return flag;
	}
	public void setFlag(Integer flag) {
		this.flag = flag;
	}
	public BigDecimal getSuccessAmount() {
		return successAmount;
	}
	public void setSuccessAmount(BigDecimal successAmount) {
		this.successAmount = successAmount;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Integer getSource() {
		return source;
	}
	public void setSource(Integer source) {
		this.source = source;
	}
	public String getAmountStr() {
		return DecimalFormatUtil.format(this.amount==null?new BigDecimal(0):this.amount);
	}
	public void setAmountStr(String amountStr) {
		this.amountStr = amountStr;
	}
	public AlibabaOrder getAlibaba() {
		return alibaba;
	}
	public void setAlibaba(AlibabaOrder alibaba) {
		this.alibaba = alibaba;
	}
	public String getUpdateTotalAmountStr() {
		if(this.updateTotalAmount==null) {
			return null;
		}
		return DecimalFormatUtil.format(this.updateTotalAmount);
	}
	public BigDecimal getUpdateTotalAmount() {
		return updateTotalAmount;
	}
	public void setUpdateTotalAmount(BigDecimal updateTotalAmount) {
		this.updateTotalAmount = updateTotalAmount;
	}
	public Integer getPayment() {
		return payment;
	}
	public void setPayment(Integer payment) {
		this.payment = payment;
	}
	public String getLastTime() {
		return lastTime;
	}
	public void setLastTime(String lastTime) {
		this.lastTime = lastTime;
	}
	public LogisticsInfo getLogistics() {
		return logistics;
	}
	public void setLogistics(LogisticsInfo logistics) {
		this.logistics = logistics;
	}
	public Integer getCashbackStatus() {
		return cashbackStatus;
	}
	public void setCashbackStatus(Integer cashbackStatus) {
		this.cashbackStatus = cashbackStatus;
	}
	public String getCashbackTime() {
		if(cashbackTime==null) {
			return "";
		}
		return cashbackTime.substring(0, 16);
	}
	public void setCashbackTime(String cashbackTime) {
		this.cashbackTime = cashbackTime;
	}
	public WeiXinPayLog getWxLog() {
		return wxLog;
	}
	public void setWxLog(WeiXinPayLog wxLog) {
		this.wxLog = wxLog;
	}
	
}
