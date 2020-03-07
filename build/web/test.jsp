<%-- 
    Document   : test
    Created on : Oct 15, 2019, 12:59:05 PM
    Author     : ASUS
--%>
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
                .block option
                {
                    font-size: 25px;
                }
                .block select
                {
                    font-size: 25px;
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
                .block table
                {
                    margin-top: 20px;
                    margin-left: 200px;
                }
                .block td
                {
                    padding-top: 10px;
                }
                .block input
                {
                    font-size: 30px;
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
          <a href="#" style="float: right; color: white; margin-top: -27px; text-decoration: none; margin-right: 10px; font-size: 25px;">Logout</a>
 	</div>
    
	<div class="block">
             <%@page import="java.sql.*" %>
             <form action="demo2.jsp" method="post">
        <%
            String edate=request.getParameter("edate");
            String dpt=request.getParameter("dpt");
            String sem=request.getParameter("sem");
            
                session.setAttribute("dpt", dpt);
                session.setAttribute("edate", edate);
                session.setAttribute("sem",sem);
                
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con=DriverManager.getConnection("Jdbc:oracle:thin:@localhost:1521:xe","system","123456789");
            PreparedStatement ps=con.prepareStatement("select status from exams where department=? and exam_date=? and semester=?");
            ps.setString(1, dpt);
            ps.setString(2, edate);
            ps.setString(3, sem);
            ResultSet rs=ps.executeQuery();
            try{rs.next();}catch(Exception e){response.sendRedirect("error.html");}
            if(rs.getString(1).equals("true"))
            {
                response.sendRedirect("view.jsp");
            }
            else
            {
                ps=con.prepareStatement("select room_no from rooms where dates != ?");
                ps.setString(1, edate);
                rs=ps.executeQuery();
                out.println("<table>");
                out.println("<tr><td><label>Please Select the Room No.</label></td><td><select name='room_no'> required");
                while(rs.next())
                {
                    out.println("<option>"+rs.getString(1)+"</option>");
                }
                out.println("</select></td></tr>");
            
            
                ps=con.prepareStatement("select name,staff_id from staffs where dates != ?");
                ps.setString(1, edate);
                rs=ps.executeQuery();
                out.println("<tr><td><label>Please Select staff</label></td><td><select name='staff_name'>");
                while(rs.next())
                {
                    out.println("<option>"+rs.getString(1)+","+rs.getString(2)+"</option>");
                }
                out.println("</select></td></tr>");
                
                
                ps=con.prepareStatement("select staff_id from staffs where dates != ?");
                ps.setString(1, edate);
                rs=ps.executeQuery();
                out.println("<tr><td><label>Please Select staff ID</label></td><td><select name='staff_id'>");
                while(rs.next())
                {
                    out.println("<option>"+rs.getString(1)+"</option>");
                }
                out.println("</select></td></tr>");
            }
  %>
        <tr><td><input type="reset" value="Cancel" /></td><td><input type="submit" value="Next" /></td></tr>
             </table>
        </form>
</body>
</html>
