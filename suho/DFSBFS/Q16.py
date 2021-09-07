import sys
import copy
from collections import deque

sys.setrecursionlimit(10000)

n, m = map(int, input().split())
lab = [list(map(int, sys.stdin.readline().rstrip().split())) for _ in range(n)]

size = n*m
virus_cnt = 0
wall_cnt = 0

dx = [1, -1, 0, 0]
dy = [0, 0, 1, -1]

result = -10e9


def make_wall(start, maked_wall):
    global result

    if maked_wall == 3:
        temp = copy.deepcopy(lab)
        for i in range(n):
            for j in range(m):
                if temp[i][j] == 2:
                    bfs(i, j, temp)
        safe = sum(x.count(0) for x in temp)
        result = max(result, safe)
        return
    else:
        for i in range(start, size):
            row = i // m
            col = i % m
            if lab[row][col] == 0:
                lab[row][col] = 1
                make_wall(i, maked_wall + 1)
                lab[row][col] = 0


def bfs(i, j, arr):
    Q = deque()
    Q.append((i, j))

    while Q:
        x, y = Q.popleft()
        for k in range(4):
            x_next = x + dx[k]
            y_next = y + dy[k]
            if 0 <= x_next < n and 0 <= y_next < m:
                if arr[x_next][y_next] == 0:
                    arr[x_next][y_next] = 2
                    Q.append((x_next, y_next))


make_wall(0, 0)
print(result)
