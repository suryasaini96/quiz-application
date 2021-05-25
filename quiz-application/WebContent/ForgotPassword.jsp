<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@include file="includes/Header.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Forget Password</title>
	<style type="text/css" media="screen">
			@media (min-width: 1200px) {
			    .container{
			        max-width: 400px;
			    }
			}		
	</style>

<script type="text/javascript">
	
	function validate() {
	   var userID = document.LoginForm.userID.value;
	   var password = document.LoginForm.password.value;
	   
	   /* To check a password between 6 to 20 characters 
	   which contain at least one numeric digit, one uppercase 
	   and one lowercase letter. */
	   var passwordRegex = /^(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{6,20}$/;
	   
	   if(userID.length==0) {
		   alert("Field cannot be empty!");
		   return false;
	   }
	   
	   else if(password.match(passwordRegex) && (userID>1000 && userID<3000 && userID!=2000)) {
		   selectLoginTypeController();
		   return true;
	   }
	   
	   alert('Wrong details.');
	   return false;
	}

	function selectLoginTypeController(){
		var loginType = document.getElementById('loginType').value;
		
		if(loginType == "student"){
			document.LoginForm.action = "StudentController";
		}
		else if(loginType == "professor"){
			document.LoginForm.action = "ProfessorController";
		}
		
	}
	
	function selectLoginTypeOnUserID(){
		var userID = document.LoginForm.userID.value;
		var loginType = document.getElementById('loginType');
		
		if(userID>1000 && userID <2000){
			   loginType.options[0].selected = true; //student loginType selected automatically
		}
		else if(userID>2000 && userID <3000){
			   loginType.options[1].selected = true; // professor loginType selected automatically
		}
	}
	
</script>



</head>
<body>
	<br><br>
	<div class="container">
		<form name="LoginForm" action="" method="post">
			<h3>Reset Password</h3>
			<hr>
		  <div class="form-group">
		    <label for="userID">User ID</label>
		    <input type="text" class="form-control" id="userID" name="id" onchange ="selectLoginTypeOnUserID()" placeholder="Enter UserID...">
		  </div>
		  <div>
		  <div class="form-group">
		    <label for="password">New password</label>
		    <input type="password" class="form-control" id="password" name="password" placeholder="New password...">
		  </div>
		  	<label for="loginType">User Type</label>
		  	<select class="custom-select" id="loginType" name="loginType">
			  <option value="student" selected>Student</option>
			  <option value="professor">Professor</option>
		  	</select>
		  </div><br>
		  <button type="submit" class="btn btn-primary" onclick = "return validate()" name="submit" value="forgotPass">Submit</button>&nbsp;&nbsp;
		  <button type="reset" class="btn btn-primary">Reset</button>
		</form>
	</div><br>	
<%@include file="includes/Footer.jsp" %>	
</body>
</html>