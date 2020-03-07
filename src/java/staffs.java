import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;  
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public class staffs extends HttpServlet 
{
    PrintWriter out;
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
    {
        try
        {
            String nm=request.getParameter("sname");
            String add=request.getParameter("address");
            String city=request.getParameter("city");
            String phone=request.getParameter("mobile_no");
            String dpt=request.getParameter("dpt");
            String email=request.getParameter("email");
            String staff_id=request.getParameter("staff_id");
            out=response.getWriter();
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con=DriverManager.getConnection("Jdbc:oracle:thin:@localhost:1521:xe","system","123456789");
            PreparedStatement ps=con.prepareStatement("insert into staffs (name,address,city,mobile_no,department,email,dates,staff_id) values(?,?,?,?,?,?,?,?)");
            ps.setString(1, nm);
            ps.setString(2, add);
            ps.setString(3, city);
            ps.setString(4,phone);
            ps.setString(5, dpt);
            ps.setString(6, email);
            ps.setString(7, "0000-00-00");
            ps.setString(8, staff_id);
            ps.executeUpdate();
            response.sendRedirect("staff.jsp");
        }
        catch(Exception e)
        {
            out.println(e);
        }
    }
}
