import sys
inp = sys.stdin.readline

N, M = map(int, inp().split())
arr = [num for num in range(1, N + 1)]
visited = [False] * N
comb = [0] * M

def sol(n):
  if n == M:
    print(" ".join(map(str, comb)))
    return

  for idx in range(N):
    if not visited[idx]:
      visited[idx] = True
      comb[n] = arr[idx]
      sol(n + 1)
      visited[idx] = False

sol(0)