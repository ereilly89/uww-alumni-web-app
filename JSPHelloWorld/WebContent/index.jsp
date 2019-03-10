<!DOCTYPE html>
<html>

  <head>
   <%@ page import = "dbconnection.main" %>
   <title>UWW CS Alumni - Home</title>
   <link rel="stylesheet" href="../css/css1.css">
   <meta charset="utf-8">
   <meta name="description" content="A web application for the visualization of University of Wisconsin - Whitewater's Computer Science Alumni.">
   <meta name="keywords" content="alumni, uww, cs">
   <link id="icon" href="images/web.ico"> 
   
  </head>
  
  <body>
  
   <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
 
   <img id="headerImage">
   
	<div class="topnav">
	<a class="active" href="index.jsp">Home</a>
	<a href="alumni.jsp">Alumni</a>
	<a href="employers.jsp">Employers</a>
	<a href="antology.jsp"> Antology</a>
	</div>
			
	<div class="boxed">
		<h1>CS Alumni App - Home</h1>
		<p>
			<%="Welcome to the University of Wisconsin-Whitewater's Computer Science Alumni Application!"%>
			
		</p>
	</div>
	<img src="willy.png">
	
  </body>
  
</html>