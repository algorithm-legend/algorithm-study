package codeTest;

/*
ACAYKP
CAPCAK
 * */
import java.util.*;

public class B9251 {
	
	public static void main(String args[]) throws Exception {
		
		Scanner sc = new Scanner(System.in);
		
		String A[] = sc.nextLine().split("");
		String B[] = sc.nextLine().split("");
		
		int answer = 0;
		
		int dp[][] = new int[A.length+1][B.length+1];
		
		for(int i = 1; i<=A.length; i++) {
			for(int j = 1; j<=B.length;j++) {
				if(A[i-1].equals(B[j-1])) {
					dp[i][j] = dp[i-1][j-1] +1;
				}else {
					dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
				}
			}
		}
		System.out.println(dp[A.length][B.length]);
	}
	
}
