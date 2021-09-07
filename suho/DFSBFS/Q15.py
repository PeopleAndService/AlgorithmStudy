import sys
from collections import deque

n, m, k, x = map(int, sys.stdin.readline().rstrip().split())
graph = [[] for _ in range(n+1)]
for _ in range(m):
    s, e = map(int, sys.stdin.readline().rstrip().split())
    graph[s].append(e)

dist = [0] * (n+1)
Q = deque()
Q.append(x)
while Q:
    curV = Q.popleft()
    for node in graph[curV]:
        if dist[node] == 0:
            dist[node] = dist[curV] + 1
            Q.append(node)

result = [x for x in range(len(dist)) if dist[x] == k]
if len(result) == 0:
    print(-1)
else:
    result.sort()
    for r in result:
        print(r)
