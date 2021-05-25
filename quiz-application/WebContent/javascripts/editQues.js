function editQuesValidate() {
		var topic = document.EditQuesForm.topic.value;
		var ques = document.EditQuesForm.ques.value;
		var op1 = document.EditQuesForm.op1.value;
		var op2 = document.EditQuesForm.op2.value;
		var op3 = document.EditQuesForm.op3.value;
		var op4 = document.EditQuesForm.op4.value;
		var ans = document.EditQuesForm.ans.value;
		var qid = document.EditQuesForm.quesid.value;
		
		if (qid.length == 0 && ques.length == 0 && op1.length == 0
				&& op2.length == 0 && op3.length == 0 && op4.length == 0
				&& ans.length == 0) {
			alert("Values cannot be empty.");
			return false;
		}

		if (ques.length < 8) {
			alert("Question length should be more.");
			return false;
		}
		alert('Question updated!');
		return true;
}

function setSelectedTopic(listOfTopics, topic) {
    for(var i=0; i<listOfTopics.options.length; i++ ) {
        if (listOfTopics.options[i].value == topic ) {
        	listOfTopics.options[i].selected = true;
            return;
        }
    }
}

function setSelectedAns(listOfAns, ans) {
    for(var i=0; i<listOfAns.options.length; i++ ) {
        if (listOfAns.options[i].value == ans ) {
        	listOfAns.options[i].selected = true;
            return;
        }
    }
}

function dropdownSelect(listOfTopics, topic, listOfAns, ans){
	setSelectedTopic(listOfTopics, topic);
	setSelectedAns(listOfAns, ans);
}