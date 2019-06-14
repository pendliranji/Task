package com.tyss.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.tyss.model.User;
import com.tyss.service.IUserService;

@Controller
@RequestMapping("/user")
public class UserController {
	@Autowired
	private IUserService service;

	@RequestMapping("/register")
	public String showReg(ModelMap map) {
		map.addAttribute("user", new User());
		return "UserRegister";
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String saveUser(@ModelAttribute User user, ModelMap map) {
		int userId = service.saveUser(user);
		String msg = "User '" + userId + "' create successfully ";
		map.addAttribute("message", msg);
		return "UserRegister";
	}
}
