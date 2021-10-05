from sys import stdin
import heapq


def dijkstra(start):
    q = []
    heapq.heappush(q, (0, start))
    distance[start] = 0

    while q:
        dist, now = heapq.heappop(q)

        if distance[now] < dist:
            continue

        for i in graph[now]:
            cost = dist + i[1]
            if cost < distance[i[0]]:
                distance[i[0]] = cost
                heapq.heappush(q, (cost, i[0]))


INF = int(1e9)
v, e = map(int, stdin.readline().rstrip().split())
graph = [[] for _ in range(v + 1)]
distance = [INF] * (v + 1)
k = int(stdin.readline().rstrip())

for _ in range(e):
    s, d, w = map(int, stdin.readline().rstrip().split())
    graph[s].append((d, w))

dijkstra(k)

for i in range(1, v + 1):
    if distance[i] == INF:
        print('INF')
    else:
        print(distance[i])
