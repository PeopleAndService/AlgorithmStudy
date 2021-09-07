import sys
import heapq

INF = int(1e9)

n, m, c = map(int, sys.stdin.readline().rstrip().split())
graph = [[] for _ in range(n+1)]
dist = [INF] * (n+1)

for _ in range(m):
    x, y, z = map(int, sys.stdin.readline().rstrip().split())
    graph[x].append((y, z))


def dijkstra(start):
    q = []

    heapq.heappush(q, (0, start))
    dist[start] = 0
    while q:
        cur_dist, cur_node = heapq.heappop(q)
        if dist[cur_node] < cur_dist:
            continue
        for node in graph[cur_node]:
            cost = cur_dist + node[1]
            if cost < dist[node[0]]:
                dist[node[0]] = cost
                heapq.heappush(q, (cost, node[0]))


dijkstra(c)

count = 0
long_dist = 0
for d in dist:
    if d != INF:
        count += 1
        long_dist = max(long_dist, d)

print(count - 1, long_dist)
