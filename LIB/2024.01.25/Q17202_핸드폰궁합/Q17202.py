import sys
inp = sys.stdin.readline

A = list(map(int, inp().strip()))
B = list(map(int, inp().strip()))
merged = []

for idx in range(len(A)):
  merged.append(A[idx])
  merged.append(B[idx])

dicts = dict()

def dp(arr):
  if len(arr) == 2:
    return arr
  
  tmp = []
  for idx in range(len(arr) - 1):
    a, b = arr[idx], arr[idx + 1]
    if (a, b) in dicts:
      tmp.append(dicts.get((a, b)))
      continue

    if (b, a) in dicts:
      tmp.append(dicts.get((b, a)))
      continue

    res = (a + b) % 10
    dicts[(a, b)] = res
    tmp.append(res)

  return dp(tmp)

ans = dp(merged)
print(str(ans[0]) + str(ans[1]))

############################################

import sys
inp = sys.stdin.readline

A = list(map(int, inp().strip()))
B = list(map(int, inp().strip()))
merged = []

for idx in range(len(A)):
  merged.append(A[idx])
  merged.append(B[idx])

def dp(arr):
  if len(arr) == 2:
    return arr
  
  tmp = []
  for idx in range(len(arr) - 1):
    tmp.append((arr[idx] + arr[idx + 1]) % 10)

  return dp(tmp)

ans = dp(merged)
print(str(ans[0]) + str(ans[1]))