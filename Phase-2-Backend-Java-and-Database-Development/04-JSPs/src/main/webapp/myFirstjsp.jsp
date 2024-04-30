<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Frank's First JSP Page</title>
</head>
<body>
	<!--  an HTML Form allows us to get input from a user 				-->
	<!--  action="name of a servlet to be run when form is submitted 	-->
	<!--  method="the HTTP method to use when calling the servlet"		 -->
	
	<form action="helloServlet" method="get">
	Please enter your name: <input type="text" name="theName" size=25>
	</form>
</body>
</html>