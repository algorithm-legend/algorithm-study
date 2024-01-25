import sys
from collections import deque
F, S, G, U, D = map(int, sys.stdin.readline().strip().split())
move_cnt = 0

def bfs():
  visited = [False] * (F + 1)
  queue = deque()

  queue.append((S, 0))
  visited[S] = True

  while queue:
    cur, dist = queue.popleft()

    if cur == G:
      print(dist)
      return

    next_dist = dist + 1
    next_up = cur + U
    next_down = cur - D

    if 0 < next_up and next_up <= F and not visited[next_up]:
      visited[next_up] = True
      queue.append((next_up, next_dist))

    if 0 < next_down and next_down <= F and not visited[next_down]:
      visited[next_down] = True
      queue.append((next_down, next_dist))

  print("use the stairs")

bfs()