package backjun.silver;

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
		for(int i=0; i<=top; i++){
			count = findLand(land, i);
			if(max < count) max = count;
		}
	}
	
	public static int findLand(int[][] map, int sink){
		int[][] check = new int[N][N];
		
		
		
		
		
		return 0;
	}
}
