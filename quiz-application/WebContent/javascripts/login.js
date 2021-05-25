function validate() {
   var userID = document.LoginForm.userID.value;
   var password = document.LoginForm.password.value;
   
   /* To check a password between 6 to 20 characters 
   which contain at least one numeric digit, one uppercase 
   and one lowercase letter. */
   var passwordRegex = /^(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{6,20}$/;
   
   if(userID.length==0 || password.length==0){
	   alert("Fields cannot be empty!");
	   return false;
   }
   
   else if(password.match(passwordRegex) && (userID>1000 && userID<3000 && userID!=2000) ) {
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