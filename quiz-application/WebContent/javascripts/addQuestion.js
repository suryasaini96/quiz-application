function addQuesValidate()
{
	var top=document.AddQuesForm.topic.value;
	var ques=document.AddQuesForm.ques.value;
	var op1=document.AddQuesForm.op1.value;
	var op2=document.AddQuesForm.op2.value;
	var op3=document.AddQuesForm.op3.value;
	var op4=document.AddQuesForm.op4.value;
	var ans=document.AddQuesForm.ans.value;
	
	 if(ques.length==0&&op1.length==0&&op2.length==0&&op3.length==0&&op4.length==0&&ans.length==0 )
		 
	   {
	     alert("value cannot be empty");
	     return false;
	   } 
	 
	 if(ques.length < 8)
			 {
		     alert("question length should be more ");
		     return false;
		   } 
		 
	 
 	return true;
}
