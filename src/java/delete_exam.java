import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;
public class delete_exam extends HttpServlet 
{
    PrintWriter out;
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
        try
        {
            out=response.getWriter();
            String dpt=request.getParameter("dpt");
            String edate=request.getParameter("edate");
            String sem=request.getParameter("sem");
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con=DriverManager.getConnection("Jdbc:oracle:thin:@localhost:1521:xe","system","123456789");
            PreparedStatement ps=con.prepareStatement("delete from exams where department=? and semester=? and exam_date=?");
            ps.setString(1, dpt);
            ps.setString(2, sem);
            ps.setString(3, edate);
            ps.executeUpdate();
            response.sendRedirect("exam_allocation.jsp");
        }
        catch(Exception e)
        {
            out.println(e);
        }
    }
}
