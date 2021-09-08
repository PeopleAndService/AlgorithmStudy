import sys
from collections import deque

x_direction = [1, -1, 0, 0]
y_direction = [0, 0, 1, -1]


def bfs(x, y):
    Q = deque()
    Q.append((x, y))

    while Q:
        x, y = Q.popleft()
        for i in range(4):
            x_next = x + x_direction[i]
            y_next = y + y_direction[i]
            if (0 <= x_next < N) and (0 <= y_next < M):
                if miro[x_next][y_next] == 1:
                    miro[x_next][y_next] = miro[x][y] + 1
                    Q.append((x_next, y_next))
        if (N - 1, M - 1) in Q:
            break

    return miro[N - 1][M - 1]


N, M = map(int, sys.stdin.readline().rstrip().split())
miro = [list(map(int, sys.stdin.readline().rstrip())) for _ in range(N)]

print(bfs(0, 0))
