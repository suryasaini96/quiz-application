<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Logout</title>
</head>
<body>
	  <% 
	   session.invalidate();
	   out.println("<Script  type=\"text/javascript\">");
	   out.println("alert('Logout Successful');");
	   out.println("location='Login.jsp';");
	   out.println("</script>");
	  %>
</body>
</html>