package com.money.common.pojo;

public class Product {
	//���Զ�Ӧ�ֶ�,��getter setter
	private String productId;//product_id
	private String productName;
	private Double productPrice;
	private String productCategoryId;
	private Integer productNum;
	private String productDescription;
	private Integer productComId;
	private Integer productManagerId;
	public Product() {
		// TODO Auto-generated constructor stub
	}
	
	public Product(String productId, String productName, Double productPrice, String productCategoryId,
			Integer productNum, String productDescription, Integer productComId, Integer productManagerId) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.productPrice = productPrice;
		this.productCategoryId = productCategoryId;
		this.productNum = productNum;
		this.productDescription = productDescription;
		this.productComId = productComId;
		this.productManagerId = productManagerId;
	}

	public String getProductCategoryId() {
		return productCategoryId;
	}
	public void setProductCategoryId(String productCategoryId) {
		this.productCategoryId = productCategoryId;
	}
	public Integer getProductComId() {
		return productComId;
	}
	public void setProductComId(Integer productComId) {
		this.productComId = productComId;
	}
	public Integer getProductManagerId() {
		return productManagerId;
	}
	public void setProductManagerId(Integer productManagerId) {
		this.productManagerId = productManagerId;
	}
	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public Double getProductPrice() {
		return productPrice;
	}
	public void setProductPrice(Double productPrice) {
		this.productPrice = productPrice;
	}
	public Integer getProductNum() {
		return productNum;
	}
	public void setProductNum(Integer productNum) {
		this.productNum = productNum;
	}
	public String getProductDescription() {
		return productDescription;
	}
	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}

	@Override
	public String toString() {
		return "Product [productId=" + productId + ", productName=" + productName + ", productPrice=" + productPrice
				+ ", productCategoryId=" + productCategoryId + ", productNum=" + productNum + ", productDescription="
				+ productDescription + ", productComId=" + productComId + ", productManagerId=" + productManagerId
				+ "]";
	}
	
}
