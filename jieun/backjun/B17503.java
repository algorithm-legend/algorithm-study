package backjun.silver;
/*
 * ▶  이진 탐색
 * '정렬되어 있는 리스트'에서 탐색 범위를 절반씩 좁혀가며 데이터 탐색
 * start, end, mid 사용
 * 찾으려는 데이터와 중간점 위치에 있는 데이터를 반복적으로 비교해서 원하는 데이터를 찾는 것
 * 
 * ▶  그리디 알고리즘
 * 최적의 값을 구해야 하는 상황에서 '현재 상태에서 최적이라고 생각되는 것'을 선택해나가는 방식으로 탐색
 * 
 * ▶  우선순위 큐
 * 저장 순서와 관계 없이 우선순위가 높은 것부터 꺼내게 됨
 * null 저장 불가(저장 시  NullPointException 발생)
 * 
 * //낮은 숫자가 우선 순위인 int 형 우선순위 큐
 * PriorityQueue<Integer> priorityQueueLowest = new PriorityQueue<>();
 *
 * //높은 숫자가 우선 순위인 int 형 우선순위 큐
 * PriorityQueue<Integer> priorityQueueHighest = new PriorityQueue<>(Collections.reverseOrder());
 */

/*
 * 마실 수 있는 맥주 갯수, 선호도 합, 종류
 * 선호도(1), 도수 레벨(2)
 * 
 * 1 최댓값, 2 최솟값
 */


import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class B17503 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt(); // 마실 수 있는 맥주 갯수
		int M = sc.nextInt(); // 선호도 합
		int K = sc.nextInt(); // 맥주 종류
		sc.nextLine();
		
		int[][] beerArray = new int[K][2];
		for(int i=0; i<K; i++){
			beerArray[i][1] = sc.nextInt(); // 선호도
			beerArray[i][0] = sc.nextInt(); // 도수
			sc.nextLine();
		}

		// 정렬 (도수 오름차순, 선호도 내림차순)
		Arrays.sort(beerArray, (o1, o2) -> {
			return o1[0] != o2[0] ? o1[0]-o2[0] : o2[1]-o1[1];
		});
		
		// 낮은 숫자 우선순위 큐
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		int tempScore = 0;
		int best = -1;
		for(int i=0; i<K; i++){
			pq.add(beerArray[i][1]); // 도수가 가장 낮은 맥주의 선호도 
			tempScore += beerArray[i][1];
			
			if(pq.size() == N && tempScore >= M){
				best = beerArray[i][0]; // 선호도 합이 목표값을 넘었을 때 해당 맥주의 도수 출력(도수 오름차순이므로 가장 높은 도수 출력됨)
				break;
			} else if(pq.size() >= N){
				tempScore -= pq.poll();
			}
		}
		
		System.out.println(best);
	}
}

