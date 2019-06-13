package com.tyss.boot.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tyss.boot.model.Student;

public interface Studentrepository extends JpaRepository<Student, Integer>{

}
