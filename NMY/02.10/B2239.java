package codeTest;

import java.io.BufferedReader;
import java.io.InputStreamReader;
/**
103x
009205800
804000107
 */
import java.util.*;

public class B2239 {

	static int[][] arr = new int[9][9];
	static ArrayList<int[]> position = new ArrayList<>();
	
	public static void main(String args[]) throws Exception {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		   for (int i = 0; i < 9; i++) {
		      String line = in.readLine();
		      for (int j = 0; j < 9; j++) {
		         arr[i][j] = line.charAt(j)-'0';
		         if(arr[i][j]==0) position.add(new int[]{i,j});
		      }
		   }
		
		sudoku(0);
		
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<9;i++){
			for(int j=0;j<9;j++){
				sb.append(arr[i][j]);
			}
			sb.append('\n');
		}
		
		System.out.print(sb);
		
	}
	
	public static boolean sudoku(int num) {
		
		if(num==position.size()) return true;
		
		int y = position.get(num)[0];
		int x = position.get(num)[1];
		
		for(int i = 1; i<10;i++) {
			
			arr[y][x] = i;
			if(check(y, x) && sudoku(num+1)) return true; 
			
		}
		
		arr[y][x] = 0;
		
		return false;
		
	}
	
	public static boolean check(int y, int x) {
		
		for(int i=0;i<9;i++){
			if(y!=i && arr[i][x] == arr[y][x]) return false;
		    if(x!=i && arr[y][i] == arr[y][x]) return false;
		}
		
		for(int i=(y/3)*3,j=0;j<3;j++,i++){
			for(int k=(x/3)*3,l=0;l<3;l++,k++){
				if(i!=y && k!=x && arr[i][k] == arr[y][x]) return false;
		    }
		}
		
		return true;
	}
	
}
