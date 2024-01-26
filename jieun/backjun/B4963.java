package backjun.silver;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class B4963 {
	
	/*
	 	[0][0]  [0][1]  [0][2]
	 	[1][0]  [1][1]  [1][2]
	 	[2][0]  [2][1]  [2][2]
	 
	 	(x-1, y-1)  (x-1, y)  (x-1, y+1)
	  	 (x, y-1)	 (x, y)    (x, y+1)
	 	(x+1, y-1)	(x+1, y)  (x+1, y+1)
	 
	 */
	
	// ¢Ö ¡æ ¢Ù ¡é ¢× ¡ç ¢Ø ¡è
	static int[] dx = {-1, 0, 1, 1, 1, 0, -1, -1};
	static int[] dy = {1, 1, 1, 0, -1, -1, -1, 0};
	
	static int[][] map;
	static boolean[][] check;
	
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int totalWidth;
		int totalHeight;
		
		int count;
		
		while(true){
			totalWidth = sc.nextInt();
			totalHeight = sc.nextInt();
			
			if(totalWidth == 0 && totalHeight == 0) break;
			
			map = new int[totalHeight][totalWidth];
			check = new boolean[totalHeight][totalWidth];
			
			for(int i=0; i<totalHeight; i++){
				for(int j=0; j<totalWidth; j++){
					map[i][j] = sc.nextInt();
				}
			}
			
			count = 0;
			
			for(int i=0; i<totalHeight; i++){
				for(int j=0; j<totalWidth; j++){
					if(map[i][j] == 1 && !check[i][j]){
						findLand(i, j, totalHeight, totalWidth);
						count++;
					}
				}
			}
			
			bw.write(count + "\n"); 
		}
		bw.flush(); 
		bw.close(); 
	}
	
	public static void findLand(int x, int y, int h, int w){
		check[x][y] = true;
		
		for(int i=0; i<8; i++){
			int newX = x + dx[i];
			int newY = y + dy[i];
			
			if(newX >= 0 && newY >= 0 && newX < h && newY < w){
				if(map[newX][newY] == 1 && !check[newX][newY]) {
					findLand(newX, newY, h, w);
				}
			}
		}
	}
}
