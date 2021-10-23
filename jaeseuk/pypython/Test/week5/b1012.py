from sys import stdin
from collections import deque

for _ in range(int(stdin.readline().rstrip())):
    m, n, k = map(int, stdin.readline().rstrip().split())
    graph = [[0] * m for _ in range(n)]
    visited = [[False] * m for _ in range(n)]

    for _ in range(k):
        x, y = map(int, stdin.readline().rstrip().split())
        graph[y][x] = 1

    dx = [1, 0, 0, -1]
    dy = [0, 1, -1, 0]

    q = deque([])
    cnt = 0
    for i in range(n):
        for j in range(m):
            if graph[i][j] == 1 and not visited[i][j]:
                cnt += 1
                q.append((i, j))

                while q:
                    x, y = q.popleft()

                    if visited[x][y]:
                        continue
                    else:
                        visited[x][y] = True

                        for k in range(4):
                            nx, ny = x + dx[k], y + dy[k]

                            if 0 <= nx < n and 0 <= ny < m and graph[nx][ny] == 1:
                                q.appendleft((nx, ny))

    print(cnt)
