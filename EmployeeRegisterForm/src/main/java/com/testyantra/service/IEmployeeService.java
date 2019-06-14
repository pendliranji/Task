package com.testyantra.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.testyantra.model.Employee;

public interface IEmployeeService {
	public Integer saveEmp(Employee e);

	public void deleteEmp(Integer id);
	public void updateEmp(Employee e/*,HttpServletRequest req*/);

	public Employee getoneemployee(Integer id);
	public List<Employee> getAllEmployees();

	public Employee getEmpByEmail(String usermail);
	public boolean isEmailExists(String email);
	public boolean checking(String mail,String pass);

}
