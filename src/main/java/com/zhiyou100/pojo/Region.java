package com.zhiyou100.pojo;

public class Region {
	private int id ;
	private String code ; 
	private String name ;
	private int parentId ;
	private int level ;
	private int order ;
	private String nameEn ;
	private String shortNameEn ;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getParentId() {
		return parentId;
	}
	public void setParentId(int parentId) {
		this.parentId = parentId;
	}
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	public int getOrder() {
		return order;
	}
	public void setOrder(int order) {
		this.order = order;
	}
	public String getNameEn() {
		return nameEn;
	}
	public void setNameEn(String nameEn) {
		this.nameEn = nameEn;
	}
	public String getShortNameEn() {
		return shortNameEn;
	}
	public void setShortNameEn(String shortNameEn) {
		this.shortNameEn = shortNameEn;
	}
	@Override
	public String toString() {
		return "Region [id=" + id + ", code=" + code + ", name=" + name + ", parentId=" + parentId + ", level=" + level
				+ ", order=" + order + ", nameEn=" + nameEn + ", shortNameEn=" + shortNameEn + "]";
	}
	
	
	
}
