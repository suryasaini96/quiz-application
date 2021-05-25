<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@include file="includes/Header.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login page</title>
	<style type="text/css" media="screen">
			@media (min-width: 1200px) {
			    .container{
			        max-width: 400px;
			    }
			}		
	</style>
<script src="javascripts/login.js" type="text/javascript"></script>	
</head>

<body>
	<br><br>
	<div class="container">
		<form name="LoginForm" action="" method="post">
			<h3>Login</h3>
			<hr>
		  <div class="form-group">
		    <label for="userID">User ID</label>
		    <input type="text" class="form-control" id="userID" name="id" onchange ="selectLoginTypeOnUserID()" placeholder="UserID">
		  </div>
		  <div class="form-group">
		    <label for="password">Password</label>
		    <input type="password" class="form-control" id="password" name="password" placeholder="Password">
		  </div>
		  <div>
		  	<label for="loginType">Login as</label>
		  	<select class="custom-select" id="loginType" name="loginType">
			  <option value="student" selected>Student</option>
			  <option value="professor">Professor</option>
		  	</select>
		  </div><br>
		  <button type="submit" class="btn btn-primary" onclick = "return validate()" name="submit" value="login">Login</button>&nbsp;&nbsp;
		  <button type="reset" class="btn btn-primary">Reset</button>
		  <a class="float-right" href="ForgotPassword.jsp">Forgot Password?</a>
		</form>
	</div><br>
<%@include file="includes/Footer.jsp" %>
</body>


</html>