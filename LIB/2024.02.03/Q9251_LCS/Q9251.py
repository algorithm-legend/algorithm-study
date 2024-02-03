seq1, seq2 = input(), input()
len1, len2 = len(seq1) + 1, len(seq2) + 1
LCS = [[0 for _ in range(len2)] for _ in range(len1)]

for i in range(1, len1):
  for j in range(1, len2):
    if seq1[i - 1] == seq2[j - 1]:
      LCS[i][j] = LCS[i - 1][j - 1] + 1
    else:
      LCS[i][j] = max(LCS[i - 1][j], LCS[i][j - 1])

print(LCS[len1 - 1][len2 - 1])

# import sys
# read = sys.stdin.readline

# word1, word2 = read().strip(), read().strip()
# l1, l2 = len(word1), len(word2)
# cache = [0] * l2

# for i in range(l1):
#     cnt = 0
#     for j in range(l2):
#         if cnt < cache[j]:
#             cnt = cache[j]
#         elif word1[i] == word2[j]:
#             cache[j] = cnt + 1
# print(max(cache))