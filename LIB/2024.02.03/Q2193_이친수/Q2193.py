### DP expression
# N = int(input())

# dp = [[0] * (N + 1) for _ in range(2)]
# dp[0][0], dp[0][1] = 0, 1
# dp[1][0], dp[1][1] = 1, 0

# for n in range(2, N + 1):
#   dp[0][n] = dp[0][n - 1] + dp[1][n - 1]
#   dp[1][n] = dp[0][n - 1]

# print(dp[0][N - 1] + dp[1][N - 1])

### Fibonacci sequence
N = int(input())
dp = [0] * (N + 1)
dp[0] = 1
dp[1] = 1

def sol(n):
  if dp[n] != 0:
    return dp[n]

  if n == 1:
    return 1
  
  dp[n] = sol(n - 1) + sol(n - 2)
  return dp[n]

print(sol(N - 1))