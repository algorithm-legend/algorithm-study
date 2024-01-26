import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class Q1068 {
  
  public static int N;
  public static LinkedList<Integer>[] graph;
  public static int R;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    N = Integer.parseInt(br.readLine());
    int[] nodes = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
    R = Integer.parseInt(br.readLine());
    graph = new LinkedList[N];
    int root = Integer.MAX_VALUE;

    for(int i = 0; i < N; i++){
      graph[i] = new LinkedList<>();
    }

    for(int i = 0; i < N; i++){
      if(nodes[i] == -1 && i == R) {
        System.out.println(0);
        System.exit(0);
      }

      if(i == R) {
        continue;
      }

      if(nodes[i] != -1) {
        graph[nodes[i]].add(i);
      } else if(nodes[i] == -1) {
        root = i;
      }
    }

    System.out.println(bfs(root));
  }

  public static int bfs(int root) {
    Queue<Integer> queue = new LinkedList<>();
    boolean[] visited = new boolean[N];
    int cnt = 0;

    queue.add(root);
    visited[root] = true;

    while(!queue.isEmpty()) {
      int cur = queue.poll();

      if(cur == R) {
        continue;
      }

      if(graph[cur].size() == 0) {
        cnt++;
        continue;
      }

      Iterator<Integer> it = graph[cur].iterator();

      while(it.hasNext()) {
        int next = it.next();

        if(!visited[next]) {
          queue.add(next);
          visited[next] = true;
        }
      }
    }

    return cnt;
  }
}