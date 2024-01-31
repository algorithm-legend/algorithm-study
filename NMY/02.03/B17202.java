package codeTest;

import java.util.*;

/*
 *  3 9 5
	2 5
	4 6
	3 3
	4 3
	1 4
 */

public class B17503 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		PriorityQueue<Integer> queue = new PriorityQueue<>();
		
		int N = sc.nextInt();
		int M = sc.nextInt();
		int K = sc.nextInt();
		
		int result = -1;
		int temp = 0;
		
		int arr[][] = new int[K][2];
		
		for(int i = 0; i<K;i++) {
			 
			arr[i][0] = sc.nextInt();
			arr[i][1] = sc.nextInt();
		}
		
		Arrays.sort(arr, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                if (a[1] != b[1]) {
                    return a[1] - b[1];
                }
                return b[0] - a[0];
            }
        });
		
		for(int i = 0; i<K;i++) {
			queue.add(arr[i][0]);
			temp += arr[i][0];
			
			if(queue.size()>N) {
				temp -= queue.poll();
			}
			
			if(queue.size()==N&&temp>=M) {
				result = arr[i][1];
				break;
			}
			
		}
		
		System.out.println(result);

	}

}
