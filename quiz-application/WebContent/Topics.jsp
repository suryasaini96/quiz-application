<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
	<%@include file="includes/StudentHeader.jsp" %>	
	<%@page import = "com.wipro.quiz.bean.TopicsBean" %>
    <%@page import = "java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Topics</title>
	<!--  <style type="text/css" media="screen">
		@media (min-width: 1200px) {
		    .container{
		        max-width: 600px;
		    }
		}	
	</style>-->
<%
	List<TopicsBean> topics = (ArrayList<TopicsBean>) request.getAttribute("topics");
%>

</head>
<body>
	<br>
	<div class="container">
		<c:forEach items="${topics}" var="topic" >
			<div class="row">  
			  <div class="col-sm-6">
			    <div class="card" style="width: 18rem;">
			      <div class="card-body">
			        <h5 class="card-title">${topic.getTopicName()}</h5>
			        <p class="card-text">Click below to take the ${topic.getTopicName()} test.</p>
			        <a href="StudentController?takeTest=${topic.getTopicName()}" class="btn btn-primary">Take test</a>
			      </div>
			    </div>
			  </div>
			 </div> 
		</c:forEach>	
	</div>
<%@include file="includes/Footer.jsp" %>	
</body>
</html>