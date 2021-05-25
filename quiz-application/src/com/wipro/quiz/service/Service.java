package com.wipro.quiz.service;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import com.wipro.quiz.bean.*;
import com.wipro.quiz.dao.DAO;

public class Service {
	
	List<TopicsBean> topics = new ArrayList<TopicsBean>();
	List<QuestionsBean> listOfQues = new ArrayList<QuestionsBean>();
	List<ResultBean> listOfTests = new ArrayList<ResultBean>();
	DAO daoObj = new DAO();
	
	/* ------------------- STUDENT ---------------------- */
	
	public StudentBean loginUserStudent(int id,String password) {
		   StudentBean beanObj = daoObj.loginUserStudent(id,password);
		   return beanObj;   
	}

	public StudentBean studentProfile(int id) {	
		StudentBean beanObj = daoObj.studentProfile(id);
		return beanObj;
	}
	
	public int studentProfileUpdate(int id, String gender, Date dob, long mobile, String email) {
		return daoObj.studentProfileUpdate(id, gender, dob, mobile, email);
	}
	
	public int studentProfileUpdate(int id, String gender, Date dob, long mobile, String email, String newPassword) {
		return daoObj.studentProfileUpdate(id, gender, dob, mobile, email, newPassword);
	}
	
	public int registerStudent(int id, String fname, String lname, String gender, Date dob, long mobile, String email, String password) {
		return daoObj.registerStudent(id, fname, lname, gender, dob, mobile,  email, password);
	}
	
	public int answerValidate(String topic, int quesID, String ans) {
		return daoObj.answerValidate(topic, quesID, ans);
	}
	
	public int storeResult(int stuID, String topic, int level1, int level2, int level3, String time) {
		return daoObj.storeResult(stuID, topic, level1, level2, level3, time);
	}
	
	public ResultBean studentProgress(int id, String topic) {
		ResultBean resultObj = daoObj.studentProgress(id, topic);
		return resultObj;
	}
	
	
    /* ------------------- PROFESSOR ---------------------- */
	
	public ProfessorBean loginUserProfessor(int id,String password) {
		   ProfessorBean beanObj = daoObj.loginUserProfessor(id,password);
		   return beanObj;	   
	}
	
	public ProfessorBean professorProfile(int id) {
		ProfessorBean beanObj = daoObj.professorProfile(id);
		return beanObj;
	}
	
	public int registerProfessor(int id, String dept, String fname, String lname, String gender, Date dob, String qualification, long mobile, String email, String password) {
		return daoObj.registerProfessor(id, dept, fname, lname, gender, dob,qualification, mobile,  email, password);
	}
	
	public int professorProfileUpdate(int id, String dept, String gender, Date dob, String qualification, long mobile, String email) {
		return daoObj.professorProfileUpdate(id, dept, gender, dob, qualification, mobile, email);
	}
	
	public int professorProfileUpdate(int id, String dept, String gender, Date dob, String qualification, long mobile, String email, String newPassword) {
		return daoObj.professorProfileUpdate(id, dept, gender, dob, qualification, mobile, email, newPassword);
	}
	
	public void createTopic(String topic) {
		daoObj.createTopic(topic);
	}
	
	public List<TopicsBean> getTopics() {		
		topics.addAll(daoObj.getTopics());
		return topics;
	}
	
	public int deleteTopic(String topic) {
		return daoObj.deleteTopic(topic);
	}
	
	public int addQues(String topic, int quesid, String ques, String op1, String op2, String op3, String op4, String ans) {
		return daoObj.addQues(topic, quesid, ques, op1, op2, op3, op4, ans);
	}
	
	public int editQues(String topic, int quesid, String ques, String op1, String op2, String op3, String op4, String ans) {
		return daoObj.editQues(topic, quesid, ques, op1, op2, op3, op4, ans);
	}
	
	public List<QuestionsBean> getQuesList(String topic) {		
		listOfQues.addAll(daoObj.getQuesList(topic));
		return listOfQues;
	}
	
	public QuestionsBean getQues(String topic, int quesid) {
		return daoObj.getQues(topic, quesid);
	}
	
	public int deleteQues(String topic, int quesid) {
		return daoObj.deleteQues(topic, quesid);
	}
	
	public List<ResultBean> studentHistory(int id) {
		listOfTests.addAll(daoObj.studentHistory(id));
		return listOfTests;
	}
	
	
	/*----------------------------------*/
	
	/*        Forgot Password         */
	
	public int forgotPass(int id, String pass, String loginType) {
		return daoObj.forgotPass(id, pass, loginType);
	}
	
	
}
