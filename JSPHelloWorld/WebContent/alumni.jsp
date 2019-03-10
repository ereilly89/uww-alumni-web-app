<!DOCTYPE html>
<html>

  <head>
   <%@ page import = "dbconnection.main" %>
   <%@ page import = "java.util.*" %>
   <title>UWW CS Alumni - Alumni</title>
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
	<a href="index.jsp">Home</a>
	<a class="active" href="alumni.jsp">Alumni</a>
	<a href="employers.jsp">Employers</a>
	<a href="antology.jsp">Antology</a>
	</div>
			
	<div class="boxed">
		<h1>CS Alumni App - Our Alumni</h1>
			<%
				main newMain = new main();
				newMain.Connection();
				ArrayList<String> alumniAll = newMain.getAlumniAll_JS();
				ArrayList<String> formatAlumni = newMain.formatList(alumniAll);
				
				for(String emps : formatAlumni){
					out.println(emps);
				}
				
			%><br><br>
		
	</div>
	
  </body>
  
</html>