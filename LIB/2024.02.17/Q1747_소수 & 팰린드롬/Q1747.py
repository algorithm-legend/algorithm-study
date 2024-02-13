# import sys

# N, B = int(input()), 1000001
# nums = [True] * B
# nums[1] = False

# for num in range(2, B):
#   if nums[num]:
#     for next_num in range(num + num, B, num):
#       nums[next_num] = False

# for num in range(N, B):
#   if nums[num]:
#     reversed = int(str(num)[::-1])

#     if nums[reversed] and reversed == num:
#       print(num)
#       break

import sys
import math

N, B = int(input()), 2000000
nums = [True] * B
nums[1] = False

def is_prime(n):
  for i in range(2, int(math.sqrt(n) + 1)):
    if n % i == 0:
      return False
  return True

for num in range(2, B):
  if nums[num]:
    reversed = int(str(num)[::-1])

    if num >= N and reversed == num and is_prime(num):
      print(num)
      break

    for next_num in range(num + num, B, num):
      nums[next_num] = False