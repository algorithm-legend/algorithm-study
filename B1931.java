package codeTest;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class B1931 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int arr[][] = new int[N][2];
		
		int count =0;
		int end = 0;
		
		for(int i = 0; i<N;i++) {
			arr[i][0] = sc.nextInt();
			arr[i][1] = sc.nextInt(); 
		}
		
		Arrays.sort(arr, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                if (a[1] == b[1]) {
                    return Integer.compare(a[0], b[0]);
                }
                return Integer.compare(a[1], b[1]);
            }
        });

		for(int i = 0; i<N; i++){
			if(end <= arr[i][0]) {
				end = arr[i][1];
				count++;
			}
		}
	
		System.out.println(count);
	}

}