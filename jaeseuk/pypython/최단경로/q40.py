from sys import stdin
import heapq

INF = int(1e9)
n, m = map(int, stdin.readline().rstrip().split())
graph = [[] for _ in range(n + 1)]
distance = [INF] * (n + 1)

for _ in range(m):
    a, b = map(int, stdin.readline().rstrip().split())
    graph[a].append(b)
    graph[b].append(a)

q = []
heapq.heappush(q, (0, 1))
distance[1] = 0

while q:
    dist, new = heapq.heappop(q)

    if distance[new] < dist:
        continue

    for i in graph[new]:
        cost = dist + 1

        if cost < distance[i]:
            distance[i] = cost
            heapq.heappush(q, (cost, i))

distance = distance[1:]
result = max(distance)
index = distance.index(result) + 1
count = distance.count(result)

print(index, result, count)
