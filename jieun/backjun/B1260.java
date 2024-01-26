package backjun.silver;
/*
 * DFS : ��� �Լ�
 * 		 ���� ���� > ����� ����
 * 		(Ž�� ���� : ����� ���ڰ� �����ϰ�, �� ���ڸ� ���� �湮���� ���� ���)
 * BFS : ���� ���� > Queue�� �߰�
 * 		 Queue���� �ϳ� ���� > ����� ���� �湮 ���� ��� Queue�� �߰�
 * 		 Queue�� empty�� ������ �ݺ�
 * 
 *   1 2 3 4 5
 *  +---------- 
 * 1|  1 1
 * 2|1       1
 * 3|1     1
 * 4|    1   1   
 * 5|  1   1
 * 
 * ���� �Է� : O(M) 	// M�� ������ ��
 * bfs, dfs : O(N) 	// N�� ����� ��
 * => �ð� ���⵵ : O(M + N) > O(n)
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
		// 1���� ����
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
			// ����� ��带 �湮���� ���� ���
			if(array[start][i] == 1 && !visited[i]){
				dfs(i);
			}
		}
	}
	
	public static void bfs(int start){
		Queue<Integer> queue = new LinkedList<Integer>();
		// ���� ���� �ֱ�
		queue.offer(start);
		visited[start] = true;
		
		System.out.print(start + " ");
		
		while(!queue.isEmpty()){
			int n = queue.poll();
			
			// ���ۼ��ڿ� ����� ��� üũ
			for(int i = 1; i<array.length; i++){
				// ����� ��� �� �湮���� ���� ��尡 �ִ� ���
				if(array[n][i] == 1 && !visited[i]){
					visited[i] = true;
					System.out.print(i + " ");
					queue.offer(i);
				}
			}
		}
	}
}
