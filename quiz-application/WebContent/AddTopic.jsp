<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ include file="includes/ProfessorHeader.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
<link href="css/Home.css" rel="stylesheet" type="text/css">
<link href="css/AddQuestion.css" rel="stylesheet" type="text/css">
<title>Add Topic</title>
<style type="text/css" media="screen">
@media ( min-width : 1200px) {
	.container {
		max-width: 600px;
	}
}
</style>
<script type="text/javascript">
	function addTopicValidate() {
		var top = document.addTopicForm.addtopic.value;
		if (top.length == 0) {
			alert("topic name cannot be empty");
			return false;
		}
		return true;
	}
</script>
</head>
<body>
	<br><br>
	<center>
		<h1>Add New Topic</h1>
	</center>
	<br>
	<div class="container">
		<form name="addTopicForm" action="ProfessorController" method="post">
			<div class="row">
				<div class="col-25">
					<label for="op1"> <b>New Topic Name </b></label>
				</div>
				<div class="col-75">
					<input type="text" name="topicName" placeholder="Topic name...">
				</div>
			</div>
			<div class="row">
				<div class="col-25"></div>
				<div class="col-75">
					<button type="submit" class="btn btn-outline-success" name="submit"
						value="addTopic" onclick="return addTopicValidate()">Add</button>
					&nbsp;&nbsp;&nbsp;
					<button type="reset" class="btn btn-outline-success" name="reset"
						value="Reset">Reset</button>
				</div>
			</div>
			<br> <br> <br>
		</form>
	</div>
	</br>
	</br>
	<br>

</body>
<%@ include file="includes/Footer.jsp"%>
</html>