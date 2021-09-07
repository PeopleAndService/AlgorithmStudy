from sys import stdin
from collections import deque

n = int(stdin.readline().rstrip())
indegree = [0] * (n + 1)
graph = [[] for _ in range(n + 1)]
result = []

for i in range(1, n + 1):
    data = list(map(int, stdin.readline().rstrip().split()))
    result.append(data[0])
    for j in range(1, len(data)):
        if data[j] != -1:
            graph[data[j]].append(i)
            indegree[i] += 1

print(indegree)
print(graph)
q = deque()

for i in range(1, n + 1):
    if indegree[i] == 0:
        q.append(i)

while q:
    now = q.popleft()

    for i in graph[now]:
        indegree[i] -= 1
        result[now - 1] += result[i - 1]
        if indegree[i] == 0:
            q.append(i)

for r in result:
    print(r)
