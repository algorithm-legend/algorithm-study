import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Q2468 {

  public static int N;
  public static int[][] maps;
  public static int[] moves = {0, 1, 0, -1, 0};
  public static void main(String[] args) throws NumberFormatException, IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int max_height = 0;
    int max_area = 0;
    
    N = Integer.parseInt(br.readLine());
    maps = new int[N][N];

    for(int i = 0; i < N; i++) {
      maps[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

      // 안전 영역중 가장 높은 곳
      for(int height: maps[i]) {
        max_height = Math.max(max_height, height);
      }
    }
    
    for(int i = 0; i < max_height; i++) {
      max_area = Math.max(max_area, bfs(i));
    }

    System.out.println(max_area);
  }

  public static int bfs(int height) {
    boolean[][] visited = new boolean[N][N];
    Queue<Point> queue = new LinkedList<>();
    int cnt = 0;

    for(int i = 0; i < N; i++){
      for(int j = 0; j < N; j++){
        if(maps[i][j] <= height || visited[i][j]) {
          continue;
        }

        queue.add(new Point(i, j));

        while(!queue.isEmpty()) {
          Point curP = queue.poll();
          
          for(int k = 1; k < 5; k++) {
            int nx = curP.x + moves[k];
            int ny = curP.y + moves[k - 1];

            if(isValid(nx, ny) && !visited[nx][ny] && maps[nx][ny] > height) {
              visited[nx][ny] = true;
              queue.add(new Point(nx, ny));
            }
          }
        }
        cnt++;
      }
    }

    return cnt;
  }

  public static boolean isValid(int x, int y){
    return 0 <= x && x < N && 0 <= y && y < N;
  }
}

class Point {
  int x;
  int y;
  
  Point(int x, int y) {
    this.x = x;
    this.y = y;
  }
}