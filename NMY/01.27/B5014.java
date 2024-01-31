package codeTest;

import java.util.*;

public class B5014 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		int F = sc.nextInt(); //전체 층
		int S = sc.nextInt(); //현재 층
		int G = sc.nextInt(); //목표 층
		int U = sc.nextInt(); //업 버튼
		int D = sc.nextInt(); //다운 버튼
		
		int check[] = new int[F+1];

		bfs(F,S,G,U,D,check);
		
	}

	static void bfs(int f, int s, int g, int u, int d, int[] check) {
		Queue<Integer> q = new LinkedList<Integer>();
        q.add(s);
        check[s] = 1;
 
        while (!q.isEmpty()) {
            int current = q.poll();
            if (current == g) {
                System.out.println(String.valueOf(check[current]-1)); 
                return;
            }
            if (current+u <= f && check[current+u] == 0) {
                	check[current + u] = check[current] + 1;
                    q.add(current + u);
 
            }
            if (current - d > 0 && check[current-d] == 0) {
                	check[current - d] = check[current] + 1;
                    q.add(current - d);
            }
 
        }	
        System.out.println("use the stairs");
	}
	
}