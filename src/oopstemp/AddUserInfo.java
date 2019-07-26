
package oopstemp;
import java.io.*;
import java.util.*;

public class AddUserInfo {
    public static boolean AddDetail(String a[], String b[])  {
		try {
                        boolean ans = false;
			//Scanner oldfile = new Scanner (new File(b[3]+b[4]+".txt"));
			BufferedWriter bw = null;
			bw = new BufferedWriter(new FileWriter(b[3]+b[4]+".txt"));
                        for(int i=0;i<6;i++){
                            bw.write(a[i]+"\n");
                            bw.write(b[i]+"\n");
                        }
			if(bw!=null) {
				bw.close();
			}
			System.out.println("Success");
                        ans = AddUser(b[3], b[4]);
                        return ans;
                }
		catch (Exception e) {
			return false;
		}
    }
    public static boolean AddUser (String usr, String pas){
        try{
            Scanner oldfile = new Scanner (new File("users.txt"));
			//Scanner newfile = new Scanner (new File("temp.txt"));
			BufferedWriter bw = null;
			bw = new BufferedWriter(new FileWriter("temp.txt"));
			while(oldfile.hasNext()) {
				String det = oldfile.nextLine();
				String val = oldfile.nextLine();
				{
					bw.write(det+"\n");
					bw.write(val+"\n");
				}
			}
                        bw.write(usr+"\n");
                        bw.write(pas+"\n");
			if(bw!=null) {
				bw.close();
			}
			oldfile.close();
			File old = new File("users.txt");
			old.delete();
			File newf = new File("temp.txt");
			newf.renameTo(old);
			System.out.println("Success");
                        return true;
        }
        catch (Exception e){
            return false;
        }
    }
}
