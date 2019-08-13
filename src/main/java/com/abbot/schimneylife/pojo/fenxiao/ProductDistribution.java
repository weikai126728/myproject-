package com.abbot.schimneylife.pojo.fenxiao;
 
public class ProductDistribution {
	
	private int id;					
	private Integer deleted;		
	private int version;			
	private double bills;			
	private String content;			
	private int inventory;			
	private double money;			
	private String picture;			
	private String title;			
	private Integer productCateId;	
	private double rateA;				
	private double rateB;				
	private double rateC;				
	private String createDate;		
	private ProductCateDistribution productCate;
	
	
	public ProductCateDistribution getProductCate() {
		return productCate;
	}
	public void setProductCate(ProductCateDistribution productCate) {
		this.productCate = productCate;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Integer getDeleted() {
		return deleted;
	}
	public void setDeleted(Integer deleted) {
		this.deleted = deleted;
	}
	public int getVersion() {
		return version;
	}
	public void setVersion(int version) {
		this.version = version;
	}
	public double getBills() {
		return bills;
	}
	public void setBills(double bills) {
		this.bills = bills;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getInventory() {
		return inventory;
	}
	public void setInventory(int inventory) {
		this.inventory = inventory;
	}
	public double getMoney() {
		return money;
	}
	public void setMoney(double money) {
		this.money = money;
	}
	public String getPicture() {
		return picture;
	}
	public void setPicture(String picture) {
		this.picture = picture;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Integer getProductCateId() {
		return productCateId;
	}
	public void setProductCateId(Integer productCateId) {
		this.productCateId = productCateId;
	}
	public double getRateA() {
		return rateA;
	}
	public void setRateA(double rateA) {
		this.rateA = rateA;
	}
	public double getRateB() {
		return rateB;
	}
	public void setRateB(double rateB) {
		this.rateB = rateB;
	}
	public double getRateC() {
		return rateC;
	}
	public void setRateC(double rateC) {
		this.rateC = rateC;
	}
	public String getCreateDate() {
		return createDate.substring(0, 19);
	}
	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}
	
	
}
