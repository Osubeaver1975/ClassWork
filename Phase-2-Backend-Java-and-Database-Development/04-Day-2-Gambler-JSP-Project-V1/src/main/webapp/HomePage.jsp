<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Gambler App Home Page</title>
<!--  the CSS styling is in this file - path is relative to the "webapp" folder -->
<!--  this file is stored in webapp/resources folder (./resources -->
<link rel="stylesheet" href="./resources/style.css"></link>
</head>
<body>
<h1> Welcome to the Gambler Support App!</h1>

<div>
	<a class="options" href="./gambler">Display all Gamblers</a> 
</div>

<div class="options">
<!--  note: action= on the form tells it what path to give to the browser  -->
<!--  ./gambler is the url path assigned to GamblerServlet -->
<!--  when the user enters input the GamblerServlet is run -->
<!--  the name of input variable is added to the URL path as a query param -->
<!--  the method= tells the server which servlet method to run -->
<!--  		method="get" indicates doGet() method in servlet should run -->
<!--  		method="post/put/delete" indicates doPost/doPut/doDelete should run -->
	<form action="./gambler" method="get">
		Display Gambler with id: <input type="text" size=5 name="id">
	</form>
</div>
<div class="options">
	<form action="./gambler" method="get">
		Display Gambler with name: <input type="text" size=25 name="gamblerName">
	</form>
</div>
<div class="options">
	<form action="./gambler?action=delete" method="get">
		Delete Gambler with id: <input type="text" size=5 name="id2Delete">
	</form>
</div>
<div class="options">
	<form action="./gambler?action=update" method="post">
		Update Gambler with id: <input type="text" size=5 name="id2Update">
	</form>
</div>
</body>
</html>