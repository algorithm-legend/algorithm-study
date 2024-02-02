package backjun.gold;
/*
 * 1. 최상위노드를 0번 노드로 가정하고 하위 노드에 숫자를 매겨 입력 > 노드의 입력 순서가 노드의 번호임, 0번 노드가 항상 최상위노드가 아닐 수 있음
 * 2. 루트노드가 리프노드일 수 있음
 */
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Objects;
import java.util.Scanner;

public class B1068 {
	/*
	 * 풀이 2
	 * target을 가지고있는 parent에서 target 삭제
	 * 최상위노드부터 깊이우선탐색으로 리프노드 찾기(타겟노드의 연결을 끊어두었으므로 타겟 하위 노드 접근 불가)
	 */
	static HashMap<Integer, ArrayList<Integer>> nodeMap;
	static int count;
	static int root;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		nodeMap = new HashMap<>();
		ArrayList<Integer> tempArr;

		// 1. 노드 추가
		int parent;
		for(int i=0; i<N; i++){
			parent = sc.nextInt();
			if(parent == -1){
				root = i;
			} else {
				if(Objects.isNull(nodeMap.get(parent))) {
					tempArr = new ArrayList<>();
					tempArr.add(i);
					nodeMap.put(parent, tempArr);
				} else {
					tempArr = nodeMap.get(parent);
					tempArr.add(i);
					nodeMap.put(parent, tempArr);
				}
			}
		}
		
		int target = sc.nextInt();
		
		System.out.println("targetIndex : " + target);
		System.out.println("root : " + root);
		
		for(Entry entry : nodeMap.entrySet()){
			System.out.println(entry.getKey() + " : " + entry.getValue());
		}
		
		count = 0;
		// 2. target을 value로 가지고있다면 삭제
		if(target != root){
			for(Entry entry : nodeMap.entrySet()){
				tempArr = nodeMap.get(entry.getKey());
				if(tempArr.contains(target)){
					tempArr.remove(tempArr.indexOf(target));
					nodeMap.put((Integer) entry.getKey(), tempArr);
					break;
				}
			}
			
			System.out.println("==");
			for(Entry entry : nodeMap.entrySet()){
				System.out.println(entry.getKey() + " : " + entry.getValue());
			}
			
			// 3. 남아있는 노드 중 리프노드 갯수 세기
			count(root);
		}
		
		System.out.println("정답 : " + count);
	}
	
	public static void count(int parent){
		if(Objects.isNull(nodeMap.get(parent)) || nodeMap.get(parent).size() == 0){
			count++;
		} else {
			for(int i : nodeMap.get(parent)){
				count(i);
			}
		}
	}
	
	/* 풀이 1
	 * target노드, 하위 노드 삭제
	 * target을 가지고있는 parent에서 target 삭제
	 * map의 전체 노드 탐색하여 리프노드 찾기(target, target하위 노드 삭제하였으므로 전체 노드 탐색 가능)
	static HashMap<Integer, ArrayList<Integer>> nodeMap;
	static int count;
	static int root;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		nodeMap = new HashMap<>();
		ArrayList<Integer> tempArr;

		// 1. 부모노드와 연결되어있는 하위 노드 추가
		int parent;
		for(int i=0; i<N; i++){
			parent = sc.nextInt();
			if(parent == -1){
				root = i;
			} else {
				if(Objects.isNull(nodeMap.get(parent))) {
					tempArr = new ArrayList<>();
					tempArr.add(i);
					nodeMap.put(parent, tempArr);
				} else {
					tempArr = nodeMap.get(parent);
					tempArr.add(i);
					nodeMap.put(parent, tempArr);
				}
			}
		}
		
		int target = sc.nextInt();
		
		System.out.println("targetIndex : " + target);
		System.out.println("root : " + root);
		
		for(Entry entry : nodeMap.entrySet()){
			System.out.println(entry.getKey() + " : " + entry.getValue());
		}
		
		removeNode(target);
		// 3. target을 value로 가지고있다면 삭제
		for(Entry entry : nodeMap.entrySet()){
			tempArr = nodeMap.get(entry.getKey());
			if(tempArr.contains(target)){
				tempArr.remove(tempArr.indexOf(target));
				nodeMap.put((Integer) entry.getKey(), tempArr);
				break;
			}
		}
		
		System.out.println("==");
		for(Entry entry : nodeMap.entrySet()){
			System.out.println(entry.getKey() + " : " + entry.getValue());
		}
		
		count = 0;
		// 4. 남아있는 노드 중 리프노드 갯수 세기
		for(Entry entry : nodeMap.entrySet()){
			tempArr = nodeMap.get(entry.getKey());
			if(tempArr.size() == 0){ // 하위 노드가 없는 노드
				count++;
			} else {
				for(int node : tempArr){
					if(Objects.isNull(nodeMap.get(node))){
						count++;
					}
				}
			}
		}

		System.out.println("정답 : " + count);
	}
	
	// 2. 타겟 노드 삭제, 타겟 노드 하위 삭제
	public static void removeNode(int target){
		if(!Objects.isNull(nodeMap.get(target))){
			for(int i : nodeMap.get(target)){
				removeNode(i);
			}
		}
		
		nodeMap.remove(target);
	}
	*/
}
