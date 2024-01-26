package backjun.silver;
/*
 * ▶ Math
 *   ceil : 올림
 *   floor : 내림
 *   round : 반올림
 */
import java.util.Arrays;
import java.util.Scanner;

/*
 * 두 통나무 간의 높이 차의 최댓값이 가작 작게
 * 
 * 테스트 케이스 T, 통나무 개수 N, 각 통나무 높이
 * 중간 기준으로 양옆으로 내림차순
 * 
 * 가장 큰 수 중간, 양옆으로 하나씩
 * 최댓값 기준 하나씩 내려오면서 두 개의 배열에 넣기
 * 양옆이랑 비교하고 배열 마지막 숫자끼리 비교하기
 * 
 * 	1 2 3 4 5 6 7 8
 * 	mid == 4
 * 	1             2
 *    3         4
 *      5     6
 *        7 8
 * 
 */
public class B11497 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		int N;
		for(int t=0; t<T; t++){
			N = sc.nextInt();
			
			int[] heightList = new int[N];
			for(int i=0; i<N; i++){
				heightList[i] = sc.nextInt();
			}
			
			// 높이 기준 오름차순
			Arrays.sort(heightList);

			// 가장 높은 수를 중간에 두고 양 옆으로 하나씩
			boolean isOdd = (N%2 == 1) ? true : false;
			int mid = N/2;
			int[] answerList = new int[N];

			int temp = 0;
			if(isOdd) answerList[mid] = heightList[N-1]; // 홀수인 경우 중간값 넣어주기
			for(int i=0; i<mid; i++){
				answerList[i] = heightList[temp];
				answerList[N-1-i] = heightList[temp+1];
				
				temp +=2;
			}
			
			int max = 0;
			for(int i=0; i<N; i++){
				if(i != N-1){
					temp =  Math.abs(answerList[i] - answerList[i+1]);
				} else {
					temp = answerList[i] - answerList[0];
				}

				if(max < temp){
					max = temp;
				}
			}
			System.out.println(max);
		}
	}
}
