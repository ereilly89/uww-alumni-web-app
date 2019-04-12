<!DOCTYPE html>
<html>

  <head>
   <%@ page import = "dbconnection.main" %>
   <title>UWW CS Alumni - Antology</title>
   <link rel="stylesheet" href="css/countdown.css">
   <meta charset="utf-8">
   <meta name="description" content="Job Position Antology of Our Alumni.">
   <meta name="keywords" content="alumni, uww, cs, antology">
   <link id="icon" href="images/web.ico"> 
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
   </style>
   <script src="JavaScript/countdown.js"></script>
   
  </head>
  
  <body>
  
  
  	<%--HEADER SECTION --%> 
  	<div class="header">
  		<a href="index.jsp" class="logo"><br/></a>
  		<div class="header-right">
    	<a href="index.jsp">Home</a>
    	<a href="alumni.jsp">Alumni</a>
    	<a href="employers.jsp">Employers</a>
    	<a class="active" href="antology.jsp">Antology</a>
    	<a href="wordcloud.jsp">Word Cloud</a>
  		</div>
	</div>
  
   <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  	
  	 
	<br><br><br>
	
	
	<div class="bgimg">
  		<div class="topleft">
    		<p>Logo</p>
  		</div>
  		<div class="middle">
    		<h1>COMING SOON</h1>
    		<hr>
    		<p id="demo" style="font-size:30px"></p>
  		</div>
  		<div class="bottomleft">
    		<p>Some text</p>
  		</div>
	</div>
	
	
	<div align="center" class="boxed">
		<p>
			<%="Welcome to the antology page, where you can view job positions that our graduates hold and how they relate to one another."%>
			
		</p>
	</div>
	
  </body>
  
</html>