package codeTest;

import java.util.*;

public class B2606 {
	
	static boolean[][] network;
    static boolean[] check;
    static int result = 0;
    static Stack<Integer> stack = new Stack<>();
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		int com = sc.nextInt();
		int conn = sc.nextInt();
		
		network = new boolean[com+1][com+1];
		check = new boolean[com+1];
		
		int a;
		int b;
		
		for(int i = 0; i<conn; i++) {
			a = sc.nextInt();
			b = sc.nextInt();
			
			network[a][b] = true;
			network[b][a] = true;
		}
		
		bfs(1);
		
		System.out.println(result);
	}
	
	static void bfs(int com) {
		Queue<Integer> queue = new LinkedList<Integer>();
		check[com] = true;
		queue.add(com);
		int temp;

		while(!queue.isEmpty()) {
			temp = queue.poll();
			for(int i = 1; i<network.length;i++) {
				if(network[temp][i]==true && check[i] == false) {
					queue.add(i);
					check[i] = true;
					result++;
				}
			}
		}
	
	}
	
}
/*	
	static void dfs(int com) {
		
		check[com] = true;
		stack.add(com);
		
	    for(int i = 1; i < network.length; i++) {
	    	if(network[com][i] == true && check[i] == false) {
	    		dfs(i);
	    		result++;
	        }
	    }
	}
  
	static void dfs(int V) {
		check[V] = true;
		result++;
        for(int node = 1; node < network.length; node++) {
        	if(network[V][node] == true && check[node] == false) {
        		dfs(node);
	        }
	    }
	}
	
}*/



