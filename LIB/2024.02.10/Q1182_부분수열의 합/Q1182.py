import sys
inp = sys.stdin.readline

N, S = map(int, inp().split())
nums = list(map(int, inp().split()))
visited = [False] * N
ans = 0

def sol(n, sums):
  global ans

  for i in range(n, N):
    if not visited[i]:
      visited[i] = True

      if sums + nums[i] == S:
        ans += 1

      sol(i + 1, sums + nums[i])
      visited[i] = False

sol(0, 0)
print(ans)