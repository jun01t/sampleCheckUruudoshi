package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.dao.LoginUserDao;
import com.example.demo.entity.LoginUser;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private LoginUserDao userDao;

	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		LoginUser user = userDao.findUser(userName);

		if (user == null) {
			throw new UsernameNotFoundException("User" + userName + "was not found in the database");
		}

		String role = user.getRole();
		List<GrantedAuthority> grantList = new ArrayList<GrantedAuthority>();
		GrantedAuthority authority = new SimpleGrantedAuthority(role);
		grantList.add(authority);

		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

		UserDetails userDetails = (UserDetails) new User(user.getUserName(), encoder.encode(user.getPassword()),
				grantList);

		return userDetails;
	}

}
