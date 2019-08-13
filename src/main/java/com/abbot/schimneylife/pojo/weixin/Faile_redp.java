package com.abbot.schimneylife.pojo.weixin;

public class Faile_redp {
private int id;
private String openid;
private int total_fee;
private String creattime;
private int xf_fee;
private int delet;

public int getDelet() {
	return delet;
}
public void setDelet(int delet) {
	this.delet = delet;
}
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
public int getTotal_fee() {
	return total_fee;
}
public void setTotal_fee(int total_fee) {
	this.total_fee = total_fee;
}

public String getCreattime() {
	if(this.creattime==null) {
		return null;
	}
	return creattime.substring(0, 19);
}
public void setCreattime(String creattime) {
	this.creattime = creattime;
}
public int getXf_fee() {
	return xf_fee;
}
public void setXf_fee(int xf_fee) {
	this.xf_fee = xf_fee;
}

}
