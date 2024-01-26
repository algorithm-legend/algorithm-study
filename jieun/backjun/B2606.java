package backjun.silver;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/*
 * 컴퓨터 수
 * 직접 연결되어있는 컴퓨터 쌍의 수
 * 컴퓨터 번호 쌍
 * 
 * 깊이 우선 탐색
 * 
 */
public class B2606 {
	static boolean[] check;
	static int count = 0; // bfs
//	static int count = 0; // dfs
	static int[][] node;
	static HashMap<Integer, HashSet<Integer>> pairMap = new HashMap<>();
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int pairCount = sc.nextInt();
		
		// 1부터 시작
		node = new int[n+1][n+1]; 
		check = new boolean[n+1];
		
		int a;
		int b;
		for(int i=0; i<pairCount; i++){
			a = sc.nextInt();
			b = sc.nextInt();
			
			node[a][b] = 1;
			node[b][a] = 1;
		}
		
//		dfs(1);
		bfs(1);
		System.out.println(count);
	}
	
	public static void dfs(int key){
		count++;
		check[key] = true;
		
		for(int i=1; i<node.length; i++){
			if(node[key][i] == 1 && !check[i]){
				dfs(i);
			} 
		}
	}
	
	public static void bfs(int start){
		Queue<Integer> q = new LinkedList<>();
		
		q.offer(start);
		check[start] = true;
		
		int target;
		while(!q.isEmpty()){
			target = q.poll();
			
			for(int i=1; i<node.length; i++){
				if(node[target][i] == 1 && !check[i]){
					q.offer(i);
					check[i] = true;
					count++;
				}
			}
		}
	}

}
