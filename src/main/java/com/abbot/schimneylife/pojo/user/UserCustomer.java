package com.abbot.schimneylife.pojo.user;
/**
 * 客户信息表
 * @author Administrator
 *
 */
public class UserCustomer {

	private Integer id;
	private String nickName;
	private String ico;
	private Integer activity;
	private Integer userID;
	private Integer integral;
	private String createTime;
	private String updateTime;
	private String lastscan;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	public String getIco() {
		return ico;
	}
	public void setIco(String ico) {
		this.ico = ico;
	}
	public Integer getActivity() {
		return activity;
	}
	public void setActivity(Integer activity) {
		this.activity = activity;
	}
	public Integer getUserID() {
		return userID;
	}
	public void setUserID(Integer userID) {
		this.userID = userID;
	}
	public Integer getIntegral() {
		return integral;
	}
	public void setIntegral(Integer integral) {
		this.integral = integral;
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
	public String getLastscan() {
		return lastscan;
	}
	public void setLastscan(String lastscan) {
		this.lastscan = lastscan;
	}
	
}
