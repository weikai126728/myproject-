package com.abbot.schimneylife.pojo.shopping;

/**
 * 物流单号
 * 
 * @author Administrator
 *
 */

public class Logistics {
	private String id;
	private String service_id;
	private String img_path;
	private String logistics;//物流单号
	private String logistics_company;//承运公司
	private String createTime;
	private String updateTime;
	private Refund service;
	
	
	public Refund getService() {
		return service;
	}

	public void setService(Refund service) {
		this.service = service;
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

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getService_id() {
		return service_id;
	}

	public void setService_id(String service_id) {
		this.service_id = service_id;
	}

	public String getImg_path() {
		return img_path;
	}

	public void setImg_path(String img_path) {
		this.img_path = img_path;
	}

	public String getLogistics() {
		return logistics;
	}

	public void setLogistics(String logistics) {
		this.logistics = logistics;
	}

	public String getLogistics_company() {
		return logistics_company;
	}

	public void setLogistics_company(String logistics_company) {
		this.logistics_company = logistics_company;
	}

}
