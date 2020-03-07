package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.*;

public final class demo2_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>JSP Page</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <div class=\"box\">\n");
      out.write("          <h1 style=\"margin-left: 10px;padding-top: 10px\">EXAM CONTROLLER</h1>\n");
      out.write("          <a href=\"#\" style=\"float: right; color: white; margin-top: -27px; text-decoration: none; margin-right: 10px; font-size: 25px;\">Logout</a>\n");
      out.write("        </div>\n");
      out.write("        \n");
      out.write("        ");

            String room_no = request.getParameter("room_no");
            String staff_id = request.getParameter("staff_id");
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con = DriverManager.getConnection("Jdbc:oracle:thin:@localhost:1521:xe", "system", "123456789");
            String edate = (String) session.getAttribute("edate");
            
            //set date for staff.
            PreparedStatement ps = con.prepareStatement("update staffs set dates=? where staff_id=?");
            ps.setString(1, edate);
            ps.setString(2, staff_id);
            ps.executeUpdate();
            //set date for room
            ps = con.prepareStatement("update rooms set dates=? where room_no=?");
            ps.setString(1, edate);
            ps.setString(2, room_no);
            ps.executeUpdate();
            //getting room information
            ps = con.prepareStatement("select * from rooms where room_no=?");
            ps.setString(1, room_no);
            ResultSet rs = ps.executeQuery();
            rs.next();
            int floor = rs.getInt(2);
            int nor = rs.getInt(3);
            int noc = rs.getInt(4);
            int cap = rs.getInt(5);
            out.println(floor + "," + nor + "," + noc + "," + cap);
        
      out.write("\n");
      out.write("        <table style=\"border: 1px solid black ; border-collapse: collapse\">\n");
      out.write("            ");

                String dpt = (String) session.getAttribute("dpt");
                String sem = (String) session.getAttribute("sem");
                ps = con.prepareStatement("select roll_no from students where room_no=0 and branch=? and semster=? ");
                ps.setString(1, dpt);
                ps.setString(2, sem);
                rs = ps.executeQuery();
                int size = 0;
                while (rs.next()) 
                {
                    size++;
                }
                
                rs = ps.executeQuery();
                int count = 0;
                for (int i = 0; i < nor; i++) 
                {
                    out.println("<tr>");
                    for (int j = 0; j < noc; j++) 
                    {
                        if (i % 2 == 0) 
                        {
                            if (j % 2 == 0 && count != size) 
                            {
                                rs.next();
                                String roll_no = rs.getString(1);
                                out.println("<td>" + roll_no + "</td>");
                                count++;
                                ps = con.prepareStatement("update students set room_no=? , col=?,ro=? where roll_no=?");
                                ps.setString(1, room_no);
                                ps.setInt(2, i + 1);
                                ps.setInt(3, j + 1);
                                ps.setString(4, roll_no);
                                ps.executeUpdate();
                            }
                            else 
                            {
                                out.println("<td>none</td>");
                            }
                        } 
                        else
                        {
                            if (j % 2 != 0 && count != size) 
                            {
                                rs.next();
                                String roll_no = rs.getString(1);
                                out.println("<td>" + roll_no + "</td>");
                                count++;
                                ps = con.prepareStatement("update students set room_no=? , col=?,ro=? where roll_no=?");
                                ps.setString(1, room_no);
                                ps.setInt(2, i + 1);
                                ps.setInt(3, j + 1);
                                ps.setString(4, roll_no);
                                ps.executeUpdate();
                            }
                            else 
                            {
                                out.println("<td>none</td>");
                            }
                        }
                    }
                    out.println("</tr>");
                }
                out.println("<form action='demo3.jsp' method='post'>");
                if (size != count) 
                {
                    edate = (String) session.getAttribute("edate");
                    ps = con.prepareStatement("select room_no from rooms where dates != ?");
                    ps.setString(1, edate);
                    ResultSet rs1 = ps.executeQuery();
                    out.println("<table>");
                    out.println("<tr><td><label>Please Select the Room No.</label></td><td><select name='room_no'>");
                    while (rs1.next()) 
                    {
                        out.println("<option>" + rs1.getString(1) + "</option>");
                    }
                    out.println("</select></td></tr>");
                    ps = con.prepareStatement("select name,staff_id from staffs where dates != ?");
                    ps.setString(1, edate);
                    rs = ps.executeQuery();
                    out.println("<tr><td><label>Please Select staff</label></td><td><select name='staff_name'>");
                    while (rs.next()) 
                    {
                        out.println("<option>" + rs.getString(1) + "," + rs.getString(2) + "</option>");
                    }
                    out.println("</select></td></tr>");

                    ps = con.prepareStatement("select staff_id from staffs where dates != ?");
                    ps.setString(1, edate);
                    rs = ps.executeQuery();
                    out.println("<tr><td><label>Please Select staff ID</label></td><td><select name='staff_id'>");
                    while (rs.next()) 
                    {
                        out.println("<option>" + rs.getString(1) + "</option>");
                    }
                    out.println("</select></td></tr>");
                    out.println("<input  type = 'submit' value = 'next' />");
                    session.setAttribute("count", count);
                    session.setAttribute("size", size);
                    out.println("</form>");
                }
                else 
                {
                    ps = con.prepareStatement("update exams set status='true',staff_id=?,room_no=? where exam_date=? and department=? & semester=?");
                    ps.setString(1, staff_id);
                    ps.setString(2, room_no);
                    ps.setString(3, edate);
                    ps.setString(4, dpt);
                    ps.setString(5, sem);
                                     ///////////////////////
                }
            
      out.write(" \n");
      out.write("        </table>\n");
      out.write("    </body>\n");
      out.write("</html>");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
