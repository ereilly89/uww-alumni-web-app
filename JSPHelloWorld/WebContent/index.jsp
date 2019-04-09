<!DOCTYPE html>
<html>

  <head>
   <%@ page import = "dbconnection.main" %>
   <title>UWW CS Alumni - Home</title>
   <link rel="stylesheet" href="/JSPHelloWorld/css1.css" type="text/css">
   <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
   <meta charset="utf-8">
   <meta name="description" content="A web application for the visualization of University of Wisconsin - Whitewater's Computer Science Alumni.">
   <meta name="keywords" content="alumni, uww, cs">
   <link id="icon" href="images/web.ico"> 
   <div id="mySidenav" class="sidenav">
 		<a href="#" id="about">About</a>
  		<a href="#" id="blog">Blog</a>
  		<a href="#" id="projects">Projects</a>
  		<a href="#" id="contact">Contact</a>
	</div>
   <style>
   ul {
  		list-style-type: none;
 		margin: 16px;
 		padding: 0;
  		overflow: hidden;
  		background-color: #502D7F;
  		float: none;
 		position: absolute;
  		left: 50%;
 		transform: translate(-50%, -50%);
 		white-space: nowrap;
 		border-radius: 12px;
	}

	ul input[type=text] {
		float: right;
  		padding: 6px;
  		padding-top: 8px;
  		padding-bottom: 6px;
 		border: none;
  		margin-top: 8px;
 		margin-right: 16px;
	}

	li {
  		float: left;
  		display: inline-block;
	}

	li a {
  		display: block;
 		color: white;
 		text-align: center;
  		padding: 14px 16px;
 		text-decoration: none;
	}

	li a:hover {
		  background-color: #62428C;
	}
	
	#mySidenav a {
 		 position: absolute;
 		 left: -80px;
 		 transition: 0.3s;
  		padding: 15px;
  		width: 100px;
 		 text-decoration: none;
 		 font-size: 20px;
  		color: white;
  		border-radius: 0 5px 5px 0;
	}

	#mySidenav a:hover {
 		 left: 0;
	}
	
	#about {
  		top: 20px;
  		background-color: #4CAF50;
	}

	#blog {
		top: 80px;
 		background-color: #2196F3;
	}

	#projects {
 		top: 140px;
 		background-color: #f44336;
	}

	#contact {
  		top: 200px;
 		 background-color: #555
	}
	
   </style>
   
  </head>
  
  <body>
  
   <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
 
   <img id="headerImage">
    <h1 align="center">CS Alumni App</h1>
	
	<ul class="topnav-centered">
  		<li><a class="active" href="index.jsp">Home</a></li>
  		<li><a href="alumni.jsp">Alumni</a></li>
  		<li><a href="employers.jsp">Employers</a></li>
  		<li><a href="antology.jsp">Antology</a></li>
  		<li><a href="wordcloud.jsp">Word Cloud</a></li>
  		<li><input type="text" placeholder="Search.."></li>
	</ul>
	<br><br><br>	
	<div align="center" class="boxed">
		<p>
			<%="Welcome to the University of Wisconsin-Whitewater's Computer Science Alumni Application!"%>
			
		</p>
	</div>
	<img alt="logo" src="/JSPHelloWorld/images/willy.png">
	<img alt="test" id="headerImage">
	
  </body>
  
</html>