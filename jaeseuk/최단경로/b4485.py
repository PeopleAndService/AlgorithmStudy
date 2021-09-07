from sys import stdin
import heapq

INF = int(1e9)
dx = [-1, 0, 1, 0]
dy = [0, 1, 0, -1]
problem = 1

while True:
    n = int(stdin.readline().rstrip())

    if n == 0:
        break

    distance = [[INF] * n for _ in range(n)]
    graph = []

    for _ in range(n):
        graph.append(list(map(int, stdin.readline().rstrip().split())))

    q = []
    heapq.heappush(q, (graph[0][0], 0, 0))
    distance[0][0] = graph[0][0]

    while q:
        dist, x, y = heapq.heappop(q)

        if distance[x][y] < dist:
            continue

        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]

            if 0 <= nx < n and 0 <= ny < n:
                cost = dist + graph[nx][ny]
                if cost < distance[nx][ny]:
                    distance[nx][ny] = cost
                    heapq.heappush(q, (cost, nx, ny))

    print("Problem %d: %d" % (problem, distance[n - 1][n - 1]))
    problem += 1
