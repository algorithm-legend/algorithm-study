### recursive (top-down)
import sys

N = int(input())
dp = [0] * 11

def sol(n):
  if n <= 1 or dp[n] != 0:
    return dp[n]

  tmp = n // 2
  a, b = tmp, n - tmp

  dp[n] = sol(a) + sol(b) + (a * b)
  return dp[n]

print(sol(N))

### for loop (bottom-up)
# import sys

# N = int(input())
# dp = [0] * 11

# for idx in range(N + 1):
#   tmp = idx // 2
#   a, b = tmp, idx - tmp
#   dp[idx] = dp[a] + dp[b] + (a * b)

# print(dp[N])