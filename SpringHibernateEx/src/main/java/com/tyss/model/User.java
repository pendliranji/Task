package com.tyss.model;

import java.util.Set;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "user_tab")
public class User {
	@Id
	@Column(name = "uid")
	@GeneratedValue(generator = "ugen")
	@GenericGenerator(name = "ugen", strategy = "increment")
	private int userId;

	@Column(name = "uname")
	private String userName;
	@Column(name = "uemail")
	private String userEmail;
	@Column(name = "upwd")
	private String userPwd;
	@ElementCollection
	@CollectionTable(name = "usr_roles_tab", joinColumns = @JoinColumn(name = "uid"))
	@Column(name = "roles")
	private Set<String> roles;

	public User() {
		super();
	}

	public User(int userId, String userName, String userEmail, String userPwd, Set<String> roles) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.userEmail = userEmail;
		this.userPwd = userPwd;
		this.roles = roles;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getUserPwd() {
		return userPwd;
	}

	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}

	public Set<String> getRoles() {
		return roles;
	}

	public void setRoles(Set<String> roles) {
		this.roles = roles;
	}

}
