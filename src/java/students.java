
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.*;
public class students extends HttpServlet 
{
    PrintWriter out;
    protected void doPost(HttpServletRequest request, HttpServletResponse response)  
    {
        try
        {
            out=response.getWriter();
            String name=request.getParameter("name");
            String branch=request.getParameter("branch");
            String branch_code=request.getParameter("branch_code");
            String year=request.getParameter("year");
            int sem=Integer.parseInt(request.getParameter("sem"));
            String address=request.getParameter("add");
            long phone=Long.parseLong(request.getParameter("phone"));
            String dob=request.getParameter("dob");
            String email=request.getParameter("email");
            String sems=Integer.toString(sem);
            String search_string=branch_code.concat(sems);
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con=DriverManager.getConnection("Jdbc:oracle:thin:@localhost:1521:xe","system","123456789");
            PreparedStatement ps=con.prepareStatement("select roll_no from temp where name=?");
            ps.setString(1,search_string);
            ResultSet rs=ps.executeQuery();
            rs.next();
            int roll_no=rs.getInt("roll_no");
            roll_no++;
            
            ps=con.prepareStatement("update temp set roll_no=? where name=?");
            ps.setInt(1, roll_no);
            ps.setString(2,search_string);
            ps.executeUpdate();
            String num=Integer.toString(roll_no);
            ps=con.prepareStatement("insert into students (sname,branch,branch_code,year,semster,address,mobile,dob,email,roll_no,room_no) values(?,?,?,?,?,?,?,?,?,?,?)");
            ps.setString(10, num);
            ps.setString(1, name);
            ps.setString(2, branch);
            ps.setString(3, branch_code);
            ps.setString(4, year);
            ps.setInt(5, sem);
            ps.setString(6, address);
            ps.setLong(7, phone);
            ps.setString(8, dob);
            ps.setString(9, email);
            ps.setString(11, "0");
            ps.executeQuery();
            response.sendRedirect("student.jsp");
        }
        catch(Exception e)
        {
            out.println(e);
        }
    }
}
