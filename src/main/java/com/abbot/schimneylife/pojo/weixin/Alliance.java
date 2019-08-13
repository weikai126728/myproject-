package com.abbot.schimneylife.pojo.weixin;



import java.util.Date;

import com.abbot.schimneylife.util.StringUtil;

/**
 * 
 * @author Administrator 加盟商信息类
 */

public class Alliance {
	private Integer alid;// alliance表主键
	private String product_id;// 合作商内部标识
	private String alopenid;// 合作商微信标识
	private String alnickname;// 合作商昵称
	private String headimgurl;// 合作商头像
	private String alname;// 合作商姓名
	private String altel;// 合作商电话
	
	private String alproject;//经营项目
	private String alMethod;// 合作方式
	private Integer type_id;
	private Integer model_id;
	private String alShopArea;//商户面积
	private String storename;// 合作商门店名称
	private String storeaddress;// 合作商门店地址
	private Date storecurrtime;// 合作商加盟时间String类型
	private String url;//二维码链接
	private String son_openid;
	private String salesmanid;
	private String createTime;
	
	

	public String getSalesmanid() {
		return salesmanid;
	}
	public void setSalesmanid(String salesmanid) {
		this.salesmanid = salesmanid;
	}
	public String getSon_openid() {
		return son_openid;
	}
	public void setSon_openid(String son_openid) {
		this.son_openid = son_openid;
	}
	public String getAlproject() {
		return alproject;
	}
	public void setAlproject(String alproject) {
		this.alproject = alproject;
	}
	public String getAlMethod() {
		return alMethod;
	}
	public void setAlMethod(String alMethod) {
		this.alMethod = alMethod;
	}
	public String getAlShopArea() {
		return alShopArea;
	}
	public void setAlShopArea(String alShopArea) {
		this.alShopArea = alShopArea;
	}
	
	
	public Integer getAlid() {
		return alid;
	}
	public void setAlid(Integer alid) {
		this.alid = alid;
	}
	public String getProduct_id() {
		return product_id;
	}
	public void setProduct_id(String product_id) {
		this.product_id = product_id;
	}
	public String getAlopenid() {
		return alopenid;
	}
	public void setAlopenid(String alopenid) {
		this.alopenid = alopenid;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getAlnickname() {
		return alnickname;
	}
	public void setAlnickname(String alnickname) {
		this.alnickname = alnickname;
	}
	public String getHeadimgurl() {
		return headimgurl;
	}
	public void setHeadimgurl(String headimgurl) {
		this.headimgurl = headimgurl;
	}
	public String getAlname() {
		return alname;
	}
	public void setAlname(String alname) {
		this.alname = alname;
	}
	public String getAltel() {
		return altel;
	}
	public void setAltel(String altel) {
		this.altel = altel;
	}
	public String getStorename() {
		return storename;
	}
	public void setStorename(String storename) {
		this.storename = storename;
	}
	public String getStoreaddress() {
		return storeaddress;
	}
	public void setStoreaddress(String storeaddress) {
		this.storeaddress = storeaddress;
	}
	public Date getStorecurrtime() {
		return storecurrtime;
	}
	public void setStorecurrtime(Date storecurrtime) {
		this.storecurrtime = storecurrtime;
	}
	public String getCreateTime() {
		if(storecurrtime!=null) {
			return StringUtil.format(storecurrtime);
		}
		return createTime;
	}
	public void setCreateTime(String createTime) {
		
		this.createTime = createTime;
	}
	public Integer getType_id() {
		return type_id;
	}
	public void setType_id(Integer type_id) {
		this.type_id = type_id;
	}
	public Integer getModel_id() {
		return model_id;
	}
	public void setModel_id(Integer model_id) {
		this.model_id = model_id;
	}

}
