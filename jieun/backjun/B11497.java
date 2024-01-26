package backjun.silver;
/*
 * �� Math
 *   ceil : �ø�
 *   floor : ����
 *   round : �ݿø�
 */
import java.util.Arrays;
import java.util.Scanner;

/*
 * �� �볪�� ���� ���� ���� �ִ��� ���� �۰�
 * 
 * �׽�Ʈ ���̽� T, �볪�� ���� N, �� �볪�� ����
 * �߰� �������� �翷���� ��������
 * 
 * ���� ū �� �߰�, �翷���� �ϳ���
 * �ִ� ���� �ϳ��� �������鼭 �� ���� �迭�� �ֱ�
 * �翷�̶� ���ϰ� �迭 ������ ���ڳ��� ���ϱ�
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
			
			// ���� ���� ��������
			Arrays.sort(heightList);

			// ���� ���� ���� �߰��� �ΰ� �� ������ �ϳ���
			boolean isOdd = (N%2 == 1) ? true : false;
			int mid = N/2;
			int[] answerList = new int[N];

			int temp = 0;
			if(isOdd) answerList[mid] = heightList[N-1]; // Ȧ���� ��� �߰��� �־��ֱ�
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
