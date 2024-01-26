package backjun.silver;
/*
 						(1, 1)
 				(2, 1)				// (1,1) 기준으로 대칭
 		(3, 1) 			(2, 3)  
	(4, 1) 	(3, 4)  (5, 3)  (2, 5)
	
	// 각 노드는 절대 같은 값이 있을 수 없음
 */
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class B2078 {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int a = sc.nextInt(); // 왼쪽 숫자
		int b = sc.nextInt(); // 오른쪽 숫자
		
		int left = 0;
		int right = 0;
		
		while(true){
			if(a > b){
				left++;
				a -= b;
			} else {
				right++;
				b -= a;
			}
			if(a == 1 && b == 1) break;
		}
		
		bw.write(left + " " + right); 
		bw.flush(); 
		bw.close(); 
		
	}
}
