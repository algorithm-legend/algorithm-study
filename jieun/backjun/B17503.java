package backjun.silver;
/*
 * ��  ���� Ž��
 * '���ĵǾ� �ִ� ����Ʈ'���� Ž�� ������ ���ݾ� �������� ������ Ž��
 * start, end, mid ���
 * ã������ �����Ϳ� �߰��� ��ġ�� �ִ� �����͸� �ݺ������� ���ؼ� ���ϴ� �����͸� ã�� ��
 * 
 * ��  �׸��� �˰���
 * ������ ���� ���ؾ� �ϴ� ��Ȳ���� '���� ���¿��� �����̶�� �����Ǵ� ��'�� �����س����� ������� Ž��
 * 
 * ��  �켱���� ť
 * ���� ������ ���� ���� �켱������ ���� �ͺ��� ������ ��
 * null ���� �Ұ�(���� ��  NullPointException �߻�)
 * 
 * //���� ���ڰ� �켱 ������ int �� �켱���� ť
 * PriorityQueue<Integer> priorityQueueLowest = new PriorityQueue<>();
 *
 * //���� ���ڰ� �켱 ������ int �� �켱���� ť
 * PriorityQueue<Integer> priorityQueueHighest = new PriorityQueue<>(Collections.reverseOrder());
 */

/*
 * ���� �� �ִ� ���� ����, ��ȣ�� ��, ����
 * ��ȣ��(1), ���� ����(2)
 * 
 * 1 �ִ�, 2 �ּڰ�
 */


import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class B17503 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt(); // ���� �� �ִ� ���� ����
		int M = sc.nextInt(); // ��ȣ�� ��
		int K = sc.nextInt(); // ���� ����
		sc.nextLine();
		
		int[][] beerArray = new int[K][2];
		for(int i=0; i<K; i++){
			beerArray[i][1] = sc.nextInt(); // ��ȣ��
			beerArray[i][0] = sc.nextInt(); // ����
			sc.nextLine();
		}

		// ���� (���� ��������, ��ȣ�� ��������)
		Arrays.sort(beerArray, (o1, o2) -> {
			return o1[0] != o2[0] ? o1[0]-o2[0] : o2[1]-o1[1];
		});
		
		// ���� ���� �켱���� ť
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		int tempScore = 0;
		int best = -1;
		for(int i=0; i<K; i++){
			pq.add(beerArray[i][1]); // ������ ���� ���� ������ ��ȣ�� 
			tempScore += beerArray[i][1];
			
			if(pq.size() == N && tempScore >= M){
				best = beerArray[i][0]; // ��ȣ�� ���� ��ǥ���� �Ѿ��� �� �ش� ������ ���� ���(���� ���������̹Ƿ� ���� ���� ���� ��µ�)
				break;
			} else if(pq.size() >= N){
				tempScore -= pq.poll();
			}
		}
		
		System.out.println(best);
	}
}

