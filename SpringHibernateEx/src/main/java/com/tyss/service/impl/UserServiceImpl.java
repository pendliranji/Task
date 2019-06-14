package com.tyss.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tyss.dao.IUserDao;
import com.tyss.model.User;
import com.tyss.service.IUserService;

@Service
public class UserServiceImpl implements IUserService {

	@Autowired
	private IUserDao dao;
	@Autowired
	private BCryptPasswordEncoder encoder;

	@Transactional
	public int saveUser(User user) {
		// read UI password
		String pwd = user.getUserPwd();
		// encode password

		pwd = encoder.encode(pwd);
		// set back to model object
		user.setUserPwd(pwd);
		// save user to DB
		return dao.saveUser(user);

	}

	@Transactional(readOnly = true)
	public User getUserByEmail(String userEmail) {
		return dao.getUserByEmail(userEmail);
	}

}
