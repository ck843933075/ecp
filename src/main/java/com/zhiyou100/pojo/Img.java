package com.zhiyou100.pojo;

import java.util.List;

public class Img {
	private int id ;
	private String username ;
	private List<String> img ;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
	public List<String> getImg() {
		return img;
	}
	public void setImg(List<String> img) {
		this.img = img;
	}
	@Override
	public String toString() {
		return "Img [id=" + id + ", username=" + username + ", img=" + img + "]";
	}
	
}
