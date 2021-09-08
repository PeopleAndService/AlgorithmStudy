import heapq
import sys

INF = int(1e9)
dx = [0, 0, 1, -1]
dy = [1, -1, 0, 0]

t = int(input())


def dijkstra(x, y):
    q = []

    heapq.heappush(q, (mars[x][y], x, y))
    cost[x][y] = mars[x][y]
    while q:
        cur_cost, cur_x, cur_y = heapq.heappop(q)
        if cost[cur_x][cur_y] < cur_cost:
            continue
        for i in range(4):
            x_next = cur_x + dx[i]
            y_next = cur_y + dy[i]
            if 0 <= x_next < n and 0 <= y_next < n:
                next_cost = cur_cost + mars[x_next][y_next]
                if next_cost < cost[x_next][y_next]:
                    cost[x_next][y_next] = next_cost
                    heapq.heappush(q, (next_cost, x_next, y_next))


for _ in range(t):
    n = int(input())
    mars = [list(map(int, sys.stdin.readline().rstrip().split())) for _ in range(n)]
    cost = [[INF] * n for _ in range(n)]
    dijkstra(0, 0)
    print(cost[n-1][n-1])
