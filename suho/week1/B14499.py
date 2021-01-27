import sys

dice = [0] * 6
N, M, x, y, K = map(int, sys.stdin.readline().rstrip().split())
m = [list(map(int, sys.stdin.readline().rstrip().split())) for _ in range(N)]
order = list(map(int, sys.stdin.readline().rstrip().split()))

dr = [0, 0, -1, 1]
dc = [1, -1, 0, 0]

for item in order:
    idx = item - 1

    next_r = x + dr[idx]
    next_c = y + dc[idx]

    if (0 <= next_r < N) and (0 <= next_c < M):
        # 동쪽
        if item == 1:
            dice[0], dice[2], dice[3], dice[5] = dice[3], dice[0], dice[5], dice[2]
        # 서쪽
        elif item == 2:
            dice[0], dice[2], dice[3], dice[5] = dice[2], dice[5], dice[0], dice[3]
        # 북쪽
        elif item == 3:
            dice[0], dice[1], dice[4], dice[5] = dice[4], dice[0], dice[5], dice[1]
        # 남쪽
        elif item == 4:
            dice[0], dice[1], dice[4], dice[5] = dice[1], dice[5], dice[0], dice[4]

        # 값 바꾸기
        if m[next_r][next_c] == 0:
            m[next_r][next_c] = dice[5]
        else:
            dice[5] = m[next_r][next_c]
            m[next_r][next_c] = 0

        # 위치 변경
        x, y = next_r, next_c

        print(dice[0])
