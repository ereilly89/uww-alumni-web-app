<!DOCTYPE html>
<html>
<head>
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<%@ page import = "dbconnection.main" %>
	<title>UWW CS Alumni - Home</title>
	<meta charset="utf-8">
	<meta name="description" content="A web application for the visualization of University of Wisconsin - Whitewater's Computer Science Alumni.">
	<meta name="keywords" content="alumni, uww, cs">
	<meta name="viewport" content="width=device-width, initial-scale=1">
<style>
<%-- --------------------------------- Header -------------------------------------------------- --%>
.header {
  overflow: hidden;
  background-color: #502D7F;
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
  background-image: linear-gradient(rgba(0, 0, 0, 0), rgba(0, 0, 0, 0)), url("willy.png");
  height: 10%;
  width: 10%;
  /* Position and center the image to scale nicely on all screens */
  background-position: center;
  background-repeat: no-repeat;
  background-size: cover;
  position: relative;
}

.header a:hover {
  background-color: #ddd;
  color: black;
}

.header a.active {
  background-color: dodgerblue;
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
	background-color: #090C08;
	color: #8D6B94
}

<%-- --------------------------------- main page -------------------------------------------------- --%>
* {
  box-sizing:border-box;
}

body {
  background-color: #090C08;
  margin: 0;
  font-family: Arial, Helvetica, sans-serif;
}

.container {
  padding: 0px;
  background-color: #474056;
}

.row:after {
  content: "";
  display: table;
  clear: both
}

.left-half {
  float: left;
  width: 50%;
  padding: 20px;
  background-color: #B9C6AE;
}

.right-half {
  float: left;
  width: 50%;
  /*padding: 20px;*/
  background-color: #474056;
    
}

.large-font {
  font-size: 48px;
}

.xlarge-font {
  font-size: 64px
}

img {
  display: block;
  height: auto;
  max-width: 100%;
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
  background-color: #ddd; /* Grey background */
  padding: 0px;
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


.employed {width: 70%; background-color: #8D6B94;} /* Green */
.continuing {width: 15%; background-color: #8D6B94;} /* Blue */
.seekingEmp {width: 10%; background-color: #8D6B94;} /* Red */
.seekingEdu {width: 3%; background-color: #8D6B94;} /* Dark Grey */
.notSeeking {width: 2%; background-color: #8D6B94;} /* Dark Grey */
.outcomeDescription{text-align: left;}
.outcomePercentage{text-align: right;}



</style>
</head>
<body>

<%--HEADER SECTION --%> 
  	<div class="header">
  		<a href="index_zigzag.jsp" class="logo"><br/></a>
  		<div class="header-right">
    	<a class="active" href="index_zigzag.jsp">Home</a>
    	<a href="alumni.jsp">Alumni</a>
    	<a href="employers.jsp">Employers</a>
    	<a href="antology.jsp">Antology</a>
    	<a href="wordcloud.jsp">Word Cloud</a>
  		</div>
	</div>

<div class="subHeader">
  <h2>HOW UWW STUDENTS ARE ACHIEVING SUCCESS</h2>
</div>

<!-- -------------------------Career Outcomes ----------------------------------------------------------->
<div class="container">
  <div class="row">
    <div class="left-half">
      <h1 class="xlarge-font"><b>Career Outcomes</b></h1>
      <h1 class="large-font" style="color:#474056;"><b>% of graduates</b></h1>
    </div>
    <div class="right-half">
       	<!-----------------------Career Outcome bar graph---------------------------------- -->
       	<div class="barGraph">
			<div class="outcomes employed"> <p class="outcomeDescription">Employed</p><p class="outcomePercentage"></p></div>
		</div>
		<p class="spacer"></p>
		<div class="barGraph">
		  	<div class="outcomes continuing"><p class="outcomeDescription">Continuing Education</p><p class="outcomePercentage"></p></div>
		</div>
		<div class="barGraph">
		  	<div class="outcomes seekingEmp"><p class="outcomeDescription">Seeking Employment</p><p class="outcomePercentage"></p></div>
		</div>
		<div class="barGraph">
		  	<div class="outcomes seekingEdu"><p class="outcomeDescription">Seeking Continuing Education</p><p class="outcomePercentage"></p></div>
		</div>
		<div class="barGraph">
		  	<div class="outcomes notSeeking"><p class="outcomeDescription">Not Currently Seeking</p></div>
		</div>
    </div>
  </div>
</div>

<!-- -----------------------------------------Continuing Education----------------------------------------------------- -->
<div class="container" style="background-color:#8D6B94">
  <div class="row">
    <div class="right-half">
      <img src="Images/pie.png" alt="App" width="335" height="471">
    </div>
    <div class="left-half">
      <h1 class="xlarge-font"><b>Continuing Education</b></h1>
      <h1 class="large-font" style="color:red;"><b>Top Institutions / Top Programs</b></h1>
    </div>
  </div>
</div>

<!-- -----------------------------------------Top Employers/Top Jobs--------------------------------------------------- -->
<div class="container">
  <div class="row">
    <div class="left-half">
      <h1 class="xlarge-font"><b>Employment</b></h1>
      <h1 class="large-font" style="color:MediumSeaGreen;"><b>Top Employers / Top Jobs</b></h1>
    </div>
    <div class="right-half">
        <img src="Images/usmap.png" width="335" height="471" >
    </div>
  </div>
</div>

<!-- -------------------------------------------Employment By Location-------------------------------------------------- -->
<div class="container" style="background-color:#8D6B94">
  <div class="row">
    <div class="right-half">
      <img src="Images/pie.png" alt="App" width="335" height="471">
    </div>
    <div class="left-half">
      <h1 class="xlarge-font"><b>Clarity</b></h1>
      <h1 class="large-font" style="color:red;"><b>Pixels, who?</b></h1>
      
    </div>
  </div>
</div>

</body>
</html>
