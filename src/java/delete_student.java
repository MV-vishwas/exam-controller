import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;
public class delete_student extends HttpServlet 
{
    PrintWriter out;
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
        try
        {
            out=response.getWriter();
            String roll_no=request.getParameter("roll_no");
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con=DriverManager.getConnection("Jdbc:oracle:thin:@localhost:1521:xe","system","123456789");
            PreparedStatement ps=con.prepareStatement("delete from students where roll_no=?");
            ps.setString(1, roll_no);
            ps.executeUpdate();
            response.sendRedirect("student.jsp");
        }
        catch(Exception e)
        {
            out.println(e);
        }
    }
}
