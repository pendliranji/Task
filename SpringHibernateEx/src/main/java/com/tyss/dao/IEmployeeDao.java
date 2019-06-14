package com.tyss.dao;

import java.util.List;

import com.tyss.model.Employee;


public interface IEmployeeDao {
	
	public Integer saveEmp(Employee e);
	
	public void deleteEmp(Integer id);
	public void updateEmp(Employee e);

	public Employee getoneemployee(Integer id);
	public List<Employee> getAllEmployees();
	public Employee getEmpByEmail(String usermail );

	public boolean isEmailExists(String email);
	
	public boolean checking(String mail,String pass);
	
	

}
