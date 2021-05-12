"""
구현, 비트마스킹
백준 15787 기차가 어둠을 헤치고 은하수를 실버2
제한 : 1초 / 512MB
제출 : 500ms / 67558KB
"""

import sys
from collections import deque

N, M = map(int, sys.stdin.readline().rstrip().split())
control = [list(map(int, sys.stdin.readline().rstrip().split())) for _ in range(M)]
train = [[0] * 20 for _ in range(N)]
pass_train = []

for order in control:
    case = order[0]
    i = order[1] - 1
    if case == 1:
        x = order[2] - 1
        if train[i][x] == 0:
            train[i][x] = 1
    if case == 2:
        x = order[2] - 1
        if train[i][x] == 1:
            train[i][x] = 0
    if case == 3:
        Q = deque(train[i])
        Q.pop()
        Q.appendleft(0)
        train[i] = list(Q)
    if case == 4:
        Q = deque(train[i])
        Q.popleft()
        Q.append(0)
        train[i] = list(Q)

count = 1
pass_train.append(train[0])
for i in range(1, N):
    if train[i] in pass_train:
        continue
    else:
        pass_train.append(train[i])
        count += 1
print(count)
