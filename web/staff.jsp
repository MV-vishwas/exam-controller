
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
		height: 500px;
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
    <%
       if(session.getAttribute("user")==null)    
        response.sendRedirect("login.html");
    %>
    <div class="box">
          <h1 style="margin-left: 10px;padding-top: 10px">EXAM CONTROLLER</h1>
          <a href="logout.jsp" style="float: right; color: white; margin-top: -27px; text-decoration: none; margin-right: 10px; font-size: 25px;">Logout</a>
    </div>

    <div class="block">
        <form action="staffs" method="post">
		<table>
                    <tr><td><label>Staff Name</label></td><td><input type="text" name="sname" required></td></tr>
                        <tr><td><label>Staff ID</label></td><td><input type="text" name="staff_id" required></td></tr>
			<tr><td><label>Address</label></td><td><input type="text" name="address" required></td></tr>
			<tr><td><label>City</label></td><td><input type="text" name="city" required></td></tr>
			<tr><td><label>Mobile No.</label></td><td><input type="text" name="mobile_no" required></td></tr>
			<tr><td><label>Department</label></td><td><select name="dpt" style=" font-size: 25px;" required><option value="Computer Science">Computer Science</option><option value="Information Technology">Infotmation Technology</option><option value="Mechanical Engineering">Mechanical Engineering</option><option value="Electrical & Electronics Engineering">Electrical & Electronics Engineering</option><option value="Electronics & Communication Engineering">Electronics & Communication Engineering</option><option value="Civil Engineering">Civil Engineering</option><option value="Automobile Engineering">Automobile Engineering</option></select></td></tr>
			<tr><td><label>Email</label></td><td><input type="text" name="email" required></td></tr>
			<tr><td><label>Choose Image</label></td><td><input type="file" name="photo" required></td></tr>
			<tr><td><input type="submit" value="Submit"></td><td><input type="reset"  value="Reset"></td></tr>
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
        <h1 style=" text-align: center ;margin-top: 50px; text-decoration: underline;"> STAFFS RECORDS</h1>
        <div class="tab">
        <%@ page import="java.sql.*"%>
        <table border="1" align="center" style="margin-top: 20px;background-color: #ccffff ;width: 100%;height: auto">
                <tr>
                    <th>S No.</th>
                    <th>Staff ID</th>
                    <th>Name</th>
                    <th>Address</th>
                    <th>City</th>
                    <th>Mobile No.</th>
                    <th>Department</th>
                    <th>Email</th>
                </tr>
                <tbody style="text-align: center">
        <%
           	try
		{
                        int c=0;
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection("Jdbc:oracle:thin:@localhost:1521:xe","system","123456789");
			java.sql.Statement stmt=con.createStatement();
			ResultSet rs=stmt.executeQuery("select staff_id, name,address,city,mobile_no, department,email from staffs");
                        while(rs.next())
                        {
                            c++;
                            out.print("<tr><td>"+c+"</td><td>"+rs.getString(1)+"</td><td>"+rs.getString(2)+"</td><td>"+rs.getString(3)+"</td><td>"+rs.getString(4)+"</td><td>"+rs.getString(5)+"</td><td>"+rs.getString(6)+"</td><td>"+rs.getString(7)+"</td></tr>");
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
        <form action="delete_staff" method="POST" style=" margin-top: 20px; margin-left: 400px; font-size: 21px;">
            <label> Enter the Staff ID.</label> <input type="text" name="id" /> &nbsp;&nbsp;<input type="submit" value="Delete" />
        </form>
    
<div class="last"> Devloped & maintain by MR. MANAV VISHWAS,MR.DEEPAK KAREDIYA,MR.ROHIT RAJPUT</div>
</body>
</html>