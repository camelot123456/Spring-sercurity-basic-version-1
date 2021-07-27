package com.springsecurity.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.springsecurity.models.UserInfo;

public class UserInfoMapper implements RowMapper<UserInfo>{

	@Override
	public UserInfo mapRow(ResultSet rs, int index) throws SQLException {
		// TODO Auto-generated method stub
		String username = rs.getString("USERNAME");
		String password = rs.getString("PASSWORD");
		return new UserInfo(username, password);
	}
	
	
	
}
