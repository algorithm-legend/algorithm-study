import sys
inp = sys.stdin.readline

sub_board_a = [[[False] * 10 for _ in range(3)] for _ in range(3)]
sub_board_r = [[False] * 10 for _ in range(9)]
sub_board_c = [[False] * 10 for _ in range(9)]
board = [[0] * 9 for _ in range(9)]

for i in range(9):
  tmp = list(inp().strip())
  sub_board_r[i][0] = sub_board_c[i][0] = True
  for j in range(9):
    sub_x, sub_y = i // 3, j // 3
    sub_board_a[sub_x][sub_y][0] = True
    num = int(tmp[j])

    board[i][j] = num
    if board[i][j] != 0:
      sub_board_r[i][num] = sub_board_c[j][num] = sub_board_a[sub_x][sub_y][num] = True

def sol(x, y):
  if x == 8 and all(sub_board_r[8]):
    for r in board:
      for c in r:
        print(c, end="")
      print()
    sys.exit()
  
  for i in range(x, 9):
    for j in range(9):
      if board[i][j] == 0:
        sub_x, sub_y = i // 3, j // 3
        
        for num in range(1, 10):
          if not sub_board_a[sub_x][sub_y][num] and not sub_board_r[i][num] and not sub_board_c[j][num]:
            board[i][j] = num
            sub_board_r[i][num] = sub_board_c[j][num] = sub_board_a[sub_x][sub_y][num] = True

            if j + 1 == 9:
              sol(i, 0)
            else:
              sol(i, j + 1)

            board[i][j] = 0
            sub_board_r[i][num] = sub_board_c[j][num] = sub_board_a[sub_x][sub_y][num] = False
        return
      
sol(0, 0)