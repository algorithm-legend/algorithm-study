package backjun.silver;
/*
 * ���� : �ߺ� ���� ���� �ٸ� N�� �߿� ���� ���� M�� ����
 * ���� x -> ���� ������ ���Һ��� �ڿ� �ִ� ���Ҹ��� Ž��
 * �ߺ� x -> �̹� �湮�� ���Ҹ� �ٽ� �湮���� �ʵ��� üũ > ������ �ڿ� �ִ� ���Ҹ� üũ
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
	
	// ��Ʈ��ŷ
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
