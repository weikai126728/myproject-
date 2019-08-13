package com.abbot.schimneylife.pojo.shopping;

import com.abbot.schimneylife.pojo.user.User;

/**
 * 英利事务所
 * @author Administrator
 *
 */
public class YingLiOrder {

	public enum Type{
		FREE(0),VIP(1);
		private Integer type;
		private Type(Integer type) {
			this.type = type;
		}
		public Integer getType() {
			return this.type;
		}
	}
	public enum Status{
		FAILL(0),SUCCESS(1);
		private Integer status;
		private Status(Integer status) {
			this.status = status;
		}
		public Integer getStatus() {
			return this.status;
		}
	}
	
	private String id;
	private String name;
	private String phone;
	private Integer type;
	private String details;
	private Integer userId;
	private User user;
	private String number;
	private Integer status;
	private Integer money;
	private String createTime;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
	}
	public String getDetails() {
		return details;
	}
	public void setDetails(String details) {
		this.details = details;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getCreateTime() {
		return createTime;
	}
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public Integer getMoney() {
		return money;
	}
	public void setMoney(Integer money) {
		this.money = money;
	}
	
}
