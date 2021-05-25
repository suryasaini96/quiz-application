package com.wipro.quiz.bean;

import java.sql.Date;

public class ProfessorBean {
	private int id;
	private String dept;
	private String fname;
	private String lname;
	private String gender;
	private Date dob;
	private String qualification;
	private long mobile;
	private String email;
	private String password;
	
	public ProfessorBean() {
		super();
	}

	public ProfessorBean(int id, String dept, String fname, String lname, String gender, Date dob, String qualification,
			long mobile, String email, String password) {
		super();
		this.id = id;
		this.dept = dept;
		this.fname = fname;
		this.lname = lname;
		this.gender = gender;
		this.dob = dob;
		this.qualification = qualification;
		this.mobile = mobile;
		this.email = email;
		this.password = password;
	}
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDept() {
		return dept;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	public String getQualification() {
		return qualification;
	}
	public void setQualification(String qualification) {
		this.qualification = qualification;
	}
	public long getMobile() {
		return mobile;
	}
	public void setMobile(long mobile) {
		this.mobile = mobile;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
	

}
