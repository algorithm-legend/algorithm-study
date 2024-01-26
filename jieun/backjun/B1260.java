package backjun.silver;
/*
 * DFS : 재귀 함수
 * 		 시작 숫자 > 연결된 숫자
 * 		(탐색 조건 : 연결된 숫자가 존재하고, 그 숫자를 아직 방문하지 않은 경우)
 * BFS : 시작 숫자 > Queue에 추가
 * 		 Queue에서 하나 꺼냄 > 연결된 숫자 방문 안한 경우 Queue에 추가
 * 		 Queue가 empty일 때까지 반복
 * 
 *   1 2 3 4 5
 *  +---------- 
 * 1|  1 1
 * 2|1       1
 * 3|1     1
 * 4|    1   1   
 * 5|  1   1
 * 
 * 숫자 입력 : O(M) 	// M은 간선의 수
 * bfs, dfs : O(N) 	// N은 노드의 수
 * => 시간 복잡도 : O(M + N) > O(n)
 * 
 */

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class B1260 {
	static int[][] array;
	static boolean[] visited;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int M = sc.nextInt();
		int start = sc.nextInt();
		sc.nextLine();
		// 1부터 시작
		array = new int[N+1][N+1];
		
		int a;
		int b;
		for(int i=0; i<M; i++){
			a = sc.nextInt();
			b = sc.nextInt();
			
			array[a][b] = 1;
			array[b][a] = 1;
			sc.nextLine();
		}
		
		visited = new boolean[N+1];
		dfs(start);
		System.out.println();

		visited = new boolean[N+1];
		bfs(start);
		
	}
	
	public static void dfs(int start){
		visited[start] = true;
		System.out.print(start + " ");
		
//		if(start == array.length) return;
		
		for(int i=1; i<array.length; i++){
			// 연결된 노드를 방문하지 않은 경우
			if(array[start][i] == 1 && !visited[i]){
				dfs(i);
			}
		}
	}
	
	public static void bfs(int start){
		Queue<Integer> queue = new LinkedList<Integer>();
		// 시작 숫자 넣기
		queue.offer(start);
		visited[start] = true;
		
		System.out.print(start + " ");
		
		while(!queue.isEmpty()){
			int n = queue.poll();
			
			// 시작숫자와 연결된 노드 체크
			for(int i = 1; i<array.length; i++){
				// 연결된 노드 중 방문하지 않은 노드가 있는 경우
				if(array[n][i] == 1 && !visited[i]){
					visited[i] = true;
					System.out.print(i + " ");
					queue.offer(i);
				}
			}
		}
	}
}
