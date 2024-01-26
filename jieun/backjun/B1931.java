package backjun.silver;
/*
 * ▶ 그리디 알고리즘 - 활동 선택 문제(Activity Selection problem)
 * 한 사람이 하나의 활동에 대해서만 작업할 수 있다.
 * > 하나의 활동을 완료하기 전까지는 다른 활동을 선택할 수 없다.
 * > 하나의 활동을 선택하면 나머지 겹치지 않는 활동에 대해서 독립적이다.
 * > 탐욕 선택이 이후의 결과에 영향을 미치지 않는다.
 * 
 * ▶ HashMap - value 기준으로 정렬
 * 	Map<Integer, Integer> map = new HashMap<>();
 * 
 * 	1. 배열로 전환
 * 	   List<Map.Entry<Integer, Integer>> entryList = new LinkedList<>(map.entrySet());
 * 
 * 	2. 정렬
 * 	  ● Map.Entry.comparingByValue() 사용 (배열로 전환)
 *      entryList.sort(Map.Entry.comparingByValue());
 *   
 * 	  ● comparator 사용
        entryList.sort(new Comparator<Map.Entry<String, Integer>>() {
		    @Override
		    public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
			return o1.getValue() - o2.getValue();
		    }
		});
 */

import java.util.Arrays;
import java.util.Scanner;

/*
 * 회의 N, 회의시간
 * 
 * 1. 회의 끝나는 시간이 빠를 수록 많은 회의 진행 가능
 * 	  > 끝나는 시간 기준 오름차순
 * 2. 회의 끝나는 시간보다 먼저 시작하는 회의는 진행 불가능
 */
public class B1931 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		int[][] timeList = new int[N][2];
		for(int i=0; i<N; i++){
			timeList[i][0] = sc.nextInt();
			timeList[i][1] = sc.nextInt();
		}
		
		// 종료시간 기준으로 오름차순, 시작 시간 오름차순
		Arrays.sort(timeList, (o1, o2) ->{
			return o1[1] != o2[1] ? o1[1] - o2[1] : o1[0] - o2[0];
		});
		
		// 가장 먼저 끝나는 회의부터 시작
		int end = 0;
		int count = 0;
		for(int[] time : timeList){
			if(time[0] >= end){ // 시작 시간이 같으면 제외 && 가장 먼저 끝나는 회의보다 늦게 시작
				count++;
				end = time[1];
			}
		}
		
		System.out.println(count);
	}
}
