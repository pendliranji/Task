 package com.tyss.service.impl;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tyss.model.User;
import com.tyss.service.IUserService;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private IUserService service;

	@Transactional(readOnly = true)
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// take login username and get DB Model class obj
		User user = service.getUserByEmail(username);
		// convert model class object roles to SGA and add to Set
		Set<GrantedAuthority> roles = new HashSet<>();
		for (String role : user.getRoles()) {
			roles.add(new SimpleGrantedAuthority(role));
		} // convert to Spring f/w user object
		return new org.springframework.security.core.userdetails.User(user.getUserEmail(), user.getUserPwd(), roles);

	}   

}
