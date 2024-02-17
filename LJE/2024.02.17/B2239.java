package backjun.gold;
/*
 * 1. �� �޾ƿ���
 * 2. ����ִ� ĭ ��ġ list�� ���
 * 3. ����ִ� ĭ Ž��
 *    - ����ִ� ĭ ����  ����,����,�簢���� ���� ���� check
 *    - check ���鼭 ������� ���� ���� �ֱ� > ���� ĭ Ž��
 *    - ���� ĭ���� ���� �� �ִ� ���� ������ �ǵ��ƿͼ� ���� check �ֱ�
 *    > ������ ���, ,,
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
				
				// ����ִ� ĭ ����
				if(sudoku[i][j] == 0) list.add(new int[]{i, j});
			}
		}
		
		solve(0);
	}
	
	public static void solve(int depth) {
		// �� ĭ�� ��� ä�� ���
		if(list.size() == depth) { 
			// ���� ���
			StringBuilder sb = new StringBuilder();
			for(int i=0; i<9; i++){
				for(int j=0; j<9; j++){
					sb.append(sudoku[i][j]);
				}
				sb.append("\n");
			}
			System.out.println(sb);
			// �ý��� ����
			System.exit(0);
		}
		
		int x = list.get(depth)[0];
		int y = list.get(depth)[1];
		boolean[] check = new boolean[10]; // 1~9 ���� üũ
		
		// ����
		for(int i=0; i<9; i++){
			if(sudoku[x][i] != 0) {
				check[sudoku[x][i]] = true;
			}
		}
		
		// ����
		for(int i=0; i<9; i++){
			if(sudoku[i][y] != 0) {
				check[sudoku[i][y]] = true;
			}
		}
		
		// �׸�
		int startX = (x/3)*3;
		int startY = (y/3)*3;
		for(int i=startX; i<startX + 3; i++){
			for(int j=startY; j<startY + 3; j++){
				if(sudoku[i][j] != 0) {
					check[sudoku[i][j]] = true;
				}
			}
		}
		
		// �� ĭ ä���
		for(int i=1; i<10; i++){
			if(!check[i]) { // ���� ������� ���� ������ ���
				sudoku[x][y] = i; // �� ĭ�� �ֱ�
				solve(depth+1); // ���� �� ĭ ä���
				sudoku[x][y] = 0; // �� �� �ִ� ���ڰ� ������ ä�� ĭ�� ���� ���� ���� ã�� 
			}
		}
	}
}
