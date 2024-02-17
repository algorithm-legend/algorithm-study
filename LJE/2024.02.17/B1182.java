package backjun.silver;
/*
 * 조합 : 중복 없이 서로 다른 N개 중에 순서 없이 M개 선택
 * 순서 x -> 현재 선택한 원소보다 뒤에 있는 원소만을 탐색
 * 중복 x -> 이미 방문한 원소를 다시 방문하지 않도록 체크 > 나보다 뒤에 있는 원소만 체크
 * 
 */
import java.util.Scanner;

public class B1182 {
	static boolean[] checked;
	static int N;
	static int S;
	static int[] arr;
	static int answer;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		S = sc.nextInt();
		sc.nextLine();
		
		checked = new boolean[N];
		arr = new int[N];
		for(int i=0; i<N; i++){
			arr[i] = sc.nextInt();
		}
		
		int sum = 0;
		dfs(sum, 0, 0);
		
		System.out.println(answer);
		
	}
	
	// 백트래킹
	public static void dfs(int sum, int start, int depth){
		if(depth > 0 && sum == S){
			answer++;
		} 
		
		if(depth > N) return;
		
		for(int i=start; i<N; i++){ 
			if(!checked[i]){
				checked[i] = true;
				sum += arr[i];
				dfs(sum, i+1, depth+1);
				
				sum -= arr[i];
				checked[i] = false;
			}
		}
	}
}
