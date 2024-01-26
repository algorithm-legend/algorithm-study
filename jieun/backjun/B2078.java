package backjun.silver;
/*
 						(1, 1)
 				(2, 1)				// (1,1) �������� ��Ī
 		(3, 1) 			(2, 3)  
	(4, 1) 	(3, 4)  (5, 3)  (2, 5)
	
	// �� ���� ���� ���� ���� ���� �� ����
 */
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class B2078 {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int a = sc.nextInt(); // ���� ����
		int b = sc.nextInt(); // ������ ����
		
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
