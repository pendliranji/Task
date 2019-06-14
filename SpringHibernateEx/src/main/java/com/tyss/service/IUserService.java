package com.tyss.service;

import com.tyss.model.User;

public interface IUserService {
	public int saveUser(User user);  
	public User getUserByEmail(String userEmail);

}
