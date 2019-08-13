package com.abbot.schimneylife.pojo.shopping;

public class SupermarketInfo {

	private Integer id;
	private String name;
	private String phone;
	private String details;
	private String introduction;
	private String contactUser;
	private String tel;
	private String imgSmall;
	private String imgMiddle;
	private String imgLarge;
	private String video;
	private String banner;
	private String html;
	private Integer status;
	private Integer recommendation;
	private String createTime;
	private String updateTime;
	private Integer mclass;//商户分类
	private String openid;
	private SupermarketAddress address;
	private String information;
	private Integer balance;//余额
	private Integer consume;//消耗
	private String weChatqrcode;
	private String productTime;
	private String products;
	private String distribution;
	private String addre;
	private String mp3;
	private Integer payment;
	
	
	public Integer getPayment() {
		return payment;
	}
	public void setPayment(Integer payment) {
		this.payment = payment;
	}
	public String getMp3() {
		return mp3;
	}
	public void setMp3(String mp3) {
		this.mp3 = mp3;
	}
	public String getAddre() {
		return addre;
	}
	public void setAddre(String addre) {
		this.addre = addre;
	}
	public String getDistribution() {
		return distribution;
	}
	public void setDistribution(String distribution) {
		this.distribution = distribution;
	}
	public String getProductTime() {
		return productTime;
	}
	public void setProductTime(String productTime) {
		this.productTime = productTime;
	}
	public String getProducts() {
		return products;
	}
	public void setProducts(String products) {
		this.products = products;
	}
	public String getWeChatqrcode() {
		return weChatqrcode;
	}
	public void setWeChatqrcode(String weChatqrcode) {
		this.weChatqrcode = weChatqrcode;
	}
	public Integer getBalance() {
		return balance;
	}
	public void setBalance(Integer balance) {
		this.balance = balance;
	}

	public Integer getConsume() {
		return consume;
	}
	public void setConsume(Integer consume) {
		this.consume = consume;
	}
	public String getInformation() {
		return information;
	}
	public void setInformation(String information) {
		this.information = information;
	}
	public String getOpenid() {
		return openid;
	}
	public void setOpenid(String openid) {
		this.openid = openid;
	}
	public Integer getMclass() {
		return mclass;
	}
	public void setMclass(Integer mclass) {
		this.mclass = mclass;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getContactUser() {
		return contactUser;
	}
	public void setContactUser(String contactUser) {
		this.contactUser = contactUser;
	}
	

	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getVideo() {
		return video;
	}
	public void setVideo(String video) {
		this.video = video;
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
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
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
	public SupermarketAddress getAddress() {
		return address;
	}
	public void setAddress(SupermarketAddress address) {
		this.address = address;
	}
	public String getDetails() {
		return details;
	}
	public void setDetails(String details) {
		this.details = details;
	}
	public String getIntroduction() {
		return introduction;
	}
	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}
	public String getBanner() {
		return banner;
	}
	public void setBanner(String banner) {
		this.banner = banner;
	}
	public String getHtml() {
		return html;
	}
	public void setHtml(String html) {
		this.html = html;
	}
	public Integer getRecommendation() {
		return recommendation;
	}
	public void setRecommendation(Integer recommendation) {
		this.recommendation = recommendation;
	}
	
}
