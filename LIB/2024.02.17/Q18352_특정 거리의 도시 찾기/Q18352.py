# import sys
# from collections import deque
# from heapq import heappush, heappop
# inp = sys.stdin.readline

# N, M, K, X = map(int, inp().split())  # 도시, 도로, 거리, 출발
# graph = [[] for _ in range(N + 1)]
# ans = []

# def bfs():
#   visited = [False] * (N + 1)
#   visited[X] = True
#   q = deque()
#   q.append((X, 0))

#   while q:
#     cur_node, cur_dis = q.popleft()

#     if cur_dis == K:
#       heappush(ans, cur_node)

#     for next in graph[cur_node]:
#       if not visited[next]:
#         visited[next] = True
#         q.append((next, cur_dis + 1))
        

# for _ in range(M):
#   A, B = map(int, inp().split())

#   graph[A].append(B)

# bfs()

# if not ans:
#   print(-1)

# while ans:
#   print(heappop(ans))

import sys
from collections import deque
from heapq import heappush, heappop
inp = sys.stdin.readline

N, M, K, X = map(int, inp().split())  # 도시, 도로, 거리, 출발
graph = [[] for _ in range(N + 1)]
distance = [sys.maxsize] * (N + 1)
ans = []

def dijkstra():
  q = []
  distance[X] = 0
  heappush(q, (0, X))

  while q:
    dis, cur = heappop(q)

    if distance[cur] < dis:
      continue

    if dis == K:
      heappush(ans, cur)

    for next in graph[cur]:
      new_dis = dis + 1

      if new_dis < distance[next]:
        distance[next] = new_dis
        heappush(q, (new_dis, next))

for _ in range(M):
  A, B = map(int, inp().split())

  graph[A].append(B)

dijkstra()

if not ans:
  print(-1)

while ans:
  print(heappop(ans))