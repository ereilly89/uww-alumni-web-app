<!DOCTYPE html>
<html>

  <head>
   <%@ page import = "dbconnection.main" %>
   <title>UWW CS Alumni - Home</title>
   <link rel="stylesheet" type="text/css" href="css/css1.css">
   <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
   <meta charset="utf-8">
   <meta name="description" content="A web application for the visualization of University of Wisconsin - Whitewater's Computer Science Alumni.">
   <meta name="keywords" content="alumni, uww, cs">
   <meta name="viewport" content="width=device-width, initial-scale=1">
   <link id="icon" href="images/web.ico"> 
   
  	   
   
   
  </head>
  
  <body>
  	<%--HEADER SECTION --%> 
  	<div class="header">
  		<a href="index.jsp" class="logo"><br/></a>
  		<div class="header-right">
    	<a class="active" href="index.jsp">Home</a>
    	<a href="alumni.jsp">Alumni</a>
    	<a href="employers.jsp">Employers</a>
    	<a href="antology.jsp">Antology</a>
    	<a href="wordcloud.jsp">Word Cloud</a>
  		</div>
	</div>
  
   <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
 
   
    
	<%-- NAVIGATION BAR --%> 
	<%--
	<ul class="topnav-centered">
  		<li><a class="active" href="index.jsp">Home</a></li>
  		<li><a href="alumni.jsp">Alumni</a></li>
  		<li><a href="employers.jsp">Employers</a></li>
  		<li><a href="antology.jsp">Antology</a></li>
  		<li><a href="wordcloud.jsp">Word Cloud</a></li>
  		<li><input type="text" placeholder="Search.."></li>
	</ul>
	<--%>
	<br><br><br>	
	<div align="center" class="boxed">
		<p>
			<%="Welcome to the University of Wisconsin-Whitewater's Computer Science Alumni Application!"%>
			
		</p>
	</div>
	<img alt="logo" src="willy.png">
	<img alt="test" id="headerImage">
	
  </body>
  
</html>