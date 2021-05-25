function regValidate() {
	
		var id = document.ProfRegisterForm.id.value;
		var dept = document.ProfRegisterForm.dept.value;
		var fname = document.ProfRegisterForm.fname.value;
		var lname = document.ProfRegisterForm.lname.value;
		var dob = new Date(document.ProfRegisterForm.dob.value);
		var gender = ProfRegisterForm.querySelectorAll('input[name="gender"]:checked');	
		var qualification = document.ProfRegisterForm.qualification.value;
		var mobile = document.ProfRegisterForm.mobile.value;
		var email = document.ProfRegisterForm.email.value;
		var password = document.ProfRegisterForm.password.value;
		var retypePassword = document.ProfRegisterForm.retypepassword.value;
		
		if (id.length ==0 && dept.length ==0 && fname.length==0 
				&& lname.length==0 && dob.length == 0 
				&& qualification.length ==0 && email.length==0
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
		if(!(id>2000 && id<3000)){
			alert("Please enter a valid id.");
			return false;
		}
		if(dept=="default")
	    {
		    alert("Please select your department from the dropdown.");
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
		if(!(dob.getFullYear() > 1900 && dob.getFullYear() < 1996)){
			alert("Please enter a valid year.");
			return false;
		}
		if (!gender.length) {
			alert("Please select your gender.");
			return false;
		}
        if(qualification=="default")
	    {
		    alert("Please select your qualification from the dropdown.");
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
		if (!(email.match(/[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,}$/))){
			alert("Please enter a valid email.");
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