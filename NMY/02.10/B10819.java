package codeTest;

import java.util.*;
import java.util.stream.IntStream;

public class B10819 {
	
	static String[] arr;
	static int[] arr2;
	static int N;
	static boolean[] check;
	static int answer = 0;
	
	public static void main(String args[]) throws Exception {
		
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		sc.nextLine();
		arr = sc.nextLine().split(" ");
		arr2 = new int[N];
		check = new boolean[N];
		
		bt(0);
		
		System.out.println(answer);
	}
	
	public static void bt(int depth) {
		
		if(depth==N) {
			int temp = 0;
			
			for(int i =1; i<arr2.length;i++) {
				temp += Math.abs(arr2[i-1] - arr2[i]);
			}
			answer = Math.max(answer, temp); 
			
			return;
		}
		
		for(int i = 0; i<arr.length;i++) {
			if(!check[i]) {
				check[i] = true;
				arr2[depth] = Integer.parseInt(arr[i]);
				bt(depth+1);
				check[i] = false;
			}
		}
		
	}
	
}