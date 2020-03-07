import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;  
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
public class exams extends HttpServlet 
{
    PrintWriter out;
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
    {
        try
        {
            String edate=request.getParameter("edate");
            String etype=request.getParameter("etype");
            String sub=request.getParameter("subject");
            String sub_code=request.getParameter("sub_code");
            String dpt=request.getParameter("dpt");
            String year=request.getParameter("year");
            String stime=request.getParameter("stime");
            String otime=request.getParameter("otime");
            HttpSession session=request.getSession();
            int sem=Integer.parseInt(request.getParameter("sem"));
            out=response.getWriter();
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con=DriverManager.getConnection("Jdbc:oracle:thin:@localhost:1521:xe","system","123456789");
            PreparedStatement ps=con.prepareStatement("insert into exams values(?,?,?,?,?,?,?,?,?,?,?,?)");
            ps.setString(1, edate);
            ps.setString(2, etype);
            ps.setString(3, sub);
            ps.setString(4,sub_code);
            ps.setString(5, dpt);
            ps.setString(6, year);
            ps.setInt(7, sem);
            ps.setString(8, "false");
            ps.setString(9, "0");
            ps.setString(10,"0");
            ps.setString(11, stime);
            ps.setString(12, otime);
            ps.executeUpdate(); 
            con.close();
            response.sendRedirect("exam_allocation.jsp");
        }
        catch(Exception e)
        {
            out.println(e);
        }
    }
}
