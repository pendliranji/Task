package com.tyss.demo.dao;

import java.util.List;

import com.tyss.demo.model.Employee;

public interface WelcomeDao {
	
	public Integer save_employee(Employee e);
	public void delete_employee(Integer id);
	public void update_employee(Employee e);
	public Employee getOne_employee(Integer id);
	public List<Employee> getAll_employees();
	
	
	

}
