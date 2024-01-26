package backjun.silver;
/*
 * �� �׸��� �˰��� - Ȱ�� ���� ����(Activity Selection problem)
 * �� ����� �ϳ��� Ȱ���� ���ؼ��� �۾��� �� �ִ�.
 * > �ϳ��� Ȱ���� �Ϸ��ϱ� �������� �ٸ� Ȱ���� ������ �� ����.
 * > �ϳ��� Ȱ���� �����ϸ� ������ ��ġ�� �ʴ� Ȱ���� ���ؼ� �������̴�.
 * > Ž�� ������ ������ ����� ������ ��ġ�� �ʴ´�.
 * 
 * �� HashMap - value �������� ����
 * 	Map<Integer, Integer> map = new HashMap<>();
 * 
 * 	1. �迭�� ��ȯ
 * 	   List<Map.Entry<Integer, Integer>> entryList = new LinkedList<>(map.entrySet());
 * 
 * 	2. ����
 * 	  �� Map.Entry.comparingByValue() ��� (�迭�� ��ȯ)
 *      entryList.sort(Map.Entry.comparingByValue());
 *   
 * 	  �� comparator ���
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
 * ȸ�� N, ȸ�ǽð�
 * 
 * 1. ȸ�� ������ �ð��� ���� ���� ���� ȸ�� ���� ����
 * 	  > ������ �ð� ���� ��������
 * 2. ȸ�� ������ �ð����� ���� �����ϴ� ȸ�Ǵ� ���� �Ұ���
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
		
		// ����ð� �������� ��������, ���� �ð� ��������
		Arrays.sort(timeList, (o1, o2) ->{
			return o1[1] != o2[1] ? o1[1] - o2[1] : o1[0] - o2[0];
		});
		
		// ���� ���� ������ ȸ�Ǻ��� ����
		int end = 0;
		int count = 0;
		for(int[] time : timeList){
			if(time[0] >= end){ // ���� �ð��� ������ ���� && ���� ���� ������ ȸ�Ǻ��� �ʰ� ����
				count++;
				end = time[1];
			}
		}
		
		System.out.println(count);
	}
}
