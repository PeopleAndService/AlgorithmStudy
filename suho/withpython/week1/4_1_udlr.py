"""
구현(시뮬레이션)
상하좌우
제한 : 1초 / 128MB
"""

import sys

N = int(sys.stdin.readline().rstrip())
plan = list(sys.stdin.readline().rstrip().split())

dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]
move = ['U', 'D', 'L', 'R']
x, y = 1, 1

for direct in plan:
    for i in range(len(move)):
        if direct == move[i]:
            x_next = x + dx[i]
            y_next = y + dy[i]

    if x_next < 1 or x_next > N or y_next < 1 or y_next > N:
        continue

    x, y = x_next, y_next

print(x, y)
