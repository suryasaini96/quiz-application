<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@include file="includes/Header.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Register as Student</title>
<link href="css/RegisterPage.css" rel="stylesheet" type="text/css">
<script src = "javascripts/studentRegistration.js" type="text/javascript"></script>
</head>
<body>
	<div class="registerDiv">
		<form name="StuRegisterForm" action="StudentController" method="post">
			<h2 style="color: white">Register Here As Student</h2>
			<br>
			<table>
				<tr>
					<td>ID</td>
					<td><input type="number" name="id" class="form-control"></td>
				</tr>
				<tr>
					<td>First Name</td>
					<td><input type="text" name="fname" class="form-control"></td>
				</tr>
				<tr>
					<td>Last Name</td>
					<td><input type="text" name="lname" class="form-control"></td>
				</tr>
				<tr>
					<td>Gender</td>
					<td><input type="radio" name="gender" value="Male">&nbsp;Male&nbsp;
						<input type="radio" name="gender" value="Female">&nbsp;Female&nbsp;
						<input type="radio" name="gender" value="Others">&nbsp;Others&nbsp;
					</td>
				</tr>
				<tr>
					<td>Date of Birth</td>
					<td><input type="date" id="date" name="dob" class="form-control" ></td>
				</tr>	
				<tr>
					<td>Mobile Number</td>
					<td><input type="number" name="mobile" maxlength="10" class="form-control"></td>
				</tr>
				<tr>
					<td>Email</td>
					<td><input type="email" name="email" class="form-control" ></td>
				</tr>
				<tr>
					<td>Password</td>
					<td><input type="password" name="password" class="form-control"></td>
				</tr>
				<tr>
					<td>Re-type Password</td>
					<td><input type="password" name="retypepassword"  class="form-control"></td>
				</tr>
			</table>
			<br>
			<div>
				
				<button type="submit" class="btn btn-primary" onclick = "return regValidate()" name="submit" value="register">Submit</button>&nbsp;&nbsp;
		  		<button type="reset" class="btn btn-primary">Reset</button>
			</div>
		</form>
	</div>
	<br>
	<br>
	<br>
</body>
<%@include file="includes/Footer.jsp"%>

</html>