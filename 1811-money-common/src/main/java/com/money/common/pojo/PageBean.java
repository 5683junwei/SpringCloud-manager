package com.money.common.pojo;

import java.util.List;

public class PageBean {
	//定义数据总数
	private Integer total;
	//定义每页显示的数据数
	private Integer pageSize;
	//定义数据集合
	private List<Product> pageList;
	
	public Integer getPageSize() {
		return pageSize;
	}
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
	public Integer getTotal() {
		return total;
	}
	public void setTotal(Integer total) {
		this.total = total;
	}
	public List<Product> getPageList() {
		return pageList;
	}
	public void setPageList(List<Product> pageList) {
		this.pageList = pageList;
	}
	
	public PageBean() {
		// TODO Auto-generated constructor stub
	}
	public PageBean(Integer total, Integer pageSize, List<Product> pageList) {
		super();
		this.total = total;
		this.pageSize = pageSize;
		this.pageList = pageList;
	}
	@Override
	public String toString() {
		return "PageBean [total=" + total + ", pageSize=" + pageSize + ", pageList=" + pageList + "]";
	}
	
	
}
