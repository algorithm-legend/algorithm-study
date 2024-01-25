package codeTest;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class B11497 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		List<Integer> list = new ArrayList<>();
		int e = 0;
		
		int result;
		int diff;
		
		for(int i = 0; i<T; i++) {
			e = sc.nextInt();
			result = 0;
			for(int j = 0;j<e;j++) {
				list.add(sc.nextInt());
			}
			list.sort(Comparator.naturalOrder());
			
			if(e%2==0) {
				for(int c = e-3;c>0;c-=2) {
					list.add(list.get(c));
					list.remove(c);
				}
			}else {
				for(int k = e-2;k>0;k-=2) {
					list.add(list.get(k));
					list.remove(k);
				}
			}
			
			for (int b = 0; b < list.size() - 1; b++) {
	            diff = Math.abs(list.get(b+1) - list.get(b));
	            if (diff > result) {
	                result = diff;
	            }
	        }
			
			System.out.println(result);
			
			list.clear();
		}
		
	}

}
