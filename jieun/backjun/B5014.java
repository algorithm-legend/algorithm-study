package backjun.silver;
/*
 * 1. boolean�� �迭�� �湮�� �� true / count++
 *    -> �ִܰ�ΰ� �ƴ� �湮�� ��� ����� ���� ī��Ʈ ��
 *    
 * 2. int�� �迭 check
 * 	    �� ���� �湮�߾����� Ȯ��(check[now] > 0)
 *    ���°�� �湮�ߴ��� Ȯ��(check[now] + 1)
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
				count = check[now] -1; // ���� ������ ����
				answer = Integer.toString(count);
			}
			
			temp = now + up;
			if(temp<=floor && check[temp] < 1){ // �ְ������� ���� �湮���� ���� ���
				q.offer(temp);
				check[temp] = check[now] + 1;
			} 
			
			temp = now - down;
			if(temp>0 && check[temp] < 1){ // ���������� ���� �湮���� ���� ���
				q.offer(temp);
				check[temp] = check[now] + 1;
			}
		}
		
		System.out.println(answer);
	}
}
