<!DOCTYPE html>
<html>
<head>
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<%@ page import = "dbconnection.main" %>
	<%@ page import = "dbconnection.main" %>
    <%@ page import = "java.util.*" %>
    <%@ page import = "java.io.*" %>
	<title>UWW CS Alumni - Home</title>
	<meta charset="utf-8">
	<meta name="description" content="A web application for the visualization of University of Wisconsin - Whitewater's Computer Science Alumni.">
	<meta name="keywords" content="alumni, uww, cs">
	<meta name="viewport" content="width=device-width, initial-scale=1">

	<script src="https://cdnjs.cloudflare.com/ajax/libs/d3/3.4.11/d3.min.js"></script>
    <script src="https://cdn.rawgit.com/jasondavies/d3-cloud/v1.2.1/build/d3.layout.cloud.js"></script>
<style>
<%
       		 //Returns an ArrayList of Strings(Employment rates, rate of continuing edu. and seeking rates), 
       		 //ex) "Employed,94.1","Continuing Education,3.2","Seeking,3.7"
			
			main newMain2 = new main();
			newMain2.Connection();
			ArrayList<String> careerOutcomes = newMain2.getCareerOutcomes(); 																	
			
			//for(int i=0;i<careerOutcomes.size();i++){
				//out.print(careerOutcomes.get(i));
			//}
			
		   
       	%>
<%-- --------------------------------- Header -------------------------------------------------- --%>
.header {
  overflow: hidden;
  background-color: #ffffff;//#502D7F
  padding-bottom:16px;
  padding-top:16px;
  /*padding: 20px 10px;*/
}

.header a {
  float: left;
  color: black;
  text-align: center;
  padding: 12px;
  text-decoration: none;
  font-size: 18px; 
  line-height: 25px;
  border-radius: 4px;
}

.header a.logo {
/*
 background-image: linear-gradient(rgba(0, 0, 0, 0), rgba(0, 0, 0, 0)), url("willy.png");
  height: 20%;
  width: 20%;
  
  background-position: center;
  background-repeat: no-repeat;
  
  position: relative;
*/
 background-image: linear-gradient(rgba(0, 0, 0, 0), rgba(0, 0, 0, 0)), url("willy2.png");
 background-position: center;
  background-repeat: no-repeat;
   height: 10%;
  width: 10%;
}

.header a:hover {
  background-color: #ddd;
  color: black;
}

.header a.active {
  background-color: #8c75ab;//dodgerblue
  color: white;
}

.header-right {
  float: right;
}

@media screen and (max-width: 500px) {
  .header a {
    float: none;
    display: block;
    text-align: left;
  }
  
  .header-right {
    float: none;
  }
}
<%-- --------------------------------- SubHeader -------------------------------------------------- --%>
.subHeader{
	paddign: 0px;
	text-align: center;
	background-color: #502d7f;
	color: #ffffff;
}

<%-- --------------------------------- main page -------------------------------------------------- --%>
* {
  box-sizing:border-box;
}

body {
  background-color: #502d7f;
  margin: 0;
  font-family: Arial, Helvetica, sans-serif;
}

.container {
  padding: 0px;
  background-color: #393939;
 
}

.container2 {
  padding: 0px;
  background-color: #393939;
  height:70%;/*get rid of if google maps doesnt work*/
}

.row:after {
  content: "";
  display: table;
  clear: both;
}

.row {
 background-color: #393939;
 
}

.row2 {
 background-color: #393939;
 height:100%;/*get rid of if google maps doesnt work*/
}

.left-half {
  float: left;
  width: 50%;
  padding: 20px;
  background-color: #ffffff;
  border-style:solid;
  border-color: #330066;
  padding-left: 64px;
}

.right-half {
  float: left;
  width: 50%;
  /*padding: 20px;*/
  background-color: #393939; 
  padding-left:32px;
  padding-top:16px;
  padding-bottom:16px;
}

.large-font {
  font-size: 40px;
  color: #502d7f;
}

.xlarge-font {
  font-size: 64px;
  color: #330066;
}

img {
  display: block;
  height: auto;
  max-width: 100%;
}

.center {
  margin: auto;
  width: 50%;
  padding: 10px;
}

@media screen and (max-width: 1000px) {
  .left-half,
  .right-half {
    width: 100%;
    text-align: center;
  }
  img {
    margin: auto;
  }
}

<%-- --------------------------------- Career Outcome Bar Graph -------------------------------------------------- --%>

