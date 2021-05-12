"""
구현(시뮬레이션)
뱀 (백준 3190 골드5)
제한 : 1초 / 128MB
제출 : 216ms / 32764KB
삼성전자 SW 역량테스트
"""

import sys
from collections import deque

N = int(sys.stdin.readline().rstrip())
K = int(sys.stdin.readline().rstrip())
apple = [tuple(map(int, sys.stdin.readline().rstrip().split())) for _ in range(K)]
L = int(sys.stdin.readline().rstrip())
change_move = [tuple(sys.stdin.readline().rstrip().split()) for _ in range(L)]

Q = deque()
time = 0
head = (1, 1)
Q.append(head)

# R U L D
dr = [0, -1, 0, 1]
dc = [1, 0, -1, 0]

cur_dir = 0

while True:
    time += 1
    head = (head[0] + dr[cur_dir], head[1] + dc[cur_dir])

    if head in Q:
        break
    if (1 > head[0] or head[0] > N) or (1 > head[1] or head[1] > N):
        break

    Q.append(head)

    if head in apple:
        apple.remove(head)
    else:
        Q.popleft()

    for move in change_move:
        if time == int(move[0]):
            next_dir = move[1]
            if next_dir == 'L':
                cur_dir += 1
            else:
                cur_dir -= 1

            if cur_dir == 4:
                cur_dir = 0
            if cur_dir == -1:
                cur_dir = 3
            change_move.remove(move)

print(time)
