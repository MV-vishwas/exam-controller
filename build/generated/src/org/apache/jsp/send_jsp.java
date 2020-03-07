package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.*;

public final class send_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write('\n');
      out.write('\n');
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>hall allocation</title>\n");
      out.write("        <style>\n");
      out.write("            th\n");
      out.write("            {\n");
      out.write("                font-size: 23px;\n");
      out.write("            }\n");
      out.write("        .box\n");
      out.write("\t{\n");
      out.write("            width: 100%;\n");
      out.write("            height: 70px;\n");
      out.write("            background-color: #1f5183;\n");
      out.write("            color: white;\n");
      out.write("            border-bottom: 2px solid whitesmoke;\n");
      out.write("            margin-top: -18px;\n");
      out.write("\t}\n");
      out.write("        body\n");
      out.write("        {\n");
      out.write("             padding: 0px;\n");
      out.write("        }\n");
      out.write("        </style>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        ");

       if(session.getAttribute("user")==null)    
        response.sendRedirect("login.html");
       
      out.write("\n");
      out.write("        <div class=\"box\">\n");
      out.write("            <h1 style=\"margin-left: 10px;padding-top: 10px\">EXAM CONTROLLER</h1>\n");
      out.write("            <a href=\"logout.jsp\" style=\"float: right; color: white; margin-top: -27px; text-decoration: none; margin-right: 10px; font-size: 25px;\">Logout</a>\n");
      out.write("        </div>\n");
      out.write("        <table border=\"1\" align=\"center\" style=\"margin-top: 20px;background-color: #ccffff ;width: 100%;height: auto\">\n");
      out.write("                <tr>\n");
      out.write("                    <th>S.No</th>\n");
      out.write("                    <th>Exam Date</th>\n");
      out.write("                    <th>Exam Type</th>\n");
      out.write("                    <th>Subject</th>\n");
      out.write("                    <th>Subject Code</th>\n");
      out.write("                    <th>Department</th>\n");
      out.write("                    <th>Year</th>\n");
      out.write("                    <th>Semester</th>\n");
      out.write("                    <th>Seating</th>\n");
      out.write("                </tr>\n");
      out.write("                <tbody style=\"text-align: center\">\n");
      out.write("        ");

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
            
        
      out.write("\n");
      out.write("        </tbody>\n");
      out.write("        </table>\n");
      out.write("        <form action=\"test.jsp\" method=\"POST\">\n");
      out.write("            <table style=\" margin-left: 500px; margin-top: 20px;\" >\n");
      out.write("            <tr><td><label style=\"font-size: 20px;\">Enter the Department</label></td><td><select name=\"dpt\" style=\" font-size: 25px;\" required><option value=\"Computer Science\">Computer Science</option><option value=\"Information Technology\">Infotmation Technology</option><option value=\"Mechanical Engineering\">Mechanical Engineering</option><option value=\"Electrical & Electronics Engineering\">Electrical & Electronics Engineering</option><option value=\"Electronics & Communication Engineering\">Electronics & Communication Engineering</option><option value=\"Civil Engineering\">Civil Engineering</option><option value=\"Automobile Engineering\">Automobile Engineering</option></select></td></tr>\n");
      out.write("            <tr><td><label style=\"font-size: 20px;\">Enter the Semester</label></td><td><input type=\"number\" name=\"sem\" max=\"8\" min=\"1\" style=\"font-size: 20px;\" required></tr>\n");
      out.write("            <tr><td><label style=\"font-size: 20px;\">Enter the Date</label></td><td><input type=\"date\" name=\"edate\" style=\"font-size: 20px;\"></td></tr>\n");
      out.write("            <tr><td><input type=\"reset\" value=\"Reset\" style=\"font-size: 20px;\"/></td><td><input type=\"submit\" value=\"Submit\" style=\"font-size: 20px;\"/></td></tr>\n");
      out.write("            </table>\n");
      out.write("        </form>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
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
