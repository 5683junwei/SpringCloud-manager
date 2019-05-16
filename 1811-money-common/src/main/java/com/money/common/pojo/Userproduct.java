package com.money.common.pojo;


public class Userproduct {
	private String userId;
	private String categroyName;
	private String categroyNum;
	private String productName;
	private String imgurl;
	private Integer pNum;
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getCategroyName() {
		return categroyName;
	}
	public void setCategroyName(String categroyName) {
		this.categroyName = categroyName;
	}
	public String getCategroyNum() {
		return categroyNum;
	}
	public void setCategroyNum(String categroyNum) {
		this.categroyNum = categroyNum;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getImgurl() {
		return imgurl;
	}
	public void setImgurl(String imgurl) {
		this.imgurl = imgurl;
	}
	public Integer getpNum() {
		return pNum;
	}
	public void setpNum(Integer pNum) {
		this.pNum = pNum;
	}
	@Override
	public String toString() {
		return "Userproduct [userId=" + userId + ", categroyName=" + categroyName + ", categroyNum=" + categroyNum
				+ ", productName=" + productName + ", imgurl=" + imgurl + ", pNum=" + pNum + "]";
	}
	public Userproduct(String userId, String categroyName, String categroyNum, String productName, String imgurl,
			Integer pNum) {
		super();
		this.userId = userId;
		this.categroyName = categroyName;
		this.categroyNum = categroyNum;
		this.productName = productName;
		this.imgurl = imgurl;
		this.pNum = pNum;
	}
	
	
	
	
	
}
