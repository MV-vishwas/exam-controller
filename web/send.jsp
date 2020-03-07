<%-- 
    Document   : send
    Created on : Oct 20, 2019, 5:24:55 PM
    Author     : ASUS
--%>

<%-- 
    Document   : hall_allocation
    Created on : Oct 14, 2019, 11:12:30 PM
    Author     : ASUS
--%>

<%@page import="java.sql.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>hall allocation</title>
        <style>
            th
            {
                font-size: 23px;
            }
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
                    <th>Seating</th>
                </tr>
                <tbody style="text-align: center">
        <%
            try
            {
                int c=0;
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con=DriverManager.getConnection("Jdbc:oracle:thin:@localhost:1521:xe","system","123456789");
		java.sql.Statement stmt=con.createStatement();
		ResultSet rs=stmt.executeQuery("select * from exams where status='true'");
                while(rs.next())
                {
                    c++;
                    out.print("<tr><td>"+c+"</td><td>"+rs.getString(1)+"</td><td>"+rs.getString(2)+"</td><td>"+rs.getString(3)+"</td><td>"+rs.getString(4)+"</td><td>"+rs.getString(5)+"</td><td>"+rs.getString(6)+"</td><td>"+rs.getString(7)+"</td>");
                    if(rs.getString(8).equals("false"))
                    {
                        out.println("<td>Incomplete</td></tr>");
                    }
                    else
                    {
                        out.println("<td>Complete</td></tr>");
                    }
                }
                con.close();
            }	
	    catch(Exception e)
	    {
                out.println(e);
            }   
            out.println("<form  action ='send_msg' method='post'></form>");
            
        %>
        </tbody>
        </table>
        <form action="send_msg" method="POST">
            <table style=" margin-left: 500px; margin-top: 20px;" >
            <tr><td><label style="font-size: 20px;">Enter the Department</label></td><td><select name="dpt" style=" font-size: 25px;" required><option value="Computer Science">Computer Science</option><option value="Information Technology">Infotmation Technology</option><option value="Mechanical Engineering">Mechanical Engineering</option><option value="Electrical & Electronics Engineering">Electrical & Electronics Engineering</option><option value="Electronics & Communication Engineering">Electronics & Communication Engineering</option><option value="Civil Engineering">Civil Engineering</option><option value="Automobile Engineering">Automobile Engineering</option></select></td></tr>
            <tr><td><label style="font-size: 20px;">Enter the Semester</label></td><td><input type="number" name="sem" max="8" min="1" style="font-size: 20px;" required></tr>
            <tr><td><label style="font-size: 20px;">Enter the Date</label></td><td><input type="date" name="edate" style="font-size: 20px;"></td></tr>
            <tr><td><input type="reset" value="Reset" style="font-size: 20px;"/></td><td><input type="submit" value="Submit" style="font-size: 20px;"/></td></tr>
            </table>
        </form>
    </body>
</html>
