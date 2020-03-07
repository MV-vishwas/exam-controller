
<!DOCTYPE html>
<html>
<head>
	<title>home page</title>
	<style type="text/css">
		.box
		{
			width: 100%;
			height: 70px;
            background-color: #1f5183;
            color: white;
        	border-bottom: 2px solid whitesmoke;
        	margin-top: -18px;

		}
        body
        {
             padding: 0px;
             
        }
        .menu
        {
            width: 200px;
            height: 500px;
            background-color: #427cb6;
            margin-top: -20px;
            box-shadow: 5px 8px 16px 4px #1f5183;
        }
        body
		{
			margin: 0;
			padding: 0;
		}
		.menu ul
		{
			list-style: none;
			margin-left: 15px;
			font-size: 20px; 
		}
		.menu ul li
		{
			padding: 10px;
			position: relative;
			background-color: #427cb6; 
			color: white;
			border-top: 1px solid whitesmoke;
			margin-left: -50px;
		}
		.menu ul li a
		{
			text-decoration: none;
			color: white;
		}
		.menu ul ul
		{
			visibility: hidden;
			position: absolute;
			margin-left: 10px;
			margin-top: 0px;
		}
		.menu ul li:hover>ul
		{
			visibility: visible;
			position: relative;
		}
		.menu ul li ul li
		{
			border-top: 0px;
			margin-left: 10px;
			list-style: square;
		}
		.menu ul li:hover
		{
			background-color:#1f5183;
		}
		.block{
			border:2px solid #427cb6;
			float: right;
			margin-right: 200px;
			margin-top: 2px;
			width:1000px;
			height: 450px;
			font-size: 25px;
			
		}
		.block label{
			background-color: #1f5183;
			margin-top:-2px; 
			color: white ;
			font-size: 30px;
			font-family: Lucida Handwriting;

		}
		.last{
			text-align: center;
			font-size: 20px;
			background-color: #427cb6;
                        margin-top: -70px;
                        height: 40px;
                        padding-top: 20px;
                        box-shadow:2px 5px #1f5183;
                        margin-top: 100px;
		}
	</style>
</head>
<body>
    <%
       if(session.getAttribute("user")==null)    
        response.sendRedirect("login.html");
    %>
     <div class="box">
          <h1 style="margin-left: 10px;padding-top: 10px">EXAM CONTROLLER</h1>
          <a href="logout.jsp" style="float: right; color: white; margin-top: -27px; text-decoration: none; margin-right: 10px; font-size: 25px;">Logout</a>
 	</div>

	<div class="block">
    	<label >EXAM NOTICE </label>
    
        <iframe src="https://www.rgpv.ac.in/" width="100%" height="100%" style=" border: 2px solid black;"></iframe>
    	</div>

     <div class="menu">
 	<ul>
 		<li><a href="home.jsp">Dashboard</a></li>
 		<li>Master Creation
 			<ul>
 				<li><a href="student.jsp">Student Details</a></li>
 				<li><a href="staff.jsp">Staff Details</a></li>
 				<li><a href="roomcreation.jsp">Room Creation</a></li>
 			</ul>
 		</li>
 		<li style="border-bottom: 1px solid whitesmoke;">Allocation
 			<ul>
 				<li><a href="exam_allocation.jsp">Exam Allocation</a></li>
 				<li><a href="hall_allocation.jsp">Hall Allocation</a></li>
 				<li><a href="send.jsp">send</a></li>
 			</ul>
 		</li>
 	</ul>
 </div>

<div class="last"> Devloped & maintain by MR. MANAV VISHWAS,MR.DEEPAK KAREDIYA,MR.ROHIT RAJPUT</div>
</body>
</html>