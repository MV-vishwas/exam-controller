<%-- 
    Document   : student.jsp
    Created on : Sep 29, 2019, 3:47:16 PM
    Author     : ASUS
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>student details</title>
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
                background-color: #ffffcc;
		border:2px solid #427cb6;
		float: right;
		margin-right: 120px;
		margin-top: 2px;
		width:1000px;
                height: 500px;
		font-size: 25px;
                align-content: center;
                box-shadow: 5px 5px 12px 0px #330033;
	}
	.block 	td
	{
                font-size: 30px;
                padding: 2px;
	}
	.block td input{
		font-size: 28px;
	}
	.last{
		text-align: center;
		font-size: 20px;
		background-color: #427cb6;
                margin-top: -70px;
                height: 40px;
                padding-top: 20px;
                box-shadow: 2px 5px #1f5183;
                margin-top: 50px;
	}
	.block form{
                padding-left: 220px;
                padding-top: 50px;			
	}
        .tab th{font-size: 25px;}
        .tab td{font-size: 20px;}
        form input{font-size: 21px;}
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
        <form action="students" method="post">
		<table>
                    <tr><td><label>Name*</label></td><td><input type="text" name="name" required></td></tr>
		<tr><td><label>Branch*</label></td><td><select name="branch" style=" font-size: 25px;" required><option value="Computer Science">Computer Science</option><option value="Information Technology">Infotmation Technology</option><option value="Mechanical Engineering">Mechanical Engineering</option><option value="Electrical & Electronics Engineering">Electrical & Electronics Engineering</option><option value="Electronics & Communication Engineering">Electronics & Communication Engineering</option><option value="Civil Engineering">Civil Engineering</option><option value="Automobile Engineering">Automobile Engineering</option></select></td></tr>
		<tr><td><label>Branch code*</label></td><td><select name="branch_code" style=" font-size: 25px;" required> <option value="CS">CS</option><option value="IT">IT</option><option value="ME">ME</option><option value="EX">EX</option><option value="EC">EC</option><option value="CE">CE</option><option value="AU">AU</option></select></td></tr>
		<tr><td><label>Year*</label></td><td><select name="year" style=" font-size: 25px;" required> <option value="1 Year">1 Year</option><option value="2 Year">2 Year</option><option value="3 Year">3 Year</option><option value="4 Year">4 Year</option></select></td></tr>
                <tr><td><label>Semester*</label></td><td><input type="number" name="sem" min="1" max="8"/></td></tr>
                <tr><td><label>Address*</label></td><td><input type="text" name="add" required/></td></tr>
                <tr><td><label>Mobile No.*</label></td><td><input type="tel" name="phone" pattern="[0-9]{10}"  required><td></tr>
                <tr><td><label>Date of Birth*</label></td><td><input type="date" name="dob" max="2000-12-31" min="1950-01-01"  required><td></tr>
                <tr><td><label>Email*</label></td><td><input type="email" name="email" required><td></tr>
               <tr><td><input type="submit"  value="Submit"></td><td><input type="reset" value="Reset"></td></tr>
        </table>	
        </form>
        
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
        
        <h1 style=" text-align: center ;margin-top: 50px; text-decoration: underline;"> STUDENTS RECORDS</h1>
        <div class="tab">
        <%@ page import="java.sql.*"%>
        <table border="1" align="center" style="margin-top: 20px;background-color: #ccffff ;width: 100%;height: auto">
                <tr>
                    <th>S No.</th>
                    <th>Name</th>
                    <th>Branch</th>
                    <th>Semester</th>
                    <th>mobile No.</th>
                    <th>DOB</th>
                    <th>Roll No.</th>
                </tr>
                <tbody style="text-align: center">
        <%
           	try
		{
                        int c=0;
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection("Jdbc:oracle:thin:@localhost:1521:xe","system","123456789");
			java.sql.Statement stmt=con.createStatement();
			ResultSet rs=stmt.executeQuery("select sname,branch,semster,mobile,dob,roll_no from students order by roll_no asc");
                        while(rs.next())
                        {
                            c++;
                            out.print("<tr><td>"+c+"</td><td>"+rs.getString(1)+"</td><td>"+rs.getString(2)+"</td><td>"+rs.getString(3)+"</td><td>"+rs.getString(4)+"</td><td>"+rs.getString(5)+"</td><td>"+rs.getString(6)+"</td></tr>");
                        }
			con.close();
		}	
		catch(Exception e)
		{
                    out.println(e);
		}    
        %>
        </tbody>
        </table>
    </div>
        <form action="delete_student" method="POST" style=" margin-top: 20px; margin-left: 450px;">
            <label style=" font-size: 21px; "> Enter the Roll No.</label> <input type="text" name="roll_no" /> &nbsp; <input type="submit" value="Delete" />
        </form>
        
<div class="last"> Devloped & maintain by MR. MANAV VISHWAS,MR.DEEPAK KAREDIYA,MR.ROHIT RAJPUT</div>
    </body>
</html>
