import sys

inp = sys.stdin.readline
N = int(inp())
arr = list(map(int, inp().split()))
visited = [False] * N
ans = 0

def sol(cnt, nums):
  global ans

  if cnt == N:
    sums = 0

    for idx in range(N - 1):
      sums += abs(nums[idx] - nums[idx + 1])

    ans = max(sums, ans)
    return

  for idx in range(N):
    if not visited[idx]:
      visited[idx] = True
      nums.append(arr[idx])
      sol(cnt + 1, nums)
      nums.pop()
      visited[idx] = False

sol(0, [])
print(ans)