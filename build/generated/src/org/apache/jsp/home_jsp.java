package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class home_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\t\t.block label{\n");
      out.write("\t\t\tbackground-color: #1f5183;\n");
      out.write("\t\t\tmargin-top:-2px; \n");
      out.write("\t\t\tcolor: white ;\n");
      out.write("\t\t\tfont-size: 30px;\n");
      out.write("\t\t\tfont-family: Lucida Handwriting;\n");
      out.write("\n");
      out.write("\t\t}\n");
      out.write("\t\t.last{\n");
      out.write("\t\t\ttext-align: center;\n");
      out.write("\t\t\tfont-size: 20px;\n");
      out.write("\t\t\tbackground-color: #427cb6;\n");
      out.write("                        margin-top: -70px;\n");
      out.write("                        height: 40px;\n");
      out.write("                        padding-top: 20px;\n");
      out.write("                        box-shadow:2px 5px #1f5183;\n");
      out.write("                        margin-top: 100px;\n");
      out.write("\t\t}\n");
      out.write("\t</style>\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("    ");

       if(session.getAttribute("user")==null)    
        response.sendRedirect("login.html");
    
      out.write("\n");
      out.write("     <div class=\"box\">\n");
      out.write("          <h1 style=\"margin-left: 10px;padding-top: 10px\">EXAM CONTROLLER</h1>\n");
      out.write("          <a href=\"logout.jsp\" style=\"float: right; color: white; margin-top: -27px; text-decoration: none; margin-right: 10px; font-size: 25px;\">Logout</a>\n");
      out.write(" \t</div>\n");
      out.write("\n");
      out.write("\t<div class=\"block\">\n");
      out.write("    \t<label >EXAM NOTICE </label>\n");
      out.write("    \n");
      out.write("        <iframe src=\"https://www.rgpv.ac.in/\" width=\"100%\" height=\"100%\" style=\" border: 2px solid black;\"></iframe>\n");
      out.write("    \t</div>\n");
      out.write("\n");
      out.write("     <div class=\"menu\">\n");
      out.write(" \t<ul>\n");
      out.write(" \t\t<li><a href=\"home.html\">Dashboard</a></li>\n");
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
      out.write(" </div>\n");
      out.write("\n");
      out.write("<div class=\"last\"> Devloped & maintain by MR. MANAV VISHWAS,MR.DEEPAK KAREDIYA,MR.ROHIT RAJPUT</div>\n");
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
