"""
구현(시뮬레이션)
게임 개발
제한 : 1초 / 128MB
"""

import sys

x_direction = [0, 1, 0, -1]
y_direction = [-1, 0, 1, 0]

N, M = map(int, sys.stdin.readline().split())
cur_x, cur_y, cur_d = map(int, sys.stdin.readline().split())
game_map = [list(map(int, sys.stdin.readline().split())) for _ in range(N)]
visit = [[False] * M for _ in range(N)]
count = 1
turn_time = 0

while True:
    cur_d -= 1
    if cur_d == -1:
        cur_d = 3
    x_next = cur_x + x_direction[cur_d]
    y_next = cur_y + y_direction[cur_d]
    if not visit[x_next][y_next] and game_map[x_next][y_next] == 0:
        count += 1
        visit[x_next][y_next] = True
        cur_x = x_next
        cur_y = y_next
        turn_time = 0
    else:
        turn_time += 1
    if turn_time == 4:
        x_next = cur_x - x_direction[cur_d]
        y_next = cur_y - y_direction[cur_d]
        if game_map[x_next][y_next] == 0:
            cur_x = x_next
            cur_y = y_next
        else:
            break
        turn_time = 0

print(count)
