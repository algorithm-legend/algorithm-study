package backjun.silver;
/*
 * �� Arrays.sort
 *   Arrays.sort(list, (o1, o2) -> {return o2-o1});
 *   �� ����� ������ ù ��° ���ڰ� �� ��° ���ں��� �۴ٰ� �����ϰ� �������� (�ڸ���ü ����) > ����� �� �ڸ� ��ü
 *   ��  o2 - o1�� ����� �� �ڸ� ��ü > o2�� o1���� ū �� > �������� 
 * 
 * ��  Arrays.sort, Collections.cort ��
 *   Arrays.sort : �迭 ����
 *   Collections.sort : ��ü ����
 * 
 *   1. sort(list) : �������� / sort(list, Collections.reverseOrder()) : ��������
 * 
 *   2. comparable �������̽� (��ü ���� �� Ȱ��)
 *     �� a.compareTo(b)
 *       a > b  : ���, a == b : 0, a < b  : ����
 *  
 * <Streams>
 * �迭�� �÷����� �Լ������� ó��(���� Ȱ��)
 * 
 * Arrays.stream(int�� �迭).sum() : int�� �迭 ��ü�� ���ϴ� �Լ�
 */
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Scanner;

/*
 * -- ù��° �� --
 * 	�׽�Ʈ ������ �� T
 * -- �ι�° �� --
 * 	�� ����
 * 	���� ��
 * 	���� �� ID
 * 	�α� ��Ʈ��
 * -- ����° �� --
 * 	�� ID
 *  ���� ��ȣ 
 *  ȹ�� ����
 * ���� : 0 ~ 100 ����
 * 
 * ������ ���� ���� : ������ ���� �� �ְ����� (���� ���� ��� 0��)
 * ���� ���� : �� ������ ���� ���� ���� 
 * 	���� ������ ���� ���, Ǯ�� ���� Ƚ�� Ȯ��
 *  ���� ������ ���� ���� Ƚ���� ���� ���, ������ ���� �ð� Ȯ��
 *  
 * �ʿ��� �� : ��num, (���� ��ȣ, �ְ�����), ���� Ƚ��, ���� �ð�  
 * 
 */

public class B3758 {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = sc.nextInt();
		
		//  ���� ����, ������ ����, ��� ���� ID, �α� ��Ʈ���� ����
		int totalTeam;
		int totalQ;
		int targetTeamID;
		int totalLog;
		
		int[][] scoreArr; // teamID, ������ �ְ�����
		int[] answerArr;
		int[] lastAnswerTimeArr;
		int[][] totalScoreArr;	// ������, �亯 Ƚ��, ������ �亯 �ð�
		
		//  �� ID, ���� ��ȣ, ȹ���� ����
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
			
			// �� ���� ������ ����, �亯 Ƚ��, ������ �亯 �ð� ���ϱ�
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
			
			// ���� ���� ���
			// ��num, ��������, ���� Ƚ��, ���� �ð�  
			for(int j=0; j<totalTeam; j++){
				totalScoreArr[j] = new int[]{j, Arrays.stream(scoreArr[j]).sum(), answerArr[j], lastAnswerTimeArr[j]};
			}
			
			// ���� (�������� ��������, �亯 Ƚ�� ��������, ������ �亯 �ð� ��������)
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
	
	
	/* ���� Ǯ��
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
		
		//  ���� ����, ������ ����, ��� ���� ID, �α� ��Ʈ���� ����
		int totalTeam;
		int totalQ;
		int targetTeamID;
		int totalLog;
		
		//  �� ID, ���� ��ȣ, ȹ���� ����
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
			
			// �������� ��������, Ǯ�� ���� Ƚ�� ��������, ������ ���� �ð� ��������
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
