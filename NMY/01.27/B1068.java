package codeTest;

import java.util.*;

public class B1068 {
	
	static boolean[][] arr;
	static boolean[] check;
	static int count;
	
	public static void main(String args[]) throws Exception {
		
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();

		arr = new boolean[N][N];
		check = new boolean[N];
		
		int node = 0;
		
		for(int i = 0; i<N; i++) {
			int a = sc.nextInt();
			
			if(a==-1) {
				node = i;
				continue;
			} 
			
			arr[i][a] = true;
			arr[a][i] = true;
		}
		int del = sc.nextInt();

		dfs(arr,node,node,del);
		
		System.out.println(count);
	}
	
	static void dfs(boolean[][] arr, int root, int node, int del) {
		check[node] = true;
		arr[node][del] = false;
		if(node == del) return;
		boolean flag = true;
		
		for(int i = 0; i<arr.length;i++) {
			if(arr[node][i] && !check[i]) {
				dfs(arr,node,i,del);
			}
		}
		
		for(int i=0;i<arr.length;i++) {
			if(i==root) continue;
			if(arr[node][i]) {
				flag = false;
				break;
			}
		}
		
		if(flag) count++;
		
	}
	
}