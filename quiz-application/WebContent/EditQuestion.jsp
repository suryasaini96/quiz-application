<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ include file="includes/ProfessorHeader.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
    <%@page import = "com.wipro.quiz.bean.QuestionsBean" %>
    <%@page import = "com.wipro.quiz.bean.TopicsBean" %>
    <%@page import = "java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="css/Home.css" rel="stylesheet" type="text/css">
<link href="css/AddQuestion.css" rel="stylesheet" type="text/css">
<title>Edit Question</title>
<script src="javascripts/editQues.js" type="text/javascript"></script>

<%
	if(request.getAttribute("quesBean")!=null){
		QuestionsBean quesBean = new QuestionsBean();
		quesBean = (QuestionsBean)request.getAttribute("quesBean");
	}
	List<TopicsBean> topics = (ArrayList<TopicsBean>) request.getAttribute("topics");	
	request.getAttribute("topic");
%>

</head>
<body onload = "dropdownSelect(document.getElementById('topics'), &quot;${topic}&quot;, document.getElementById('ans'), &quot;${quesBean.getAns()}&quot;)" >
	<center>
		<h1>Edit Question</h1>
	</center>

	<div class="container">
		<form name="EditQuesForm" action="ProfessorController" method="post">
		
			<div class="row">
				<div class="col-25">
					<label for="topics">Topic</label>
				</div>
				<div class="col-75">
					<select name="topics" id="topics">
						<c:forEach items="${topics}" var="topics">
			    		<option value="${topics.getTopicName()}">${topics.getTopicName()}</option>
					</c:forEach>	
					</select>
				</div>
			</div>
			
			<div class="row">
				<div class="col-25">
					<label for="quesid">Question ID</label>
				</div>
				<div class="col-75">
					<input type="text" name="quesid" value="${quesBean.getQuesid()}" placeholder="Ques Id..">
				</div>
			</div>

			<div class="row">
				<div class="col-25">
					<label for="ques">Question</label>
				</div>
				<div class="col-75">
					<textarea name="ques" placeholder="Type Question ..." style="height: 200px">${quesBean.getQues()}</textarea>
				</div>
			</div>

			<div class="row">
				<div class="col-25">
					<label for="op1">Option 1</label>
				</div>
				<div class="col-75">
					<input type="text" name="op1" value="${quesBean.getOp1()}" placeholder="Option 1..">
				</div>
			</div>

			<div class="row">
				<div class="col-25">
					<label for="op2">Option 2</label>
				</div>
				<div class="col-75">
					<input type="text" name="op2" value="${quesBean.getOp2()}" placeholder="Option 2..">
				</div>
			</div>

			<div class="row">
				<div class="col-25">
					<label for="op3">Option 3</label>
				</div>
				<div class="col-75">
					<input type="text" name="op3" value="${quesBean.getOp3()}" placeholder="Option 3..">
				</div>
			</div>

			<div class="row">
				<div class="col-25">
					<label for="op4">Option 4</label>
				</div>
				<div class="col-75">
					<input type="text" name="op4" value="${quesBean.getOp4()}" placeholder="Option 4..">
				</div>
			</div>

			<div class="row">
				<div class="col-25">
					<label for="ans">Answer Option</label>
				</div>
				<div class="col-75">
					<select name="ans" id="ans">
						<option value="op1">Option 1</option>		
						<option value="op2">Option 2</option>
						<option value="op3">Option 3</option>
						<option value="op4">Option 4</option>	
					</select>
				</div>
			</div>
			
			<div class="row">
				<div class="col-25">
				</div>
				<div class="col-75">
					<button type="submit" class="btn btn-outline-success" name="submit" value="editQues" onclick="return editQuesValidate()">Edit</button>&nbsp;&nbsp;&nbsp;
					<button type="reset" class="btn btn-outline-success" name="reset" value="Reset">Reset</button>
				</div>
				<br> <br> <br>
			</div>
			
		</form>
	</div>

</body>
<%@ include file="includes/Footer.jsp"%>

</html>