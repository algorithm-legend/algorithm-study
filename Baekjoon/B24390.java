package codeTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B24390 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String N = br.readLine();
		
		String time[] = N.split(":");
		
		int M = Integer.valueOf(time[0]);
		int S = Integer.valueOf(time[1]);
		
		int count = M % 10;
		count += M/10;
		
		if(S >= 30) {
			S -= 30;
		}
		
		count += S/10+1;
		
		System.out.println(count);
		
	}


}