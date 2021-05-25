package com.wipro.quiz.bean;

import java.sql.Date;

public class StudentBean {
	private int id;
	private String fname;
	private String lname;
	private String gender;
	private Date dob;
	private long mobile;
	private String email;
	private String password;
	
	public StudentBean() {
		super();
	}
	
	public StudentBean(int id, String fname, String lname, String gender, Date dob, long mobile, String email,
			String password) {
		super();
		this.id = id;
		this.fname = fname;
		this.lname = lname;
		this.gender = gender;
		this.dob = dob;
		this.mobile = mobile;
		this.email = email;
		this.password = password;
	}
	
	public int getId() {
		return id;
	}
	public String getFname() {
		return fname;
	}
	public String getLname() {
		return lname;
	}
	public String getGender() {
		return gender;
	}
	public Date getDob() {
		return dob;
	}
	public long getMobile() {
		return mobile;
	}
	public String getEmail() {
		return email;
	}
	public String getPassword() {
		return password;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public void setDob(Date date) {
		this.dob = date;
	}
	public void setMobile(long mobile) {
		this.mobile = mobile;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
	
	

}
