
package oopstemp;
import java.util.*;
import java.time.*;
import java.io.*;
public class CurrentUser {
	public static String cur,pas,single,dob,hotelname,curcity;
	public static String sdate, edate;
	public static String csd, ced, csing, cdob, chotel;
	public static int days;
	public void init() {
		try {
		File file = new File(cur+pas+hotelname+".txt");
		if(file.createNewFile()) {
			System.out.println("Created");
		}
		else {
			System.out.println("Already");
		}
	
		}
		catch (Exception e) {
			
		}
	}
	
}
