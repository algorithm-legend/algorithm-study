import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q5014 {

  public static int F, S, G, U, D;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));
    StringTokenizer st = new StringTokenizer(br.readLine());

    F = Integer.parseInt(st.nextToken());
    S = Integer.parseInt(st.nextToken());
    G = Integer.parseInt(st.nextToken());
    U = Integer.parseInt(st.nextToken());
    D = Integer.parseInt(st.nextToken());

    bfs();
  }

  public static void bfs() {
    Queue<Point> queue = new LinkedList<>();
    boolean[] visited = new boolean[F + 1];

    queue.add(new Point(S, 0));
    visited[S] = true;

    while(!queue.isEmpty()) {
      Point cur = queue.poll();

      if(cur.floor == G) {
        System.out.println(cur.dist);
        return;
      }

      int nu = cur.floor + U;
      int nd = cur.floor - D;

      if(nu <= F && !visited[nu]) {
        queue.add(new Point(nu, cur.dist + 1));
        visited[nu] = true;
      }

      if(0 < nd && !visited[nd]) {
        queue.add(new Point(nd, cur.dist + 1));
        visited[nd] = true;
      }
    }

    System.out.println("use the stairs");
  }

  static class Point {
    int floor;
    int dist;
  
    Point(int f, int d) {
      this.floor = f;
      this.dist = d;
    }
  }
}