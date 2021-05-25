<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
	<%@page import = "com.wipro.quiz.bean.QuestionsBean" %>
    <%@page import = "java.util.*" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Assessment</title>

<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
	integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
	crossorigin="anonymous"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
	integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
	crossorigin="anonymous"></script>
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
	integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
	crossorigin="anonymous"></script>
	
<script src="javascripts/timer.js" type="text/javascript"> </script>
<script>
	$(document).ready(function() {
		$('[data-toggle="popover"]').popover();
	});
</script>

<%
	int min = (Integer) session.getAttribute("min");
	int sec = (Integer) session.getAttribute("sec");
	
	String id = Integer.toString((Integer) session.getAttribute("id"));
	String topic = (String) session.getAttribute("topic");
	QuestionsBean quesBean = (QuestionsBean) session.getAttribute("quesBean");
	HashMap<Integer, String> answerKey = (HashMap<Integer, String>) session.getAttribute("answerKey");
	String selectedAns = (String) session.getAttribute("selectedAns");
	
%>

</head>

<body onload="execute(<%=min%>, <%=sec%>, <%=selectedAns%>)">
	<nav aria-label="breadcrumb">
		<ol class="breadcrumb">
			<li class="breadcrumb-item"><a href="#"
				title="Question Navigator" data-toggle="popover"
				data-trigger="focus" data-placement="bottom"
				data-content="
	    	   <a href='#'>1</a>&nbsp;&nbsp;   <a href='#'>2</a> &nbsp;&nbsp;  <a href='#'>3</a> &nbsp;&nbsp;  <a href='#'>4</a>  &nbsp;&nbsp; <a href='#'>5</a> &nbsp;&nbsp;  <a href='#'>6</a>  &nbsp;&nbsp;  <a href='#'>7</a>  &nbsp;&nbsp; <a href='#'>8</a>  &nbsp;&nbsp; <a href='#'>9</a>  &nbsp;&nbsp;  <a href='#'>10</a><br>
	    	   <a href='#'>11</a>&nbsp;&nbsp;   <a href='#'>12</a> &nbsp;&nbsp;  <a href='#'>13</a> &nbsp;&nbsp;  <a href='#'>14</a>  &nbsp;&nbsp; <a href='#'>15</a> &nbsp;&nbsp;  <a href='#'>16</a>  &nbsp;&nbsp;  <a href='#'>17</a>  &nbsp;&nbsp; <a href='#'>18</a>  &nbsp;&nbsp; <a href='#'>19</a>  &nbsp;&nbsp;  <a href='#'>20</a><br>
	    	   <a href='#'>21</a>&nbsp;&nbsp;   <a href='#'>22</a> &nbsp;&nbsp;  <a href='#'>23</a> &nbsp;&nbsp;  <a href='#'>24</a>  &nbsp;&nbsp; <a href='#'>25</a> &nbsp;&nbsp;  <a href='#'>26</a>  &nbsp;&nbsp;  <a href='#'>27</a>  &nbsp;&nbsp; <a href='#'>28</a>  &nbsp;&nbsp; <a href='#'>29</a>  &nbsp;&nbsp;  <a href='#'>30</a><br>
				"
				data-html="true" style="color: black"> Question ${quesBean.getQuesid()}/30 </a></li>

			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;

			<div id="showtime" class="float-right" style:align=right;></div>

		</ol>
	</nav>
	<br>
	<form name="AssessmentForm" action="StudentController" method="post">
		<div class="container">
			<pre>${quesBean.getQuesid()}.&nbsp;${quesBean.getQues()}</pre>
			<div class="form-check">
				<input class="form-check-input" type="radio" name="ans"
					id="op1" value="op1"> <label
					class="form-check-label" for="options"> ${quesBean.getOp1()} </label>
			</div>
			<div class="form-check">
				<input class="form-check-input" type="radio" name="ans"
					id="op2" value="op2"> <label
					class="form-check-label" for="options"> ${quesBean.getOp2()} </label>
			</div>
			<div class="form-check">
				<input class="form-check-input" type="radio" name="ans"
					id="op3" value="op3"> <label
					class="form-check-label" for="options"> ${quesBean.getOp3()} </label>
			</div>
			<div class="form-check">
				<input class="form-check-input" type="radio" name="ans"
					id="op4" value="op4"> <label
					class="form-check-label" for="options"> ${quesBean.getOp4()} </label>
			</div>
			<br>
	
			<div class="text-left">
				<button type="submit" name="submit" onclick="setSubmitTime()" value="prevQues" class="btn btn-info">Previous</button>
				<button type="submit" name="submit" onclick="setSubmitTime()" value="nextQues" class="btn btn-info">Next</button>
			</div>
			<div class="text-right">
				<button type="submit" name="submit" id="finishTest" onclick="setSubmitTime()" value="finishTest" class="btn btn-success">Finish Test</button>
			</div>
			
			<input type="hidden" name="min" id="min" value=""/>
			<input type="hidden" name="sec" id="sec" value=""/>
			
		</div>
	</form>


</body>
</html>