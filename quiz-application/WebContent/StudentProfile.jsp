<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@include file="includes/StudentHeader.jsp" %>
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
	request.getAttribute("student");
%>
<script src="javascripts/studentProfile.js" type="text/javascript"></script>	
</head>
<body onload = "setSelectedGender(document.getElementById('gender'),&quot;${student.getGender()}&quot;)">
	<div class="jumbotron jumbotron-fluid">
	  <div class="container">
	    <h1 class="display-4">Welcome! ${student.getFname()}</h1>
	    <p class="lead">Given are your profile details. You can edit your details here.</p>
	  </div>
	</div>
	
	<div class="container">
		<form name="ProfileForm" action="" method="post">
		  <h5>Student details</h5>
		  <hr>	
		  <div class="form-group">
		    <label for="id">Student ID</label>
		    <input type="text" class="form-control" id="id" placeholder="Student ID" value="${student.getId()}" name="id" readonly>
		  </div>
		  <div class="form-group">
		    <label for="fname">First Name</label>
		    <input type="text" class="form-control" id="fname" placeholder="First Name" value="${student.getFname()}" name="fname" readonly>
		  </div>
		  <div class="form-group">
		    <label for="lname">Last Name</label>
		    <input type="text" class="form-control" id="lname" placeholder="Last Name" value="${student.getLname()}" name ="lname" readonly>
		  </div>
		  <div class="form-group">
		    <label for="gender">Gender</label>
		    <select class="form-control" id="gender" name="gender">
		      <option value="Male">Male</option>
		      <option value="Female">Female</option>
		      <option value="Others">Others</option>
		    </select>
		  </div>
		  <div class="form-group">
		    <label for="dob">Date of birth (mm-dd-yyyy)</label>
		    <input type="date" class="form-control" id="dob" value="${student.getDob()}" name ="dob">
		  </div>
		  <div class="form-group">
		    <label for="mobile">Mobile</label>
		    <input type="text" class="form-control" id="mobile" placeholder="Mobile" name="mobile" value="${student.getMobile()}" pattern="[789][0-9]{9}">
		  </div>
		  <div class="form-group">
		    <label for="email">Email</label>
		    <input type="text" class="form-control" id="email" placeholder="Email" name="email" value="${student.getEmail()}" pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,}$">
		  </div>
		  
	  	  <h5>Change Password</h5>
	  	  <hr>
		  <div class="form-group">
		    <label for="currPassword">Current Password</label>
		    <input type="password" class="form-control" id="currPassword" name="currPassword" placeholder="Current Password">
		  </div>
		  <div class="form-group">
		    <label for="newPassword">New Password</label>
		    <input type="password" class="form-control" id="newPassword" name="newPassword" placeholder="New Password">
		  </div>
		   <div class="form-group">
		    <label for="confPassword">Confirm Password</label>
		    <input type="password" class="form-control" id="confPassword" name="confPassword" placeholder="Confirm Password">
		  </div>
		  <button type="submit" class="btn btn-outline-primary" onclick="return validPass('${student.getPassword()}')" name="submit" value="update">Submit</button>&nbsp;&nbsp;
		  <button type="reset" class="btn btn-outline-primary">Reset</button>
		</form>
	</div>
	
</body>
<%@include file="includes/Footer.jsp" %>
</html>