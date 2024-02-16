# https://www.youtube.com/watch?v=WhpOsCR8pvI

import math

n = int(input())
ans = n

for num in range(2, int(math.sqrt(n)) + 1):
  if n % num == 0:  # 약수
    while n % num == 0:  # 소인수 분해
      n //= num

    ans *= (1 - 1 / num)

if n > 1:  # 남은 n이 1보다 크다면, 이는 소수
    ans *= (1 - 1 / n)

print(int(ans))