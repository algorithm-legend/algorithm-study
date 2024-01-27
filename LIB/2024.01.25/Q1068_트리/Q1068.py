import sys
from collections import deque
inp = sys.stdin.readline

N = int(inp())
root = sys.maxsize
nodes = list(map(int, inp().split()))
graph = [[] for _ in range(N)]
R = int(inp())

for idx in range(N):
  if nodes[idx] == -1:
    root = idx

  if idx == R:
    continue

  if nodes[idx] != -1:
    graph[nodes[idx]].append(idx)

print(graph)

if R == root:
  print(0)
  sys.exit()

def bfs():
  visited = [False] * N
  visited[R] = True
  queue = deque()
  queue.append(root)
  cnt = 0

  while queue:
    curN = queue.pop()

    if len(graph[curN]) == 0:
      cnt += 1
      continue

    for nextN in graph[curN]:
      if not visited[nextN]:
        visited[nextN] = True
        queue.append(nextN)

  return cnt

print(bfs())