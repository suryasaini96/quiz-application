<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@include file="includes/Header.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<script type="text/javascript">
	function regvalidate() {
		
		var pass = document.changepasswordForm.password.value;
		var newpass = document.changepasswordForm.newpassword.value;
		var rnewpass = document.changepasswordForm.rnewpassword.value;

		
		if (pass.length == 0 || newpass.length == 0 || rnewpass == 0 ) {
			alert("Please enter your password");
			return false;
		}

		if ((!(pass.length >= 8 && pass.length <= 12)) || (!(newpass.length >= 8 && newpass.length <= 12)) || (!(rnewpass.length >= 8 && rnewpass.length <= 12))) {
			alert("Password should have length of  minimum 8 and maximum 12");
			return false;
		}
		if (!(pass.match(/^(?=.*\d)(?=.*([a-z]|[A-Z]))([\x20-\x7E]){8,}$/)) || !(newpass.match(/^(?=.*\d)(?=.*([a-z]|[A-Z]))([\x20-\x7E]){8,}$/)) || !(rnewpass.match(/^(?=.*\d)(?=.*([a-z]|[A-Z]))([\x20-\x7E]){8,}$/))) {
			alert("Password should be a combination of Characters,Numerals and Special Characters");
			return false;
		}
		if (!(newpass== rnewpass)) {
			alert("Password mismatch");
			return false;
		}

		 alert("Registration is Successful");
		return true;

	}
</script>
</head>
<body>
<br>
<br>
<br>
<form name = "changepasswordForm" method="post" style="margin-left:250px;">
  <div class="form-group row">
    <label for="inputPassword" class="col-sm-2 col-form-label">Enter Old password</label>
    <div class="col-sm-10">
      <input type="password" class="form-control" style="width:200px;" name="password" placeholder="Old Password">
    </div>
  </div>
  <div class="form-group row">
    <label for="inputPassword" class="col-sm-2 col-form-label">Enter new Password</label>
    <div class="col-sm-10">
      <input type="password" class="form-control" name="newpassword" style="width:200px;" placeholder="New Password">
    </div>
  </div>
   <div class="form-group row">
    <label for="inputPassword" class="col-sm-2 col-form-label">Confirm new Password</label>
    <div class="col-sm-10">
      <input type="password" class="form-control" name="rnewpassword" style="width:200px;" placeholder="Retype New Password">
    </div>
  </div>
 <br>
  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type ="submit" class ="btn btn-primary mb-2" name = "submit" value = "Submit" onClick="return regvalidate()">   
    <input type ="reset" class ="btn btn-primary mb-2" name = "reset" value = "Reset">

</form>
</body>
<br>
<br>
<br>
<%@include file="includes/Footer.jsp"%>
</html>