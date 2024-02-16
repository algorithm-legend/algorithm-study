package codeTest;

import java.util.*;

public class B15649 {
	
	static int arr[];
	static boolean check[];
	
	public static void main(String args[]) throws Exception {
		
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int M = sc.nextInt();
		
		check = new boolean[N];
		arr = new int[M];
		
		bt(N,M,0);
	}
	
	static void bt(int n, int m, int d) {
		
		if(d == m) {
			for(int num : arr) {
				System.out.print(num+" ");
			}
			System.out.println();
			return;
		}
		
		for (int i = 1; i <= n; i++) {
            if (!check[i - 1]) {
                check[i - 1] = true;
                arr[d] = i;
                bt(n, m, d + 1);
                check[i - 1] = false;
            }
        }
		
	}
}
