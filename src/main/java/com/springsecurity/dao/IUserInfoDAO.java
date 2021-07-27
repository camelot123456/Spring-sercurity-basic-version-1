package com.springsecurity.dao;

import java.util.List;

import com.springsecurity.models.UserInfo;

public interface IUserInfoDAO {
	
	public UserInfo findUserInfo(String username);
	
	public List<String> getUserRoles(String username);
	
}