/* Container for skill bars */
.barGraph {
  width: 100%; /* Full width */
  background-color: #393939; /* Grey background */
  /*padding: 0px;*/
  padding-left:32px;
  padding-right:32px;
  text-align: right;
  white-space: nowrap; 
  overflow: hidden;
  text-overflow: ellipsis;
  padding-bottom: 0px;
  
}

.spacer{
	line-height:1px;
}

.outcomes {
  text-align: right; /* Right-align text */
  font-weight: bold;
  padding: 1px;  /*Add some padding */
  color: white; /* White text color */
}


.employed {
			
	background-color: #502d7f;
    border-style:solid;
    border-color: #330066;   
} 
		  
.continuing {

	background-color: #502d7f;
    border-style:solid;
    border-color: #330066; 
} 
		   
.seekingEmp {

	background-color: #502d7f;
	border-style:solid;
    border-color: #330066; 
} 
		     
.outcomeDescription{
	text-align: left;
	padding-left:8px;				
}
	
.outcomePercentage{
	text-align: right;
	padding-left:8px;
	padding-right:8px;
}

svg {
	float:right;
	padding-right:32px;
	
}

<!--Tables-->

#customers {
 	font-family: "Trebuchet MS", Arial, Helvetica, sans-serif;
    border-collapse: collapse;
    width: 100%;
    margin-top:16px;
    margin-bottom: 16px;
    float:left;
}

#customers td, #customers th {
 	border: 0px solid #ddd;
 	padding: 8px;
 	white-space: nowrap;
}

#customers tr:nth-child(even){
	background-color: #f2f2f2;
}

#customers tr:hover {
	background-color: #ddd;
}

#customers th {
  	padding-top: 12px;
  	padding-bottom: 12px;
  	text-align: left;
  	background-color: #330066;
  	color: white;
}

#map {
    height: 100%;
}

#map2 {
    height: 100%;
}

/* Optional: Makes the sample page fill the window. */
html, body {
    height: 100%;
        
}

</style>

</head>
<body>

<%--HEADER SECTION --%> 
  	<div class="header">
  		<center>
  			<img src="willy2.png">
  		</center>
  		<!--  
  		<div class="header-right">
  			
    	<a class="active" href="index_zigzag.jsp">Home</a>
    	<a href="alumni.jsp">Alumni</a>
    	<a href="employers.jsp">Employers</a>
    	<a href="antology.jsp">Ontology</a>
    	<a href="wordcloud.jsp">Word Cloud</a> 
  		</div>-->
	</div>

<div class="subHeader">
  <h2>HOW UWW STUDENTS ARE ACHIEVING SUCCESS</h2>
</div>



<!-- -------------------------Career Outcomes ----------------------------------------------------------->
<div class="container">
  <div class="row">
    <div class="left-half"><center>
      <h1 class="xlarge-font" style="float:right;padding-right:37px;"><b>Career Outcomes</b></h1>
      <h1 class="large-font" style="float:right;padding-right:37px;"><b><br><br></b></h1>
      <h1 class="large-font" style="float:right;padding-right:37px;"><b>Total Graduates: <%=newMain2.getNumAlumni()%><br>Avg Starting Salary: $<%=newMain2.getAvgSalary()%><br><br></b></h1>
    </div>
    <div class="right-half">
       	<!-----------------------Career Outcome bar graph---------------------------------- -->
       	<br>
       	<br>
       		<div class="barGraph">
				<div class="outcomes employed" style="width: <%=Double.parseDouble(careerOutcomes.get(0).substring(9))%>%;height:70px;border-radius: 12px;"> 
					<p class="outcomeDescription">Employed</p>
					<p class="outcomePercentage"><%=Double.parseDouble(careerOutcomes.get(0).substring(9))%>%</p>
				</div>
			</div>
			<p class="spacer"></p>
			<div class="barGraph">
		  		<div class="outcomes continuing" style="width: <%=Double.parseDouble(careerOutcomes.get(1).substring(22))%>%;height:70px;border-radius: 12px;">
		  			<p class="outcomeDescription">Continuing Education</p>
		  			<p class="outcomePercentage"><%=Double.parseDouble(careerOutcomes.get(1).substring(22))%>%</p>
		  		</div>
			</div>
			<p class="spacer"></p>
			<div class="barGraph">
		  		<div class="outcomes seekingEmp" style="width: <%=Double.parseDouble(careerOutcomes.get(2).substring(30))%>%;height:70px;border-radius: 12px;">
		  			<p class="outcomeDescription">Seeking Employment</p>
		  			<p class="outcomePercentage"><%=Double.parseDouble(careerOutcomes.get(2).substring(30))%>%</p>
		  		</div>
			</div>
    </div>
  </div>
