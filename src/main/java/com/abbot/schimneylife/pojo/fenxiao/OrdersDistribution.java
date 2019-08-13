package com.abbot.schimneylife.pojo.fenxiao;

 
public class OrdersDistribution {

	private int id;
	private Integer deleted;		
	private int version;			
	private double money;			
	private String no;				
	private String payDate;			
	private String productId;		
	private double productMoney;	
	private String productName;		
	private int productNum;			
	private int status;				
	private String summary;			
	private int userId;				
	private String wlid;			
	private String createDate;		
	private UserDistribution user;
	
	
	public UserDistribution getUser() {
		return user;
	}
	public void setUser(UserDistribution user) {
		this.user = user;
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
	public double getMoney() {
		return money;
	}
	public void setMoney(double money) {
		this.money = money;
	}
	public String getNo() {
		return no;
	}
	public void setNo(String no) {
		this.no = no;
	}
	public String getPayDate() {
		return payDate;
	}
	public void setPayDate(String payDate) {
		this.payDate = payDate;
	}
	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}
	public double getProductMoney() {
		return productMoney;
	}
	public void setProductMoney(double productMoney) {
		this.productMoney = productMoney;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public int getProductNum() {
		return productNum;
	}
	public void setProductNum(int productNum) {
		this.productNum = productNum;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getSummary() {
		return summary;
	}
	public void setSummary(String summary) {
		this.summary = summary;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getWlid() {
		return wlid;
	}
	public void setWlid(String wlid) {
		this.wlid = wlid;
	}
	public String getCreateDate() {
		return createDate.substring(0, 19);
	}
	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}
		
}
