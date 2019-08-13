package com.abbot.schimneylife.pojo.shopping;

public class MallProduct {

	private String id;
	private Integer productTypeId;
	private String productName;
	private String details;
	private String imgSmall;
	private String imgMiddle;
	private String imgLarge;
	private String productArea;
	private String province;//所属省份
	private MallProductParameter parameter;
	private String number;
	private String keywords;
	private String createTime;
	private Integer status;
	private Integer degree;//热度
	private Integer recommendation;//推荐度
	private Integer source;//商品来源   0 自营    1阿里分销   2阿里代购
	private String noname;// 预留
	private Integer productIntegral;
	
	public MallProduct() {}
	public MallProduct(Integer productTypeId,String productName,String details,String imgSmall,String imgMiddle,String imgLarge
			,String province,String number,String keywords,Integer status,Integer productIntegral) {
		this.productTypeId = productTypeId;
		this.productName = productName;
		this.details = details;
		this.imgSmall = imgSmall;
		this.imgMiddle = imgMiddle;
		this.imgLarge = imgLarge;
		this.province = province;
		this.number = number;
		this.status = status;
		this.keywords = keywords;
		this. productIntegral = productIntegral;
	}
	
	
	
	
	public Integer getProductIntegral() {
		return productIntegral;
	}
	public void setProductIntegral(Integer productIntegral) {
		this.productIntegral = productIntegral;
	}
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Integer getProductTypeId() {
		return productTypeId;
	}

	public void setProductTypeId(Integer productTypeId) {
		this.productTypeId = productTypeId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	public String getImgSmall() {
		return imgSmall;
	}

	public void setImgSmall(String imgSmall) {
		this.imgSmall = imgSmall;
	}

	public String getImgMiddle() {
		return imgMiddle;
	}

	public void setImgMiddle(String imgMiddle) {
		this.imgMiddle = imgMiddle;
	}

	public String getImgLarge() {
		return imgLarge;
	}

	public void setImgLarge(String imgLarge) {
		this.imgLarge = imgLarge;
	}

	public String getProductArea() {
		return productArea;
	}

	public void setProductArea(String productArea) {
		this.productArea = productArea;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public String getNoname() {
		return noname;
	}

	public void setNoname(String noname) {
		this.noname = noname;
	}

	public MallProductParameter getParameter() {
		return parameter;
	}

	public void setParameter(MallProductParameter parameter) {
		this.parameter = parameter;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getKeywords() {
		return keywords;
	}

	public void setKeywords(String keywords) {
		this.keywords = keywords;
	}
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	public Integer getDegree() {
		return degree;
	}
	public void setDegree(Integer degree) {
		this.degree = degree;
	}
	public Integer getRecommendation() {
		return recommendation;
	}
	public void setRecommendation(Integer recommendation) {
		this.recommendation = recommendation;
	}
	public Integer getSource() {
		return source;
	}
	public void setSource(Integer source) {
		this.source = source;
	}

}
