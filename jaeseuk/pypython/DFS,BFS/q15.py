from sys import stdin
from collections import deque

n, m, k, x = map(int, stdin.readline().rstrip().split())

graph = [[] for _ in range(n + 1)]
for _ in range(m):
    start, end = map(int, stdin.readline().rstrip().split())
    graph[start].append(end)

visited = [-1] * (n + 1)
visited[x] = 0

queue = deque([x])
while queue:
    v = queue.popleft()

    for i in graph[v]:
        if visited[i] == -1:
            queue.append(i)
            visited[i] = visited[v] + 1

for i in range(1, n + 1):
    if visited[i] == k:
        print(i)

if k not in visited:
    print(-1)
