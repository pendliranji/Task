package com.testyantra.test;

import java.sql.SQLException;

import org.junit.Test;

import com.testyantra.dao.impl.EmployeeDaoImpl;
import com.testyantra.model.Employee;

import junit.framework.TestCase;

public class UnitTest {
	EmployeeDaoImpl dao = new EmployeeDaoImpl();

	boolean success = true;
	boolean fail = false;

	@Test
	public void testLogin() {

		System.out.println("hi"); // boolean b = dao.checking("sunitha@gmail.com","{noop}sunitha");
		TestCase.assertEquals(true, dao.checking("sunitha@gmail.com", "{noop}sunitha"));

		// assertTrue(b);

	}

	@Test
	public void testMailExists() {

		boolean b = dao.isEmailExists("sunitha@gmail.com");
		TestCase.assertEquals(success, b);

	}
/*
	@Test
	public void register() throws Exception
	{
		Employee e=new Employee();
		e.setEmpDesg("java");
		e.setEmpMail("penranj@gmail.com");
		e.setEmpName("ranji");
		e.setEmpPwd("ranj");
		e.setRoles("ADMIN");
	TestCase.assertEquals(1, dao.saveEmp1(e));
		
		
	}*/
	
	/*
	@Test
	public void delete() throws ClassNotFoundException, SQLException
	{
		TestCase.assertEquals(1, EmployeeDaoImpl.deleteJdbc(6));
		
	}
	*/
	 
}