package com.zhiyou100.pojo;

public class User {
	private String username ;
	private String password ;
	private String realname ;
	private String code ;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRealname() {
		return realname;
	}
	public void setRealname(String realname) {
		this.realname = realname;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	@Override
	public String toString() {
		return "User [username=" + username + ", password=" + password + ", realname=" + realname + ", code=" + code
				+ "]";
	}
	
}
