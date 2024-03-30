package com.java_project.model;

public class Admin {
	
	private String admin_reg_name;
	private String admin_reg_pass;
	private int admin_reg_level;
	
	public String getAdminRegName() {
		return admin_reg_name;
	}
	
	public String getAdminRegPassword() {
		return admin_reg_pass;
	}
	
	public int getAdminRegLevel() {
		return admin_reg_level;
	}
	
	public void setAdminRegName(String admin_reg_name) {
		this.admin_reg_name = admin_reg_name;
	}
	
	public void setAdminRegPassword(String admin_reg_pass) {
		this.admin_reg_pass = admin_reg_pass;
	}
	
	public void setAdminRegLevel(int admin_reg_level) {
		this.admin_reg_level = admin_reg_level;
	}

}
