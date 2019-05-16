package com.money.common.pojo;

public class Com {
	private Integer comId;
	private String comName;
	private String comDescription;
	public Integer getComId() {
		return comId;
	}
	public void setComId(Integer comId) {
		this.comId = comId;
	}
	public String getComName() {
		return comName;
	}
	public void setComName(String comName) {
		this.comName = comName;
	}
	public String getComDescription() {
		return comDescription;
	}
	public void setComDescription(String comDescription) {
		this.comDescription = comDescription;
	}
	public Com() {
		// TODO Auto-generated constructor stub
	}
	public Com(Integer comId, String comName, String comDescription) {
		super();
		this.comId = comId;
		this.comName = comName;
		this.comDescription = comDescription;
	}
	@Override
	public String toString() {
		return "Com [comId=" + comId + ", comName=" + comName + ", comDescription=" + comDescription + "]";
	}
	
}
