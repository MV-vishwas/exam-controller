
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%@ page import="java.sql.*" %>
        <%
            try
		{
                        boolean flag=false;
                        String uname=request.getParameter("uname");
                        String upass=request.getParameter("upass");
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection("Jdbc:oracle:thin:@localhost:1521:xe","system","123456789");
			Statement stmt=con.createStatement();
			ResultSet rs=stmt.executeQuery("select username,password from shop_emp");
                        while(rs.next())
                        {
                           if(uname.equals(rs.getString(1)))
                            {
                                if(upass.equals(rs.getString(2)))
                                {
                                    session.setAttribute("user",uname);
                                    flag=true;
                                    response.sendRedirect("home.jsp");
                                    break;
                                }
                            }
                        }
                        con.close();
                        response.sendRedirect("login.html");
		}	
		catch(Exception e)
		{
                    out.print(e.toString());
		}
         %>   
    </body>
</html>

