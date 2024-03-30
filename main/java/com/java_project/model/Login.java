package com.java_project.model;

import java.io.Serializable;

public class Login implements Serializable  {
	
	private static final long serialBersionUID = 1L;
	public static final String TABLE = "ADMIN_USER";
	
	static private String id;
	static private String password;
	static private int admin_level;
	static private boolean loginFlag;
	
	public String getId() {
		return id;
	}
	
	public String getPass() {
		return password;
	}
	
	public int getLevel() {
		return admin_level;
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
	
	public void setLevel(int admin_level) {
		this.admin_level = admin_level;
		
	}
	
	public void setLoginFlag(boolean loginFlag) {
		this.loginFlag = loginFlag;
	}

}
