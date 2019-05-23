package com.zhiyou100.pojo;

import java.util.Date;

public class ProjectType {
	private int id ;
	private String name ;
	private String desc ;
	private Date stardate ;
	private int type ;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public Date getStardate() {
		return stardate;
	}
	public void setStardate(Date stardate) {
		this.stardate = stardate;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	@Override
	public String toString() {
		return "ProjectType [id=" + id + ", name=" + name + ", desc=" + desc + ", stardate=" + stardate + ", type="
				+ type + "]";
	}
	
	
	
}
