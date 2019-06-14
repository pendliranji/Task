package com.tyss.demo.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.tyss.demo.model.Employee;

@Repository
public class WelcomeDaoImpl implements WelcomeDao {
	@Autowired
	private JdbcTemplate jt;

	public Integer save_employee(Employee e) {
	String sql="insert into emp(id,designation,mail,names,password) values(?,?,?,?,?)";
//	jt.update(sql,new Object[] {e.get})
		return null;
	}

	public void delete_employee(Integer id) {
		// TODO Auto-generated method stub
		
	}

	public void update_employee(Employee e) {
		// TODO Auto-generated method stub
		
	}

	public Employee getOne_employee(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Employee> getAll_employees() {
		// TODO Auto-generated method stub
		return null;
	}

	

}
