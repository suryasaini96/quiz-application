<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@include file="includes/Header.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Register as Professor</title>
<link href="css/RegisterPage.css" rel="stylesheet" type="text/css">
<script src = "javascripts/professorRegistration.js" type="text/javascript"></script>
</head>
<body>
	<div class="registerDiv">
		<form name="ProfRegisterForm" action="ProfessorController" method="post">
			<h2 style="color: white">Register Here as Professor</h2>
			<br>
			<table>
				<tr>
					<td>ID</td>
					<td><input type="number" name="id" class="form-control"></td>
				</tr>
				<tr>
					<td>Department</td>
					<td><select  name="dept" class="form-control" >
			                <option selected="selected" value="default">Select your department</option>
			                <option value="cse">Computer Science (CSE)</option>
			                <option value="it">Information Technology (IT)</option>
			                <option value="ece">Electronics and Communication (ECE)</option>
			                <option value="me">Mechanical (ME)</option>
			                <option value="eee">Electrical and Electronics (EEE)</option>
			                <option value="ce">Civil (CE)</option>
		                </select>
    				</td>
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
					<td>Qualification</td>
					<td><select  name="qualification" class="form-control" >
			                <option selected="selected" value="default">Select your qualification</option>
			                <option value="pg">Post Graduate (PG)</option>
			                <option value="phd">PhD: Doctor of Philosophy</option>
		                </select>
    				</td>
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