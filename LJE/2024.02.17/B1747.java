package backjun.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B1747 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		/*
		 *  1. N ���� ū ���� ���� �Ҽ� ã��
		 *     1) N���� ���� �� �߿� �������� �� 0�� �Ǵ� ���� ������ �Ҽ� �ƴ�
		 *     2) N�� �����ٺ��� ���� ������ ã��
		 *  2. �Ӹ�����ΰ� ? 
		 *  	> ������ ��, �ƴϸ� ���� �Ҽ� ���ϱ�
		 */
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int prime = 0;
		while(true){
			// 99% �ݷ� : N=1�� ���
			// �Ҽ� �Ǻ�
			if(N>1 && isPrime(N)){
				// �Ҽ��ΰ�� �Ӹ���� ������ �Ǻ�
				if(isPalindrome(N)) break;
			}
			
			N++;
		}
		
		System.out.println(N);
	}
	
	public static boolean isPrime(int N){
		for(int i=2; i*i<=N; i++){
			if(N%i == 0) return false;
		}
		return true;
	}
	
	public static boolean isPalindrome(int prime){
		String str = Integer.toString(prime);
		for(int i=0; i<str.length()/2; i++){
			if(str.charAt(i) != str.charAt(str.length()-1-i)) 
				return false;
		}
		return true;
	}
}
