package codeTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class B1260 {

	static int[][] graph;
    static boolean[] check;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");

        int N = Integer.parseInt(str[0]);   
        int M = Integer.parseInt(str[1]);
        int V = Integer.parseInt(str[2]);

        graph = new int[N+1][N+1];

        for(int i = 0; i < M; i++) {
            String[] str2 = br.readLine().split(" ");

            int a = Integer.parseInt(str2[0]);
            int b = Integer.parseInt(str2[1]);

            graph[a][b] = 1;
            graph[b][a] = 1;
        }
        
        check = new boolean[N + 1];
        sb = new StringBuilder();
        dfs(V);
        System.out.println(sb.toString());


        check = new boolean[N + 1];
        sb = new StringBuilder();
        bfs(V);
        System.out.println(sb.toString());
    }
    
    static void dfs(int V) {
        check[V] = true;
        sb.append(V+" ");

        for(int node = 1; node < graph.length; node++) {
            if(graph[V][node] == 1 && check[node] == false) {
                dfs(node);
            }
        }
    }
    
    static void bfs(int V) {
        Queue<Integer> queue = new LinkedList<Integer>();

        queue.add(V); 
        check[V] = true;
        sb.append(V+" ");

        while(!queue.isEmpty()) { 
            int temp = queue.poll(); 
            for(int node = 1; node < graph.length; node++) {
                if(graph[temp][node] == 1 && check[node] == false) { 
                    queue.add(node);
                    check[node] = true;
                    sb.append(node+" ");
                }
            }
        }
    }
}