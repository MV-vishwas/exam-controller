<%@page import="java.sql.*" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
                background-color: #ffffcc;
		border:2px solid #427cb6;
		float: right;
		margin-right: 200px;
		margin-top: 2px;
		width:1000px;
		height: 550px;
		font-size: 25px;
                align-content: center;
                box-shadow: 5px 5px 12px 0px #330033;
	}
	.block 	td
	{
                font-size: 30px;
                padding-top: 10px;
	}
	.block td input{
		font-size: 28px;
                width: 250px;
	}
	.block form
        {
                padding-left: 220px;
                padding-top: 20px;
        }
	.last{
                text-align: center;
		font-size: 20px;
                background-color: #427cb6;
                margin-top: -70px;
                height: 40px;
                padding-top: 20px;
                box-shadow: 2px 5px #1f5183;
                margin-top: 100px;
        }
        .tab th{font-size: 25px;}
        .tab td{font-size: 20px;}
        form input{font-size: 21px;}
	</style>
</head>
<body>
    <div class="box">
          <h1 style="margin-left: 10px;padding-top: 10px">EXAM CONTROLLER</h1>
          <a href="logout.jsp" style="float: right; color: white; margin-top: -27px; text-decoration: none; margin-right: 10px; font-size: 25px;">Logout</a>
    </div>

    <div class="block">
        <form action="exams" method="post">
		<table>
			<tr><td><label>Exam Date</label></td><td><input type="date" name="edate"></td></tr>
			<tr><td><label>Exam Type</label></td><td><select name="etype" style=" font-size: 25px;width: 250px;" ><option value="Internal">Internal</option><option value="External">External</option><option value="Theory">Theory</option></td></tr>
                        <tr><td><label>Start Time</label></td><td><input type="time" name="stime"></td></tr>
                        <tr><td><label>Over Time</label></td><td><input type="time" name="otime"></td></tr>
			<tr><td><label>Subject</label></td><td><input type="text" name="subject"></td></tr>
			<tr><td><label>Subject Code</label></td><td><input type="text" name="sub_code"></td></tr>
                        <tr><td><label>Department</label></td><td><select name="dpt" style=" font-size: 25px;" ><option value="Computer Science">Computer Science</option><option value="Information Technology">Infotmation Technology</option><option value="Mechanical Engineering">Mechanical Engineering</option><option value="Electrical & Electronics Engineering">Electrical & Electronics Engineering</option><option value="Electronics & Communication Engineering">Electronics & Communication Engineering</option><option value="Civil Engineering">Civil Engineering</option><option value="Automobile Engineering">Automobile Engineering</option></select></td></tr>
                      	<tr><td><label>Year*</label></td><td><select name="year" style=" font-size: 25px; width: 250px" > <option value="1 Year">1 Year</option><option value="2 Year">2 Year</option><option value="3 Year">3 Year</option><option value="4 Year">4 Year</option></select></td></tr>
                        <tr><td><label>Semester*</label></td><td><input type="number" name="sem" min="1" max="8"/></td></tr>
                        <tr><td><input type="submit" value="Submit" style=" width: 150px;"></td><td><input  type="reset"  value="Reset" style=" width: 150px;"></td></tr>
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
 				<li><a href="exam_allocaion.jsp">Exam Allocation</a></li>
 				<li><a href="hall_allocation.jsp">Hall Allocation</a></li>
 				<li><a href="send.jsp">send</a></li>
 			</ul>
 		</li>
 	</ul>
    </div>
        <h1 style=" text-align: center ;margin-top: 70px; text-decoration: underline;"> EXAMS RECORDS</h1>
        <div class="tab">
        <%@ page import="java.sql.*"%>
        <table border="1" align="center" style="margin-top: 20px;background-color: #ccffff ;width: 100%;height: auto">
                <tr>
                    <th>S.No</th>
                    <th>Exam Date</th>
                    <th>Exam Type</th>
                    <th>Subject</th>
                    <th>Subject Code</th>
                    <th>Department</th>
                    <th>Year</th>
                    <th>Semester</th>
                    <th>Time</th>
                </tr>
                <tbody style="text-align: center">
        <%
           	try
		{
                        int c=0;
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection("Jdbc:oracle:thin:@localhost:1521:xe","system","123456789");
			java.sql.Statement stmt=con.createStatement();
			ResultSet rs=stmt.executeQuery("select * from exams");
                        while(rs.next())
                        {
                            c++;
                            out.print("<tr><td>"+c+"</td><td>"+rs.getString(1)+"</td><td>"+rs.getString(2)+"</td><td>"+rs.getString(3)+"</td><td>"+rs.getString(4)+"</td><td>"+rs.getString(5)+"</td><td>"+rs.getString(6)+"</td><td>"+rs.getString(7)+"</td><td>"+rs.getString("stime")+" to "+rs.getString("otime")+"</td></tr>");
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
        <form action="delete_exam" method="POST" style=" margin-top: 20px; margin-left: 50px; font-size: 21px;">
            <table style=" margin-left: 500px; margin-top: 20px;" >
            <tr><td><label style="font-size: 20px;">Enter the Department</label></td><td><select name="dpt" style=" font-size: 25px;" ><option value="Computer Science">Computer Science</option><option value="Information Technology">Infotmation Technology</option><option value="Mechanical Engineering">Mechanical Engineering</option><option value="Electrical & Electronics Engineering">Electrical & Electronics Engineering</option><option value="Electronics & Communication Engineering">Electronics & Communication Engineering</option><option value="Civil Engineering">Civil Engineering</option><option value="Automobile Engineering">Automobile Engineering</option></select></td></tr>
            <tr><td><label style="font-size: 20px;">Enter the Semester</label></td><td><input type="number" name="sem" max="8" min="1" style="font-size: 20px;"></tr>
            <tr><td><label style="font-size: 20px;">Enter the Date</label></td><td><input type="date" name="edate" style="font-size: 20px;"></td></tr>
            <tr><td><input type="reset" value="Reset" style="font-size: 20px;"/></td><td><input type="submit" value="Submit" style="font-size: 20px;"/></td></tr>
            </table>
        </form>
    
<div class="last"> Devloped & maintain by MR. MANAV VISHWAS,MR.DEEPAK KAREDIYA,MR.ROHIT RAJPUT</div>
</body>
</html>