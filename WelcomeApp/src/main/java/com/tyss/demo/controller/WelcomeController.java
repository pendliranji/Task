package com.tyss.demo.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.tyss.demo.dao.WelcomeDao;
import com.tyss.demo.model.Employee;

@Controller
public class WelcomeController {
	

	@Autowired
	private WelcomeDao dao;

	@RequestMapping("/register")
	public String show_form(Map<String, Object> map) {
		map.put("employee", new Employee());
		return "EmpRegister";
	}

	@RequestMapping(value="/save",method=RequestMethod.POST)
	public String getData(Map<String,Object> map,@ModelAttribute("employee") Employee employee) {
		
	
		map.put("data","done");
		return "Welcome";
	}
	@RequestMapping("/view")
	public String getAllEmployeesData()
	{
		
		return null;
	}
}

