package codeTest;

/*
5
6 8 2 6 2
3 2 3 4 6
6 7 3 3 2
7 2 5 3 6
8 9 5 2 7
 */

import java.util.*;

public class B2468 {
	
	
	static boolean check[][]; 
	static int map[][];
	static int N;
	static int [][] dir = {{-1,0}, {1,0}, {0,-1}, {0,1}}; //╩С, го, аб, ©Л
	
	public static void main(String args[]) throws Exception {
		
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		int answer = 1;
		
		map = new int[N][N];
		
		int max = Integer.MIN_VALUE;
	    
	    for (int i = 0; i < N; i++) {
	        for (int j = 0; j < N; j++) {
	            map[i][j] = sc.nextInt();
	            max = Math.max(map[i][j], max);
	        }
	    }
		
	    for(int i =1; i<=max;i++) {
	    	check = new boolean[N][N];
	    	int count = 0;
	    	for (int j = 0; j < N; j++) {
		        for (int l = 0; l < N; l++) {
		        	if(map[j][l] > i && !check[j][l]) {
		        		count++;
		        		dfs(j,l,i);
		        	}
		        }
		    }
	    	answer = Math.max(answer, count);
	    }
	    
	    System.out.println(answer);
	    
	}
	
	static void dfs(int x, int y, int r) {
		check[x][y] = true;
		int xx;
		int yy;
		for(int i = 0; i<dir.length;i++) {
			xx = x + dir[i][0];
			yy = y + dir[i][1];
			if(xx >= 0 && xx < N && yy >= 0 && yy < N) {
				if(map[xx][yy] > r &&!check[xx][yy]) {
					dfs(xx,yy,r);
				}
			}
		}
		
	}
}
	

//	static void bfs(int[][] map, int j) {
//		
//		check = new boolean[N][N];
//		Queue<int[]> queue = new LinkedList<>();
//		int temp = 0;
//		int[] coo;
//		int x,y;
//		
//		for (int i = 0; i < N; i++) {
//	        for (int l = 0; l < N; l++) {
//	        	if(map[i][l] <= j) {
//	        		map[i][l] = 0;
//	        	}
//	        }
//	    }
//		
//		for (int i = 0; i < N; i++) {
//	        for (int l = 0; l < N; l++) {
//	        	if(map[i][l] > 0 && !check[i][l]) {
//	        		
//	        		temp++;
//	        		check[i][l] = true;
//	        		queue.add(new int[]{i,l});
//	        		while(!queue.isEmpty()) {
//	        			coo = queue.poll();
//	        			x = coo[0];
//	        			y = coo[1];
//	        			for(int k =0; k<dir.length;k++) {
//	        				int xx = x +dir[k][0];
//	        				int yy = y +dir[k][1];
//	        				
//	        				if(xx >= 0 && xx < N && yy >= 0 && yy < N) {
//	        					if(map[xx][yy] > 0 && !check[xx][yy]) {
//	        						queue.add(new int[] {xx,yy});
//	        						check[xx][yy] = true;
//	        					}
//	        				}
//	        			}
//	        		}
//	        		
//	        	}
//	        }
//	    }
//		
//		answer = Math.max(temp, answer);
//		
//	}
