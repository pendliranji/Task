package com.tyss.controller;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.tyss.model.User;
import com.tyss.model.Users;

@RestController
public class UserRestController {

	@RequestMapping(value="/use",method=RequestMethod.POST)	
	public Users getAll(@RequestBody User user) {
		Users u = new Users();
		if (user != null || user.getName()!=null ) {
			int id = user.getId();
			String name = user.getName();
			double sal = user.getSal();
		u.setSuccess("Success");
		}
		else
		{
			u.setSuccess("failure");
		}
		return u;
	}
}
