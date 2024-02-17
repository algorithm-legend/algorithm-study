package backjun.gold;
/*
 * 1. 값 받아오기
 * 2. 비어있는 칸 위치 list로 담기
 * 3. 비어있는 칸 탐색
 *    - 비어있는 칸 기준  가로,세로,사각형에 사용된 숫자 check
 *    - check 돌면서 사용하지 않은 숫자 넣기 > 다음 칸 탐색
 *    - 다음 칸에서 넣을 수 있는 숫자 없으면 되돌아와서 다음 check 넣기
 *    > 무조건 재귀, ,,
 */

import java.util.ArrayList;
import java.util.Scanner;

public class B2239 {
	static int[][] sudoku;
	static ArrayList<int[]>  list;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		sudoku = new int[9][9];
		list = new ArrayList<>();
	 	
		String input;
		for(int i=0; i<9; i++){
			input = sc.nextLine();
			for(int j=0; j<9; j++){
				sudoku[i][j] = input.charAt(j) - '0';
				
				// 비어있는 칸 저장
				if(sudoku[i][j] == 0) list.add(new int[]{i, j});
			}
		}
		
		solve(0);
	}
	
	public static void solve(int depth) {
		// 빈 칸을 모두 채운 경우
		if(list.size() == depth) { 
			// 정답 출력
			StringBuilder sb = new StringBuilder();
			for(int i=0; i<9; i++){
				for(int j=0; j<9; j++){
					sb.append(sudoku[i][j]);
				}
				sb.append("\n");
			}
			System.out.println(sb);
			// 시스템 종료
			System.exit(0);
		}
		
		int x = list.get(depth)[0];
		int y = list.get(depth)[1];
		boolean[] check = new boolean[10]; // 1~9 숫자 체크
		
		// 가로
		for(int i=0; i<9; i++){
			if(sudoku[x][i] != 0) {
				check[sudoku[x][i]] = true;
			}
		}
		
		// 세로
		for(int i=0; i<9; i++){
			if(sudoku[i][y] != 0) {
				check[sudoku[i][y]] = true;
			}
		}
		
		// 네모
		int startX = (x/3)*3;
		int startY = (y/3)*3;
		for(int i=startX; i<startX + 3; i++){
			for(int j=startY; j<startY + 3; j++){
				if(sudoku[i][j] != 0) {
					check[sudoku[i][j]] = true;
				}
			}
		}
		
		// 빈 칸 채우기
		for(int i=1; i<10; i++){
			if(!check[i]) { // 아직 사용하지 않은 숫자인 경우
				sudoku[x][y] = i; // 빈 칸에 넣기
				solve(depth+1); // 다음 빈 칸 채우기
				sudoku[x][y] = 0; // 쓸 수 있는 숫자가 없으면 채운 칸을 비우고 다음 숫자 찾기 
			}
		}
	}
}
