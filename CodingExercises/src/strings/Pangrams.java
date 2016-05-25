package strings;

import java.util.Scanner;

public class Pangrams {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println("Enter the string (with at most 1000 characters) : ");
		
		Scanner sc = new Scanner(System.in);
		
		String str = sc.nextLine();
		
		sc.close();
		
		System.out.println(str);
		
	}

}
