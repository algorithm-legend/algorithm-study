package backjun.silver;
/*
 * 1 : 1
 * 2 : 10
 * 3 : 100, 101
 * 4 : 1000, 1001, 1010
 * 5 : 10000, 10001, 10010, 10100, 10101
 * 6 : 100000, 100001, 100010, 100100, 100101, 101000, 101001, 101010
 * 7 : 1000000, 1000001, 1000010, 1000100, 1000101, 1001000, 1001001, 1001010, 1010000, 1010001, 1010010, 1010100, 1010101
 * 
 * D[7] = D[1]~D[5]까지의 개수 합 = D[5] + D[6]
 * ∵ D[6] = D[1]~D[4]까지의 개수 합이므로 D[7]은 D[5]의 갯수를 더해줘야함
 * 
 * D[n] = D[n-1] + D[n-2]
 * 
 * int형 변수 표현 범위 : -2^31 ~ 2^31 -1 (약 ±20억)
 * > int형 변수 사용하는 경우, 90 입력하면 오버플로우 발생
 */
import java.util.Scanner;

public class B2193 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		long[] D = new long[n+1];
		if(n>0) D[1] = 1;
		
		for(int i=2; i<=n; i++){
			D[i] = D[i-1] + D[i-2];
		}
		
		System.out.println(D[n]);
	}
}
