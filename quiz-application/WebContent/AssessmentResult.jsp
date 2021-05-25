<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@include file="includes/StudentHeader.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Result</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<link href="css/stprogress.css" rel="stylesheet" type="text/css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

<%
	int correctAns = (Integer) session.getAttribute("correctAns");
	int wrongAns = (Integer) session.getAttribute("wrongAns");
	int totalMarks = (Integer) session.getAttribute("totalMarks");
	float percentage = (Float) session.getAttribute("percentage");
	String result="";
	if(totalMarks<25){
		result="Failed";
	}
	else{
		result="Passed";
	}
%>

</head>
<body>
	<br><br>
	<h2 align="center">Final Result</h2>
	<br>
	<br>
	<label id="result" style="color: green; margin-left: 470px"><b><%=result%></b></label>
	<br>
	<div class="container">
		<table class="table table-striped"
			style="border: 1; width: 300px; float: left; margin-left: 150px">
			<thead>
				<tr>
					<th scope="col">Total Questions</th>
					<th scope="col">Correct Answers</th>
					<th scope="col">Wrong Answers</th>
					<th scope="col">Total Marks</th>
					<th scope="col">Percentage</th>
				</tr>
			</thead>

			<tbody>
				<tr>
					<td>30</td>
					<td><%=correctAns%></td>
					<td><%=wrongAns%></td>
					<td><%=totalMarks%>/50</td>
					<td><%=percentage%>%</td>
				</tr>
			</tbody>

		</table>

		<div class="row text-center"
			style="float: right; margin-right: 150px;">
			<div class="col-sm-4">
				<div class="progressbar">
					<div class="second circle" data-percent="<%=percentage%>">
						<strong style="margin-top: 40px"></strong> <span
							style="color: #808080">Percentage</span>
					</div>
				</div>
			</div>
		</div>
	</div>


	<script src="javascripts/circle-progress.js" type="text/javascript"></script>
	<script>
	$(document).ready(function ($) {
	    function animateElements() {
	        $('.progressbar').each(function () {
	            var elementPos = $(this).offset().top;
	            var topOfWindow = $(window).scrollTop();
	            var percent = $(this).find('.circle').attr('data-percent');
	            var animate = $(this).data('animate');
	            if (elementPos < topOfWindow + $(window).height() - 30 && !animate) {
	                $(this).data('animate', true);
	                $(this).find('.circle').circleProgress({
	                    startAngle: -Math.PI / 2,
	                    value: percent / 100,
	                    size : 400,
	                    thickness: 15,
	                    fill: {
	                        color: '#663399'
	                    }
	                }).on('circle-animation-progress', function (event, progress, stepValue) {
	                    $(this).find('strong').text((stepValue*100).toFixed(2) + "%");
	                }).stop();
	            }
	        });
	    }
	
	    animateElements();
	    $(window).scroll(animateElements);
	});
	</script>
</body>
</html>