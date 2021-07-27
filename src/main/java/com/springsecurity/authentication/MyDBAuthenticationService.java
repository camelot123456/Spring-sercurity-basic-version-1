package com.springsecurity.authentication;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.springsecurity.dao.impl.UserInfoDAO;
import com.springsecurity.models.UserInfo;

@Service
public class MyDBAuthenticationService implements UserDetailsService{

	@Autowired
	private UserInfoDAO userInfoDAO;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		UserInfo userInfo = userInfoDAO.findUserInfo(username);
		System.out.println("UserInfo = " + userInfo);
		
		if (userInfo == null) {
            throw new UsernameNotFoundException("User " + username + " was not found in the database");
        }
		
		// [USER,ADMIN,..]
        List<String> roles= userInfoDAO.getUserRoles(username);
        
        List<GrantedAuthority> grantList = new ArrayList<>();
        if (roles != null) {
			for (String role : roles) {
				// ROLE_USER, ROLE_ADMIN,..
				GrantedAuthority authority = new SimpleGrantedAuthority("ROLE" + role);
				grantList.add(authority);
			}
		}
        //grantList là danh sách chứa các quyền của user đó
        UserDetails userDetails = (UserDetails) new User(userInfo.getUsername(), userInfo.getPassword(), grantList);
        
		return userDetails;
	}

}
