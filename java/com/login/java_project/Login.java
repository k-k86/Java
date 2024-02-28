package com.login.java_project;

import java.io.Serializable;

public class Login implements Serializable  {
	
	private static final long serialBersionUID = 1L;
	public static final String TABLE = "ADMIN";
	
	static private String id;
	static private String password;
	static private boolean loginFlag;
	
	public String getId() {
		return id;
	}
	
	public String getPass() {
		return password;
	}
	
	public boolean getLoginFlag() {
		return loginFlag;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public void setPass(String password) {
		this.password = password;
	}
	
	public void setLoginFlag(boolean loginFlag) {
		this.loginFlag = loginFlag;
	}

}
