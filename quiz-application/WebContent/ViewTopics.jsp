<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
    <%@include file="includes/ProfessorHeader.jsp" %>
    <%@page import = "com.wipro.quiz.bean.TopicsBean" %>
    <%@page import = "java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Profile</title>
	<style type="text/css" media="screen">
		@media (min-width: 1200px) {
		    .container{
		        max-width: 600px;
		    }
		}	
	</style>
<%
	List<TopicsBean> topics = (ArrayList<TopicsBean>) request.getAttribute("topics");
%>	
</head>
<body>
	<div class="jumbotron jumbotron-fluid">
	  <div class="container">
	    <h1 class="display-4">Welcome! ${id}</h1>
	    <p class="lead">You can view the topics here.</p>
	  </div>
	</div>
	
	<div class="container">
		<form name="ViewTopics" action="">
		  <h5>Topics List</h5>
		  <hr>	

		  
		  <ol>
			<c:forEach items="${topics}" var="topic">
				<li style="font-size:18px">${topic.getTopicName()}&nbsp; <a
					href="ProfessorController?deleteTopic=${topic.getTopicName()}">Delete</a>
				</li>
			</c:forEach>
		  </ol>
		</form>
	</div>
	
</body>
<%@include file="includes/Footer.jsp" %>
</html>