import java.net.*;
import javax.net.ssl.HttpsURLConnection;
class f2f
{   
	public static void sendSms(String no,String roll_no,String room_no,String RC)
	{
		try
		{
			String key="G6KbSXn2gTYjmBZJRu1w3syDWvQA4IPO5Mp7NCHeUlE9VFLkzoXZQbyU9exjdgFpmEoVlvkAsnt21rKh";
			String sendID="FSTSMS";
			String myURL="https://www.fast2sms.com/dev/bulk?authorization="+key+"&sender_id=FSTSMS&language=english&route=qt&numbers="+no+"&message=17277&variables={AA}|{BB}|{CC}&variables_values="+room_no+"|"+roll_no+"|"+RC;
			//sending get request using java
			URL url=new URL(myURL);
			HttpsURLConnection con=(HttpsURLConnection)url.openConnection();
			con.setRequestMethod("GET");
			con.setRequestProperty("cache-control", "no-cache");
			int code=con.getResponseCode();
		}
		catch(Exception e){System.out.println(e);}
	}
	public static void main(String args[])
	{
		f2f.sendSms("9993540341","EX171010","119","R-5_C-5");
	}
}