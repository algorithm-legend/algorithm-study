package backjun.silver;
/*
 * 1. 
 * 1 > 0
 * 2 > 1*1 + 1행복 + 1행복 = 1
 * 3 > 2*1 + 2행복 + 1행복 = 2+1+0
 * 4 > 2*2 + 2행복 + 2행복 = 4+1+1
 * 5 > 3*2 + 3행복 + 2행복 = 6+3+1
 * D[n] = (n/2)*(n-(n/2)) + D[n/2] + D[n-(n/2)]
 * 
 * 2. 
 * 1  2  3  4  5  6  7  8   ... 9
 * 0  1  3  6  10 15 21 28  ... 8+28
 * D[index] = (index-1) + D[index-1]
 */
import java.util.Scanner;

public class B14606 {
	static int[] D;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		D = new int[n+1];
		D[1] = 0;
		
		System.out.println(dp(n));
	}
	
	public static int dp(int n){
		if(n==1) return D[n];
		int half = n/2;
		
		return D[n] = (half * (n-half)) + dp(half) + dp(n-half);
	}
}
