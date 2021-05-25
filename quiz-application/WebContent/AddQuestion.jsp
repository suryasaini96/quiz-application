<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ include file="includes/ProfessorHeader.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	<%@page import = "com.wipro.quiz.bean.TopicsBean" %>
    <%@page import = "java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="css/Home.css" rel="stylesheet" type="text/css">
<link href="css/AddQuestion.css" rel="stylesheet" type="text/css">
<title>Add Question</title>
<script src="javascripts/addQuestion.js" type="text/javascript"></script>

<% 
	List<TopicsBean> topics = (ArrayList<TopicsBean>) request.getAttribute("topics");
%>

</head>

<body>
	<br>
	<center>
		<h1>Add Question</h1>
	</center>
	<div class="container">
		<form name="AddQuesForm" action="ProfessorController" method="post">

			<div class="row">
				<div class="col-25">
					<label for="topic">Topic</label>
				</div>
				<div class="col-75">
					<select name="topic" id="topics">
						<c:forEach items="${topics}" var="topic">
			    		<option value="${topic.getTopicName()}">${topic.getTopicName()}</option>
					</c:forEach>	
					</select>
				</div>
			</div>

			<div class="row">
				<div class="col-25">
					<label for="quesid">Question ID</label>
				</div>
				<div class="col-75">
					<input type="text" name="quesid" placeholder="Question ID ...">
				</div>
			</div>

			<div class="row">
				<div class="col-25">
					<label for="ques">Question</label>
				</div>
				<div class="col-75">
					<textarea name="ques" placeholder="Type Question ..."
						style="height: 200px"></textarea>
				</div>
			</div>

			<div class="row">
				<div class="col-25">
					<label for="op1">Option 1</label>
				</div>
				<div class="col-75">
					<input type="text" name="op1" placeholder="Option 1">
				</div>
			</div>

			<div class="row">
				<div class="col-25">
					<label for="op2">Option 2</label>
				</div>
				<div class="col-75">
					<input type="text" name="op2" placeholder="Option 2">
				</div>
			</div>

			<div class="row">
				<div class="col-25">
					<label for="op3">Option 3</label>
				</div>
				<div class="col-75">
					<input type="text" name="op3" placeholder="Option 3">
				</div>
			</div>

			<div class="row">
				<div class="col-25">
					<label for="op4">Option 4</label>
				</div>
				<div class="col-75">
					<input type="text" name="op4" placeholder="Option 4">
				</div>
			</div>

			<div class="row">
				<div class="col-25">
					<label for="ans">Answer Option</label>
				</div>
				<div class="col-75">
					<select name="ans">
						<option value="op1">Option 1</option>
						<option value="op2">Option 2</option>
						<option value="op3">Option 3</option>
						<option value="op4">Option 4</option>
					</select>
				</div>
			</div>

			<div class="row">
				<div class="col-25"></div>
				<div class="col-75">
					<button type="submit" class="btn btn-outline-success" name="submit" value="addQues" onclick="return addQuesValidate()">Add</button>&nbsp;&nbsp;&nbsp;
					<button type="reset" class="btn btn-outline-success" name="reset" value="Reset">Reset</button>
				</div>
			</div>
			<br>
			<br>
			<br>

		</form>
	</div>

</body>
<%@ include file="includes/Footer.jsp"%>

</html>