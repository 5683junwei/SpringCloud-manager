package com.money.common.pojo;

public class Categroy {
	private Integer id;
	private String name;
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
	public Categroy() {
		// TODO Auto-generated constructor stub
	}
	public Categroy(Integer id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	@Override
	public String toString() {
		return "Categroy [id=" + id + ", name=" + name + "]";
	}
	
}
