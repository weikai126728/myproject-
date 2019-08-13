package com.abbot.schimneylife.pojo.shopping;

public class CommDistribution {

	private int id;
	private String openid;
	private Integer noComm;//未提现
	private Integer haveComm;//已提现
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getOpenid() {
		return openid;
	}
	public void setOpenid(String openid) {
		this.openid = openid;
	}
	public Integer getNoComm() {
		return noComm;
	}
	public void setNoComm(Integer noComm) {
		this.noComm = noComm;
	}
	public Integer getHaveComm() {
		return haveComm;
	}
	public void setHaveComm(Integer haveComm) {
		this.haveComm = haveComm;
	}
	
}
