<!DOCTYPE html>
<html>
  <head>
    <title>Simple Map</title>
    <meta name="viewport" content="initial-scale=1.0">
    <meta charset="utf-8">
    
    
    <meta name="viewport" content="width=device-width, initial-scale=1">
	<%@ page import = "dbconnection.main" %>
	<%@ page import = "dbconnection.main" %>
    <%@ page import = "java.util.*" %>
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

.row:after {
  content: "";
  display: table;
  clear: both;
}

.row {
 background-color: #393939;
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

<!--Google Maps CSS-->
#map {
	height: 100%;
}

html, body {
    height: 100%;
    margin: 0;
    padding: 0;
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
       	
       	
       	
       	
       	
       	
       	
       	
      /* Always set the map height explicitly to define the size of the div
       * element that contains the map. */
      #map {
        height: 100%;
      }
      /* Optional: Makes the sample page fill the window. */
      html, body {
        height: 100%;
        
      }
    </style>
  </head>
  <body>
  
	<div id="map"></div>
		<!-- Replace the value of the key parameter with your own API key. -->
	<script async defer
		src="https://maps.googleapis.com/maps/api/js?key=AIzaSyAfUwMiEZy-HZBoFjMeY-G8hZBOfSCv0Eo&callback=initMap">
	</script>
	<div class="container" style="background-color:#8D6B94">
  	<div class="row">
   	 <div class="right-half">
      	<img src="Images/pie.png" alt="App" width="335" height="471">
      	<!-- -------------------------------------Google Maps API Start------------------------------------------------- -->>
      	<script>
     	 function initMap() {
    	  	var myLatLng = {lat: -25.363, lng: 131.044};

    	  	var map = new google.maps.Map(document.getElementById('map'), {
    	  	  zoom: 4,
    	  	  center: myLatLng
    	  	});

    	 	 var marker = new google.maps.Marker({
    	  	  position: myLatLng,
    	  	  map: map,
    	   	 title: 'Hello World!'
    	 	 });
    		}
      	</script>
      	<!-- --------------------------------------GOOGLE MAPS API END------------------------------------------------ -->
   	 </div>
    <div class="left-half">
		    
      <h1 class="xlarge-font"><b>Clarity</b></h1>
      <h1 class="large-font" style="color:red;"><b>Pixels, who?</b></h1>
      
    </div>
  </div>
</div>
  
  
  </body>
</html>
