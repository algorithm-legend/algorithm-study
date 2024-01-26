package backjun.silver;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;


/* Queue
 * 
 * 0. 선언
 * 	  Queue<자료형> 변수명 = new LinkedList<>();
 * 	  → 자료형에 넣은 자료형만 삽입, 삭제 가능
 * 	  Queue 변수명 = new LinkedList();
 *    → 어떤 자료형이든 삽입, 삭제 가능
 * 
 * 1. 삽입
 * 	  q.add(삽입할 값);
 *    → 반환값(boolean) : 삽입 성공 시 true / 실패 시 Exception 발생
 *    q.offer(삽입할 값);
 *    → 반환값(boolean) : 삽입 성공 시 true / 실패 시 false 
 * 
 * 2. 삭제
 *    q.remove();
 *    → 반환값(삭제된 값의 자료형) : 삭제된 value / 공백 큐인 경우 Exception 발생
 *    q.remove();
 *    → 반환값(boolean) : 큐에 해당 value가 존재하면 삭제 후 true / 존재하지 않으면 false
 *    q.poll();
 *    → 반환값(삭제된 값의 자료형) : 삭제된 value / 공백 큐인 경우 null
 *    
 * 3. 큐의 head에 위치한 value 반환
 *    q.element();
 *    → 반환값(반환하는 값의 자료형) : 큐의 head에 위치한 value / 공백 큐인 경우 Exception 발생
 *    q.peek();
 *    → 반환값(반환하는 값의 자료형) : 큐의 head에 위치한 value / 공백 큐인 경우 null
 *    
 * 4. 초기화
 *    q.clear();
 *    → 반환값 void
 *    
 * 5. 큐의 크기
 *    q.size();
 *    → 반환값(int) : 큐의 사이즈 반환
 *    
 * 6. 큐에 존재하는 원소 찾기
 *    q.contains(찾을 값);
 *    → 반환값(boolean) : 해당 값이 존재하는 경우 true / 없는 경우 false
 * 
 * 7. 공백 큐 확인
 *    q.isEmpty();
 *    → 반환값(boolean) : 공백 큐인 경우 true / 아니면 false
 */

/*
 * 라우터에 들어온 패킷 순서대로 입력
 * 패킷 처리 속도보다 입력 속도가 빠른 경우, 버퍼에 공간이 생길때까지 입력받은 패킷 버림
 * 
 * 1 : 라우터 내부 버퍼의 크기 
 * 2 ~ N : 라우터가 처리해야할 정보
 * 		   0 : 라우터가 패킷을 처리함
 *  	  -1 : 종료
 *  
 * 출력 : 라우터에 남아있는 패킷 
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
//		String answer = ""; // 시간초과.. (1872ms) 
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
