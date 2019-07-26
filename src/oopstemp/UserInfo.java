/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oopstemp;

/**
 *
 * @author hp Vardhan
 */

import java.util.Scanner;
import java.io.*;
public class UserInfo {
	public boolean FindUser(String user, String pass) {
		boolean ans = false;
		try {
                    		//System.out.println(user);
				//System.out.println(pass);
			Scanner file = new Scanner(new File("users.txt"));
			while(file.hasNext()) {
				String s = file.nextLine();
				String t = file.nextLine();
				//System.out.println(s);
				//System.out.println(t);
				if(s.equals(user) && t.equals(pass)) {
					ans = true;
				}
			}
			file.close();
		}
		catch (Exception e) {
			System.out.println("Error");
		}
		return ans;
	}
}
