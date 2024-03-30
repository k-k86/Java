package com.java_project.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * 顧客情報に関するDTOクラス
 */
public class Customer implements Serializable {

	private static final long serialBersionUID = 1L;
	public static final String TABLE = "CUSTOMER_LIST_TESTER";
	
	private Integer customer_id;
	private String customer_name;
	private String customer_name_kana;
	private Integer customer_sex;
	private LocalDate customer_birth_date;
	private String customer_address;
	private String customer_tell;
	private String cusotmer_mail;
	private LocalDate cusotmer_reg_date;
	
	public Integer getCustomer_id() {
		return customer_id;
	}
	
	public void setCustomer_id(Integer customer_id) {
		this.customer_id = customer_id;
	}
	
	public String getCustomer_name() {
		return customer_name;
	}
	
	public void setCustomer_name(String customer_name) {
		this.customer_name = customer_name;
	}
	
	public String getCustomer_name_kana() {
		return customer_name_kana;
	}
	
	public void setCustomer_name_kana(String customer_name_kana) {
		this.customer_name_kana = customer_name_kana;
	}
	
	public Integer getCustomer_sex() {
		return customer_sex;
	}
	
	public void setCustomer_sex(Integer customer_sex) {
		this.customer_sex = customer_sex;
	}
	
	public LocalDate getCustomer_birth_date() {
		return customer_birth_date;
	}
	
	public void setCustomer_birth_date(LocalDate customer_birth_date) {
		this.customer_birth_date = customer_birth_date;
	}
	
	public String getCustomer_address() {
		return customer_address;
	}
	
	public void setCustomer_address(String customer_address) {
		this.customer_address = customer_address;
	}
	
	public String getCustomer_tell() {
		return customer_tell;
	}
	
	public void setCustomer_tell(String customer_tell) {
		this.customer_tell = customer_tell;
	}
	
	public String getCusotmer_mail() {
		return cusotmer_mail;
	}
	
	public void setCustomer_mail(String cusotmer_mail) {
		this.cusotmer_mail = cusotmer_mail;
	}
	
	public LocalDate getCustomer_reg_date() {
		return cusotmer_reg_date;
	}
	
	public void setCustomer_reg_date(LocalDate cusotmer_reg_date) {
		this.cusotmer_reg_date = cusotmer_reg_date;
	}
	
	
	public String getNotNullCheck(String nullCheck) {
		
		if(nullCheck == null) {
			return "";
		}
		
		return nullCheck;
	}
	
	public String getDateFormat(LocalDate date) {
		
		String formatDate = "";
		String format = "yyyy年MM月dd日";
		
		if(date == null) {
			return formatDate;
		}
		
		formatDate = date.format(DateTimeFormatter.ofPattern(format));
		return formatDate;
	}
	
	
	
}
