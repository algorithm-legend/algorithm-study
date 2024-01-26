package backjun.silver;
/*
 * ▶ Arrays.sort
 *   Arrays.sort(list, (o1, o2) -> {return o2-o1});
 *   비교 결과가 음수면 첫 번째 인자가 두 번째 인자보다 작다고 간주하고 오름차순 (자리교체 없음) > 양수일 때 자리 교체
 *   ∴  o2 - o1이 양수일 때 자리 교체 > o2가 o1보다 큰 수 > 내림차순 
 * 
 * ▶  Arrays.sort, Collections.cort 비교
 *   Arrays.sort : 배열 정렬
 *   Collections.sort : 객체 정렬
 * 
 *   1. sort(list) : 오름차순 / sort(list, Collections.reverseOrder()) : 내림차순
 * 
 *   2. comparable 인터페이스 (객체 정렬 시 활용)
 *     ● a.compareTo(b)
 *       a > b  : 양수, a == b : 0, a < b  : 음수
 *  
 * <Streams>
 * 배열과 컬렉션을 함수형으로 처리(람다 활용)
 * 
 * Arrays.stream(int형 배열).sum() : int형 배열 전체를 더하는 함수
 */
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Scanner;

/*
 * -- 첫번째 줄 --
 * 	테스트 데이터 수 T
 * -- 두번째 줄 --
 * 	팀 개수
 * 	문제 수
 * 	나의 팀 ID
 * 	로그 엔트리
 * -- 세번째 줄 --
 * 	팀 ID
 *  문제 번호 
 *  획득 점수
 * 점수 : 0 ~ 100 사이
 * 
 * 문제의 최종 점수 : 여러번 제출 중 최고점수 (제출 안한 경우 0점)
 * 최종 점수 : 각 문제의 최종 점수 총합 
 * 	최종 점수가 같은 경우, 풀이 제출 횟수 확인
 *  최종 점수가 같고 제출 횟수가 같은 경우, 마지막 제출 시간 확인
 *  
 * 필요한 값 : 팀num, (문제 번호, 최고점수), 제출 횟수, 제출 시간  
 * 
 */

public class B3758 {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = sc.nextInt();
		
		//  팀의 개수, 문제의 개수, 당신 팀의 ID, 로그 엔트리의 개수
		int totalTeam;
		int totalQ;
		int targetTeamID;
		int totalLog;
		
		int[][] scoreArr; // teamID, 문제별 최고점수
		int[] answerArr;
		int[] lastAnswerTimeArr;
		int[][] totalScoreArr;	// 총점수, 답변 횟수, 마지막 답변 시간
		
		//  팀 ID, 문제 번호, 획득한 점수
		int teamID;
		int Qnum;
		int score;
		
		int sum = 0;
		
		for(int i=0; i<n;i++){
			totalTeam = sc.nextInt();
			totalQ = sc.nextInt();
			targetTeamID = sc.nextInt();
			totalLog = sc.nextInt();
			
			scoreArr = new int[totalTeam][totalQ];
			answerArr = new int[totalTeam];
			lastAnswerTimeArr = new int[totalTeam];
			totalScoreArr = new int[totalTeam][4];
			
			// 각 팀의 문제별 점수, 답변 횟수, 마지막 답변 시간 구하기
			for(int j=0; j<totalLog; j++){
				teamID = sc.nextInt() -1;
				Qnum = sc.nextInt() -1;
				score = sc.nextInt();
				
				answerArr[teamID] += 1;
				lastAnswerTimeArr[teamID] = j;
				if(scoreArr[teamID][Qnum] < score){
					scoreArr[teamID][Qnum] = score;
				}
			}
			
			// 최종 점수 계산
			// 팀num, 최종점수, 제출 횟수, 제출 시간  
			for(int j=0; j<totalTeam; j++){
				totalScoreArr[j] = new int[]{j, Arrays.stream(scoreArr[j]).sum(), answerArr[j], lastAnswerTimeArr[j]};
			}
			
			// 정렬 (최종점수 내림차순, 답변 횟수 오름차순, 마지막 답변 시간 오름차순)
			Arrays.sort(totalScoreArr, (o1, o2) -> {
				return o1[1] != o2[1] ? o2[1]-o1[1] : (o1[2] != o2[2] ? o1[2]-o2[2] : o1[3] - o2[3]);
			});
			
			for(int j=0; j<totalTeam; j++){
				if(targetTeamID == (totalScoreArr[j][0] + 1)){
                    bw.write(j+1 + "\n"); 
                    break;
                }
			}
		}
		bw.flush(); 
		bw.close(); 
	}
	
	
	/* 정답 풀이
	static class Team {
		int id;
		int[] scoreList;
		int answerNumber;
		int lastAnswerTime;
		int totalScore;
	}
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int testCase = sc.nextInt();
		
		//  팀의 개수, 문제의 개수, 당신 팀의 ID, 로그 엔트리의 개수
		int totalTeam;
		int totalQ;
		int targetTeamID;
		int totalLog;
		
		//  팀 ID, 문제 번호, 획득한 점수
		int teamID;
		int Qnum;
		int score;
		
		for(int i=0; i<testCase;i++){
			totalTeam = sc.nextInt();
			totalQ = sc.nextInt();
			targetTeamID = sc.nextInt();
			totalLog = sc.nextInt();
			
			Team[] teamList = new Team[totalTeam];
			for(int j=0; j<totalLog; j++){
				teamID = sc.nextInt()-1;
				Qnum = sc.nextInt()-1;
				score = sc.nextInt();
				
				if(teamList[teamID] == null){
					teamList[teamID] = new Team();
					teamList[teamID].id = teamID+1;
					teamList[teamID].scoreList = new int[totalQ];
				}
				
				teamList[teamID].answerNumber += 1;
				teamList[teamID].lastAnswerTime = j;
				if(teamList[teamID].scoreList[Qnum] < score){
					teamList[teamID].scoreList[Qnum] = score;
				}
			}
			
			for(Team team : teamList){
				for(int j=0; j<totalQ; j++){
					team.totalScore += team.scoreList[j];
				}
			}
			
			// 최종점수 내림차순, 풀이 제출 횟수 오름차순, 마지막 제출 시간 오름차순
			Arrays.sort(teamList, (o1, o2) -> {
				return o1.totalScore != o2.totalScore ? o2.totalScore - o1.totalScore : 
					(o1.answerNumber != o2.answerNumber ? o1.answerNumber - o2.answerNumber : o1.lastAnswerTime - o2.lastAnswerTime);
				});
			
			for(int j=0; j<teamList.length; j++){
				if(teamList[j].id == targetTeamID){
					bw.write(j+1 + "\n");
					break;
				}
			}
		}
		bw.flush(); 
		bw.close();
	}
	*/
}
