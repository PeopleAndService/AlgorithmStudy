import sys
import heapq

INF = int(1e9)
dx = [0, 0, 1, -1]
dy = [1, -1, 0, 0]


def dijkstra(x, y):
    q = []

    heapq.heappush(q, (array[x][y], x, y))
    cost[x][y] = array[x][y]
    while q:
        cur_cost, cur_x, cur_y = heapq.heappop(q)
        if cost[cur_x][cur_y] < cur_cost:
            continue
        for i in range(4):
            x_next = cur_x + dx[i]
            y_next = cur_y + dy[i]
            if 0 <= x_next < n and 0 <= y_next < n:
                next_cost = cur_cost + array[x_next][y_next]
                if next_cost < cost[x_next][y_next]:
                    cost[x_next][y_next] = next_cost
                    heapq.heappush(q, (next_cost, x_next, y_next))


case = 0
while True:
    n = int(input())
    if n == 0:
        sys.exit()

    case += 1
    array = [list(map(int, sys.stdin.readline().rstrip().split())) for _ in range(n)]
    cost = [[INF] * n for _ in range(n)]
    dijkstra(0, 0)
    print('Problem ', case, ':', ' ', cost[n-1][n-1], sep='')
