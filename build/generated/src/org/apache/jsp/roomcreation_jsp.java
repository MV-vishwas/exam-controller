package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.*;

public final class roomcreation_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\t<title>room creation</title>\n");
      out.write("\t<style type=\"text/css\">\n");
      out.write("\t.box\n");
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
      out.write("        .menu\n");
      out.write("        {\n");
      out.write("            width: 200px;\n");
      out.write("            height: 500px;\n");
      out.write("            background-color: #427cb6;\n");
      out.write("            margin-top: -20px;\n");
      out.write("            box-shadow: 5px 8px 16px 4px #1f5183;\n");
      out.write("        }\n");
      out.write("        body\n");
      out.write("\t{\n");
      out.write("            margin: 0;\n");
      out.write("            padding: 0;\n");
      out.write("\t}\n");
      out.write("\t.menu ul\n");
      out.write("\t{\n");
      out.write("\t\tlist-style: none;\n");
      out.write("\t\tmargin-left: 15px;\n");
      out.write("\t\tfont-size: 20px; \n");
      out.write("\t}\n");
      out.write("\t.menu ul li\n");
      out.write("\t{\n");
      out.write("\t\tpadding: 10px;\n");
      out.write("\t\tposition: relative;\n");
      out.write("\t\tbackground-color: #427cb6; \n");
      out.write("\t\tcolor: white;\n");
      out.write("\t\tborder-top: 1px solid whitesmoke;\n");
      out.write("\t\tmargin-left: -50px;\n");
      out.write("\t}\n");
      out.write("\t.menu ul li a\n");
      out.write("\t{\n");
      out.write("\t\ttext-decoration: none;\n");
      out.write("\t\tcolor: white;\n");
      out.write("\t}\n");
      out.write("\t.menu ul ul\n");
      out.write("\t{\n");
      out.write("\t\tvisibility: hidden;\n");
      out.write("\t\tposition: absolute;\n");
      out.write("\t\tmargin-left: 10px;\n");
      out.write("\t\tmargin-top: 0px;\n");
      out.write("\t}\n");
      out.write("\t.menu ul li:hover>ul\n");
      out.write("\t{\n");
      out.write("\t\tvisibility: visible;\n");
      out.write("\t\tposition: relative;\n");
      out.write("\t}\n");
      out.write("\t.menu ul li ul li\n");
      out.write("\t{\n");
      out.write("\t\tborder-top: 0px;\n");
      out.write("\t\tmargin-left: 10px;\n");
      out.write("\t\tlist-style: square;\n");
      out.write("\t}\n");
      out.write("\t.menu ul li:hover\n");
      out.write("\t{\n");
      out.write("\t\tbackground-color:#1f5183;\n");
      out.write("\t}\n");
      out.write("\t.block{\n");
      out.write("                background-color: #ffffcc;\n");
      out.write("\t\tborder:2px solid #427cb6;\n");
      out.write("\t\tfloat: right;\n");
      out.write("\t\tmargin-right: 200px;\n");
      out.write("\t\tmargin-top: 2px;\n");
      out.write("\t\twidth:1000px;\n");
      out.write("\t\theight: 500px;\n");
      out.write("\t\tfont-size: 25px;\n");
      out.write("                align-content: center;\n");
      out.write("                box-shadow: 5px 5px 12px 0px #330033;\n");
      out.write("\t}\n");
      out.write("\t.block \ttd\n");
      out.write("\t{\n");
      out.write("                font-size: 30px;\n");
      out.write("                padding-top: 10px;\n");
      out.write("\t}\n");
      out.write("\t.block td input{\n");
      out.write("\t\tfont-size: 28px;\n");
      out.write("\t}\n");
      out.write("\t.block form\n");
      out.write("        {\n");
      out.write("                padding-left: 220px;\n");
      out.write("                padding-top: 100px;\n");
      out.write("        }\n");
      out.write("\t.last{\n");
      out.write("                text-align: center;\n");
      out.write("\t\tfont-size: 20px;\n");
      out.write("                background-color: #427cb6;\n");
      out.write("                margin-top: -70px;\n");
      out.write("                height: 40px;\n");
      out.write("                padding-top: 20px;\n");
      out.write("                box-shadow: 2px 5px #1f5183;\n");
      out.write("                margin-top: 100px;\n");
      out.write("\t}\n");
      out.write("        .tab th{font-size: 25px;}\n");
      out.write("        .tab td{font-size: 20px;}\n");
      out.write("        form input{font-size: 21px;}\n");
      out.write("\t</style>\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("    ");

       if(session.getAttribute("user")==null)    
        response.sendRedirect("login.html");
    
      out.write("\n");
      out.write("    <div class=\"box\">\n");
      out.write("          <h1 style=\"margin-left: 10px;padding-top: 10px\">EXAM CONTROLLER</h1>\n");
      out.write("          <a href=\"view.jsp\" style=\"float: right; color: white; margin-top: -27px; text-decoration: none; margin-right: 10px; font-size: 25px;\">Logout</a>\n");
      out.write("    </div>\n");
      out.write("\n");
      out.write("    \n");
      out.write("    \n");
      out.write("    <div class=\"block\">\n");
      out.write("        <form action=\"NewServlet\" method=\"post\">\n");
      out.write("\t\t<table>\n");
      out.write("\t\t\t<tr><td><label>Room No.</label></td><td><input type=\"Number\" min=\"0\" name=\"room_no\"></td></tr>\n");
      out.write("\t\t\t<tr><td><label>Floor</label></td><td><input type=\"Number\" min=\"0\" max=\"5\" name=\"floor\"></td></tr>\n");
      out.write("\t\t\t<tr><td><label>No. of rows</label></td><td><input type=\"Number\" min=\"0\" name=\"nor\"></td></tr>\n");
      out.write("\t\t\t<tr><td><label>No. of columns</label></td><td><input type=\"Number\" min=\"0\" name=\"noc\"></td></tr>\n");
      out.write("\t\t\t<tr><td><label>Capacity</label></td><td><input type=\"Number\" min=\"0\" name=\"capacity\"></td></tr>\n");
      out.write("\t\t\t<tr><td><input type=\"submit\" value=\"Submit\" name=\"submit\"></td><td><input type=\"reset\" value=\"Reset\"></td></tr>\n");
      out.write("\t\t</table>\n");
      out.write("\t</form>\n");
      out.write("    </div>\n");
      out.write("    <div class=\"menu\">\n");
      out.write(" \t<ul>\n");
      out.write(" \t\t<li><a href=\"home.html\">Dashboard</a></li>\n");
      out.write(" \t\t<li>Master Creation\n");
      out.write(" \t\t\t<ul>\n");
      out.write(" \t\t\t\t<li><a href=\"student.jsp\">Student Details</a></li>\n");
      out.write(" \t\t\t\t<li><a href=\"staff.jsp\">Staff Details</a></li>\n");
      out.write(" \t\t\t\t<li><a href=\"roomcreation.jsp\">Room Creation</a></li>\n");
      out.write(" \t\t\t</ul>\n");
      out.write(" \t\t</li>\n");
      out.write(" \t\t<li style=\"border-bottom: 1px solid whitesmoke;\">Exam Allocation\n");
      out.write(" \t\t\t<ul>\n");
      out.write(" \t\t\t\t<li><a href=\"#\">xxx</a></li>\n");
      out.write(" \t\t\t\t<li><a href=\"#\">yyy</a></li>\n");
      out.write(" \t\t\t\t<li><a href=\"#\">zzz</a></li>\n");
      out.write(" \t\t\t</ul>\n");
      out.write(" \t\t</li>\n");
      out.write(" \t</ul>\n");
      out.write("    </div>\n");
      out.write("    \n");
      out.write("    <h1 style=\" text-align: center ;margin-top: 50px; text-decoration: underline;\"> ROOMS RECORDS</h1>\n");
      out.write("    <div class=\"tab\">\n");
      out.write("        \n");
      out.write("        <table border=\"1\" align=\"center\" style=\"margin-top: 20px;background-color: #ccffff ;width: 100%;height: auto\">\n");
      out.write("                <tr>\n");
      out.write("                    <th>S No.</th>\n");
      out.write("                    <th>Room No.</th>\n");
      out.write("                    <th>Floor</th>\n");
      out.write("                    <th>No. of Rows</th>\n");
      out.write("                    <th>No. of column</th>\n");
      out.write("                    <th>Capacity</th>\n");
      out.write("                </tr>\n");
      out.write("                <tbody style=\"text-align: center\">\n");
      out.write("        ");

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
        
      out.write("\n");
      out.write("        </tbody>\n");
      out.write("        </table>\n");
      out.write("            <form action=\"delete_room\" method=\"POST\" style=\" margin-top: 20px; margin-left: 450px;\">\n");
      out.write("            <label style=\" font-size: 21px; \"> Enter the Room No.</label> <input type=\"text\" name=\"room_no\" /> &nbsp; <input type=\"submit\" value=\"Delete\" />\n");
      out.write("        </form>\n");
      out.write("\n");
      out.write("    <div class=\"last\">\n");
      out.write("        Devloped & maintain by MR. MANAV VISHWAS,MR.DEEPAK KAREDIYA,MR.ROHIT RAJPUT\n");
      out.write("    </div>\n");
      out.write("    \n");
      out.write("    \n");
      out.write("</body>\n");
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
