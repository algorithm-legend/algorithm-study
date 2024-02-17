/*
 * �����佺�׳׽��� ü : ������ �ڿ��� n�� ���� �� ������ �Ҽ��� ��� ã�� ���
 * 
 * 1 ~ 100����
 * �� 1 ����
 * �� 2�� ��� ����
 * �� 3�� ��� ����
 * ...
 * �� 11*11 > 100 �̱� ������ ���� �ʿ� ����
 *   100 ���� �ڿ��� �߿��� 11�� ����� 11�� 1~9 ������ ���� ���� �� > 1~9 ������ ��� 
 */
package backjun.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B1929 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] temp = br.readLine().split(" ");
		
		int M = Integer.parseInt(temp[0]);
		int N = Integer.parseInt(temp[1]);
		
		boolean[] num = new boolean[N+1]; // �Ҽ��� �ƴ� ��� true
		num[0] = true;
		num[1] = true;
		
		for(int i=2; i*i < num.length; i++){
			// �Ǻ����� ���� ��
			if(!num[i]){  
				// ��� ���� (�ڽ��� ������ ���� ����� �̹� ���ŵ�)
				for(int j=i*i; j< num.length; j+=i){ 
					num[j] = true;
				}
			}
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i=M; i<=N; i++){
			if(!num[i]){
				sb.append(i).append("\n");
			}
		}
		System.out.println(sb);
	}
	
	/*
	// �ð� �ʰ�
	public static void main(String[] args) { 
		Scanner sc = new Scanner(System.in);
		
		int M = sc.nextInt();
		int N = sc.nextInt();
		
		boolean isPrime = true;
		for(int i=M; i<=N; i++){
			if(i != 0 && i != 1){
				for(int j=2; j<i; j++){
					// ������ ���� �� �߿� ���������� ���� ������ �Ҽ� �ƴ�
					if(i%j == 0) {
						isPrime = false;
						break;
					}
				}
				if(isPrime) System.out.println(i);
				isPrime = true;
			}
		}
	}
	*/
}
