package backjun.silver;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/*
 * A - B 친구 / B - c 친구 -> A - C 친구
 * 친구면 Y, 아니면 N
 */
public class B1058 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//		Scanner sc = new Scanner(System.in);
//		int n = Integer.parseInt(sc.nextLine());
		int n = Integer.parseInt(br.readLine());
		
		String[] isFriend = new String[n]; // 한 줄씩 받아오기(NYNNN)
		Map<Integer, Set<Integer>> friendMap = new HashMap<>(); 
//		Map<Integer, Set<Integer>> answerMap = new HashMap<>();
		Set<Integer> innerList;
		
		int[] count = new int[n];
		int max = 0;

		// 친구면 Map에 번호 넣어놓기
		for (int i = 0; i < n; i++) {
//			isFriend[i] = sc.nextLine();
			isFriend[i] = br.readLine();

			innerList = new HashSet<>();
			for (int j = 0; j < n; j++) {
				if (isFriend[i].charAt(j) == 'Y') {
					innerList.add(j);
				}
				friendMap.put(i, innerList);
			}
		}
		
		for(Entry<Integer, Set<Integer>> entry : friendMap.entrySet()){
			
			innerList = new HashSet<>(friendMap.get(entry.getKey())); 
			/* innerList = friendMap.get(entry.getKey()); // Shallow Copy
			   => innerList에 값을 추가하면 원본 배열인 friendMap에도 값이 추가됨
			   java.util.ConcurrentModificationException 오류 발생 
			*/ 
			
			for(int myFriend : entry.getValue()){ 
				for(int friendFriend : friendMap.get(myFriend)){ // 친구의 친구
					if(friendFriend != entry.getKey())
					 innerList.add(friendFriend);
				}
			}
			
			max = Math.max(max, innerList.size());
//			if(max < innerList.size()) max = innerList.size();
		}
	
		bw.write(max);
        bw.close();
        br.close();
	}
}
