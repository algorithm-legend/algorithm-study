package codeTest;

import java.util.Arrays;
import java.util.Scanner;

public class B3758 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		int n,k,t,m;
		int i,j,s;
		
		int[][] score;
		int[] count;
		int[][] cc;
		int[] time;
		
		for(int a = 0; a<T;a++) {
			n = sc.nextInt();
			k = sc.nextInt();
			t = sc.nextInt();
			m = sc.nextInt();
			score = new int[n+1][4];
			count = new int[n+1]; 
			cc = new int[n+1][k+1]; 
			time = new int[n+1];
			
			for(int b = 1; b<=m;b++) {
				i = sc.nextInt();
				j = sc.nextInt();
				s = sc.nextInt();
				
				cc[i][j] = Math.max(cc[i][j], s);
				count[i]++;
				time[i] = b;
			}
			
			for(int c=0; c<=n; c++){
	            score[c] = new int[]{c, Arrays.stream(cc[c]).sum(), count[c], time[c]};
	         }
			
			Arrays.sort(score, (o1, o2) -> {
	            return o1[1] != o2[1] ? o2[1]-o1[1] : (o1[2] != o2[2] ? o1[2]-o2[2] : o1[3] - o2[3]);
	         });
			
			for(int d=0; d<=n;d++) {
				if(t==score[d][0]) {
					System.out.println(d+1);
				}
			}
		}
	}
}