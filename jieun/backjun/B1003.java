package backjun.silver;
/*
 0 : 1 0
 1 : 0 1
 2 : 1 1
 3 : 1 2
 4 : 2 3
 5 : 3 5
 6 : 5 8
 7 : 8 13
 
 0�� ���� : ���� 1�� ����
 1�� ���� : 0�� ���� + 1�� ����
*/

/*
 * �õ� 1. �������� �����Ͽ� 0, 1�� ���ö����� ++ 
 * 		 => static �޼ҵ� �������� static ������ �о�� �� ���� 
 * �õ� 2. �Ǻ���ġ �޼ҵ� N-1�� : 0�� ����
 *       �Ǻ���ġ �޼ҵ� N�� : 1�� ����
 *       => stackOverflowError �߻�
 * �õ� 3. �Ǻ���ġ ������ 0, 1�� ����
 * 		 => �ʱ�ȭ �ʼ� ***
 */


import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class B1003 {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = sc.nextInt();
		 
		int num;
		int zero;
		int one;
		for(int i=0; i<n; i++){
			zero = 0;
			one = 1;
			num = sc.nextInt();
			if(num == 0) {
				bw.write("1 0\n");
			} else if(num == 1){
				bw.write(zero + " " + one + "\n");
			} else {
				int temp;
				for(int j=1; j<num; j++){
					temp = one;
					one += zero;
					zero = temp;
				}
				bw.write(zero + " " + one + "\n");
			}
		}
		bw.flush(); 
		bw.close();
	}
	
	public static int fibonacci(int n){
		if(n == 0) {
			return 0;
		} else if(n == 1) {
			return 1;
		} else {
			return fibonacci(n-1) + fibonacci(n-2);
		}
	}

}
