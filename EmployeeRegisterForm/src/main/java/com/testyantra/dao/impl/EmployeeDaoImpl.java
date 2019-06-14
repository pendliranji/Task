package com.testyantra.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.testyantra.dao.IEmployeeDao;
import com.testyantra.model.Employee;

@Repository
public class EmployeeDaoImpl implements IEmployeeDao {

	@Autowired
	JdbcTemplate jt;

	@Override
	public Integer saveEmp(Employee e) {
		String sql = "insert into employee_tab(designation,mail,names,password) values(?,?,?,?)";
		String sql2 = "insert into employee_roles(mail,roles) values(?,?)";
		int count1 = jt.update(sql2, new Object[] { e.getEmpMail(), e.getRoles() });

		int count = jt.update(sql,
				new Object[] { e.getEmpDesg(), e.getEmpMail(), e.getEmpName(), "{noop}" + e.getEmpPwd() });

		return count;
	}

	@Override
	public void deleteEmp(Integer id) {
		String sql = "delete from employee_tab where id=?";
		int count = jt.update(sql, new Object[] { id });

	}

	@Override
	public void updateEmp(Employee e) {
		String sql = "update employee_tab set names=?,password=?,designation=?,mail=? where id=?";
		int c = jt.update(sql,
				new Object[] { e.getEmpName(), e.getEmpPwd(), e.getEmpDesg(), e.getEmpMail(), e.getEmpId() });

	}

	public Employee getoneemployee(Integer id) {

		String sql = "select * from employee_tab where id= ?";
		// System.out.println("111" + sql);
		return jt.queryForObject(sql, new Object[] { id }, new RowMapper<Employee>() {
			public Employee mapRow(ResultSet rs, int row) throws SQLException {
				Employee employee = new Employee();
				employee.setEmpId(rs.getInt(1));
				employee.setEmpDesg(rs.getString(2));
				employee.setEmpMail(rs.getString(3));
				employee.setEmpName(rs.getString(4));
				employee.setEmpPwd(rs.getString(5));

				return employee;

			}
		});

	}

	public List<Employee> getAllEmployees() {
		return jt.query("select * from employee_tab", new RowMapper<Employee>() {
			public Employee mapRow(ResultSet rs, int row) throws SQLException {
				Employee employee = new Employee();
				employee.setEmpId(rs.getInt(1));
				employee.setEmpDesg(rs.getString(2));
				employee.setEmpMail(rs.getString(3));
				employee.setEmpName(rs.getString(4));
				employee.setEmpPwd(rs.getString(5));
				return employee;
			}
		});

	}

	@Override
	public Employee getEmpByEmail(String usermail) {
		System.out.println();

		String sql = "select * from employee_tab where mail=?";
		Employee e = jt.queryForObject(sql, new Object[] { usermail }, new RowMapper<Employee>() {
			public Employee mapRow(ResultSet rs, int row) throws SQLException {
				Employee employee = new Employee();
				employee.setEmpId(rs.getInt(1));
				employee.setEmpDesg(rs.getString(2));
				employee.setEmpMail(rs.getString(3));
				employee.setEmpName(rs.getString(4));
				employee.setEmpPwd(rs.getString(5));
				// employee.setRoles(rs.getString(6));
				return employee;

			}
		});
		return e;
	}

	/*
	 * @Override public boolean isEmailExists(String email) { String sql =
	 * "SELECT count(*) FROM employee_tab WHERE mail = ?"; boolean result = false;
	 * 
	 * 
	 * 
	 * System.out.println(jt); System.out.println("hhh");
	 * 
	 * int count = jt.queryForObject(sql, Integer.class, email); if (count > 0) {
	 * result = true; } System.out.println("after"); return result;
	 * 
	 * }
	 */
	@Override
	/*
	 * @Override public boolean checking(String mail, String pass) {
	 * 
	 * boolean decision = false;
	 * 
	 * String sql = "select COUNT(*) from employee_tab where mail=? and password=?";
	 * System.out.println(sql + " -->>>query"); int count = jt.queryForObject(sql,
	 * new Object[] { mail, pass }, Integer.class); if (count > 0) { decision =
	 * true; } System.out.println(count + " -->>>count"); return decision; }
	 */
	public boolean isEmailExists(String email) {
		String sql = "SELECT * FROM employee_tab WHERE mail = ?";
		boolean result = false;
		PreparedStatement st = null;

		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/dbname", "root", "root");
			st = con.prepareStatement(sql);
			st.setString(1, email);
			ResultSet rs = st.executeQuery();
			while (rs.next())
				result = true;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return result;

	}

	@Override
	public boolean checking(String mail, String pass) {

		boolean decision = false;
		PreparedStatement st = null;

		String sql = "select mail,password from employee_tab where mail=? and password=?";

		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/dbname", "root", "root");
			st = con.prepareStatement(sql);
			st.setString(1, mail);
			st.setString(2, pass);
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				decision = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return decision;
	}

	public int saveEmp1(Employee e) throws Exception {
		String sql = "insert into employee_tab(designation,mail,names,password) values(?,?,?,?)";
		String sql2 = "insert into employee_roles(mail,roles) values(?,?)";
		System.out.println(e.getEmpDesg());
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/dbname", "root", "root");
		PreparedStatement st = con.prepareStatement(sql);
		PreparedStatement st1 = con.prepareStatement(sql2);
		st.setString(1, e.getEmpDesg());
		st.setString(2, e.getEmpMail());
		st.setString(3, e.getEmpName());
		st.setString(4, e.getEmpPwd());
		st1.setString(1,e.getEmpMail());
		st1.setString(2,e.getRoles());
		 st.executeUpdate();
		 return st1.executeUpdate();

	}

	static String myConnectionURL = "jdbc:mysql://localhost:3306/dbname";

	public static int deleteJdbc(int id) throws SQLException {
		String sql = "delete from employee_tab where id=" + id + "";
		System.out.println(id);
		try (Connection con = DriverManager.getConnection(myConnectionURL, "root", "root");
				PreparedStatement pstmt = con.prepareStatement(sql)) {
			return pstmt.executeUpdate();
		}

	}
	
	
	
}
