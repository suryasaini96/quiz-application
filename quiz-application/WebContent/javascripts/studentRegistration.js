function regValidate() {
	
		var id = document.StuRegisterForm.id.value;
		var fname = document.StuRegisterForm.fname.value;
		var lname = document.StuRegisterForm.lname.value;
		var gender = document.StuRegisterForm.querySelectorAll('input[name="gender"]:checked');
		var dob = document.StuRegisterForm.dob.value;
		var mobile = document.StuRegisterForm.mobile.value;
		var email = document.StuRegisterForm.email.value;
		var password = document.StuRegisterForm.password.value;
		var retypePassword = document.StuRegisterForm.retypepassword.value;
		
		if (id.length ==0 && fname.length==0 
				&& lname.length==0 && email.length==0
				&& mobile.length==0 && password.length == 0
				&& retypePassword.length == 0)

		{
			alert("Fields cannot be empty.");
			return false;
		}
		if(id.length == 0){
			alert("Please enter your id.");
			return false;
		}
		if(!(id>1000 && id<2000)){
			alert("Please enter a valid id.");
			return false;
		}
		if (fname.length == 0) {
			alert("Please enter your first name.");
			return false;
		}
		if (!(fname.match(/^[A-Za-z]+$/))) {
			alert("First name must have alphabetic characters only.");
			return false;
		}
		if (fname.length < 3)
		{
			alert("First name should contain atleast 3 characters.");
			return false;
		}
		if (lname.length == 0) {
			alert("Please enter your last name.");
			return false;
		}
		if (!(lname.match(/^[A-Za-z]+$/))) {
			alert("Last name must have alphabetic characters only.");
			return false;
		}
		if (lname.length < 3)
		{
			alert("Last name should contain atleast 3 characters.");
			return false;
		}
		if (dob.length==0)
		{
			alert("Please enter your DOB.");
			return false;
		}
		if(!(dob.getFullYear() > 1990 && dob.getFullYear() < 2000)){
			alert("Please enter a valid year.");
			return false;
		}
		if (!gender.length) {
			alert("Please select your gender.");
			return false;
		}
        if (mobile.length == 0) {
			alert("Please enter your mobile number.");
			return false;
		}
		if (!(mobile.match(/^[789]\d{9}$/))) {
			alert("Not a valid phone number.");
			return false;
		}
		if (email.length == 0) {
			alert("Please enter your email.");
			return false;
		}
		
		if (password.length == 0) {
			alert("Please enter your password.");
			return false;
		}
		if (!(password.length >= 6 && password.length <= 20)) {
			alert("Password should have length of 6-20 characters.");
			return false;
		}
		if (!(password.match(/^(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{6,20}$/))) {
			alert("Password should be 6-20 characters which contain at least one numeric digit, one uppercase and one lowercase letter.");
			return false;
		}
		if (retypePassword.length == 0) {
			alert("Please retype your password.");
			return false;
		}
		if (!(retypePassword.length >= 6 && retypePassword.length <= 20)) {
			alert("Retyped password should have length of minimum 6 and maximum 20");
			return false;
		}
		if (!(password == retypePassword)) {
			alert("Password mismatch.");
			return false;
		}

		alert("Registration successful!");
		return true;
	}