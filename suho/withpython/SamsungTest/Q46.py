import sys
import heapq
from collections import deque

dr = [1, -1, 0, 0]
dc = [0, 0, 1, -1]

n = int(input())
sea = []


def bfs(r, c):
    visit = [[False] * n for _ in range(n)]
    visit[r][c] = True
    time = [[0] * n for _ in range(n)]
    eat = []

    Q = deque()
    Q.append((r, c))

    while Q:
        cur_r, cur_c = Q.popleft()
        for i in range(4):
            next_r = cur_r + dr[i]
            next_c = cur_c + dc[i]
            if 0 <= next_r < n and 0 <= next_c < n and not visit[next_r][next_c]:
                if 0 <= sea[next_r][next_c] <= sea[r][c]:
                    Q.append((next_r, next_c))
                    visit[next_r][next_c] = True
                    time[next_r][next_c] = time[cur_r][cur_c] + 1
                if 0 < sea[next_r][next_c] < sea[r][c]:
                    heapq.heappush(eat, (time[next_r][next_c], next_r, next_c))

    if eat:
        return heapq.heappop(eat)
    else:
        return -1, -1, -1


# 입력
for i in range(n):
    rows = list(map(int, sys.stdin.readline().rstrip().split()))
    for j in range(n):
        if rows[j] == 9:
            start_r, start_c = i, j
            rows[j] = 2
    sea.append(rows)


count = 0
time = 0
while True:
    mov_time, mov_r, mov_c = bfs(start_r, start_c)
    if mov_time == -1:
        break
    sea[mov_r][mov_c] = sea[start_r][start_c]
    sea[start_r][start_c] = 0
    start_r, start_c = mov_r, mov_c
    count += 1
    if count == sea[mov_r][mov_c]:
        count = 0
        sea[mov_r][mov_c] += 1
    time += mov_time

print(time)
