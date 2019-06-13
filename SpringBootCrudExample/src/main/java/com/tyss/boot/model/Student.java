package com.tyss.boot.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity@
Table(name="stu_tab")
public class Student {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer stu_Id;

	private String stu_Name;
	
	private String stu_Hobby;
	private String stu_mail;
	private String stu_Pass;

	public Student() {
		super();
	}
	

	public Student(Integer stu_Id) {
		super();
		this.stu_Id = stu_Id;
		
	}


	public Integer getStu_Id() {
		return stu_Id;
	}

	public void setStu_Id(Integer stu_Id) {
		this.stu_Id = stu_Id;
	}

	public String getStu_Name() {
		return stu_Name;
	}

	public void setStu_Name(String stu_Name) {
		this.stu_Name = stu_Name;
	}

	public String getStu_Hobby() {
		return stu_Hobby;
	}

	public void setStu_Hobby(String stu_Hobby) {
		this.stu_Hobby = stu_Hobby;
	}


	public String getStu_Pass() {
		return stu_Pass;
	}


	public void setStu_Pass(String stu_Pass) {
		this.stu_Pass = stu_Pass;
	}


	public String getStu_mail() {
		return stu_mail;
	}


	public void setStu_mail(String stu_mail) {
		this.stu_mail = stu_mail;
	}


	
	
	
}
