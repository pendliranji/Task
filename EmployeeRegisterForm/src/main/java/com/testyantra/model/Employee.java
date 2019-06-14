package com.testyantra.model;

import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.JoinColumn;

import lombok.Data;

public class Employee  {

	private Integer empId;
	private String empPwd;
	private String empName;
	private String empDesg;
	private String empMail;
	private String roles;

	public Employee() {
		super();
	}

	public String getRoles() {
		return roles;
	}

	public void setRoles(String roles) {
		this.roles = roles;
	}

	public Integer getEmpId() {
		return empId;
	}

	public void setEmpId(Integer empId) {
		this.empId = empId;
	}

	public String getEmpPwd() {
		return empPwd;
	}

	public void setEmpPwd(String empPwd) {
		this.empPwd = empPwd;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getEmpDesg() {
		return empDesg;
	}

	public void setEmpDesg(String empDesg) {
		this.empDesg = empDesg;
	}

	public String getEmpMail() {
		return empMail;
	}

	public void setEmpMail(String empMail) {
		this.empMail = empMail;
	}

	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", empPwd=" + empPwd + ", empName=" + empName + ", empDesg=" + empDesg
				+ ", empMail=" + empMail + ", roles=" + roles + "]";
	}
	
	

}