</div>

<!-- -----------------------------------------Top Employers/Top Jobs--------------------------------------------------- -->
<div class="container2" style="background-color:#393939">
  <div class="row2">
    <div id="map" class="right-half" style="height: 100%">
      <h1>Employer Map</h1>
    </div>
    <div class="left-half" style="height:100%;">
     <h1 class="xlarge-font"><b>Employment</b></h1>
      <h1 class="large-font"><b>Top Employers / Top Jobs</b></h1>
      <%
      	main newMain1 = new main();
		newMain1.Connection();
		ArrayList<String> topEmployers = newMain1.getTopEmployers();
		ArrayList<String> formatTopEmployers = newMain1.formatList(topEmployers, 65);
		
		out.println("<div style=\"float:left;\">");
		out.println("<font size=\"2\">");
		for(String employers : formatTopEmployers){
			out.println(employers);
		}
		out.println("</font>");
     	out.println("</div>");
		
		ArrayList<String> topPositions = newMain1.getPositions();
		ArrayList<String> formatTopPositions = newMain1.formatList(topPositions, 50);
		
      %>
      
      
    </div>
  </div>
</div>

<!-- -----------------------------------------Continuing Education----------------------------------------------------- -->
<div class="container2">
  <div class="row2">
    <div class="left-half" style="height:100%;">
    
      <h1 class="xlarge-font" style="float:right;padding-right:37px;"><b>Continuing Education</b></h1>
      <h1 class="large-font" style="float:right;padding-right:37px;"><b>Top Institutions / Top Programs</b></h1>
      <%
      	main newMain3 = new main();
		newMain3.Connection();
		ArrayList<String> topGradSchools = newMain3.getTopGradSchools();
		ArrayList<String> formatGradSchools = newMain3.formatList(topGradSchools, 80);
		
		out.println("<div style=\"float:right;padding-right:37px;\">");
		out.println("<font size=\"2\">");
		for(String employers : formatGradSchools){
			out.println(employers);
		}
		out.println("</font>");
		out.println("</div>");
		
		ArrayList<String> locations = newMain3.getEmployerLocations();
		ArrayList<String> gradSchoolLocations = newMain3.getTopGradSchoolLocations();
		ArrayList<String> jobPositions = newMain3.getPositions();
		
		//ArrayList<String> freshmenLocations = newMain3.getFreshmenLocations();
      %>
      
    </div>
    <div id="map2" class="right-half" style="height: 100%">
        <h1>Graduate School Map</h1>
    </div>
    <br><br><br>
  </div>
</div>

      <script>
		var map;
		var map2;
    	function initMap() {
    		
    		map = new google.maps.Map(document.getElementById('map'), {
    			center: {lat: 41.850033, lng: -95},
       	 		zoom: 4
    		});
    		
    		map2 = new google.maps.Map(document.getElementById('map2'), {
    			center: {lat: 41.850033, lng: -95},
       	 		zoom: 4
    		});
    		
    		
    		//new stuff***

    		var address = new Array(<%=locations.size()%>);
    	
    		var theCount = <%=locations.size()%>;
    	    
    	    address = <%=newMain3.toJavascriptArray(locations)%> //change back to address = <%=newMain3.toJavascriptArray(locations)%>
    	    address2 = <%=newMain3.toJavascriptArray(gradSchoolLocations)%>
    	    
			//var address = ['whitewater, wi','seattle, wa','chicago, il','madison, wi'];///
      	 	var geocoder = new google.maps.Geocoder();
    		
    		
			function point(index)
	      	{
	      		geocoder.geocode({'address':address[index]}, function(results, status) 
	      		{
	      			if (status == google.maps.GeocoderStatus.OK) 
	      			{
	      				var Lat = results[0].geometry.location.lat();
	      				var Lng = results[0].geometry.location.lng();
	      				var pos = {lat: Lat, lng: Lng};
	      				marker = new google.maps.Marker({position: pos, map: map});
	      			} 
	      			else 
	      			{
	      				alert("Error"+ status);
	      			}
	      		});
	      		
	      		geocoder.geocode({'address':address2[index]}, function(results, status) 
	    	      		{
	    	      			if (status == google.maps.GeocoderStatus.OK) 
	    	      			{
	    	      				var Lat = results[0].geometry.location.lat();
	    	      				var Lng = results[0].geometry.location.lng();
	    	      				var pos = {lat: Lat, lng: Lng};
	    	      				marker = new google.maps.Marker({position: pos, map: map2});
	    	      			} 
	    	      			else 
	    	      			{
	    	      				alert("Error"+ status);
	    	      			}
	    	      		});
	      	}
    		
			for(var i = 0; i< address.length; i++)
	        {
	        	point(i);
	        }
    		
    	    }
    	
    	    google.maps.event.addDomListener(window,"load",initialize);
    	    </script>
    	    
	<script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyAfUwMiEZy-HZBoFjMeY-G8hZBOfSCv0Eo&callback=initMap"
	async defer></script>
	
	<script src="https://developers.google.com/maps/documentation/javascript/examples/markerclusterer/markerclusterer.js">
    </script>
    
