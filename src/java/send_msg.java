import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.URL;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;
import javax.net.ssl.HttpsURLConnection;
public class send_msg extends HttpServlet 
{
    PrintWriter out;
    protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException 
    {
        try
        {
            String key="G6KbSXn2gTYjmBZJRu1w3syDWvQA4IPO5Mp7NCHeUlE9VFLkzoXZQbyU9exjdgFpmEoVlvkAsnt21rKh";
            String sendID="FSTSMS";
            String myURL;
            String no;
            String roll_no;
            String room_no;
            String RC;
            out=response.getWriter();
            String edate=request.getParameter("edate");
            String sem=request.getParameter("sem");
            String dpt=request.getParameter("dpt");
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con=DriverManager.getConnection("Jdbc:oracle:thin:@localhost:1521:xe","system","123456789");
            PreparedStatement ps=con.prepareStatement("select roll_no,room_no,ro,col,mobile from students where semster=? and branch=?");
            ps.setString(1,sem);
            ps.setString(2, dpt);
            ResultSet rs=ps.executeQuery();
            while(rs.next())
            {
                roll_no=rs.getString(1);
                room_no=rs.getString(2);
                RC="%20R-"+rs.getString(3)+"%20C-"+rs.getString(4);
                no=rs.getString(5);
                myURL="https://www.fast2sms.com/dev/bulk?authorization="+key+"&sender_id=FSTSMS&language=english&route=qt&numbers="+no+"&message=17299&variables={AA}|{BB}|{CC}&variables_values="+room_no+"|"+RC+"|"+roll_no;
		URL url=new URL(myURL);
		HttpsURLConnection connection=(HttpsURLConnection)url.openConnection();
		connection.setRequestMethod("GET");
		connection.setRequestProperty("cache-control", "no-cache");
		int code=connection.getResponseCode();
                StringBuffer sb=new StringBuffer();
                BufferedReader br=new BufferedReader(new InputStreamReader(connection.getInputStream()));
                int i;
                while((i=br.read())!=-1)
                {
                    out.print((char)i);
                }
                out.println();
		out.println(code+","+rs.getString(1)+" send successful.");	
            }
        }
        catch(Exception e){out.println(e);}		
    }
}
