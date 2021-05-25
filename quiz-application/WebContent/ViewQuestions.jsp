<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
    <%@include file="includes/ProfessorHeader.jsp" %>
    <%@page import = "com.wipro.quiz.bean.QuestionsBean" %>
    <%@page import = "java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>View Questions</title>
<%
	List<QuestionsBean> listOfQues = (ArrayList<QuestionsBean>) request.getAttribute("listOfQues");
	request.getAttribute("topic");
%>	
</head>
<body>
	<table class="table table-striped">
	  <thead>
	    <tr>
	      <th scope="col">#</th>
	      <th scope="col">Question</th>
	      <th scope="col">Option 1</th>
	      <th scope="col">Option 2</th>
	      <th scope="col">Option 3</th>
	      <th scope="col">Option 4</th>
	      <th scope="col">Answer</th>
	      <th scope="col">Operation</th>
	    </tr>
	  </thead>
	  <tbody>
	  	<c:forEach items="${listOfQues}" var="quesBean">
			<tr>
		      <th scope="row">${quesBean.getQuesid()}</th>
		      <td><pre>${quesBean.getQues()}</pre></td>
		      <td>${quesBean.getOp1()}</td>
		      <td>${quesBean.getOp2()}</td>
		      <td>${quesBean.getOp3()}</td>
		      <td>${quesBean.getOp4()}</td>
		      <td>${quesBean.getAns()}</td>
		      <td><a href="ProfessorController?editQues=${topic}&quesID=${quesBean.getQuesid()}">Edit</a>&nbsp;&nbsp;&nbsp;
		      <a href="ProfessorController?deleteQues=${topic}&quesID=${quesBean.getQuesid()}">Delete</a>
		      </td>
		    </tr>
		</c:forEach>
	  </tbody>
	</table>
</body>
<%@include file="includes/Footer.jsp" %>
</html>