<!-- -------------------------------------------Employment By Location-------------------------------------------------- -->
<div class="container" style="background-color:#ffffff;">
  <div class="row">
    <div id="cloud" class="right-half" style="height:100%;">
      <!--  <img src="Images/pie.png" alt="App" width="335" height="471">-->
     
      
    </div>
    <div  class="left-half">
      <h1 class="xlarge-font"><b>Welcome to UWW's CS Alumni Page</b></h1>
      <h1 class="large-font"><b>Where you can see visualizations of our graduates employment information such as employment rate, top employers, job titles, average salary,
       and employer locations.  You can also see the locations of our alumni who are going to graduate school.<br><br>We hope to expand beyond the computer science department's alumni and collect data from other departments in the near future. <br><br><br><br><br></b></h1>
      
      <script>
      
   // First define your cloud data, using text and size properties:
	
	  var skillsToDraw = <%=newMain3.toJavascriptArraySkills(jobPositions)%>;
	   
      var positionArray = new Array();
      var obj = {};
     
   /**/
     
	  
	  
  // Next you need to use the layout script to calculate the placement, rotation and size of each word:

  var width = 800;
  var height = 800;
  var fill = d3.scale.category20();

      d3.layout.cloud()
      	.size([width, height])
      	.words(skillsToDraw)
      	.rotate(function() {
      		// up and down-> return ~~(Math.random() * 2) * 90;
      		var angle = ~~(Math.random()*2);
      		if(angle==0){
      			return 60;
      		}else if(angle==1){
      			return -30;
      		}
      	})
      	.font("Impact")
      	.fontSize(function(d) {
      		return d.size;
      	})
      	.on("end", drawSkillCloud)
      	.start();

  // Finally implement `drawSkillCloud`, which performs the D3 drawing:

      // apply D3.js drawing API
      function drawSkillCloud(words) {
      	d3.select("#cloud").append("svg")
      		.attr("width", width)
      		.attr("height", height)
      		.append("g")
      		.attr("transform", "translate(" + ~~(width / 2) + "," + ~~(height / 2) + ")")
      		.selectAll("text")
      		.data(words)
      		.enter().append("text")
      		.style("font-size", function(d) {
      			return d.size + "px";
      		})
      		.style("-webkit-touch-callout", "none")
      		.style("-webkit-user-select", "none")
      		.style("-khtml-user-select", "none")
      		.style("-moz-user-select", "none")
      		.style("-ms-user-select", "none")
      		.style("user-select", "none")
      		.style("cursor", "default")
      		.style("font-family", "Impact")
      		.style("fill", function(d, i) {
      			//default -> return fill(i);
      			var ran = ~~(Math.random()*3);
      			var color = "#f00";
      			if(ran==0){
      				color = "#330066";
      			}else if(ran==1){
      				color = "#ffffff";
      			}else if(ran==2){
      				color = "#000000";
      			}
      			
      			return color;
      		})
      		.attr("text-anchor", "middle")
      		.attr("transform", function(d) {
      			return "translate(" + [d.x, d.y] + ")rotate(" + d.rotate + ")";
      		})
      		.text(function(d) {
      			return d.text;
      		});
      }
      
  // set the viewbox to content bounding box (zooming in on the content, effectively trimming whitespace)

      var svg = document.getElementsByTagName("svg")[0];
      var bbox = svg.getBBox();
      var viewBox = [bbox.x, bbox.y, bbox.width, bbox.height].join(" ");
      svg.setAttribute("viewBox", viewBox);
      
      </script>
    </div>
  </div>
</div>

</body>
</html>
