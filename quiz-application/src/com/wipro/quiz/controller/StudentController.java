package com.wipro.quiz.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.wipro.quiz.bean.QuestionsBean;
import com.wipro.quiz.bean.ResultBean;
import com.wipro.quiz.bean.StudentBean;
import com.wipro.quiz.service.Service;

public class StudentController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	HashMap<Integer, String> answerKey = new HashMap<Integer, String>();

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String buttonTrigger = request.getParameter("submit");
		PrintWriter out = response.getWriter();
		
		if(buttonTrigger.equals("login")) {
			
			int id = Integer.parseInt(request.getParameter("id"));
			String password = request.getParameter("password");

			Service service = new Service();
			StudentBean beanObj = service.loginUserStudent(id,password);

			if(beanObj!= null) {
				HttpSession session = request.getSession();
				session.setAttribute("id", id);
				response.sendRedirect("StudentHome.jsp");
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
			String fname = request.getParameter("fname");
			String lname = request.getParameter("lname");
			String gender = request.getParameter("gender");
			Date dob = Date.valueOf(request.getParameter("dob"));
			long mobile = Long.parseLong(request.getParameter("mobile"));
			String email = request.getParameter("email");
			String password = request.getParameter("password");
		
			Service service = new Service();
			int rowsInserted = service.registerStudent(id, fname, lname, gender, dob, mobile,  email, password);

			if(rowsInserted>0) {
				response.sendRedirect("Login.jsp");
			}
			else {
				out.println("<Script  type=\"text/javascript\">");
				out.println("alert('Registration failed');");
				out.println("location='StudentRegistration.jsp';");
				out.println("</script>");

			}
		}
		
		if(buttonTrigger.equals("update")) {
			int id = Integer.parseInt(request.getParameter("id"));
			String gender = request.getParameter("gender");
			Date dob = Date.valueOf(request.getParameter("dob"));
			long mobile = Long.parseLong(request.getParameter("mobile"));
			String email = request.getParameter("email");
			String newPassword = request.getParameter("newPassword");
			
			Service service = new Service();
			int rowsAffected=0;
			if (newPassword.length()>0) {
				rowsAffected = service.studentProfileUpdate(id, gender, dob, mobile, email, newPassword);
			}
			else {
				rowsAffected = service.studentProfileUpdate(id, gender, dob, mobile, email);
			}

			if(rowsAffected>0) {
				StudentBean updatedData = new StudentBean();
				updatedData = service.studentProfile(id);
				if(updatedData!=null) {
					request.setAttribute("student", updatedData);
					request.getRequestDispatcher("/StudentProfile.jsp").forward(request, response);
				}
				else {
					out.print("DAO Failed");
				}
			}
			else {
				out.print("No rows affected!");
			}
		}
				
		if(buttonTrigger.equals("nextQues")) {
			HttpSession session = request.getSession();
			Service service = new Service();
			
			QuestionsBean quesBean = (QuestionsBean) session.getAttribute("quesBean");
			String topic = (String) session.getAttribute("topic");
			String ans = request.getParameter("ans");
			int submitMin = Integer.parseInt(request.getParameter("min"));
			int submitSec = Integer.parseInt(request.getParameter("sec"));
			session.setAttribute("min", submitMin);
			session.setAttribute("sec", submitSec);
			
			answerKey = (HashMap<Integer, String>) session.getAttribute("answerKey");
			answerKey.put(quesBean.getQuesid(), ans);
			session.setAttribute("answerKey", answerKey);
			
			int nextQuesID = quesBean.getQuesid() + 1;
			if (nextQuesID>30) {
				nextQuesID = 30;
			}
			
			QuestionsBean nextQuesBean = service.getQues(topic, nextQuesID);
			if(nextQuesBean==null) {
				nextQuesBean = quesBean;
				nextQuesID = nextQuesID - 1;
			}
			session.setAttribute("quesBean", nextQuesBean);
			
			String selectedAns="";
			if(answerKey.containsKey(nextQuesID)){
				selectedAns = answerKey.get(nextQuesID);
			}
			session.setAttribute("selectedAns", selectedAns);
			response.sendRedirect("Assessment.jsp");
			
		}
		
		if(buttonTrigger.equals("prevQues")) {
			HttpSession session = request.getSession();
			Service service = new Service();
			
			QuestionsBean quesBean = (QuestionsBean) session.getAttribute("quesBean");
			String topic = (String) session.getAttribute("topic");
			String ans = request.getParameter("ans");
			int submitMin = Integer.parseInt(request.getParameter("min"));
			int submitSec = Integer.parseInt(request.getParameter("sec"));
			session.setAttribute("min", submitMin);
			session.setAttribute("sec", submitSec);
			
			int prevQuesID = quesBean.getQuesid() - 1;
			if (prevQuesID<1) {
				prevQuesID = 1;
			}
			
			QuestionsBean prevQuesBean = service.getQues(topic, prevQuesID);
			if(prevQuesBean==null) {
				prevQuesBean = quesBean;
				prevQuesID = prevQuesID + 1 ;
			}
			session.setAttribute("quesBean", prevQuesBean);
			
			answerKey = (HashMap<Integer, String>) session.getAttribute("answerKey");
			answerKey.put(quesBean.getQuesid(), ans);
			session.setAttribute("answerKey", answerKey);
			
			String selectedAns="";
			if(answerKey.containsKey(prevQuesID)){
				selectedAns = answerKey.get(prevQuesID);
			}
			session.setAttribute("selectedAns", selectedAns);
			response.sendRedirect("Assessment.jsp");
			
			
		}
		
		if(buttonTrigger.equals("finishTest")) {
			HttpSession session = request.getSession();
			Service service = new Service();
			
			String topic = (String) session.getAttribute("topic");
			int stuID = (Integer) session.getAttribute("id");
			
			DateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy hh:mm:ss aa");
			Calendar cal = Calendar.getInstance();
			String time = dateFormat.format(cal.getTime()); //16/11/2016 12:08:43 am
			System.out.println(time);

			Set<Integer> quesID = answerKey.keySet();
			Iterator<Integer> itr = quesID.iterator();
			int correctCountL1=0;
			int correctCountL2=0;
			int correctCountL3=0;
			while(itr.hasNext()) {
				int quesid = itr.next();
				int correct = service.answerValidate(topic, quesid , answerKey.get(quesid));
				if(quesid>=1 && quesid<=10) {
					if(correct==1) {
						correctCountL1++;
					}
				}
				else if(quesid>=11 && quesid<=20) {
					if(correct==1) {
						correctCountL2++;
					}
				}
				else if(quesid>=21 && quesid<=30) {
					if(correct==1) {
						correctCountL3++;
					}
				}
			}
			System.out.println(correctCountL1 + ", " + correctCountL2 + ", " + correctCountL3);
			
			service.storeResult(stuID, topic, correctCountL1, correctCountL2, correctCountL3, time);
			
			session.invalidate();
			answerKey = new HashMap<Integer, String>();
			
			session = request.getSession(); //new session
			session.setAttribute("id", stuID);
			
			int correctAns = correctCountL1 + correctCountL2 + correctCountL3;
			int wrongAns = 30 - correctAns;
			int totalMarks = correctCountL1*1 + correctCountL2*2 + correctCountL3*3;
			float percentage = ((float)totalMarks/50)*100;
			
			session.setAttribute("correctAns", correctAns);
			session.setAttribute("wrongAns", wrongAns);
			session.setAttribute("totalMarks", totalMarks);
			session.setAttribute("percentage", percentage);
			
			
			response.sendRedirect("AssessmentResult.jsp");
			
		}
		
		if(buttonTrigger.equals("viewProgress")) {
			HttpSession session = request.getSession();
			Service service = new Service();
			int id = (Integer) session.getAttribute("id");
			String topic = request.getParameter("topic");
			
			ResultBean resultObj = service.studentProgress(id,topic);
			
			if (resultObj!=null) { //if DAO request is true
				request.setAttribute("result", resultObj);
				request.getRequestDispatcher("/ProgressCard.jsp").forward(request, response);
			}
			else {
				out.println("<Script  type=\"text/javascript\">");
				out.println("alert('Assessment is not completed');");
				out.println("location='StudentHome.jsp';");
				out.println("</script>");
			}
		}
		
		if(buttonTrigger.equals("forgotPass")) {
			Service service = new Service();
			int id = Integer.parseInt(request.getParameter("id"));
			String pass = request.getParameter("password");
			
			int rowsUpdated = service.forgotPass(id,pass, "student");
			
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

	}
	
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		PrintWriter out = response.getWriter();
		//Connecting to service
		Service service = new Service();

		if(request.getParameter("id")!=null) {
		
			int id = Integer.parseInt(request.getParameter("id"));
			StudentBean beanObj = service.studentProfile(id);
			if (beanObj!=null) { //if DAO request is true
				request.setAttribute("student", beanObj);
				request.getRequestDispatcher("/StudentProfile.jsp").forward(request, response);
			}
			else {
				out.print("DAO Failed");
			}
		}
		
		else if (request.getParameter("param")!=null) {
			String param = request.getParameter("param");
			request.setAttribute("topics", service.getTopics());
			if(param.equals("viewTopics")) {
				request.getRequestDispatcher("/Topics.jsp").forward(request, response);
			}
			else if(param.equals("viewProgress")) {
				request.getRequestDispatcher("/StudentSelectTopic.jsp").forward(request, response);
			}
		}
		
		else if(request.getParameter("takeTest")!= null) {
				HttpSession session = request.getSession();
				String topic = request.getParameter("takeTest");
				session.setAttribute("topic", topic);
				session.setAttribute("quesBean", service.getQues(topic, 1));
				session.setAttribute("min", 29);
				session.setAttribute("sec", 60);
				session.setAttribute("answerKey", answerKey);
				response.sendRedirect("Assessment.jsp");
		}
		
	}

}


