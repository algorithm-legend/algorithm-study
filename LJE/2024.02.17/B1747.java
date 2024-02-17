package backjun.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B1747 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		/*
		 *  1. N 보다 큰 가장 작은 소수 찾기
		 *     1) N보다 작은 수 중에 나누었을 때 0이 되는 수가 있으면 소수 아님
		 *     2) N의 제곱근보다 작은 수에서 찾기
		 *  2. 팰린드롬인가 ? 
		 *  	> 맞으면 끝, 아니면 다음 소수 구하기
		 */
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int prime = 0;
		while(true){
			// 99% 반례 : N=1인 경우
			// 소수 판별
			if(N>1 && isPrime(N)){
				// 소수인경우 팰린드롬 수인지 판별
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
