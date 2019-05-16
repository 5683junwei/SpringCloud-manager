package com.money.common.vo;

import java.util.List;

import com.money.common.pojo.Product;

public class VoProduct  {
	private String categroyName;
	private String categroyNum;
	List<Product>  productList;
	private String imgurl;
	
	public VoProduct(List<Product> productList) {
		super();
		this.productList = productList;
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
	public List<Product> getProductList() {
		return productList;
	}
	public void setProductList(List<Product> productList) {
		this.productList = productList;
	}
	public String getImgurl() {
		return imgurl;
	}
	public void setImgurl(String imgurl) {
		this.imgurl = imgurl;
	}
	
	
	
	
	
}
