package backjun.gold;
/*
 * 최장 공통 문자열(Longest Common Substring) : 연속되는 문자열
 * LCS[i][j] = LCS[i-1][j-1] + 1
 * 
 * 최장 공통 부분 수열(Longest Common Subsequence) : 문자열이 연속적이지 않아도 된다.
 * 두 문자가 일치하는 경우 : LCS[i][j] = LCS[i-1][j-1] + 1
 * 두 문자가 일치하지 않는 경우 : LCS[i][j] = max(LCS[i-1][j], LCS[i][j-1])
 * 
 */
import java.util.Scanner;

public class B9251 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String str1 = sc.nextLine();
		String str2 = sc.nextLine();
		
		int[][] lcs = new int[str1.length()+1][str2.length()+1];
		int max = 0;
		for(int i=1; i<str1.length()+1; i++){
			for(int j=1; j<str2.length()+1; j++){
				if(str1.charAt(i-1) == str2.charAt(j-1)){
					lcs[i][j] = lcs[i-1][j-1] + 1;
				} else {
					lcs[i][j] = Math.max(lcs[i-1][j], lcs[i][j-1]);
				}
				
				if(lcs[i][j] > max) max = lcs[i][j];
			}
		}
		
		System.out.println(max);
	}
}
