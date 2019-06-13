package com.tyss.boot.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.tyss.boot.dao.Studentrepository;
import com.tyss.boot.model.Student;

@Repository
public class StudentServiceImpl implements StudentService {
	@Autowired
	private JdbcTemplate jt;

	@Autowired
	Studentrepository repo;

	@Override
	public void save(Student s) {
		repo.save(s);
	}

	@Override
	public void delete(Integer id) {

		repo.delete(new Student(id));

	}

	@Override
	public List<Student> getAllStudents() {
		return repo.findAll();
	}

	public void update(Student s) {
		String sql = "update stu_tab set stu_hobby=?,stu_name=?,stu_mail=?,stu_Pass=? where stu_id=?";
		jt.update(sql,
				new Object[] { s.getStu_Hobby(), s.getStu_Name(), s.getStu_mail(), s.getStu_Pass(), s.getStu_Id() });
	}
	
	
	public int count(Integer id,String pass)
	{
		String query="select count(*) from stu_tab where  stu_id=? and stu_pass=?";
		
		
		return jt.queryForObject(query, new Object[] {id,pass},int.class);
	}

	@Override
	public Student getOneStudent(Integer id) {

		String sql ="select * from stu_tab where stu_Id=?";
		
		return jt.queryForObject(sql, new Object[] { id }, new RowMapper<Student>() {
			public Student mapRow(ResultSet rs, int row) throws SQLException {
				Student student = new Student();
				student.setStu_Id(rs.getInt(1));
				student.setStu_Hobby(rs.getString(2));
				student.setStu_mail(rs.getString(3));
				student.setStu_Name(rs.getString(4));
				student.setStu_Pass(rs.getString(5)); 

				return student;

			}
		});
	}
}
