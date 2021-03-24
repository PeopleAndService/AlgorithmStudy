import sys
import heapq

n, k = map(int, input().split())
virus_map = [list(map(int, sys.stdin.readline().rstrip().split())) for _ in range(n)]
s, x, y = map(int, input().split())

dx = [1, -1, 0, 0]
dy = [0, 0, 1, -1]

Q = []

for i in range(n):
    for j in range(n):
        if virus_map[i][j] != 0:
            heapq.heappush(Q, (virus_map[i][j], i, j))


def bfs(q):
    temp = []

    while q:
        virus, x, y = heapq.heappop(q)

        for i in range(4):
            x_next = x + dx[i]
            y_next = y + dy[i]

            if 0 <= x_next < n and 0 <= y_next < n:
                if virus_map[x_next][y_next] == 0:
                    virus_map[x_next][y_next] = virus
                    heapq.heappush(temp, (virus, x_next, y_next))

    return temp


for _ in range(s):
    Q = bfs(Q)

print(virus_map[x-1][y-1])
