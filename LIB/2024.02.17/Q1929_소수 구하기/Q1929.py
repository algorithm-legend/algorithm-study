import sys
inp = sys.stdin.readline

N, M = map(int, inp().split())
is_prime = [True] * (M + 1)
is_prime[1] = False

for num in range(2, M + 1):
  if is_prime[num]:
    if N <= num <= M:
      print(num)

    for next_num in range(num + num, M + 1, num):
      is_prime[next_num] = False