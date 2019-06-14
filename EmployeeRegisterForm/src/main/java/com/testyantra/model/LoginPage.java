package com.testyantra.model;

public class LoginPage {

	private String userName;
	private String userPwd;
	public LoginPage() {
		super();
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserPwd() {
		return userPwd;
	}
	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}
	@Override
	public String toString() {
		return "LoginPage [userName=" + userName + ", userPwd=" + userPwd + "]";
	}


}
