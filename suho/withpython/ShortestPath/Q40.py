import sys
import heapq

INF = int(1e9)

n, m = map(int, input().split())
graph = [[] for _ in range(n+1)]
dist = [INF] * (n+1)

for _ in range(m):
    s, e = map(int, sys.stdin.readline().rstrip().split())
    graph[s].append(e)
    graph[e].append(s)


def dijkstra(start):
    q = []

    heapq.heappush(q, (0, start))
    dist[start] = 0
    while q:
        cur_dist, cur_node = heapq.heappop(q)
        if dist[cur_node] < cur_dist:
            continue
        for node in graph[cur_node]:
            cost = cur_dist + 1
            if cost < dist[node]:
                dist[node] = cost
                heapq.heappush(q, (cost, node))


dijkstra(1)

max_dist = 0
cnt = 0
idx = 0

for i in range(1, n+1):
    if max_dist < dist[i]:
        max_dist = dist[i]
        idx = i
        cnt = 1
    elif max_dist == dist[i]:
        cnt += 1

print(idx, max_dist, cnt)
