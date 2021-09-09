# 답 봄
from sys import stdin
from collections import deque

n, k = map(int, stdin.readline().rstrip().split())

graph = []
data = []
for i in range(n):
    graph.append(list(map(int, stdin.readline().rstrip().split())))
    for j in range(n):
        if graph[i][j] != 0:
            data.append((graph[i][j], 0, i, j))

data.sort()
queue = deque(data)

s, x, y = map(int, stdin.readline().rstrip().split())

dx = [-1, 0, 1, 0]
dy = [0, 1, 0, -1]

while queue:
    virus, sec, vx, vy = queue.popleft()

    if sec == s:
        break

    for i in range(4):
        nx = vx + dx[i]
        ny = vy + dy[i]

        if 0 <= nx < n and 0 <= ny < n:
            if graph[nx][ny] == 0:
                graph[nx][ny] = virus
                queue.append((virus, s + 1, nx, ny))

print(graph[x - 1][y - 1])
