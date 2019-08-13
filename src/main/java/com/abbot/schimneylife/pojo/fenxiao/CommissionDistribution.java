package com.abbot.schimneylife.pojo.fenxiao;


public class CommissionDistribution {
	private int id;
	private Integer deleted;		
	private int version;			
	private String createDate;		
	private int level;
	private String lowerLevelNo;
	private double money;
	private String no;
	private String operator;
	private String remark;
	private int type;
	private int userId;
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
	public String getCreateDate() {
		return createDate.substring(0, 19);
	}
	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	public String getLowerLevelNo() {
		return lowerLevelNo;
	}
	public void setLowerLevelNo(String lowerLevelNo) {
		this.lowerLevelNo = lowerLevelNo;
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
	public String getOperator() {
		return operator;
	}
	public void setOperator(String operator) {
		this.operator = operator;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	 

	
}
