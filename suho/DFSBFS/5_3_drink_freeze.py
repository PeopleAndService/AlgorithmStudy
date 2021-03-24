import sys

sys.setrecursionlimit(10000)

x_direction = [1, -1, 0, 0]
y_direction = [0, 0, 1, -1]


def dfs(x, y):
    visit[x][y] = True

    for i in range(4):
        x_next = x + x_direction[i]
        y_next = y + y_direction[i]
        if (0 <= x_next < N) and (0 <= y_next < M):
            if template[x_next][y_next] == 0 and not visit[x_next][y_next]:
                dfs(x_next, y_next)


N, M = map(int, sys.stdin.readline().split())
template = [list(map(int, sys.stdin.readline().rstrip())) for _ in range(N)]
print(template)
visit = [[False] * M for _ in range(N)]
count = 0

for i in range(N):
    for j in range(M):
        if template[i][j] == 0 and not visit[i][j]:
            dfs(i, j)
            count += 1

print(count)
