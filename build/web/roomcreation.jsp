
<!DOCTYPE html>
<html>
<head>
	<title>room creation</title>
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
                padding-top: 100px;
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
        <form action="NewServlet" method="post">
		<table>
			<tr><td><label>Room No.</label></td><td><input type="Number" min="0" name="room_no"></td></tr>
			<tr><td><label>Floor</label></td><td><input type="Number" min="0" max="5" name="floor"></td></tr>
			<tr><td><label>No. of rows</label></td><td><input type="Number" min="0" name="nor"></td></tr>
			<tr><td><label>No. of columns</label></td><td><input type="Number" min="0" name="noc"></td></tr>
			<tr><td><label>Capacity</label></td><td><input type="Number" min="0" name="capacity"></td></tr>
			<tr><td><input type="submit" value="Submit" name="submit"></td><td><input type="reset" value="Reset"></td></tr>
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
    
    <h1 style=" text-align: center ;margin-top: 50px; text-decoration: underline;"> ROOMS RECORDS</h1>
    <div class="tab">
        <%@ page import="java.sql.*"%>
        <table border="1" align="center" style="margin-top: 20px;background-color: #ccffff ;width: 100%;height: auto">
                <tr>
                    <th>S No.</th>
                    <th>Room No.</th>
                    <th>Floor</th>
                    <th>No. of Rows</th>
                    <th>No. of column</th>
                    <th>Capacity</th>
                </tr>
                <tbody style="text-align: center">
        <%
           	try
		{
                        int c=0;
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection("Jdbc:oracle:thin:@localhost:1521:xe","system","123456789");
			java.sql.Statement stmt=con.createStatement();
			ResultSet rs=stmt.executeQuery("select * from rooms");
                        while(rs.next())
                        {
                            c++;
                            out.print("<tr><td>"+c+"</td><td>"+rs.getString(1)+"</td><td>"+rs.getString(2)+"</td><td>"+rs.getString(3)+"</td><td>"+rs.getString(4)+"</td><td>"+rs.getString(5)+"</td></tr>");
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
            <form action="delete_room" method="POST" style=" margin-top: 20px; margin-left: 450px;">
            <label style=" font-size: 21px; "> Enter the Room No.</label> <input type="text" name="room_no" /> &nbsp; <input type="submit" value="Delete" />
        </form>

    <div class="last">
        Devloped & maintain by MR. MANAV VISHWAS,MR.DEEPAK KAREDIYA,MR.ROHIT RAJPUT
    </div>
    
    
</body>
</html>