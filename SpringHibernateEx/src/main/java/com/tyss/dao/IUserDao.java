package com.tyss.dao;

import com.tyss.model.User;

public interface IUserDao {
	
	public int saveUser(User user);  
	public User getUserByEmail(String userEmail); 

}
