<%-- 
    Document   : view
    Created on : Oct 19, 2019, 1:03:14 PM
    Author     : ASUS
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>view </title>
        <style>
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
        .block
        {   margin-top: 10px;
            width: auto;
            height: auto;
            background-color: yellow;
        }
        .block table
        {
            width: 100%;
            height: 150px;
            text-align: center;
            font-size: 20px;
            
        }
        .block td
        {
            border: 1px solid black;
            border-collapse: collapse;
        }
        .token table
        {
            border: 1px solid #003399;
            width: 500px;
            height: auto;
            margin-left: 450px;
            margin-top: 10px;
            align-items: center;
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
        <%
            String dpt = (String) session.getAttribute("dpt");
            String sem = (String) session.getAttribute("sem");
            String edate = (String) session.getAttribute("edate");
            int size = (int) session.getAttribute("size");
            int count = (int) session.getAttribute("count");
            
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con = DriverManager.getConnection("Jdbc:oracle:thin:@localhost:1521:xe", "system", "123456789");
            
            
            PreparedStatement ps = con.prepareStatement("select room_no,staff_id from subexams where edate=? and dpt=? and sem=?");
            ps.setString(1, edate);
            ps.setString(2, dpt);
            ps.setString(3, sem);
            ResultSet rs=ps.executeQuery();
            int c=0;
            rs.next();
            while( c != count )
            {
                rs.next();
                c++;
            }
            count++;
            String room_no=rs.getString(1);
            String staff_id=rs.getString(2);
            
            //getting room information
            ps = con.prepareStatement("select * from rooms where room_no=?");
            ps.setString(1, room_no);
            rs = ps.executeQuery();
            rs.next();
            int floor = rs.getInt(2);
            int nor = rs.getInt(3);
            int noc = rs.getInt(4);
            int cap = rs.getInt(5);
            
            ps=con.prepareStatement("select subject,year,stime,otime from exams where exam_date=? and department=? and semester=? ");
            ps.setString(1,edate);
            ps.setString(2, dpt);
            ps.setString(3,sem);
            rs=ps.executeQuery();
            
            rs.next();
            out.println("<table>");
            out.println("<tr><td>Branch</td><td>"+dpt+"</td>                  <td>Room No.</td><td>"+room_no+"</td></tr>");
            out.println("<tr><td>Subject</td><td>"+rs.getString(1)+"</td>	<td>Date</td><td>"+edate+"</td></tr>");
            out.println("<tr><td>Year/Semester</td><td>"+rs.getString(2)+"/"+sem+"</td>         <td>Total Capcity</td><td>"+cap+"</td></tr>");
            out.println("<tr><td>Time</td><td>"+rs.getString(3)+" to "+rs.getString(4)+"</td>                  <td>Staff ID</td><td>"+staff_id+"</td></tr>");
            out.println("</table>");
        
        %>
        <table style="border: 1px solid black ; border-collapse: collapse ;margin-top: 30px; height: 300px;">
            
            <%
                for(int i=0;i<noc;i++)
                    out.println("<th>C"+(i+1)+"</th>");
                ps = con.prepareStatement("select roll_no , ro , col from students where room_no=? order by ro asc,col asc");
                ps.setString(1, room_no);
                rs = ps.executeQuery();
                int x=0,y=0;
                while(rs.next()){x++;}
                rs=ps.executeQuery();
                rs.next();
                for (int i = 1; i <= nor; i++) 
                {
                    out.println("<tr>");
                    for(int j=1; j<=noc;j++)
                    {
                        if(rs.getInt(2)==i && rs.getInt(3)==j)
                        {
                            out.println("<td>"+rs.getString(1)+"</td>");
                            y++;
                            if(y!=x)
                                rs.next();
                        }
                        else
                        {
                            out.println("<td>None</td>");
                        }
                    }
                    out.println("</tr>");
                }
                
                out.println("</table>");
                out.println("<table style='height:40px;'><tr><td>Total Students:  "+y+"</td></tr></table></div>");
                
                
                
                if (size != count) 
                {
                    out.println("<form action='view2.jsp' method='post'>");
                    session.setAttribute("size", size);
                    session.setAttribute("count",count);
                    out.println("<input type='submit' value='Next'>");
                    out.println("</form>");
                }
                else
                {
                    out.println("<a href='home.jsp'>Dashboard</a>");
                }
            %> 
        
    </body>
</html> 