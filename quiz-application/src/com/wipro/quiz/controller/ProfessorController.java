package com.wipro.quiz.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.wipro.quiz.bean.*;
import com.wipro.quiz.service.Service;

/**
 * Servlet implementation class ProfessorController
 */
public class ProfessorController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String buttonTrigger = request.getParameter("submit");
		PrintWriter out = response.getWriter();
		
		if(buttonTrigger.equals("login")) {
			
			int id = Integer.parseInt(request.getParameter("id"));
			String password = request.getParameter("password");
			

			Service service = new Service();
			ProfessorBean beanObj = service.loginUserProfessor(id,password);

			if(beanObj!= null) {
				
				HttpSession session = request.getSession();
				session.setAttribute("id", id);
				response.sendRedirect("ProfessorHome.jsp");
			}
			else {
				out.println("<Script  type=\"text/javascript\">");
				out.println("alert('Invalid UserID or Password');");
				out.println("location='Login.jsp';");
				out.println("</script>");
			}
		}
		
		if(buttonTrigger.equals("register")) {
			
			int id = Integer.parseInt(request.getParameter("id"));
			String dept = request.getParameter("dept");
			String fname = request.getParameter("fname");
			String lname = request.getParameter("lname");
			String gender = request.getParameter("gender");
			Date dob = Date.valueOf(request.getParameter("dob"));
			String qualification = request.getParameter("qualification");
			long mobile = Long.parseLong(request.getParameter("mobile"));
			String email = request.getParameter("email");
			String password = request.getParameter("password");
		
			Service service = new Service();
			int rowsInserted = service.registerProfessor(id, dept, fname, lname, gender, dob, qualification, mobile,  email, password);

			if(rowsInserted>0) {
				response.sendRedirect("Login.jsp");
			}
			else {
				out.println("<Script  type=\"text/javascript\">");
				out.println("alert('Registration failed');");
				out.println("location='ProfessorRegistration.jsp';");
				out.println("</script>");

			}
		}
		
		if(buttonTrigger.equals("update")) {
			int id = Integer.parseInt(request.getParameter("id"));
			String dept = request.getParameter("dept");
			String gender = request.getParameter("gender");
			Date dob = Date.valueOf(request.getParameter("dob"));
			String qualification = request.getParameter("qualification");
			long mobile = Long.parseLong(request.getParameter("mobile"));
			String email = request.getParameter("email");
			String newPassword = request.getParameter("newPassword");
			
			Service service = new Service();
			int rowsAffected=0;
			if (newPassword.length()>0) {
				rowsAffected = service.professorProfileUpdate(id, dept, gender, dob, qualification, mobile, email, newPassword);
			}
			else {
				rowsAffected = service.professorProfileUpdate(id, dept, gender, dob, qualification, mobile, email);
			}

			if(rowsAffected>0) {
				ProfessorBean updatedData = new ProfessorBean();
				updatedData = service.professorProfile(id);
				if(updatedData!=null) {
					request.setAttribute("professor", updatedData);
					request.getRequestDispatcher("/ProfessorProfile.jsp").forward(request, response);
				}
				else {
					out.print("DAO Failed");
				}
			}
			else {
				out.print("No rows affected!");
			}
		}
		
		if(buttonTrigger.equals("addTopic")) {
			
			String topic = request.getParameter("topicName");
		
			Service service = new Service();
			service.createTopic(topic);

			out.println("<Script  type=\"text/javascript\">");
			out.println("alert('Topic created.');");
			out.println("location='ProfessorController?param=viewTopics';");
			out.println("</script>");
		}
		
		if(buttonTrigger.equals("deleteTopic")) {
			
			String topic = request.getParameter("topic");
		
			Service service = new Service();
			int rowsDeleted = service.deleteTopic(topic);
			
			if(rowsDeleted>0) {
				response.sendRedirect("ViewTopics.jsp");
			}
			else {
				out.println("<Script  type=\"text/javascript\">");
				out.println("alert('Topic deletion failed');");
				out.println("location='ViewTopics.jsp';");
				out.println("</script>");
			}
		}
		
		if(buttonTrigger.equals("addQues")) {
			
			String topic = request.getParameter("topic");
			int quesid = Integer.parseInt(request.getParameter("quesid"));
			String ques = request.getParameter("ques");
			String op1 = request.getParameter("op1");
			String op2 = request.getParameter("op2");
			String op3 = request.getParameter("op3");
			String op4 = request.getParameter("op4");
			String ans = request.getParameter("ans");
		
			Service service = new Service();
			int rowsInserted = service.addQues(topic, quesid, ques, op1, op2, op3, op4, ans);
			
			if(rowsInserted>0) {
				out.println("<Script  type=\"text/javascript\">");
				out.println("alert('Question added!');");
				out.println("location='ProfessorController?param=addQues';");
				out.println("</script>");
			}
			else {
				out.println("<Script  type=\"text/javascript\">");
				out.println("alert('Adding question failed. Question ID already exists.');");
				out.println("location='ProfessorController?param=addQues';");
				out.println("</script>");
			}
		}
		
		if(buttonTrigger.equals("editQues")) {
			
			String topic = request.getParameter("topics");
			int quesid = Integer.parseInt(request.getParameter("quesid"));
			String ques = request.getParameter("ques");
			String op1 = request.getParameter("op1");
			String op2 = request.getParameter("op2");
			String op3 = request.getParameter("op3");
			String op4 = request.getParameter("op4");
			String ans = request.getParameter("ans");
		
			Service service = new Service();
			int rowsUpdated = service.editQues(topic, quesid, ques, op1, op2, op3, op4, ans);
			
			if(rowsUpdated>0) {
				//out.println("<Script  type=\"text/javascript\">");
				//out.println("alert('Question updated!');");
				//out.println("location='ProfessorController?editQues="+topic+"&quesID="+quesid+"';");
				//out.println("</script>");
		
				request.setAttribute("topic", topic);
				request.setAttribute("listOfQues", service.getQuesList(topic));
				request.getRequestDispatcher("/ViewQuestions.jsp").forward(request, response);
				
			}
			else {
				out.println("<Script  type=\"text/javascript\">");
				out.println("alert('Editing question failed');");
				out.println("location='ProfessorController?editQues=true';");
				out.println("</script>");
			}
		}
		
		if(buttonTrigger.equals("viewQues")) {
			String topic = request.getParameter("topic");		
			Service service = new Service();
			request.setAttribute("topic", topic);
			request.setAttribute("listOfQues", service.getQuesList(topic));
			request.getRequestDispatcher("/ViewQuestions.jsp").forward(request, response);
		}

		if(buttonTrigger.equals("deleteQues")) {
			
			String topic = request.getParameter("topic");
			int id = Integer.parseInt(request.getParameter("ques"));
		
			Service service = new Service();
			int rowsDeleted = service.deleteQues(topic, id);
			
			if(rowsDeleted>0) {
				out.println("<Script  type=\"text/javascript\">");
				out.println("alert('Question deleted!');");
				out.println("location='EditQuestion.jsp';");
				out.println("</script>");
			}
			else {
				out.println("<Script  type=\"text/javascript\">");
				out.println("alert('Adding question failed');");
				out.println("location='EditQuestion.jsp';");
				out.println("</script>");
			}
		}
		
		if(buttonTrigger.equals("forgotPass")) {
			Service service = new Service();
			int id = Integer.parseInt(request.getParameter("id"));
			String pass = request.getParameter("password");
			
			int rowsUpdated = service.forgotPass(id, pass, "professor");
			
			if (rowsUpdated>0) { //if DAO request is true
				out.println("<Script  type=\"text/javascript\">");
				out.println("alert('Password updated successfully!');");
				out.println("location='Login.jsp';");
				out.println("</script>");
			}
			else {
				out.println("<Script  type=\"text/javascript\">");
				out.println("alert('Password updation failed!');");
				out.println("location='ForgotPassword.jsp';");
				out.println("</script>");
			}
		}
		
		if(buttonTrigger.equals("searchStu")) {
			Service service = new Service();
			int stuid = Integer.parseInt(request.getParameter("stuid"));
			HashMap<String,Integer> noOfAttempts = new HashMap<String,Integer>();
			List<ResultBean> listOfTests = new ArrayList<ResultBean>();
			List<TopicsBean> topics = new ArrayList<TopicsBean>();
			
			listOfTests = service.studentHistory(stuid);			
			topics = service.getTopics();
			Iterator<TopicsBean> itrTopics = topics.iterator();
			
			if(listOfTests.size()>0) { //if result history exists
				int attemptCount=0;
				while(itrTopics.hasNext()) { // No. of attempts count
					TopicsBean topic = itrTopics.next();
					Iterator<ResultBean> itrTests = listOfTests.iterator();
					while(itrTests.hasNext()) {
						ResultBean resultObj = itrTests.next();
						if(resultObj.getTopic().equals(topic.getTopicName())){
							attemptCount++;	
						}
					}
					noOfAttempts.put(topic.getTopicName(), attemptCount);
					attemptCount=0;
				}			
				
				request.setAttribute("listOfTests", listOfTests);
				request.setAttribute("noOfAttempts", noOfAttempts);
				request.setAttribute("topics", topics);
				request.getRequestDispatcher("/TestHistory.jsp").forward(request, response);
			}

			else {
				out.println("<Script  type=\"text/javascript\">");
				out.println("alert('Student ID does not exist!');");
				out.println("location='ProfessorHome.jsp';");
				out.println("</script>");
			}
			
		}

	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		PrintWriter out = response.getWriter();
		//Connecting to service
		Service service = new Service();
		
		if(request.getParameter("param")!=null){ // VIEW TOPICS
			String param = request.getParameter("param");
			request.setAttribute("topics", service.getTopics());
			if (param.equals("viewTopics")) { //if DAO request is true
				request.getRequestDispatcher("/ViewTopics.jsp").forward(request, response);
			}
			else if (param.equals("selectTopic")) { //if DAO request is true
				request.getRequestDispatcher("/SelectTopic.jsp").forward(request, response);
			}
			else if (param.equals("addQues")) { //if DAO request is true
				request.getRequestDispatcher("/AddQuestion.jsp").forward(request, response);
			}
			else {
				out.print("DAO Failed");
			}
		}
		
		else if(request.getParameter("id")!=null) { //only for professor profile
			int id = Integer.parseInt(request.getParameter("id"));
			ProfessorBean beanObj = service.professorProfile(id);
			
			if (beanObj!=null) { //if DAO request is true
				request.setAttribute("professor", beanObj);
				request.getRequestDispatcher("/ProfessorProfile.jsp").forward(request, response);
			}
			else {
				out.print("DAO Failed");
			}	
		}
		
		else if(request.getParameter("deleteTopic")!=null) { // DELETE LINK ON VIEW TOPICS PAGE
			String topic = request.getParameter("deleteTopic");
			int rowsDeleted = service.deleteTopic(topic);
			
			if (rowsDeleted>0) { //if DAO request is true
				request.setAttribute("topics", service.getTopics());
				request.getRequestDispatcher("/ViewTopics.jsp").forward(request, response);
			}
			else {
				out.print("DAO Failed");
			}
		}

		else if(request.getParameter("quesID")!=null) {
			if(request.getParameter("deleteQues")!=null) {
				String topic = request.getParameter("deleteQues");
				int quesid = Integer.parseInt(request.getParameter("quesID"));
				int rowsDeleted = service.deleteQues(topic, quesid);
				
				if(rowsDeleted>0) {
					out.println("<Script  type=\"text/javascript\">");
					out.println("alert('Question deleted!');");
					request.setAttribute("listOfQues", service.getQuesList(topic));
					request.setAttribute("topic", topic);
					request.getRequestDispatcher("/ViewQuestions.jsp").forward(request, response);
				}
				else {
					out.print("DAO Failed");
				}

			}
			else if(request.getParameter("editQues")!=null) {
				String topic = request.getParameter("editQues").toLowerCase();
				int quesid = Integer.parseInt(request.getParameter("quesID"));
				
				request.setAttribute("quesBean", service.getQues(topic,quesid));
				request.setAttribute("topic", topic);
				request.setAttribute("topics", service.getTopics());
				request.getRequestDispatcher("/EditQuestion.jsp").forward(request, response);
			}
		
		}

	}
			
}

