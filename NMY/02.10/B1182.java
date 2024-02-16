package codeTest;

/**
 5 0
-7 -3 -2 5 8

 */
import java.util.Scanner;

public class B1182 {

	public static void main(String args[]) throws Exception {
		
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();	
		int S = sc.nextInt();
		
		int[] arr = new int[N];

		for(int i = 0; i<N;i++) {
			arr[i] = sc.nextInt();
		}
		
		int sum;
		int count = 0;
		
		for(int i = 1; i < (1<<N); i++) {
			sum = 0;
			for(int j = 0; j < N; j++) {
				if((i & (1<<j)) != 0) {
					sum += arr[j];
				}
			}
			if(sum==S) count++;
		}
		
		System.out.println(count);
		
	}
	
	
}