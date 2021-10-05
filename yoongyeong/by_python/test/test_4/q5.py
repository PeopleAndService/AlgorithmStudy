import sys
import heapq


def minimum_path(start):
    queue = []
    heapq.heappush(queue, (0, start))
    distance[start] = 0

    while queue:
        dist, now = heapq.heappop(queue)
        if distance[now] < dist: continue
        for i in graph[now]:
            cost = dist + i[1]
            if cost < distance[i[0]]:
                distance[i[0]] = cost
                heapq.heappush(queue, (cost, i[0]))


v, e = map(int, input().split())
start_node = int(input())
graph = [[] * (v + 1) for _ in range(v + 1)]
distance = [1e9] * (v + 1)

for _ in range(e):
    a, b, c = map(int, sys.stdin.readline().split())
    graph[a].append((b, c))

minimum_path(start_node)

for i in range(1, v+1):
    if distance[i] == 1e9: print("INF")
    else: print(distance[i])