package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.*;

public final class student_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("        <title>student details</title>\n");
      out.write("        \t<style type=\"text/css\">\n");
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
      out.write("\t\tmargin: 0;\n");
      out.write("\t\tpadding: 0;\n");
      out.write("\t}\n");
      out.write("\t.menu ul\n");
      out.write("\t{\n");
      out.write("\t\tlist-style: none;\n");
      out.write("\t\tmargin-left: 15px;\n");
      out.write("\t\tfont-size: 20px; \n");
      out.write("\t}\n");
      out.write("        .menu ul li\n");
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
      out.write("            border-top: 0px;\n");
      out.write("            margin-left: 10px;\n");
      out.write("            list-style: square;\n");
      out.write("\t}\n");
      out.write("\t.menu ul li:hover\n");
      out.write("\t{\n");
      out.write("\t\tbackground-color:#1f5183;\n");
      out.write("\t}\n");
      out.write("\t.block{\n");
      out.write("                background-color: #ffffcc;\n");
      out.write("\t\tborder:2px solid #427cb6;\n");
      out.write("\t\tfloat: right;\n");
      out.write("\t\tmargin-right: 120px;\n");
      out.write("\t\tmargin-top: 2px;\n");
      out.write("\t\twidth:1000px;\n");
      out.write("                height: 500px;\n");
      out.write("\t\tfont-size: 25px;\n");
      out.write("                align-content: center;\n");
      out.write("                box-shadow: 5px 5px 12px 0px #330033;\n");
      out.write("\t}\n");
      out.write("\t.block \ttd\n");
      out.write("\t{\n");
      out.write("                font-size: 30px;\n");
      out.write("                padding: 2px;\n");
      out.write("\t}\n");
      out.write("\t.block td input{\n");
      out.write("\t\tfont-size: 28px;\n");
      out.write("\t}\n");
      out.write("\t.last{\n");
      out.write("\t\ttext-align: center;\n");
      out.write("\t\tfont-size: 20px;\n");
      out.write("\t\tbackground-color: #427cb6;\n");
      out.write("                margin-top: -70px;\n");
      out.write("                height: 40px;\n");
      out.write("                padding-top: 20px;\n");
      out.write("                box-shadow: 2px 5px #1f5183;\n");
      out.write("                margin-top: 50px;\n");
      out.write("\t}\n");
      out.write("\t.block form{\n");
      out.write("                padding-left: 220px;\n");
      out.write("                padding-top: 50px;\t\t\t\n");
      out.write("\t}\n");
      out.write("        .tab th{font-size: 25px;}\n");
      out.write("        .tab td{font-size: 20px;}\n");
      out.write("        form input{font-size: 21px;}\n");
      out.write("        </style>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        \n");
      out.write("    ");

       if(session.getAttribute("user")==null)    
        response.sendRedirect("login.html");
    
      out.write("\n");
      out.write("          <div class=\"box\">\n");
      out.write("          <h1 style=\"margin-left: 10px;padding-top: 10px\">EXAM CONTROLLER</h1>\n");
      out.write("          <a href=\"logout.jsp\" style=\"float: right; color: white; margin-top: -27px; text-decoration: none; margin-right: 10px; font-size: 25px;\">Logout</a>\n");
      out.write("    </div>\n");
      out.write("\n");
      out.write("    \n");
      out.write("    <div class=\"block\">\n");
      out.write("        <form action=\"students\" method=\"post\">\n");
      out.write("\t\t<table>\n");
      out.write("                    <tr><td><label>Name*</label></td><td><input type=\"text\" name=\"name\" required></td></tr>\n");
      out.write("\t\t<tr><td><label>Branch*</label></td><td><select name=\"branch\" style=\" font-size: 25px;\" required><option value=\"Computer Science\">Computer Science</option><option value=\"Information Technology\">Infotmation Technology</option><option value=\"Mechanical Engineering\">Mechanical Engineering</option><option value=\"Electrical & Electronics Engineering\">Electrical & Electronics Engineering</option><option value=\"Electronics & Communication Engineering\">Electronics & Communication Engineering</option><option value=\"Civil Engineering\">Civil Engineering</option><option value=\"Automobile Engineering\">Automobile Engineering</option></select></td></tr>\n");
      out.write("\t\t<tr><td><label>Branch code*</label></td><td><select name=\"branch_code\" style=\" font-size: 25px;\" required> <option value=\"CS\">CS</option><option value=\"IT\">IT</option><option value=\"ME\">ME</option><option value=\"EX\">EX</option><option value=\"EC\">EC</option><option value=\"CE\">CE</option><option value=\"AU\">AU</option></select></td></tr>\n");
      out.write("\t\t<tr><td><label>Year*</label></td><td><select name=\"year\" style=\" font-size: 25px;\" required> <option value=\"1 Year\">1 Year</option><option value=\"2 Year\">2 Year</option><option value=\"3 Year\">3 Year</option><option value=\"4 Year\">4 Year</option></select></td></tr>\n");
      out.write("                <tr><td><label>Semester*</label></td><td><input type=\"number\" name=\"sem\" min=\"1\" max=\"8\"/></td></tr>\n");
      out.write("                <tr><td><label>Address*</label></td><td><input type=\"text\" name=\"add\" required/></td></tr>\n");
      out.write("                <tr><td><label>Mobile No.*</label></td><td><input type=\"tel\" name=\"phone\" pattern=\"[0-9]{10}\"  required><td></tr>\n");
      out.write("                <tr><td><label>Date of Birth*</label></td><td><input type=\"date\" name=\"dob\" max=\"2000-12-31\" min=\"1950-01-01\"  required><td></tr>\n");
      out.write("                <tr><td><label>Email*</label></td><td><input type=\"email\" name=\"email\" required><td></tr>\n");
      out.write("               <tr><td><input type=\"submit\"  value=\"Submit\"></td><td><input type=\"reset\" value=\"Reset\"></td></tr>\n");
      out.write("        </table>\t\n");
      out.write("        </form>\n");
      out.write("        \n");
      out.write("    </div>\n");
      out.write("\n");
      out.write("    \n");
      out.write("    <div class=\"menu\">\n");
      out.write(" \t<ul>\n");
      out.write(" \t\t<li><a href=\"home.jsp\">Dashboard</a></li>\n");
      out.write(" \t\t<li>Master Creation\n");
      out.write(" \t\t\t<ul>\n");
      out.write(" \t\t\t\t<li><a href=\"student.jsp\">Student Details</a></li>\n");
      out.write(" \t\t\t\t<li><a href=\"staff.jsp\">Staff Details</a></li>\n");
      out.write(" \t\t\t\t<li><a href=\"roomcreation.jsp\">Room Creation</a></li>\n");
      out.write(" \t\t\t</ul>\n");
      out.write(" \t\t</li>\n");
      out.write(" \t\t<li style=\"border-bottom: 1px solid whitesmoke;\">Allocation\n");
      out.write(" \t\t\t<ul>\n");
      out.write(" \t\t\t\t<li><a href=\"exam_allocation.jsp\">Exam Allocation</a></li>\n");
      out.write(" \t\t\t\t<li><a href=\"hall_allocation.jsp\">Hall Allocation</a></li>\n");
      out.write(" \t\t\t\t<li><a href=\"#\">send</a></li>\n");
      out.write(" \t\t\t</ul>\n");
      out.write(" \t\t</li>\n");
      out.write(" \t</ul>\n");
      out.write("    </div>    \n");
      out.write("        \n");
      out.write("        <h1 style=\" text-align: center ;margin-top: 50px; text-decoration: underline;\"> STUDENTS RECORDS</h1>\n");
      out.write("        <div class=\"tab\">\n");
      out.write("        \n");
      out.write("        <table border=\"1\" align=\"center\" style=\"margin-top: 20px;background-color: #ccffff ;width: 100%;height: auto\">\n");
      out.write("                <tr>\n");
      out.write("                    <th>S No.</th>\n");
      out.write("                    <th>Name</th>\n");
      out.write("                    <th>Branch</th>\n");
      out.write("                    <th>Semester</th>\n");
      out.write("                    <th>mobile No.</th>\n");
      out.write("                    <th>DOB</th>\n");
      out.write("                    <th>Roll No.</th>\n");
      out.write("                </tr>\n");
      out.write("                <tbody style=\"text-align: center\">\n");
      out.write("        ");

           	try
		{
                        int c=0;
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection("Jdbc:oracle:thin:@localhost:1521:xe","system","123456789");
			java.sql.Statement stmt=con.createStatement();
			ResultSet rs=stmt.executeQuery("select sname,branch,semster,mobile,dob,roll_no from students");
                        while(rs.next())
                        {
                            c++;
                            out.print("<tr><td>"+c+"</td><td>"+rs.getString(1)+"</td><td>"+rs.getString(2)+"</td><td>"+rs.getString(3)+"</td><td>"+rs.getString(4)+"</td><td>"+rs.getString(5)+"</td><td>"+rs.getString(6)+"</td></tr>");
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
      out.write("    </div>\n");
      out.write("        <form action=\"delete_student\" method=\"POST\" style=\" margin-top: 20px; margin-left: 450px;\">\n");
      out.write("            <label style=\" font-size: 21px; \"> Enter the Roll No.</label> <input type=\"text\" name=\"roll_no\" /> &nbsp; <input type=\"submit\" value=\"Delete\" />\n");
      out.write("        </form>\n");
      out.write("        \n");
      out.write("<div class=\"last\"> Devloped & maintain by MR. MANAV VISHWAS,MR.DEEPAK KAREDIYA,MR.ROHIT RAJPUT</div>\n");
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
