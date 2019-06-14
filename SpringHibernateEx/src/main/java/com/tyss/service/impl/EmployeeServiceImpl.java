package com.tyss.service.impl;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tyss.dao.IEmployeeDao;
import com.tyss.model.Employee;
import com.tyss.service.IEmployeeService;

@Service
public class EmployeeServiceImpl implements IEmployeeService {

	
	@Autowired
	private IEmployeeDao dao;
	

	@Transactional
	public Integer saveEmp(Employee e) {
		return dao.saveEmp(e);
	}

	@Transactional
	public void deleteEmp(Integer id) {
		dao.deleteEmp(id);
	}

	@Transactional(readOnly = true)
	public Employee getoneemployee(Integer id) {
		return dao.getoneemployee(id);
	}

	@Transactional(readOnly = true)
	public List<Employee> getAllEmployees() {
		return dao.getAllEmployees();
	}

	@Transactional
	public void updateEmp(Employee e,HttpServletRequest req) {
		HttpSession ses=req.getSession(false);
		

		String name = (String) ses.getAttribute("name");
		String mail =  (String) ses.getAttribute("mail");
		String pwd =  (String) ses.getAttribute("pwd");
	//	if (name == null || name.isEmpty() || mail == null || mail.isEmpty() || pwd == null || pwd.isEmpty()) {
	if(e.getEmpMail()==null||e.getEmpMail().isEmpty() || e.getEmpName()==null ||e.getEmpName().isEmpty() || e.getEmpPwd()==null || e.getEmpPwd().isEmpty()) {
		
		    e.setEmpMail(mail);
			e.setEmpName(name);
			e.setEmpPwd(pwd);
			dao.updateEmp(e);
			System.out.println("session-ee"+e);
		} else {

			dao.updateEmp(e);
			System.out.println("other e:"+e);
		}
	}

	@Transactional(readOnly = true)
	public Employee getEmpByEmail(String usermail) {
		return dao.getEmpByEmail(usermail);
	}

	@Transactional(readOnly = true)
	public boolean isEmailExists(String email) {

		return dao.isEmailExists(email);

	}

	@Transactional(readOnly = true)
	public boolean checking(String mail, String pass) {
		
		return dao.checking(mail, pass);
	}

	

}
