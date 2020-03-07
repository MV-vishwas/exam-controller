package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.*;

public final class test_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      response.setContentType("text/html");
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
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("<head>\n");
      out.write("\t<title>home page</title>\n");
      out.write("\t<style type=\"text/css\">\n");
      out.write("\t\t.box\n");
      out.write("\t\t{\n");
      out.write("\t\t\twidth: 100%;\n");
      out.write("\t\t\theight: 70px;\n");
      out.write("            background-color: #1f5183;\n");
      out.write("            color: white;\n");
      out.write("        \tborder-bottom: 2px solid whitesmoke;\n");
      out.write("        \tmargin-top: -18px;\n");
      out.write("\n");
      out.write("\t\t}\n");
      out.write("        body\n");
      out.write("        {\n");
      out.write("             padding: 0px;\n");
      out.write("             \n");
      out.write("        }\n");
      out.write("        .menu\n");
      out.write("        {\n");
      out.write("            width: 200px;\n");
      out.write("            height: 500px;\n");
      out.write("            background-color: #427cb6;\n");
      out.write("            margin-top: -20px;\n");
      out.write("            box-shadow: 5px 8px 16px 4px #1f5183;\n");
      out.write("        }\n");
      out.write("        body\n");
      out.write("\t\t{\n");
      out.write("\t\t\tmargin: 0;\n");
      out.write("\t\t\tpadding: 0;\n");
      out.write("\t\t}\n");
      out.write("\t\t.menu ul\n");
      out.write("\t\t{\n");
      out.write("\t\t\tlist-style: none;\n");
      out.write("\t\t\tmargin-left: 15px;\n");
      out.write("\t\t\tfont-size: 20px; \n");
      out.write("\t\t}\n");
      out.write("\t\t.menu ul li\n");
      out.write("\t\t{\n");
      out.write("\t\t\tpadding: 10px;\n");
      out.write("\t\t\tposition: relative;\n");
      out.write("\t\t\tbackground-color: #427cb6; \n");
      out.write("\t\t\tcolor: white;\n");
      out.write("\t\t\tborder-top: 1px solid whitesmoke;\n");
      out.write("\t\t\tmargin-left: -50px;\n");
      out.write("\t\t}\n");
      out.write("\t\t.menu ul li a\n");
      out.write("\t\t{\n");
      out.write("\t\t\ttext-decoration: none;\n");
      out.write("\t\t\tcolor: white;\n");
      out.write("\t\t}\n");
      out.write("\t\t.menu ul ul\n");
      out.write("\t\t{\n");
      out.write("\t\t\tvisibility: hidden;\n");
      out.write("\t\t\tposition: absolute;\n");
      out.write("\t\t\tmargin-left: 10px;\n");
      out.write("\t\t\tmargin-top: 0px;\n");
      out.write("\t\t}\n");
      out.write("\t\t.menu ul li:hover>ul\n");
      out.write("\t\t{\n");
      out.write("\t\t\tvisibility: visible;\n");
      out.write("\t\t\tposition: relative;\n");
      out.write("\t\t}\n");
      out.write("\t\t.menu ul li ul li\n");
      out.write("\t\t{\n");
      out.write("\t\t\tborder-top: 0px;\n");
      out.write("\t\t\tmargin-left: 10px;\n");
      out.write("\t\t\tlist-style: square;\n");
      out.write("\t\t}\n");
      out.write("\t\t.menu ul li:hover\n");
      out.write("\t\t{\n");
      out.write("\t\t\tbackground-color:#1f5183;\n");
      out.write("\t\t}\n");
      out.write("\t\t.block{\n");
      out.write("\t\t\tborder:2px solid #427cb6;\n");
      out.write("\t\t\tfloat: right;\n");
      out.write("\t\t\tmargin-right: 200px;\n");
      out.write("\t\t\tmargin-top: 2px;\n");
      out.write("\t\t\twidth:1000px;\n");
      out.write("\t\t\theight: 450px;\n");
      out.write("\t\t\tfont-size: 25px;\n");
      out.write("\t\t\t\n");
      out.write("\t\t}\n");
      out.write("                .block option\n");
      out.write("                {\n");
      out.write("                    font-size: 25px;\n");
      out.write("                }\n");
      out.write("                .block select\n");
      out.write("                {\n");
      out.write("                    font-size: 25px;\n");
      out.write("                }\n");
      out.write("\t\t.last{\n");
      out.write("\t\t\ttext-align: center;\n");
      out.write("\t\t\tfont-size: 20px;\n");
      out.write("\t\t\tbackground-color: #427cb6;\n");
      out.write("                        margin-top: -70px;\n");
      out.write("                        height: 40px;\n");
      out.write("                        padding-top: 20px;\n");
      out.write("                        box-shadow: 2px 5px #1f5183;\n");
      out.write("                        margin-top: 100px;\n");
      out.write("\t\t}\n");
      out.write("                .block table\n");
      out.write("                {\n");
      out.write("                    margin-top: 20px;\n");
      out.write("                    margin-left: 200px;\n");
      out.write("                }\n");
      out.write("                .block td\n");
      out.write("                {\n");
      out.write("                    padding-top: 10px;\n");
      out.write("                }\n");
      out.write("                .block input\n");
      out.write("                {\n");
      out.write("                    font-size: 30px;\n");
      out.write("                }\n");
      out.write("\t</style>\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("     <div class=\"box\">\n");
      out.write("          <h1 style=\"margin-left: 10px;padding-top: 10px\">EXAM CONTROLLER</h1>\n");
      out.write("          <a href=\"#\" style=\"float: right; color: white; margin-top: -27px; text-decoration: none; margin-right: 10px; font-size: 25px;\">Logout</a>\n");
      out.write(" \t</div>\n");
      out.write("\n");
      out.write("\t<div class=\"block\">\n");
      out.write("             \n");
      out.write("             <form action=\"demo2.jsp\" method=\"post\">\n");
      out.write("        ");

            String rdate=(String)session.getAttribute("edate");
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con=DriverManager.getConnection("Jdbc:oracle:thin:@localhost:1521:xe","system","123456789");
            PreparedStatement ps=con.prepareStatement("select room_no from rooms where rdate != ?");
            ps.setString(1, rdate);
            ResultSet rs=ps.executeQuery();
            out.println("<table>");
            out.println("<tr><td><label>Please Select the Room No.</label></td><td><select name='room_no'>");
            while(rs.next())
            {
                out.println("<option>"+rs.getString(1)+"</option>");
            }
            out.println("</select></td></tr>");
            ps=con.prepareStatement("select name from staffs where dates != ?");
            ps.setString(1, rdate);
            rs=ps.executeQuery();
            out.println("<tr><td><label>Please Select staff</label></td><td><select name='staff_name'>");
            while(rs.next())
            {
                out.println("<option>"+rs.getString(1)+"</option>");
            }
            out.println("</select></td></tr>");
        
      out.write("\n");
      out.write("        <tr><td><input type=\"reset\" value=\"Cancel\" /></td><td><input type=\"submit\" value=\"Next\" /></td></tr>\n");
      out.write("             </table>\n");
      out.write("        </form>\n");
      out.write("</body>\n");
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
