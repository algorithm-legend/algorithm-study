package codeTest;

import java.util.*;

public class B14606 {
	
	public static void main(String args[]) throws Exception {
		
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		int pizza[] = new int[N];
		
		for(int i=1; i<pizza.length;i++) {
			pizza[i] = i + pizza[i-1];
		}
		
		System.out.println(pizza[N-1]);
		
	}
}