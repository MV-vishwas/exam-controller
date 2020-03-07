import java.sql.*;
public class reset 
{
    public static void main(String args[])
    {
        try
        {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con = DriverManager.getConnection("Jdbc:oracle:thin:@localhost:1521:xe", "system", "123456789");
            PreparedStatement ps = con.prepareStatement("update students set room_no=0");
            ps.executeUpdate();
            ps = con.prepareStatement("update staffs set dates=0000-00-00");
            ps.executeUpdate();
            ps = con.prepareStatement("update rooms set dates=0000-00-00");
            ps.executeUpdate();
            ps = con.prepareStatement("update exams set status='false'");
            ps.executeUpdate();
           ps = con.prepareStatement("delete from subexams");
            ps.executeUpdate();
           
                       
        }
        catch(Exception e){System.out.println(e);};
    }
}
