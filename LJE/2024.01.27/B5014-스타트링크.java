package backjun.silver;
/*
 * 1. boolean형 배열에 방문한 층 true / count++
 *    -> 최단경로가 아닌 방문한 모든 경우의 수가 카운트 됨
 *    
 * 2. int형 배열 check
 * 	    이 층을 방문했었는지 확인(check[now] > 0)
 *    몇번째에 방문했는지 확인(check[now] + 1)
 */
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class B5014 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int floor = sc.nextInt();
		int now = sc.nextInt();
		int to = sc.nextInt();
		int up = sc.nextInt();
		int down = sc.nextInt();
		
		String answer = "use the stairs";
	
		int temp = 0;
		int count = 0;
		
		Queue<Integer> q = new LinkedList<>();
		int[] check = new int[floor + 1];
		q.offer(now);
		check[now] = 1;
		
		while(!q.isEmpty()){
			now = q.poll();
			
			if(now == to){
				count = check[now] -1; // 최초 시작층 빼기
				answer = Integer.toString(count);
			}
			
			temp = now + up;
			if(temp<=floor && check[temp] < 1){ // 최고층보다 낮고 방문하지 않은 경우
				q.offer(temp);
				check[temp] = check[now] + 1;
			} 
			
			temp = now - down;
			if(temp>0 && check[temp] < 1){ // 최저층보다 높고 방문하지 않은 경우
				q.offer(temp);
				check[temp] = check[now] + 1;
			}
		}
		
		System.out.println(answer);
	}
}
