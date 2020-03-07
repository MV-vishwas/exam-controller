import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;
public class delete_room extends HttpServlet 
{
    PrintWriter out;
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
        try
        {
            out=response.getWriter();
            String room_no=request.getParameter("room_no");
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con=DriverManager.getConnection("Jdbc:oracle:thin:@localhost:1521:xe","system","123456789");
            PreparedStatement ps=con.prepareStatement("delete from rooms where room_no=?");
            ps.setString(1, room_no);
            ps.executeUpdate();
            response.sendRedirect("roomcreation.jsp");
        }
        catch(Exception e)
        {
            out.println(e);
        }
    }
}
