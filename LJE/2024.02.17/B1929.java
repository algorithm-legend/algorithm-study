/*
 * 에라토스테네스의 체 : 임의의 자연수 n에 대해 그 이하의 소수를 모두 찾는 방법
 * 
 * 1 ~ 100에서
 * ① 1 제거
 * ② 2의 배수 제거
 * ③ 3의 배수 제거
 * ...
 * ④ 11*11 > 100 이기 때문에 지울 필요 없음
 *   100 이하 자연수 중에서 11의 배수는 11에 1~9 사이의 값을 곱한 것 > 1~9 사이의 배수 
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
		
		boolean[] num = new boolean[N+1]; // 소수가 아닌 경우 true
		num[0] = true;
		num[1] = true;
		
		for(int i=2; i*i < num.length; i++){
			// 판별되지 않은 수
			if(!num[i]){  
				// 배수 제거 (자신의 곱보다 작은 배수는 이미 제거됨)
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
	// 시간 초과
	public static void main(String[] args) { 
		Scanner sc = new Scanner(System.in);
		
		int M = sc.nextInt();
		int N = sc.nextInt();
		
		boolean isPrime = true;
		for(int i=M; i<=N; i++){
			if(i != 0 && i != 1){
				for(int j=2; j<i; j++){
					// 나보다 작은 수 중에 나누어지는 수가 있으면 소수 아님
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
