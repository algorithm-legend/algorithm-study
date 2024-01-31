package codeTest;

/**
74759336
36195974
 */


import java.util.*;

public class B17202 {
	
	public static void main(String args[]) throws Exception {
		
		Scanner sc = new Scanner(System.in);
		
		String A = sc.nextLine();
		String B = sc.nextLine();
		
		StringBuilder sb = new StringBuilder();
		StringBuilder temp = new StringBuilder();
		
		for(int i = 0; i<8;i++) {
			sb.append(A.charAt(i));
			sb.append(B.charAt(i));
		}
		
		while(sb.length()>2) {
			for(int i = 0; i<sb.length()-1;i++) {
				temp.append((Character.getNumericValue(sb.charAt(i)) + Character.getNumericValue(sb.charAt(i+1))) % 10);
			}
			
			sb.delete(0,sb.length());
			sb.append(temp.toString());
			temp.delete(0,temp.length());
		}
		
		System.out.println(sb);
		
	}
}