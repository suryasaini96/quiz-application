<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@include file="includes/StudentHeader.jsp" %>
    <%@page import = "com.wipro.quiz.bean.ResultBean" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Progress Card</title>
<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<link href="css/stprogress.css" rel="stylesheet" type="text/css">


<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<%
	ResultBean result = (ResultBean) request.getAttribute("result");
	float level1 = ((float)result.getLevel1()/10)*100;
	float level2 = ((float)result.getLevel2()/10)*100;
	float level3 = ((float)result.getLevel3()/10)*100;
%>

</head>
<body>
<br><br>
<div class="container">
	<h2 align="center">${result.getTopic()}</h2>
    <br>
    <br>
	<div class="row text-center">

		<div class="col-sm-4">
		    <div class="progressbar">
            <div class="second circle" data-percent="<%=level1%>">
              <strong style="margin-top:40px"></strong>
              <span style="color: #808080">Level 1</span>
            </div>
            </div>
		</div>
		
		<div class="col-sm-4">
		    <div class="progressbar">
            <div class="second circle" data-percent="<%=level2%>">
              <strong style="margin-top:40px"></strong>
              <span style="color: #808080">Level 2</span>
            </div>
              </div>
		</div>
		
		<div class="col-sm-4">
		    <div class="progressbar">
            <div class="second circle" data-percent="<%=level3%>">
              <strong style="margin-top:40px"></strong>
              <span style="color: #808080">Level 3</span>
            </div>
            </div>
		</div>
	</div><br><br>
	<h6 align="center"><u>Test date</u>: ${result.getTime()}</h6>
	
</div>
<script src="javascripts/circle-progress.js"></script>
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
                    // startAngle: -Math.PI / 2,
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