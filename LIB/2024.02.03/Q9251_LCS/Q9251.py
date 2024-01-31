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