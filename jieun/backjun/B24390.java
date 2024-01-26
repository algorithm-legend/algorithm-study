package backjun.silver;

import java.util.Scanner;

public class B24390 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String time[] = sc.nextLine().split(":");
		
		int min = Integer.parseInt(time[0]);
		int sec = Integer.parseInt(time[1]);
		
		int count = 0;
		boolean isStart = false;
		
		count += min % 10;
		count += min / 10;
		
		if(sec >= 30) {
			sec -= 30;
			count++;
			isStart = true;
		}
		
		count += sec/10;
		
		if(!isStart) count++;
		
		System.out.println(count);
	}

}
