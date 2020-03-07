import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Random;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public class get_otp extends HttpServlet 
{
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
        PrintWriter out;
        try
        {
            out=response.getWriter();
            String name=request.getParameter("name");
            String username=request.getParameter("username");
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con = DriverManager.getConnection("Jdbc:oracle:thin:@localhost:1521:xe", "system", "123456789");
            PreparedStatement ps = con.prepareStatement("select mobile_no from shop_emp where username=? and name=?");
            ps.setString(1, username);
            ps.setString(2, name);
            ResultSet rs=ps.executeQuery();
            rs.next();
            String mobile_no=rs.getString(1);
            Random r=new Random();
            String otp="";
            char c;
            for(int i=1;i<=5;i++)
            {
                 c=(char)r.nextInt(10);
                out.println(c);
            }
            out.println(mobile_no);
        }
        catch(Exception e){System.out.println(e);};
    }


}
