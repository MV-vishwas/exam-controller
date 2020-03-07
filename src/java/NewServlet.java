import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/NewServlet"})
public class NewServlet extends HttpServlet 
{
    PrintWriter out;
    protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException 
    {  
        try
        {
            out=response.getWriter();
            String room_no=request.getParameter("room_no");
            String floor=request.getParameter("floor");
            String nor=request.getParameter("nor");
            String noc=request.getParameter("noc");
            String capacity=request.getParameter("capacity");
            String rdate="0000-00-00";
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con=DriverManager.getConnection("Jdbc:oracle:thin:@localhost:1521:xe","system","123456789");
            PreparedStatement ps=con.prepareStatement("insert into rooms values(?,?,?,?,?,?)");
            ps.setString(1, room_no);
            ps.setString(2, floor);
            ps.setString(3,nor);
            ps.setString(4, noc);
            ps.setString(5, capacity);
            ps.setString(6,rdate);
            ps.executeUpdate();
            response.sendRedirect("roomcreation.jsp");
        }
        catch(Exception e)
        {
            out.println(e);
        }
    }
}
