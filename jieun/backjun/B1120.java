package backjun.silver;
// bList.length - aList.length + 1 : b의 앞에서부터 a랑 비교, 한칸씩 옆으로 이동
/*
 * b.length = 5, a.length = 3인 경우
 * 
 * b  - - - - -
 * a  - - -
 *      - - -
 *        - - -
 *  => 세 가지 경우의 수 나옴
 */

import java.util.Scanner;

public class B1120 { 
	public static void main(String[] args) {
		/*
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] words = br.readLine().split(" ");
		
		String a = words[0];
		String b = words[1];
		*/
		Scanner sc = new Scanner(System.in); // 196ms
		
		String a = sc.next();
		String b = sc.next();
		
		String[] aList = a.split("");
		String[] bList = b.split("");
		
		int count = 50;
		int tempCount = 0;
		
		if(b.contains(a)){ // b가 a를 포함할 때
			System.out.println(0);
		} else {
			for(int i=0; i<bList.length - aList.length + 1; i++){
				tempCount = 0;
				for(int j=0; j<aList.length; j++){
					if(!aList[j].equals(bList[i+j])) tempCount++;
				}
				if(tempCount < count) count = tempCount;
			}

			System.out.println(count);
		}
	}
}
