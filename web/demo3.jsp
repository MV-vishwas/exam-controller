<%-- 
    Document   : demo3
    Created on : Oct 14, 2019, 8:44:30 PM
    Author     : ASUS
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
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
        .token td
        {
            font-size: 25px;
            text-align: center;
        }
        .token input
        {
            font-size: 30px;
        }
        .token select
        {
           width: 200px;
          font-size: 25px;   
        }
        .token option
        {
            font-size: 25px;
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
            String room_no = request.getParameter("room_no");
            String staff_id = request.getParameter("staff_id");
            String dpt = (String) session.getAttribute("dpt");
            String sem = (String) session.getAttribute("sem");
            String edate = (String) session.getAttribute("edate");
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con=DriverManager.getConnection("Jdbc:oracle:thin:@localhost:1521:xe","system","123456789");
            PreparedStatement ps=con.prepareStatement("update staffs set dates=? where staff_id=?");
            ps.setString(1, edate);
            ps.setString(2, staff_id);
            ps.executeUpdate();
            
            ps=con.prepareStatement("update rooms set dates=? where room_no=?");
            ps.setString(1, edate);
            ps.setString(2, room_no);
            ps.executeUpdate();
            
            ps=con.prepareStatement("select * from rooms where room_no=?");
            ps.setString(1, room_no);
            ResultSet rs=ps.executeQuery();
            rs.next();
            int floor=rs.getInt(2);
            int nor=rs.getInt(3);
            int noc=rs.getInt(4);
            int cap=rs.getInt(5);
            
            ps=con.prepareStatement("select subject,year from exams where exam_date=? and department=? and semester=? ");
            ps.setString(1,edate);
            ps.setString(2, dpt);
            ps.setString(3,sem);
            rs=ps.executeQuery();
        
            rs.next();
            out.println("<table>");
            out.println("<tr><td>Branch</td><td>"+dpt+"</td>                  <td>Room No.</td><td>"+room_no+"</td></tr>");
            out.println("<tr><td>Subject</td><td>"+rs.getString(1)+"</td>	<td>Date</td><td>"+edate+"</td></tr>");
            out.println("<tr><td>Year/Semester</td><td>"+rs.getString(2)+"/"+sem+"</td>         <td>Total Capcity</td><td>"+cap+"</td></tr>");
            out.println("</table>");
        
        
        %>


        <table style="border: 1px solid black ; border-collapse: collapse ;margin-top: 30px; height: 300px;">
       
               <%
                   for(int i=0;i<noc;i++)
                        out.println("<th>C"+(i+1)+"</th>");
                   int size=(int)session.getAttribute("size");
                   int count=(int)session.getAttribute("count");
                   int c=0;
                   ps=con.prepareStatement("select roll_no from students where semster=? and branch=? and room_no=0 order by roll_no asc");
                   ps.setString(1, sem);
                   ps.setString(2, dpt);
                   rs=ps.executeQuery();
                   
                   for(int i=0;i<nor;i++)
                   {
                      out.println("<tr>");
                      for(int j=0;j<noc;j++)
                      {
                          if(i%2==0)
                          {
                            if(j%2==0 && count!=size)
                            {
                                  rs.next();
                                  String roll_no=rs.getString("roll_no");
                                  out.println("<td>"+roll_no+"</td>");
                                  count++;
                                  c++;
                                  ps=con.prepareStatement("update students set room_no=? , col=?,ro=? where roll_no=?");
                                  ps.setString(1, room_no);
                                  ps.setInt(2, j+1);
                                  ps.setInt(3, i+1);
                                  ps.setString(4, roll_no);
                                  ps.executeUpdate();
                            }
                            else
                                  out.println("<td>none</td>");
                          }
                          else
                          {
                            if(j%2!=0 && count!=size)
                            {
                                  rs.next();
                                  String roll_no=rs.getString(1);
                                  out.println("<td>"+roll_no+"</td>");
                                  count++;
                                  c++;
                                  ps=con.prepareStatement("update students set room_no=? , col=?,ro=? where roll_no=?");
                                  ps.setString(1, room_no);
                                  ps.setInt(2, j+1);
                                  ps.setInt(3, i+1);
                                  ps.setString(4, roll_no);
                                  ps.executeUpdate();
                            }
                            else
                                  out.println("<td>none</td>");
                          }
                      }
                       out.println("</tr>");
                   }
                   out.println("</table>");       
                   out.println("<table style='height:40px;'><tr><td>Total Students:  "+c+"</td></tr></table></div>");
                   



                   out.println("<div class='token'>");
                   out.println("<form action='demo3.jsp' method='post'>");
                   if(size!=count)
                   {
                        ps=con.prepareStatement("insert into subexams values(?,?,?,?,?)");
                        ps.setString(1,edate);
                        ps.setString(2, dpt);
                        ps.setString(3, sem);
                        ps.setString(4, staff_id);
                        ps.setString(5, room_no);
                        ps.executeQuery();
                        String rdate=(String)session.getAttribute("edate");
                        ps=con.prepareStatement("select room_no from rooms where dates != ?");
                        ps.setString(1, rdate);
                        ResultSet rs1=ps.executeQuery();
                        out.println("<table>");
                        out.println("<tr><td><label>Please Select the Room No.</label></td><td><select name='room_no'>");
                        while(rs1.next())
                        {
                            out.println("<option>"+rs1.getString(1)+"</option>");
                        }
                        out.println("</select></td></tr>");
                        ps=con.prepareStatement("select name from staffs where dates != ?");
                        ps.setString(1, rdate);
                        rs1=ps.executeQuery();
                        out.println("<tr><td><label>Please Select staff</label></td><td><select name='staff_name'>");
                        while(rs1.next())
                        {
                               out.println("<option>"+rs1.getString(1)+"</option>");
                        }
                        out.println("</select></td></tr>");
                        out.println("<tr><td colspan='2'><input  type = 'submit' value = 'next' /></td></tr>");
                        session.setAttribute("count", count);
                        session.setAttribute("size",size);
                        out.println("</form>");
                   }
                   else
                   {
                        ps = con.prepareStatement("update exams set status='true' where exam_date=? and department=? and semester=?");
                        ps.setString(1, edate);
                        ps.setString(2, dpt);
                        ps.setString(3, sem);
                        ps.executeUpdate();
                        ps=con.prepareStatement("insert into subexams values(?,?,?,?,?)");
                        ps.setString(1,edate);
                        ps.setString(2, dpt);
                        ps.setString(3, sem);
                        ps.setString(4, staff_id);
                        ps.setString(5, room_no);
                        ps.executeQuery();
                        out.println("<a href='home.jsp'>Dashboard</a>");
                }
                   con.close(); 
               %> 
        </table>
        </div>
        
        
        
        
    </body>
</html>
