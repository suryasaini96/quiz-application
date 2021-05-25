<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
    <%@include file="includes/ProfessorHeader.jsp" %>
    <%@page import = "com.wipro.quiz.bean.ResultBean" %>
    <%@page import = "com.wipro.quiz.bean.TopicsBean" %>
    <%@page import = "java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>View Questions</title>
<%
	List<ResultBean> listOfTests = (ArrayList<ResultBean>) request.getAttribute("listOfTests");	
	HashMap<String,Integer> noOfAttempts = (HashMap<String,Integer>) request.getAttribute("noOfAttempts");
	List<TopicsBean> topics = (ArrayList<TopicsBean>) request.getAttribute("topics");
	
%>	
</head>
<body>
	<br>
	<div class="container">
		<h5 align="center"><u> Result History </u></h5><br>
		<table class="table table-striped">
		  <thead>
		    <tr>
		      <th scope="col">Student ID</th>
		      <th scope="col">Topic</th>
		      <th scope="col">Level 1 <br>(correct questions)<br></th>
		      <th scope="col">Level 2 <br>(correct questions)<br></th>
		      <th scope="col">Level 3 <br>(correct questions)<br></th>
		      <th scope="col">Time</th>
		    </tr>
		  </thead>
		  <tbody>
		  	<c:forEach items="${listOfTests}" var="listOfTests">
				<tr>
			      <th scope="row">${listOfTests.getStuid()}</th>
			      <td>${listOfTests.getTopic()}</td>
			      <td>${listOfTests.getLevel1()}</td>
			      <td>${listOfTests.getLevel2()}</td>
			      <td>${listOfTests.getLevel3()}</td>
			      <td>${listOfTests.getTime()}</td>
			    </tr>
			</c:forEach>
		  </tbody>
		</table>
	</div>
	<br>

	<div class="container">
		<h5 align="center"><u> Attempt Analysis </u></h5><br>
		<table class="table table-striped">
		  <thead>
		    <tr>
		      <th scope="col">Topic</th>
		      <th scope="col">No. of attempts</th>
		    </tr>
		  </thead>
		  <tbody>
		  	<c:forEach items="${topics}" var="topic">
				<tr>
			      <th scope="row">${topic.getTopicName()}</th>
			      <td>${noOfAttempts.get(topic.getTopicName())}</td>
			    </tr>
			</c:forEach>
		  </tbody>
		</table>
	</div>
	
</body>
<%@include file="includes/Footer.jsp" %>
</html>