package com.springsecurity.models;

public class UserInfo {


	private String username;
	private String password;
	private String fullname;
	private String roleId;
	private String avatar;
	
	public UserInfo(String username, String password, String fullname, String roleId, String avatar) {
		super();
		this.username = username;
		this.password = password;
		this.fullname = fullname;
		this.roleId = roleId;
		this.avatar = avatar;
	}
	

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

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public String getRoleId() {
		return roleId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

}
