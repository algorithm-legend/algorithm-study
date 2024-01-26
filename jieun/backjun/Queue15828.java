package backjun.silver;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;


/* Queue
 * 
 * 0. ����
 * 	  Queue<�ڷ���> ������ = new LinkedList<>();
 * 	  �� �ڷ����� ���� �ڷ����� ����, ���� ����
 * 	  Queue ������ = new LinkedList();
 *    �� � �ڷ����̵� ����, ���� ����
 * 
 * 1. ����
 * 	  q.add(������ ��);
 *    �� ��ȯ��(boolean) : ���� ���� �� true / ���� �� Exception �߻�
 *    q.offer(������ ��);
 *    �� ��ȯ��(boolean) : ���� ���� �� true / ���� �� false 
 * 
 * 2. ����
 *    q.remove();
 *    �� ��ȯ��(������ ���� �ڷ���) : ������ value / ���� ť�� ��� Exception �߻�
 *    q.remove();
 *    �� ��ȯ��(boolean) : ť�� �ش� value�� �����ϸ� ���� �� true / �������� ������ false
 *    q.poll();
 *    �� ��ȯ��(������ ���� �ڷ���) : ������ value / ���� ť�� ��� null
 *    
 * 3. ť�� head�� ��ġ�� value ��ȯ
 *    q.element();
 *    �� ��ȯ��(��ȯ�ϴ� ���� �ڷ���) : ť�� head�� ��ġ�� value / ���� ť�� ��� Exception �߻�
 *    q.peek();
 *    �� ��ȯ��(��ȯ�ϴ� ���� �ڷ���) : ť�� head�� ��ġ�� value / ���� ť�� ��� null
 *    
 * 4. �ʱ�ȭ
 *    q.clear();
 *    �� ��ȯ�� void
 *    
 * 5. ť�� ũ��
 *    q.size();
 *    �� ��ȯ��(int) : ť�� ������ ��ȯ
 *    
 * 6. ť�� �����ϴ� ���� ã��
 *    q.contains(ã�� ��);
 *    �� ��ȯ��(boolean) : �ش� ���� �����ϴ� ��� true / ���� ��� false
 * 
 * 7. ���� ť Ȯ��
 *    q.isEmpty();
 *    �� ��ȯ��(boolean) : ���� ť�� ��� true / �ƴϸ� false
 */

/*
 * ����Ϳ� ���� ��Ŷ ������� �Է�
 * ��Ŷ ó�� �ӵ����� �Է� �ӵ��� ���� ���, ���ۿ� ������ ���涧���� �Է¹��� ��Ŷ ����
 * 
 * 1 : ����� ���� ������ ũ�� 
 * 2 ~ N : ����Ͱ� ó���ؾ��� ����
 * 		   0 : ����Ͱ� ��Ŷ�� ó����
 *  	  -1 : ����
 *  
 * ��� : ����Ϳ� �����ִ� ��Ŷ 
 * 
 */
public class Queue15828 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int size = sc.nextInt();

		int temp = 0;
		Queue<Integer> queue = new LinkedList<>();
		
		while(true){
			temp = sc.nextInt();
			
			if(temp == -1) break;
			
			if(temp == 0){
				queue.poll();
			} else if( queue.size() < size){
				queue.add(temp);
			}
		}
		
		StringBuilder answer = new StringBuilder(); // 912ms
//		String answer = ""; // �ð��ʰ�.. (1872ms) 
		if(queue.isEmpty()){
			answer.append("empty");
		} else {
			while(!queue.isEmpty()){
				answer.append(queue.peek() + " ");
				queue.poll();
			}
		}
		
		System.out.println(answer);
	}
}
