
package oopstemp;
import java.util.*;
import java.time.*;
import java.io.*;
public class CheckAvailability {
	public boolean check() {
		CurrentUser u = new CurrentUser();
		LocalDate start = LocalDate.parse(u.sdate),
		          end   = LocalDate.parse(u.edate);
		start = start.minusDays(1);
		end = end.plusDays(1);
		int sing = Integer.parseInt(u.single);
		int dob = Integer.parseInt(u.dob);
		boolean ans = true;
		try {
		Scanner file = new Scanner(new File(u.hotelname+".txt"));
                System.out.println(u.hotelname);
                System.out.println(u.single);
                System.out.println(u.dob);
			while(file.hasNext()) {
				String c = file.nextLine();
				String d = file.nextLine();
				String e = file.nextLine();
				int dd = Integer.parseInt(d);
				int ee = Integer.parseInt(e);
				LocalDate curdate = LocalDate.parse(c);
				if(curdate.isAfter(start)&&curdate.isBefore(end)) {
					if(dd>=sing && ee>=dob ) {	
					}
					else {
						ans = false;
					}
				}
			}
		file.close();
		return ans;
		}
		catch (Exception e) {
			return false;
		}	
	}
	
	public void BookRoom() {
		CurrentUser u = new CurrentUser();
		LocalDate start = LocalDate.parse(u.sdate),
		          end   = LocalDate.parse(u.edate);
		start = start.minusDays(1);
		end = end.plusDays(1);
		int sing = Integer.parseInt(u.single);
		int dob = Integer.parseInt(u.dob);
		boolean ans = true;
		try {
		Scanner file = new Scanner(new File(u.hotelname+".txt"));
		BufferedWriter bw = null;
                int sum = 0;
		bw = new BufferedWriter(new FileWriter("temp.txt"));
			while(file.hasNext()) {
				String c = file.nextLine();
				String d = file.nextLine();
				String e = file.nextLine();
				int dd = Integer.parseInt(d);
				int ee = Integer.parseInt(e);
				LocalDate curdate = LocalDate.parse(c);
				if(curdate.isAfter(start)&&curdate.isBefore(end)) {
					dd-=sing;
					ee-=dob;
                                        sum++;
				}
				bw.write(c+"\n");
				bw.write(dd+"\n");
				bw.write(ee+"\n");
			}
                u.days = sum;
		bw.close();
		file.close();
		File old = new File(u.hotelname+".txt");
		old.delete();
		File newf = new File("temp.txt");
		newf.renameTo(old);
		System.out.println("Success");
		return ;
		}
		catch (Exception e) {
			return;
		}	
	}
	public void Update(){
		CurrentUser u = new CurrentUser();
		LocalDate start = LocalDate.parse(u.sdate),
		          end   = LocalDate.parse(u.edate);
		start = start.minusDays(1);
		end = end.plusDays(1);
		int sing = Integer.parseInt(u.single);
		int dob = Integer.parseInt(u.dob);
		String fname = u.cur + u.pas + u.hotelname ;
		//System.out.println(fname);
		try {
			Scanner file = new Scanner(new File(fname+".txt"));
			BufferedWriter bw = null;
			bw = new BufferedWriter(new FileWriter("temp.txt"));
			//System.out.println(fname);
			if(file==null) {
				System.out.println(fname);
			}
			while(file!=null && file.hasNext()) {
				//System.out.println(fname);
				String a = file.nextLine();
				String b = file.nextLine();
				String c = file.nextLine();
				String d = file.nextLine();
                                String e = file.nextLine();
				bw.write(a+"\n");
				bw.write(b+"\n");
				bw.write(c+"\n");
				bw.write(d+"\n");
                                bw.write(e+"\n");
			}
                        bw.write(u.hotelname+"\n");
			bw.write(u.sdate+"\n");
			bw.write(u.edate+"\n");
			bw.write(u.single+"\n");
			bw.write(u.dob+"\n");
			if(bw!=null) {
				bw.close();
			}
			file.close();
			File old = new File(fname+".txt");
			old.delete();
			File newf = new File("temp.txt");
			newf.renameTo(old);
			System.out.println("Success");
		}
		catch(Exception e){
			System.out.println(fname);
			return ;
		}
	}
        
        public void cancel() {
		CurrentUser u = new CurrentUser();
		String cb = u.csd;
		String ce = u.ced;
		String sig = u.csing;
		String dub = u.cdob;
		String ch = u.chotel;
		LocalDate start = LocalDate.parse(cb),
		          end   = LocalDate.parse(ce);
		start = start.minusDays(1);
		end = end.plusDays(1);
		int s = Integer.parseInt(sig);
		int d = Integer.parseInt(dub);
		try {
			Scanner file = new Scanner(new File(ch+".txt"));
			BufferedWriter bw = null;
			bw = new BufferedWriter(new FileWriter("temp.txt"));
			while(file.hasNext()) {
				String a = file.nextLine();
				String b = file.nextLine();
				String c = file.nextLine();
				int bb = Integer.parseInt(b);
				int cc = Integer.parseInt(c);
				LocalDate curdate = LocalDate.parse(a);
				if(curdate.isAfter(start)&&curdate.isBefore(end)) {
					bb+=s;
					cc+=d;
				}
				bw.write(a+"\n");
				bw.write(bb+"\n");
				bw.write(cc+"\n");
			}
			bw.close();
			file.close();
			File old = new File(ch+".txt");
			old.delete();
			File newf = new File("temp.txt");
			newf.renameTo(old);
			System.out.println("Success");
		}
		catch (Exception e) {
			System.out.println("Unsuccessful");
		}
	}
	
	public void cancelupdate() {
		CurrentUser u = new CurrentUser();
		String cb = u.csd;
		String ce = u.ced;
		String sig = u.csing;
		String dub = u.cdob;
		String ch = u.chotel;
		LocalDate start = LocalDate.parse(cb),
		          end   = LocalDate.parse(ce);
		start = start.minusDays(1);
		end = end.plusDays(1);
		//int s = Integer.parseInt(sig);
		//int d = Integer.parseInt(dub);
		try {
			Scanner file = new Scanner(new File(u.cur+u.pas+ch+".txt"));
			BufferedWriter bw = null;
			bw = new BufferedWriter(new FileWriter("temp.txt"));
			while(file.hasNext()) {
				String a = file.nextLine();
				String b = file.nextLine();
				String c = file.nextLine();
				String d = file.nextLine();
				String e = file.nextLine();
				
				if(ch.equals(a)&&cb.equals(b)&&ce.equals(c)&&sig.equals(d)&&dub.equals(e)) {
					System.out.println("Works");
				}
				else {
				bw.write(a+"\n");
				bw.write(b+"\n");
				bw.write(c+"\n");
				bw.write(d+"\n");
				bw.write(e+"\n");
				}
				}
			bw.close();
			file.close();
			File old = new File(u.cur+u.pas+ch+".txt");
			old.delete();
			File newf = new File("temp.txt");
			newf.renameTo(old);
			System.out.println("Success");
		}
		catch (Exception e) {
			System.out.println("Unsuccessful");
		}
	}
	
}
