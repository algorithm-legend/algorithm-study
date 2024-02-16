package codeTest;

import java.util.Scanner;

public class B1747 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		if(N==1) {
			System.out.println(2);
		}else {
			for(int i = N;;i++) {
				if(isPal(String.valueOf(i))&&isPrime(i)) {
					System.out.println(i);
					return;
				}
			}
		}
		
	}

	static boolean isPal(String num) {
		
		for(int i =0; i<=num.length()/2;i++) {
			if(num.charAt(i) != num.charAt(num.length()-i-1))
			return false;
		}
		return true;
	}
	
	static boolean isPrime(int num) {
		
		for(int i = 2; i<=Math.sqrt(num);i++) {
			if(num%i == 0) return false;
		}
		
		return true;
	}
	
	
}