package backjun.silver;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class B2468 {
	/* 
	 * ���Ž��(DFS)
	 * 
 	[0][0]  [0][1]  [0][2]
 	[1][0]  [1][1]  [1][2]
 	[2][0]  [2][1]  [2][2]
 
 	(x-1, y-1)  (x-1, y)  (x-1, y+1)
  	 (x, y-1)	 (x, y)    (x, y+1)
 	(x+1, y-1)	(x+1, y)  (x+1, y+1)
 
	 */
	// �� �� �� ��
	static int[] dx = {0, 1, 0, -1};
	static int[] dy = {1, 0, -1, 0};
	
	static int N;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		
		int top = 0; // �ְ� ����
		int[][] land = new int[N][N];
		
		int max = 0; // ���������� �ִ� ����
		
		for(int i=0; i<N; i++){
			for(int j=0; j<N; j++){
				land[i][j] = sc.nextInt();
				if(top<land[i][j]) top = land[i][j]; // �ְ� ���� ���ϱ�
			}
		}
		
		int count;
		boolean[][] check ;
		// 1. ��ü ������ Ž��
		for(int i=0; i<=top; i++){
			check = new boolean[N][N];			
			count = findLand(land, check, i);
			
			if(max < count) max = count;
		}
		System.out.println(max);
	}
	
	// 2. ��ü ���� Ž��
	public static int findLand(int[][] land, boolean[][] check, int sink){
		int count = 0;
		for(int i=0; i<N; i++){
			for(int j=0; j<N; j++){
				if(land[i][j] > sink && !check[i][j]){ 
//					dfs(i, j, land, check, sink);
					bfs(i, j, land, check, sink);
					count++;
				}
			}
		}
		return count;
	}
	
	// 3. �������� Ž��(bfs)
	public static void bfs(int x, int y, int[][] land, boolean[][] check, int sink){
		Queue<Node> q = new LinkedList<>();
		int newX;
		int newY;

		q.offer(new Node(x, y));
		check[x][y] = true;
		
		Node now;
		while(!q.isEmpty()){
			now = q.poll();
			
			for(int i=0; i<4; i++){
				newX = now.getX() + dx[i];
				newY = now.getY() + dy[i];
				
				if(newX>=0 && newY>=0 && newX<N && newY<N){
					if(land[newX][newY] > sink && !check[newX][newY]){
						q.offer(new Node(newX, newY));
						check[newX][newY] = true;
					}
				}
			}
		}
	}
	
	// 3. �������� Ž��(dfs)
	public static void dfs(int x, int y, int[][] land, boolean[][] check, int sink){
		int newX;
		int newY;
		check[x][y] = true;
		
		for(int i=0; i<4; i++){
			newX = x + dx[i];
			newY = y + dy[i];
			
			if(newX>=0 && newY>=0 && newX<N && newY<N){
				if(land[newX][newY] > sink && !check[newX][newY]){
					dfs(newX, newY, land, check, sink);
				}
			}
		}
	}
}

class Node {
	private int x;
	private int y;

	public Node(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public int getX() {
		return this.x;
	}

	public int getY() {
		return this.y;
	}
}
