package backjun.bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class B17202 {
	public static final int phone = 8;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] arrA = br.readLine().split("");
		String[] arrB = br.readLine().split("");
		
		ArrayList<Integer> arr = new ArrayList<>();
		
		// 휴대폰번호 정렬(ABAB..)
		for(int i=0; i<phone;i++){
			arr.add(Integer.parseInt(arrA[i]));
			arr.add(Integer.parseInt(arrB[i]));
		}
		
		int i = 0;
		int arrSize = arr.size();
		while(arr.get(2) != -1){ // 두 개의 숫자만 남을때까지 반복
			if(i < arrSize -1){
				arr.set(i, (arr.get(i) + arr.get(i+1)) % 10 ); // 현재 인덱스에 (현재 + 다음) % 10 입력
				i++;
			} else {
				arr.set(i, -1); // 계산 완료한 마지막 인덱스에 -1 입력
				i = 0; // 반복문 초기화
				arrSize--; // 배열 사이즈 변경
			}
		}
		
        System.out.println(arr.get(0) + "" + arr.get(1));
        
	}
}
