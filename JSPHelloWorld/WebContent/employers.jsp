<!DOCTYPE html>
<html>

  <head>
   <%@ page import = "dbconnection.main" %>
   <%@ page import = "java.util.*" %>
   <title>UWW CS Alumni - Employers</title>
   <link rel="stylesheet" href="css/css1.css" />
   <meta charset="utf-8">
   <meta name="description" content="Employer information from University of Wisconsin - Whitewater computer science graduates.">
   <meta name="keywords" content="alumni, uww, cs, employers">
   <link id="icon" href="images/web.ico"> 
   
  </head>
  
  <body>
  
   <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
 
   <img id="headerImage">
   
	<div class="topnav">
	<a href="index.jsp">Home</a>
	<a href="alumni.jsp">Alumni</a>
	<a class="active" href="employers.jsp">Employers</a>
	<a href="antology.jsp">Antology</a>
	</div>
			
	<div class="boxed">
		<h1>CS Alumni App - Our Employers</h1>
		
			<%
				main newMain = new main();
				newMain.Connection();
				ArrayList<String> employersAll = newMain.getEmployersAll_JS();
				ArrayList<String> formatEmployers = newMain.formatList(employersAll);
				
				for(String emps : formatEmployers){
					out.println(emps);
				}
				
			%>
		
	</div>
	
  </body>
  
</html>