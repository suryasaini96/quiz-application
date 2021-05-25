<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="includes/ProfessorHeader.jsp" %>
<%@page import="com.wipro.quiz.bean.TopicsBean"%>
<%@page import="java.util.*"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="css/Home.css" rel="stylesheet" type="text/css">
<link href="css/AddQuestion.css" rel="stylesheet" type="text/css">
<title>Select Topic</title>
<style type="text/css" media="screen">
@media ( min-width : 1200px) {
	.container {
		max-width: 400px;
	}
}
</style>

<%
	List<TopicsBean> topics = (ArrayList<TopicsBean>) request.getAttribute("topics");
	String redirectTo = (String) request.getAttribute("redirectTo");
%>	

<script type="text/javascript">

	function selectAction(){
		var redirectTo = document.selectTopicForm.submit.value;
		var listOfTopics = document.getElementById('topic');
		var sb;
		for(var i=0; i<listOfTopics.options.length; i++ ) {
	        if (listOfTopics.options[i].selected == true ) {
	        	sb = listOfTopics.options[i].value;
	        }
	    }
		if(redirectTo == "viewQues"){
			document.selectTopicForm.action = "ProfessorController";
			
		}
		else if(redirectTo == "viewProgress"){
			document.selectTopicForm.action = "StudentController?sid="+<%=id%>+"&sb="+sb;
		}	
	}
	
</script>

</head>
<body>
	<br><br><br>
	<div class="container">
		<center>
			<h1>View Questions</h1>
		</center>
		<form action="ProfessorController" name="selectTopicForm" method="post">
			<div class="form-group">
				<label for="topic">Select a topic to view questions</label> 
				<select class="form-control" id="topic" name="topic">
					<c:forEach items="${topics}" var="topic">
						<option value="${topic.getTopicName()}">${topic.getTopicName()}</option>
					</c:forEach>
				</select>
			</div>
			<button type="submit" class="btn btn-outline-primary" name="submit" value="viewQues">Submit</button> &nbsp;&nbsp;
		</form>
	</div>
</body>
<%@ include file="includes/Footer.jsp"%>
</html>