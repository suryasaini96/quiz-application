//var min = document.get
//var time = new Date();


var localMin;
var localSec;     
var timer;

function f1(min, sec) {
    if (parseInt(sec) > 0) {
        sec = parseInt(sec) - 1;
        localSec = sec;
        localMin = min;
        document.getElementById("showtime").innerHTML = "Time left: " + min + " min   " + sec + " seconds";
        timer = setTimeout(function(){
        	f1(min,sec);
        },1000);
    }
    else {
        if (parseInt(sec) == 0) {
            min = parseInt(min) - 1;
            localSec = sec;
            localMin = min;
            if (parseInt(min) == -1) {
                clearTimeout(timer);
                alert('Time up!');
                document.getElementById('finishTest').value = "finishTest";
                setSubmitTime();
                document.AssessmentForm.action = "StudentController";
                return;
            }
            else {
                sec = 60;
                document.getElementById("showtime").innerHTML = "Time left: " + min + " min   " + sec + " seconds";
                timer = setTimeout(function(){
                	f1(min,sec);
                },1000);
            }
        }
    }
}

function setSubmitTime(){
	document.getElementById('min').value = localMin;
	document.getElementById('sec').value = localSec;
}

function checkPrevAns(selectedAns){
	if(document.getElementById('op1').value == selectedAns.value){
		document.getElementById('op1').checked = true;
	}
	else if(document.getElementById('op2').value == selectedAns.value){
		document.getElementById('op2').checked = true;
	}
	else if(document.getElementById('op3').value == selectedAns.value){
		document.getElementById('op3').checked = true;
	}
	else if(document.getElementById('op4').value == selectedAns.value){
		document.getElementById('op4').checked = true;
	}
}

function execute(min,sec,selectedAns){
	f1(min,sec);
	checkPrevAns(selectedAns);
}