import sys
from collections import deque
inp = sys.stdin.readline

N = int(inp())
moves = [0, 1, 0, -1]
maps = [list(map(int, inp().split())) for _ in range(N)]
max_height = max(max(row) for row in maps)
max_area = 0

def bfs(height) -> int:
  visited = [[False] * N for _ in range(N)]
  queue = deque()
  cnt = 0

  for i in range(N):
    for j in range(N):
      if maps[i][j] <= height or visited[i][j]:
        continue

      queue.append((i, j))

      while queue:
        x, y = queue.pop()
        
        for idx in range(4):
          nx = x + moves[idx]
          ny = y + moves[idx - 1]

          if isValid(nx, ny) and not visited[nx][ny] and maps[nx][ny] > height:
            queue.append((nx, ny))
            visited[nx][ny] = True
      
      cnt += 1
  
  return cnt

def isValid(x, y):
  return 0 <= x < N and 0 <= y < N

for height in range(max_height):
  max_area = max(max_area, bfs(height))

print(max_area)