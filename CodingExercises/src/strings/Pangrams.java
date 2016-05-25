package strings;

import java.util.Scanner;

public class Pangrams {
	
	boolean isPangram(String str) {
		
		String string = str.toLowerCase().replaceAll("\\s", "");
		
		int chararray[] = new int[26];
		
//		System.out.println(string);
		
		for(int i=0;i<string.length();i++) {
			int c = string.charAt(i);
//			System.out.println(c);
			if(c-97 >= 0 && c-97 <= 122) {
				chararray[c-97]++;
			}
			else {
				System.out.println("Please enter only letters, not numbers of special characters in the string!!");
				System.exit(0);
			}
		}
		
		for(int i=0;i<26;i++) {
			if(chararray[i] == 0)
				return false;
			else
					continue;
		}
		
		return true; 
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println("Enter the string (with at most 1000 characters) : ");
		
		Scanner sc = new Scanner(System.in);
		
		String str = sc.nextLine();
		
		sc.close();
		
		if(str.length() > 1000)
			System.out.println("String length exceeded limit!! Enter less number of characters (< 1000)");
		
		Pangrams pangrams = new Pangrams();
		
		boolean result = pangrams.isPangram(str);
		
		if(result)
			System.out.println("'" + str + "' is a Pangram!");
		else
			System.out.println("'" + str + "' is not a Pangram!");
	}

}
