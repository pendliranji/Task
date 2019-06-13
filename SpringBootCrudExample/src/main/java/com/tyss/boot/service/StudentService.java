package com.tyss.boot.service;

import java.util.List;

import com.tyss.boot.model.Student;

public interface StudentService {

	public void save(Student s);
	public void delete(Integer id);
	public List<Student> getAllStudents();
	public void update(Student s);
	public Student getOneStudent(Integer id);
	public int count(Integer id,String pass);
	
}
