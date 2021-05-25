function validPass(password) {
	   var fetchedPassword = password; 
	   var currPassword = document.ProfileForm.currPassword.value;
	   var newPassword = document.ProfileForm.newPassword.value;
	   var confPassword = document.ProfileForm.confPassword.value;
	   /* To check a password between 6 to 20 characters 
	   which contain at least one numeric digit, one uppercase 
	   and one lowercase letter. */ 
	   var passwordRegex = /^(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{6,20}$/;
	   if(currPassword.length!=0) { //if user enters current password then only change password else submit the form
		   if(currPassword == fetchedPassword){ //currPassword is correct
			   if(newPassword.length==0 || confPassword.length==0){ //
				   alert('Password fields cannot be empty!');
				   return false;
			   }
			   else if((newPassword == confPassword) && newPassword.match(passwordRegex)) {
				   alert('Password changed successfully!');
				   document.ProfileForm.action = "StudentController";
				   return true;
			   }
			   else if((newPassword == confPassword) && !newPassword.match(passwordRegex) ) {
				   alert('Invalid new password!');
				   return false;
			   }
			   else{
				   alert('Passwords don\'t match!');
				   return false;
			   }
		   }
		   else {
			   alert('Wrong current password.');
			   return false;
		   }
	   }
	   
	   else if (currPassword.length==0 && (newPassword.length>0 || confPassword.length>0) ) {
		   alert('Please enter current password!');
		   return false;
	   }

	   alert('Profile updated without password change.');
	   document.ProfileForm.action = "StudentController";
	   return true; //submit if no current password is entered.
}

function setSelectedGender(listOfGenders, gender) {
    for(var i=0; i<listOfGenders.options.length; i++ ) {
        if (listOfGenders.options[i].text == gender ) {
        	listOfGenders.options[i].selected = true;
            return;
        }
    }
}

//window.onload = setSelectedGender(document.getElementById('gender'),"${student.getGender()}");





	
