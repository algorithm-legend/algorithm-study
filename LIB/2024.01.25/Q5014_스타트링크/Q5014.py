# import sys
# from collections import deque
# F, S, G, U, D = map(int, sys.stdin.readline().strip().split())
# move_cnt = 0

# def bfs():
#   visited = [False] * (F + 1)
#   queue = deque()

#   queue.append((S, 0))
#   visited[S] = True

#   while queue:
#     cur, dist = queue.popleft()

#     if cur == G:
#       print(dist)
#       return

#     next_up = cur + U
#     next_down = cur - D

#     if next_up <= F and not visited[next_up]:
#       visited[next_up] = True
#       queue.append((next_up, dist + 1))

#     if 0 < next_down and not visited[next_down]:
#       visited[next_down] = True
#       queue.append((next_down, dist + 1))

#   print("use the stairs")

# bfs()

#####

import sys
from collections import deque
F, S, G, U, D = map(int, sys.stdin.readline().strip().split())
move_cnt = 0

def bfs():
  visited = [-1] * (F + 1)
  queue = deque()

  queue.append(S)
  visited[S] = 0

  while queue:
    cur = queue.popleft()

    if cur == G:
      print(visited[cur])
      return
    
    for next_floor in [(cur + U), (cur - D)]:
      if 0 < next_floor <= F and visited[next_floor] == -1:
        visited[next_floor] = visited[cur] + 1
        queue.append(next_floor)

  print("use the stairs")

bfs()