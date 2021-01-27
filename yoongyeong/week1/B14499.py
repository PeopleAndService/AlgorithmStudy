# 주사위 굴리기
# 입력: 1) 지도 크기 N, M 주사위의 좌표 x, y 명령의 개수 K 2 ~ ) 지도 3) 이동하는 명령 동서북남 1, 2, 3, 4
# 출력: 이동할때마다 윗면 수 출력

import sys

N, M, x, y, K = map(int, sys.stdin.readline().rstrip().split())
dice_map = [list(map(int, sys.stdin.readline().rstrip().split())) for _ in range(N)]
movingOrder = list(map(int, sys.stdin.readline().rstrip().split()))
dice = [0 for _ in range(6)]
step = [[0, 1], [0, -1], [-1, 0], [1, 0]]


for i, command in enumerate(movingOrder):
    new_x, new_y = x + step[command - 1][0], y + step[command - 1][1]
    if not 0 <= new_x < N or not 0 <= new_y < M: continue
    x, y = new_x, new_y

    if command == 1:
        dice[0], dice[2], dice[3], dice[5] = dice[3], dice[0], dice[5], dice[2]
    elif command == 2:
        dice[0], dice[2], dice[3], dice[5] = dice[2], dice[5], dice[0], dice[3]
    elif command == 3:
        dice[0], dice[1], dice[4], dice[5] = dice[4], dice[0], dice[5], dice[1]
    else:
        dice[0], dice[1], dice[4], dice[5] = dice[1], dice[5], dice[0], dice[4]

    if dice_map[x][y] == 0: dice_map[x][y] = dice[5]
    else: dice[5], dice_map[x][y] = dice_map[x][y], 0

    print(dice[0])
