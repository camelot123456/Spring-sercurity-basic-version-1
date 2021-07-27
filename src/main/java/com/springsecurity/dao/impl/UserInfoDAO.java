package com.springsecurity.dao.impl;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springsecurity.dao.IUserInfoDAO;
import com.springsecurity.mapper.UserInfoMapper;
import com.springsecurity.models.UserInfo;

@Service
@Transactional
public class UserInfoDAO extends JdbcDaoSupport implements IUserInfoDAO{

	@Autowired
	public UserInfoDAO(DataSource dataSource) {
		// TODO Auto-generated constructor stub
		this.setDataSource(dataSource);
	}
	
	@Override
	public UserInfo findUserInfo(String username) {
		// TODO Auto-generated method stub
		String sql = "SELECT * FORM [USER]"
				+ " WHERE USERNAME = ?";
		Object[] params = new Object[] {username};
		UserInfoMapper mapper = new UserInfoMapper();
		try {
			UserInfo userInfo = this.getJdbcTemplate().queryForObject(sql, params, mapper);
			return userInfo;
		} catch (EmptyResultDataAccessException e) {
			// TODO: handle exception
			return null;
		}
	}

	@Override
	public List<String> getUserRoles(String username) {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM [USER] U, [ROLE] R "
				+ "WHERE U.USERNAME = ? AND U.ROLE_ID = R.ID";
		Object[] params = new Object[] {username};
		List<String> roles = this.getJdbcTemplate().queryForList(sql, params, String.class);
		return roles;
	}
	
}
