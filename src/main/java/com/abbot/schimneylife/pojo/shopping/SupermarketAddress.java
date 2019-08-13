package com.abbot.schimneylife.pojo.shopping;

import java.math.BigDecimal;

public class SupermarketAddress {

	private String id;
	private String province;
	private String detail;
	private String busRoute;
	private BigDecimal longitude;
	private BigDecimal latitude;
	private Integer supermarketInfoId;
	private String createTime;
	private String updateTime;
	private BigDecimal dis;
	private String geoCode;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	public String getDetail() {
		return detail;
	}
	public void setDetail(String detail) {
		this.detail = detail;
	}
	public BigDecimal getLongitude() {
		return longitude;
	}
	public void setLongitude(BigDecimal longitude) {
		this.longitude = longitude;
	}
	public BigDecimal getLatitude() {
		return latitude;
	}
	public void setLatitude(BigDecimal latitude) {
		this.latitude = latitude;
	}
	public Integer getSupermarketInfoId() {
		return supermarketInfoId;
	}
	public void setSupermarketInfoId(Integer supermarketInfoId) {
		this.supermarketInfoId = supermarketInfoId;
	}
	public String getCreateTime() {
		return createTime;
	}
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	public String getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(String updateTime) {
		this.updateTime = updateTime;
	}
	public BigDecimal getDis() {
		return dis;
	}
	public void setDis(BigDecimal dis) {
		this.dis = dis;
	}
	public String getBusRoute() {
		return busRoute;
	}
	public void setBusRoute(String busRoute) {
		this.busRoute = busRoute;
	}
	public String getGeoCode() {
		return geoCode;
	}
	public void setGeoCode(String geoCode) {
		this.geoCode = geoCode;
	}
	
}
